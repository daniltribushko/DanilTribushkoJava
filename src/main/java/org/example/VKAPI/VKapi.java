package org.example.VKAPI;

import com.vk.api.sdk.actions.Users;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.base.Sex;
import com.vk.api.sdk.objects.groups.Group;
import com.vk.api.sdk.objects.users.UserFull;
import org.example.ScourOfCourse.Report;
import org.example.ScourOfCourse.Student;

import java.util.ArrayList;

public class VKapi {
    private final int APP_ID = 0;
    private final String CODE = "";
    private final VkApiClient vk;
    private final UserActor actor;


    public VKapi(){
        TransportClient transportClient = new HttpTransportClient();
        vk = new VkApiClient(transportClient);
        actor = new UserActor(APP_ID, CODE);
    }



    public Group gitIDVkGroup()  throws ClientException, ApiException {
        String groupFirst = "Уральский федеральный университет | УрФУ";
        return vk.groups()
                .search(actor,groupFirst)
                .execute()
                .getItems()
                .get(0);
    }

    public String getSex(UserFull result) throws ClientException,ApiException,InterruptedException{
        if(result == null){
            return null;
        }

        else {
            return result.getSex().name();
        }

    }

    public UserFull getIdStudents(Group group, String name) throws ClientException, ApiException, InterruptedException{
        UserFull result = vk.users()
                .search(actor)
                .q(name)
                .groupId(group.getId())
                .count(1)
                .execute()
                .getItems()
                .stream()
                .findFirst()
                .orElse(null);
        Thread.sleep(300);

        return result;
    }

    public ArrayList<VkPerson> getStudentsFromVk(ArrayList<Student> students) throws ClientException,ApiException, InterruptedException{
        Group group = gitIDVkGroup();
        ArrayList<VkPerson> vkPersons = new ArrayList<>();
        for (var i : students){
            String name = i.getStudentName();
            UserFull user = getIdStudents(group, name);
            if(user == null){
                String nameVk = String.format("Студент <%s> не найден", name);
                VkPerson vkPerson= new VkPerson(nameVk, getSex(user));
                vkPersons.add(vkPerson);
            }

            else {
                VkPerson vkPerson = new VkPerson(name, getSex(user));
                vkPersons.add(vkPerson);
            }

        }

        return vkPersons;
    }

    public VkPerson getMe() throws ClientException, ApiException, InterruptedException {
        String myname = "Данил Трибушко";
        Group group = gitIDVkGroup();
        UserFull user = getIdStudents(group,myname);
        VkPerson vk = new VkPerson(myname, getSex(user));
        return vk;
    }
}
