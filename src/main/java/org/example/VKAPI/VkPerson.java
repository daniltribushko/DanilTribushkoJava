package org.example.VKAPI;

import com.vk.api.sdk.objects.base.Sex;
import org.example.ScourOfCourse.Student;

import java.util.ArrayList;

public class VkPerson {
    private final String name;
    private final String sex;
    public VkPerson(String name, String sex){
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String toString(){
        return String.format("%s - %s", name, sex);
    }
}
