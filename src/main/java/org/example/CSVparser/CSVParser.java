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
        var students = new ArrayList<Student>();
        var course = getCourse(headers, headers2, headers3);

        while (sc.hasNextLine()){
            var headers4 = sc.nextLine().split(";");
            Student student  = new Student(mapStudent(headers4), getCourseScore(headers, headers2, headers4));
            students.add(student);
        }
        Report report = new Report(course, students);

        return report;
    }

    private static Scanner getScanner(String path) throws IOException {
        String content = Files.readString(Path.of(path), StandardCharsets.UTF_8);
        return new Scanner(content);
    }

    private static Person mapStudent(String[] headers){
        var nameSurname = headers[0];
        var group = headers[1];
        Person person = new Person(nameSurname, group);
        return person;
    }




    private static ArrayList<ModuleScore> getModuleScoreListCsv(String[] headers, String[] headers2, String[] headers4) {
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
                        if (task.getTasktype() != null){
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
                MaxScore maxScore = new MaxScore(maxscoreOfActivities, maxscoreOfExercises, maxscoreOfHomeworks, maxscoreOfSeminars);
                ModuleScore moduleScore = new ModuleScore(headers[countModule], maxScore, tasks);
                modules.add(moduleScore);


            }
        }

        return modules;
    }

    private static ArrayList<Module> getModuleListScv(String[] headers, String[] headers2, String[] headers4) {
        int maxscoreOfExercises = 0;
        int maxscoreOfActivities = 0;
        int maxscoreOfSeminars = 0;
        int maxscoreOfHomeworks = 0;
        ArrayList<Module> modules = new ArrayList<>();

        int countModule = 1;

        for (int j = 8; j < headers2.length; j++){

            ArrayList<Task> task = new ArrayList<>();

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
                        Task tasks = new Task(tasktype.getTaskType(), tasktype.getNameType(), Integer.parseInt(headers4[j]));
                        if (tasks.getTasktype() != null){
                            task.add(tasks);
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
                MaxScore maxScore = new MaxScore(maxscoreOfActivities, maxscoreOfExercises, maxscoreOfHomeworks, maxscoreOfSeminars);
                Module moduleScore = new Module(headers[countModule], maxScore, task);
                modules.add(moduleScore);


            }
        }

        return modules;
    }

    private static CourseScore getCourseScore(String[] headers, String[] headers2, String[] headers3){
        ArrayList<ModuleScore> moduleList = getModuleScoreListCsv(headers, headers2, headers3);
        MaxScore maxScore = new MaxScore(Integer.parseInt(headers3[2]), Integer.parseInt(headers3[3]), Integer.parseInt(headers3[4]), Integer.parseInt(headers3[5]));
        String name = "Основы программирования на C# часть 1";
        CourseScore course = new CourseScore(name, maxScore, moduleList);

        return course;
    }

    private static Course getCourse(String[] headers, String[] headers2, String[] headers3){
        ArrayList<Module> moduleList = getModuleListScv(headers, headers2, headers3);
        MaxScore maxScore = new MaxScore(Integer.parseInt(headers3[2]), Integer.parseInt(headers3[3]), Integer.parseInt(headers3[4]), Integer.parseInt(headers3[5]));
        String name = "Основы программирования на C# часть 1";
        Course course = new Course(name, maxScore, moduleList);

        return course;
    }

}