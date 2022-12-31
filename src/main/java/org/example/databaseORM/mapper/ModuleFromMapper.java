package org.example.databaseORM.mapper;

import org.example.Studentrtf.Modulemain;
import org.example.databaseORM.DbModelsTask.ModulesDb;

public class ModuleFromMapper {
    public static Modulemain mapModule(ModulesDb module){
        return new Modulemain(module.getModulenamedb(), module.getMaxScore(),
                module.getAllScoreFromStudent(), module.getAllScoreFromStudentMale(),
                module.getCountStudentsHaveMaxScore(), module.getCountStudentsHaveMaxScoreMale(),
                module.getCountStudentDontHaveMaxScore(), module.getCountStudentDontHaveMaxScoreMale(),
                module.getCountSudentHaveZeroScore(), module.getCountSudentHaveZeroScoreMale());
    }
}
