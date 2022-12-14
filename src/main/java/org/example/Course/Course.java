package org.example.Course;

import java.util.ArrayList;

public class Course {
    private final String nameCourse;
    private final int maxscoreOfActivities;
    private final int maxscoreOfExcersises;
    private final int maxscoreOfHomeWorks;
    private final int maxscoreOfSeminars;
    private ArrayList<java.lang.Module> modules  = new ArrayList<>();

    public Course(String nameCourse, int maxscoreOfActivities, int maxscoreOfExcersises, int maxscoreOfHomeworks, int maxscoreOfSeminars, ArrayList modules){
        this.nameCourse = nameCourse;
        this.maxscoreOfActivities = maxscoreOfActivities;
        this.maxscoreOfExcersises = maxscoreOfExcersises;
        this.maxscoreOfHomeWorks = maxscoreOfHomeworks;
        this.maxscoreOfSeminars = maxscoreOfSeminars;
        this.modules = modules;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public int getScoreOfActivities() {
        return maxscoreOfActivities;
    }

    public int getScoreOfExcersises() {
        return maxscoreOfExcersises;
    }

    public int getScoreOfHomeWorks() {
        return maxscoreOfHomeWorks;
    }

    public int getScoreOfSeminars() {
        return maxscoreOfSeminars;
    }

    public ArrayList<java.lang.Module> getModules() {
        return modules;
    }

    public String toString(){
        return String.format("%s : максимум за все активности - %s, максимум за все упражнения - %s, максиум за все домашнии работы - %s, максимум за все семинары - %s %s",nameCourse, maxscoreOfActivities, maxscoreOfExcersises, maxscoreOfHomeWorks, maxscoreOfSeminars, modules);
    }
}