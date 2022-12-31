package org.example.ScourOfCourse;

import java.util.ArrayList;

public class ModuleScore {
    private ArrayList<TaskScore> tasks;

    private final String moduleName;
    private final MaxScore maxScore;




    public ModuleScore(String moduleName, MaxScore maxScore, ArrayList<TaskScore> tasks){

        this.moduleName = moduleName;
        this.maxScore = maxScore;
        this.tasks = tasks;

    }

    public String getModuleName(){
        return moduleName;
    }

    public ArrayList<TaskScore> getTasks() {
        return tasks;
    }

    public MaxScore getMaxScore() {
        return maxScore;
    }


    public String toString(){
        return String.format("%s : %s,  %s  m; ", moduleName, maxScore, tasks);
    }

}


