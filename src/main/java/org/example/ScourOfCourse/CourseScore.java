package org.example.ScourOfCourse;

import java.util.ArrayList;

public class CourseScore{
    private final String nameCourse;
    private final int scoreOfActivities;
    private final int scoreOfExcersises;
    private final int scoreOfHomeWorks;
    private final int scoreOfSeminars;
    private ArrayList<ModuleScore> modules  = new ArrayList<>();

    public CourseScore(String nameCourse, int scoreOfActivities, int scoreOfExcersises, int scoreOfHomeworks, int scoreOfSeminars, ArrayList<ModuleScore> modules){
        this.nameCourse = nameCourse;
        this.scoreOfActivities = scoreOfActivities;
        this.scoreOfExcersises = scoreOfExcersises;
        this.scoreOfHomeWorks = scoreOfHomeworks;
        this.scoreOfSeminars = scoreOfSeminars;
        this.modules = modules;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public int getScoreOfActivities() {
        return scoreOfActivities;
    }

    public int getScoreOfExcersises() {
        return scoreOfExcersises;
    }

    public int getScoreOfHomeWorks() {
        return scoreOfHomeWorks;
    }

    public int getScoreOfSeminars() {
        return scoreOfSeminars;
    }

    public ArrayList<ModuleScore> getModules() {
        return modules;
    }

    @Override
    public String toString(){
        return String.format("%s : максимум за все активности - %s, максимум за все упражнения - %s, максиум за все домашнии работы - %s, максимум за все семинары - %s %s", nameCourse, scoreOfActivities, scoreOfExcersises, scoreOfHomeWorks, scoreOfSeminars, modules);
    }
}