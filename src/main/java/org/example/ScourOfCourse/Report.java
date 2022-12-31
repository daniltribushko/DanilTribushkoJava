package org.example.ScourOfCourse;


import org.example.Course.Course;

import java.util.ArrayList;

public class Report {
    private final ArrayList<Student> students;
    private ArrayList<Person> personslist = new ArrayList<>();
    private final Course course;
    public Report(Course course, ArrayList<Student> students){
        this.students = students;
        this.course = course;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Person> getPersonslist(){
        for (var i : students){
            personslist.add(i.getPerson());
        }

        return personslist;
    }
    public Course getCourse() {
        return course;
    }

    public int getPersonCount(){
        int count = 0;

        for (var ignored : getStudents()){
            count++;
        }

        return count;
    }
    public Student getStudent(String name){
        return students.stream()
                .filter(student -> student.getStudentName().equals(name))
                .findFirst()
                .orElseThrow();


    }
}