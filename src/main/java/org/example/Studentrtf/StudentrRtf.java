package org.example.Studentrtf;

public class StudentrRtf {
    private final String name;

    private final String group;

    private final String gender;


    public StudentrRtf(String name, String group, String gender) {
        this.name = name;
        this.group = group;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public String getGender() {
        return gender;
    }
}
