package org.example.Course;

import org.example.ScourOfCourse.MaxScore;

import java.util.ArrayList;

public class Course {
    private final String nameCourse;

    private final MaxScore maxScore;
    private ArrayList<Module> modulesCourse;

    public Course(String nameCourse, MaxScore maxScore, ArrayList modulesCourse){
        this.nameCourse = nameCourse;
        this.maxScore = maxScore;
        this.modulesCourse = modulesCourse;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public MaxScore maxScore(){
        return maxScore;
    }
    public ArrayList<Module> getModulesFromCourse() {
        return modulesCourse;
    }

    public MaxScore getMaxScore() {
        return maxScore;
    }

    public String toString(){
        return String.format("%s : максимум за все активности - %s, максимум за все упражнения - %s, максиум за все домашнии работы - %s, максимум за все семинары - %s %s",nameCourse, maxScore.getScoreOfActivities(), maxScore.getScoreOfExercises(), maxScore.getScoreOfHomeworks(), maxScore.getScoreOfSiminars(), modulesCourse);
    }
}