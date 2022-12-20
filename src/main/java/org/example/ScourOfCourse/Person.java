package org.example.ScourOfCourse;

import java.util.ArrayList;

public class Person {
    private final Student student;
    private final  CourseScore courseScore;
    public Person(Student student, CourseScore courseScore){
        this.student = student;
        this.courseScore = courseScore;
    }

    public String getStudentName(){
        return student.getStudentName();
    }

    public Student getStudent(){
        return student;
    }
    @Override
    public String toString() {
        return String.format("%s %s", student, courseScore);
    }


}