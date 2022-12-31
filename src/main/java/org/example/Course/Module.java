package org.example.Course;

import org.example.ScourOfCourse.MaxScore;
import org.example.ScourOfCourse.TaskScore;

import java.util.ArrayList;

public class Module {
    private ArrayList<Task> tasks;

    private final String moduleName;
    private final MaxScore maxScore;



    public Module(String moduleName, MaxScore maxScore, ArrayList<Task> tasks){

        this.moduleName = moduleName;
        this.maxScore = maxScore;
        this.tasks = tasks;

    }

    public MaxScore getMaxScore() {
        return maxScore;
    }

    public String getModuleName(){
        return moduleName;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }



    public String toString(){
        return String.format("%s курс : максимум за все активности - %s, максимум за все упражнения - %s, максиум за все домашнии работы - %s, максимум за все семинары - %s %s \n", moduleName , maxScore.getScoreOfActivities(), maxScore.getScoreOfExercises(), maxScore.getScoreOfHomeworks(), maxScore.getScoreOfSiminars(), tasks);
    }
}
