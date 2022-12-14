package org.example.ScourOfCourse;

import java.util.ArrayList;

public class ModuleScore {
    private ArrayList<TaskScore> tasks = new ArrayList<>();
    private final  int scoreOfActivities;
    private final int scoreOfExercises;
    private final int scoreOfHomework;
    private final String moduleName;
    private final int scoreOfSiminars;





    public ModuleScore(String moduleName, int scoreOfActivities, int scoreOfExercises, int scoreOfHomework, int scoreOfSiminars, ArrayList<TaskScore> tasks){

        this.scoreOfActivities = scoreOfActivities;
        this.scoreOfExercises = scoreOfExercises;
        this.scoreOfHomework = scoreOfHomework;
        this.moduleName = moduleName;
        this.scoreOfSiminars = scoreOfSiminars;
        this.tasks = tasks;

    }

    public String getModuleName(){
        return moduleName;
    }

    public ArrayList<TaskScore> getTasks() {
        return tasks;
    }

    public int getMaxScoreOfActivities() {
        return scoreOfActivities;
    }

    public int getMaxScoreOfExercises() {
        return scoreOfExercises;
    }

    public int getMaxScoreOfHomework() {
        return scoreOfHomework;
    }

    public int getMaxScoreOfSiminars() {
        return scoreOfSiminars;
    }

    @Override
    public String toString(){
        String string = moduleName + " " + scoreOfActivities + " " + scoreOfExercises + " " + scoreOfHomework + " " + scoreOfSiminars + " " + tasks;
        return String.format("%s : максимум за активность - %s, максимум за упражнения - %s, максимум за дз - %s, максимум за семинары - %s %s  \n", moduleName, scoreOfActivities, scoreOfExercises, scoreOfHomework, scoreOfSiminars, tasks);
    }

}


