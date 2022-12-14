package org.example.ScourOfCourse;


import org.example.Course.Course;

import java.util.ArrayList;

public class Report {
    private final ArrayList<Person> persons;
    private final Course course;
    public Report(Course course, ArrayList<Person> persons){
        this.persons = persons;
        this.course = course;
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public Course getCourse() {
        return course;
    }

    public int getPersonCount(){
        int count = 0;

        for (var ignored : getPersons()){
            count++;
        }

        return count;
    }
    public Person getStudent(String name){
        return persons.stream()
                .filter(person -> person.getStudent().equals(name))
                .findFirst()
                .orElseThrow();

    }
}