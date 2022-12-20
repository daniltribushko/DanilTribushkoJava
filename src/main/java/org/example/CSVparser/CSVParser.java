package org.example.CSVparser;
//import org.example.ScourOfCourse.Person;
import org.example.Course.Module;
import org.example.ScourOfCourse.*;
import org.example.Course.*;
import org.example.Tasktype.Tasktype;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class CSVParser {

    public static Report getReportFromCSV(String path) throws IOException {
        Scanner sc = getScanner(path);
        var headers = sc.nextLine().split(";");
        var headers2 = sc.nextLine().split(";");
        var headers3 = sc.nextLine().split(";");
        var persons = new ArrayList<Person>();
        var course = getCourse(headers, headers2, headers3);

        while (sc.hasNextLine()){
            var headers4 = sc.nextLine().split(";");
            Person person = new Person(mapStudent(headers4), getCourseScoreList(headers, headers2, headers4));
            persons.add(person);
        }
        Report report = new Report(course, persons);

        return report;
    }

    private static Scanner getScanner(String path) throws IOException {
        String content = Files.readString(Path.of(path), StandardCharsets.UTF_8);
        return new Scanner(content);
    }

    private static Student mapStudent(String[] headers){
        var nameSurname = headers[0];
        var group = headers[1];
        Student student = new Student(nameSurname, group);
        return student;
    }


    private static ArrayList getModuleList(String[] headers, String[] headers2, String[] headers3) {
        int maxscoreOfExercises = 0;
        int maxscoreOfActivities = 0;
        int maxscoreOfSeminars = 0;
        int maxscoreOfHomeworks = 0;
        ArrayList<Module> modules = new ArrayList<>();
        int countModule = 1;

        for (int j = 8; j < headers2.length; j++){

            ArrayList<Task> tasks = new ArrayList<>();

            while (headers2[j].equals("Сем") == false){
                Tasktype tasktype = new Tasktype(headers2[j]);
                switch (headers2[j]){
                    case "Акт":
                        maxscoreOfActivities = Integer.parseInt(headers3[j]);
                        countModule = j;
                        break;
                    case "Упр":
                        maxscoreOfExercises = Integer.parseInt(headers3[j]);
                        break;
                    case "Дз":
                        maxscoreOfHomeworks = Integer.parseInt(headers3[j]);
                        break;
                    default:

                        Task task = new Task(tasktype.getTaskType(), tasktype.getNameType(), Integer.parseInt(headers3[j]));
                        if (!task.getTasktype().equals("No task")){
                            tasks.add(task);
                        }

                }


                if(j + 1 == headers2.length){
                    break;
                }

                else {
                    j++;
                }

            }

            if (headers2[j].equals("Сем")) {
                maxscoreOfSeminars = Integer.parseInt(headers3[j]);
                Module module = new Module(headers[countModule], maxscoreOfActivities, maxscoreOfExercises, maxscoreOfHomeworks, maxscoreOfSeminars, tasks);
                modules.add(module);

            }
        }
        return modules;
    }

    private static ArrayList getModuleListScore(String[] headers, String[] headers2, String[] headers4) {
        int maxscoreOfExercises = 0;
        int maxscoreOfActivities = 0;
        int maxscoreOfSeminars = 0;
        int maxscoreOfHomeworks = 0;
        ArrayList<ModuleScore> modules = new ArrayList<>();
        int countModule = 1;

        for (int j = 8; j < headers2.length; j++){

            ArrayList<TaskScore> tasks = new ArrayList<>();

            while (headers2[j].equals("Сем") == false){
                Tasktype tasktype = new Tasktype(headers2[j]);
                switch (headers2[j]){
                    case "Акт":
                        maxscoreOfActivities = Integer.parseInt(headers4[j]);
                        countModule = j;
                        break;
                    case "Упр":
                        maxscoreOfExercises = Integer.parseInt(headers4[j]);
                        break;
                    case "Дз":
                        maxscoreOfHomeworks = Integer.parseInt(headers4[j]);
                        break;
                    default:
                        TaskScore task = new TaskScore(tasktype.getTaskType(), tasktype.getNameType(), Integer.parseInt(headers4[j]));
                        if (task.getTasktype().equals("No task")==false){
                            tasks.add(task);
                        }
                }

                if(j+1 == headers2.length){
                    break;
                }

                else {
                    j++;
                }

            }

            if (headers2[j].equals("Сем")) {
                maxscoreOfSeminars = Integer.parseInt(headers4[j]);
                ModuleScore module = new ModuleScore(headers[countModule], maxscoreOfActivities, maxscoreOfExercises, maxscoreOfHomeworks, maxscoreOfSeminars, tasks);
                modules.add(module);

            }
        }
        return modules;
    }

    private static Course getCourse(String[] headers, String[] headers2, String[] headers3){
        ArrayList<Module> moduleList = getModuleList(headers, headers2, headers3);
        var maxscoreOfActivities = Integer.parseInt(headers3[2]);
        var maxscoreOfExcersises = Integer.parseInt(headers3[3]);
        var maxscoreOfHomeWorks = Integer.parseInt(headers3[4]);
        var maxscoreOfSeminars = Integer.parseInt(headers3[5]);
        String name = "Основы программирования на C# часть 1";
        Course course = new Course(name, maxscoreOfActivities, maxscoreOfExcersises, maxscoreOfHomeWorks, maxscoreOfSeminars, moduleList);
        return course;
    }

    private static CourseScore getCourseScoreList(String[] headers, String[] headers2, String[] headers4){
        ArrayList<ModuleScore> moduleList = getModuleListScore(headers, headers2, headers4);
        var maxscoreOfActivities = Integer.parseInt(headers4[2]);
        var maxscoreOfExcersises = Integer.parseInt(headers4[3]);
        var maxscoreOfHomeWorks = Integer.parseInt(headers4[4]);
        var maxscoreOfSeminars = Integer.parseInt(headers4[5]);
        String name = "Основы программирования на C# часть 1";
        CourseScore course = new CourseScore(name, maxscoreOfActivities, maxscoreOfExcersises, maxscoreOfHomeWorks, maxscoreOfSeminars, moduleList);
        return course;
    }

}