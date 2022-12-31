package org.example.databaseORM.mapper;

import org.example.Studentrtf.Taskmain;
import org.example.databaseORM.DbModelsTask.TaskDb;

public class TaskFromDbMapper {
    public static Taskmain mapTask(TaskDb taskDb){
        return new Taskmain(taskDb.getName(), taskDb.getTasktype(), taskDb.getModulenamedb(), taskDb.getMaxScore(), taskDb.getAllScoreFromStudent(),
                taskDb.getAllScoreFromStudentMale(),
                taskDb.getCountStudentsHaveMaxScore(), taskDb.getCountStudentDontHaveMaxScoreMale(),
                taskDb.getCountStudentDontHaveMaxScore(), taskDb.getCountStudentDontHaveMaxScoreMale(),
                taskDb.getCountSudentHaveZeroScore(), taskDb.getCountSudentHaveZeroScoreMale());
    }
}
