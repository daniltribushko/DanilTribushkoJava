package org.example.ScourOfCourse;

import java.util.ArrayList;

public class CourseScore{
    private final String nameCourse;

    private final MaxScore maxScore;

    private ArrayList<ModuleScore> modulesScores;

    public CourseScore(String nameCourse, MaxScore maxScore, ArrayList<ModuleScore> modulesScores){
        this.nameCourse = nameCourse;
        this.maxScore = maxScore;
        this.modulesScores = modulesScores;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public MaxScore getMaxScore(){
        return maxScore;
    }

    public ArrayList<ModuleScore> getModulesScoreCourse() {
        return modulesScores;
    }


    public String toString(){
        return String.format("%s : %s  %s", nameCourse, maxScore, getModulesScoreCourse());
    }
}