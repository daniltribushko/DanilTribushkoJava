package org.example.ScourOfCourse;

public class Student {
    private final String studentNameSurname;
    private final String group;
    public Student(String studentNameSurname, String group){
        this.studentNameSurname = studentNameSurname;
        this.group = group;
    }

    public String getStudentName() {
        return studentNameSurname;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString(){
        return String.format("%s (%s) ", studentNameSurname, group);
    }
}