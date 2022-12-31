package org.example.ScourOfCourse;

import java.util.ArrayList;

public class Student {
    private final Person person;
    private final  CourseScore courseScore;
    public Student(Person person, CourseScore courseScore){
        this.person = person;
        this.courseScore = courseScore;
    }

    public String getStudentName(){
        return person.getStudentName();
    }

    public CourseScore getCourseScore() {
        return courseScore;
    }

    public Person getPerson(){
        return person;
    }
    @Override
    public String toString() {
        return String.format("%s %s", person, courseScore);
    }


}