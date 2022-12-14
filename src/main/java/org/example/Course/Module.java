package org.example.Course;

import java.util.ArrayList;

public class Module {
    private ArrayList<Task> tasks = new ArrayList<>();
    private final  int maxscoreOfActivities;
    private final int maxscoreOfExercises;
    private final int maxscoreOfHomework;
    private final String moduleName;
    private final int maxscoreOfSiminars;





    public Module(String moduleName, int maxscoreOfActivities, int maxscoreOfExercises, int maxscoreOfHomework, int maxscoreOfSiminars, ArrayList<Task> tasks){

        this.maxscoreOfActivities = maxscoreOfActivities;
        this.maxscoreOfExercises = maxscoreOfExercises;
        this.maxscoreOfHomework = maxscoreOfHomework;
        this.moduleName = moduleName;
        this.maxscoreOfSiminars = maxscoreOfSiminars;
        this.tasks = tasks;

    }

    public String getModuleName(){
        return moduleName;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public int getMaxScoreOfActivities() {
        return maxscoreOfActivities;
    }

    public int getMaxScoreOfExercises() {
        return maxscoreOfExercises;
    }

    public int getMaxScoreOfHomework() {
        return maxscoreOfHomework;
    }

    public int getMaxScoreOfSiminars() {
        return maxscoreOfSiminars;
    }

    public String toString(){
        return String.format("%s : максимум за активность - %s, максимум за упражнения - %s, максимум за дз - %s, максимум за семинары - %s %s  \n", moduleName,  maxscoreOfActivities,  maxscoreOfExercises,  maxscoreOfHomework,  maxscoreOfSiminars,  tasks);
    }
}
