package org.example.databaseORM.DbModelsTask;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class ModulesDb {

    @DatabaseField(generatedId = true)
    private  int id;

    @DatabaseField(canBeNull = false)
    private  String modulenamedb;


    @DatabaseField(canBeNull = false)
    private int maxScore;

    @DatabaseField(canBeNull = false, columnName = "Обще количество баллов за задание у жещин")
    private int allScoreFromStudent;


    @DatabaseField(canBeNull = false, columnName = "Обще количество баллов за задание у иужчин")
    private int allScoreFromStudentMale;

    @DatabaseField(canBeNull = false, columnName = "Количество студентов получивших максимальный бал среди женщин")
    private int countStudentsHaveMaxScore;

    @DatabaseField(canBeNull = false, columnName = "Количество студентов получивших максимальный бал среди мужчин")
    private int countStudentsHaveMaxScoreMale;

    @DatabaseField(canBeNull = false, columnName = "Количество студентов сделавших задание не на максимальный бал среди женщин")
    private int countStudentDontHaveMaxScore;

    @DatabaseField(canBeNull = false, columnName = "Количество студентов сделавших задание не на максимальный бал среди мужчин")
    private int countStudentDontHaveMaxScoreMale;


    @DatabaseField(canBeNull = false, columnName = "Количество студентов не сделавших задание среди женщин")
    private int countSudentHaveZeroScore;


    @DatabaseField(canBeNull = false, columnName = "Количество студентов не сделавших задание среди мужчин")
    private int countSudentHaveZeroScoreMale;

    public ModulesDb(String modulenamedb, int maxScore, int allScoreFromStudent, int allScoreFromStudentMale, int countStudentsHaveMaxScore, int countStudentsHaveMaxScoreMale, int countStudentDontHaveMaxScore, int countStudentDontHaveMaxScoreMale, int countSudentHaveZeroScore, int countSudentHaveZeroScoreMale) {
        this.modulenamedb = modulenamedb;
        this.maxScore = maxScore;
        this.allScoreFromStudent = allScoreFromStudent;
        this.allScoreFromStudentMale = allScoreFromStudentMale;
        this.countStudentsHaveMaxScore = countStudentsHaveMaxScore;
        this.countStudentsHaveMaxScoreMale = countStudentsHaveMaxScoreMale;
        this.countStudentDontHaveMaxScore = countStudentDontHaveMaxScore;
        this.countStudentDontHaveMaxScoreMale = countStudentDontHaveMaxScoreMale;
        this.countSudentHaveZeroScore = countSudentHaveZeroScore;
        this.countSudentHaveZeroScoreMale = countSudentHaveZeroScoreMale;
    }

    ModulesDb(){}

    public int getId() {
        return id;
    }

    public String getModulenamedb() {
        return modulenamedb;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public int getAllScoreFromStudent() {
        return allScoreFromStudent;
    }

    public int getAllScoreFromStudentMale() {
        return allScoreFromStudentMale;
    }

    public int getCountStudentsHaveMaxScore() {
        return countStudentsHaveMaxScore;
    }

    public int getCountStudentsHaveMaxScoreMale() {
        return countStudentsHaveMaxScoreMale;
    }

    public int getCountStudentDontHaveMaxScore() {
        return countStudentDontHaveMaxScore;
    }

    public int getCountStudentDontHaveMaxScoreMale() {
        return countStudentDontHaveMaxScoreMale;
    }

    public int getCountSudentHaveZeroScore() {
        return countSudentHaveZeroScore;
    }

    public int getCountSudentHaveZeroScoreMale() {
        return countSudentHaveZeroScoreMale;
    }
}
