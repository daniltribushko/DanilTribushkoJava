package org.example.databaseORM.VkDb;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class StudentEntity {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false)
    private String name;

    @DatabaseField(canBeNull = false)
    private String group;
    @DatabaseField
    private String gender;

    public StudentEntity(String name, String group, String gender){
        this.name = name;
        this.group = group;
        this.gender = gender;
    }

    StudentEntity(){}

    public int getId() {
        return id;
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

    public String toString(){
        return String.format("Фамилия и Имя: %s Группа %s Пол %s", name, group, gender);
    }
}
