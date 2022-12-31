package org.example.databaseORM.mapper;

import org.example.ScourOfCourse.Student;
import org.example.Studentrtf.StudentrRtf;
import org.example.VKAPI.VkPerson;
import org.example.databaseORM.VkDb.StudentEntity;

public class VkpersonFromDbMapper {
    public static StudentrRtf map(StudentEntity student){
        return new StudentrRtf(student.getName(), student.getGroup(), student.getGender());
    }
}
