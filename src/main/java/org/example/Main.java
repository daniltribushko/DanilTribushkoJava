package org.example;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import org.example.CSVparser.CSVParser;
import org.example.ScourOfCourse.Person;
import org.example.ScourOfCourse.Report;

import org.example.Studentrtf.Modulemain;
import org.example.Studentrtf.StudentrRtf;
import org.example.Studentrtf.Taskmain;
import org.example.VKAPI.VKapi;
import org.example.VKAPI.VkPerson;
import org.example.Vizualation.drower.BarCharDrawer;
import org.example.Vizualation.drower.PieCharDrawer;
import org.example.Vizualation.drower.TaskCharDrawer;
import org.example.Vizualation.mapper.ChartDataMApper;
import org.example.databaseORM.DbModelsTask.ModulesDb;
import org.example.databaseORM.DbModelsTask.TaskDb;
import org.example.databaseORM.NewDatabaseReposit;
import org.example.databaseORM.VkDb.StudentEntity;
import org.example.databaseORM.mapper.ModuleFromMapper;
import org.example.databaseORM.mapper.TaskFromDbMapper;
import org.example.databaseORM.mapper.VkpersonFromDbMapper;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        var persons = getReport();
        var countPersons = persons.getPersonCount();

        System.out.println(persons.getCourse());
        System.out.println("Количество студентов - " + countPersons);
        Report report = new Report(persons.getCourse(), persons.getStudents());
        System.out.println(report.getStudent("Петренко Владислав"));


        var vkInformation = getStudentFromVk(persons);

        for (var i : vkInformation){
            System.out.println(i);
        }
        for (var student : getStudentsFromDb(vkInformation, persons.getPersonslist())){
            System.out.println(student);
        }
        getModulesDb(persons);



        for (var q : getModulesDb(persons)){
            System.out.println(q);
        }

        var dbOrm = new NewDatabaseReposit();
        var studentsFromDb = new ArrayList<StudentrRtf>();
        try{
            dbOrm.connect();
            studentsFromDb = dbOrm.getStudents()
                    .stream()
                    .map(VkpersonFromDbMapper::map)
                    .collect(Collectors.toCollection(ArrayList::new));
            dbOrm.close();
        } catch (Exception throwable){
            throwable.printStackTrace();
        }

        int count1 = 0;
        int count2 = 0;
        for(var i : studentsFromDb){
            if(i.getGender().equals("MALE")){
                count1++;
            }
            else count2++;
        }
        System.out.println(count1 + " " + count2);

        var taskFromDb = new ArrayList<Taskmain>();
        try {
            dbOrm.connect();
            taskFromDb = dbOrm.getTaskDd()
                    .stream()
                    .map(TaskFromDbMapper::mapTask)
                    .collect(Collectors.toCollection(ArrayList::new));
            dbOrm.close();
        } catch (Exception throwable){
            throwable.printStackTrace();
        }

        var moduleFromdb = new ArrayList<Modulemain>();
        try {
            dbOrm.close();
            moduleFromdb = dbOrm.getModules()
                    .stream()
                    .map(ModuleFromMapper::mapModule)
                    .collect(Collectors.toCollection(ArrayList::new));
            dbOrm.close();
        }catch (Exception throwable){

        }



        new TaskCharDrawer("Сравнение успеваемости мужчин и женщин", moduleFromdb, studentsFromDb).setVisible(true);
        new BarCharDrawer("Общее соотношение модуля от успеваемости мужчин", moduleFromdb, studentsFromDb, 0).setVisible(true);
        new BarCharDrawer("Общее соотношение модуля от успеваемости женщин", moduleFromdb, studentsFromDb, 1).setVisible(true);

    }

    public static Report getReport() throws IOException {
        var pesons = CSVParser.getReportFromCSV("CSV/basicprogramming_2.csv");
        return pesons;
    }

    public static ArrayList<VkPerson> getStudentFromVk(Report persons) throws ClientException, InterruptedException, ApiException {
        VKapi vk = new VKapi();
        var students = persons.getPersonslist();
        var vkIformations = vk.getStudentsFromVk(students);
        return vkIformations;
    }


    public static List<TaskDb> getTaskDd(Report report) throws Exception {
        var dbOrm = new NewDatabaseReposit();
        dbOrm.connect();
        dbOrm.DropTableTaskDb();
        dbOrm.CreateTableTaskDb();
        dbOrm.SaveTaskDb(report.getStudents(), dbOrm.getModules(), report.getCourse(), dbOrm.getStudents());
        dbOrm.close();
        return dbOrm.getTaskDd();
    }

    public static List<ModulesDb> getModulesDb(Report report) throws Exception{
        var dbOrm = new NewDatabaseReposit();
        dbOrm.connect();
        dbOrm.dropModulesTable();
        dbOrm.createModulesTable();
        dbOrm.saveModules(report.getStudents(), report.getCourse(), dbOrm.getStudents());
        dbOrm.close();
        return dbOrm.getModules();
    }

    public static List<StudentEntity> getStudentsFromDb(ArrayList<VkPerson> vk, ArrayList<Person> persons) throws Exception {
        var dbOrm = new NewDatabaseReposit();
        dbOrm.connect();
        dbOrm.dropStudentTable();
        dbOrm.createStudentTable();
        dbOrm.saveStudents(vk, persons);
        dbOrm.close();
        return dbOrm.getStudents();
    }


}