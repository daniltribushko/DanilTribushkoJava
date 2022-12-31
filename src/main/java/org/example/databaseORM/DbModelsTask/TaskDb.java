package org.example.databaseORM.DbModelsTask;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Задание")
public class TaskDb {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false)
    private String name;

    @DatabaseField(canBeNull = false)
    private String tasktype;

    @DatabaseField(canBeNull = false)
    private String modulenamedb;

    @DatabaseField(canBeNull = false)
    private int maxScore;

    @DatabaseField(canBeNull = false, columnName = "Обще количество баллов за задание у жещин")
    private int allScoreFromStudent;



    @DatabaseField(canBeNull = false, columnName = "Обще количество баллов за задание у иужчин")
    private int allScoreFromStudentMale;

    @DatabaseField(canBeNull = false, columnName = "Количество студентов получивших максимальный бал среди женщин")
    private int countStudentsHaveMaxScore;

    @DatabaseField(canBeNull = false, columnName = "Количество студентов сделавших задание не на максимальный бал среди женщин")
    private int countStudentDontHaveMaxScore;

    @DatabaseField(canBeNull = false, columnName = "Количество студентов не сделавших задание среди женщин")
    private int countSudentHaveZeroScore;

    @DatabaseField(canBeNull = false, columnName = "Количество студентов получивших максимальный бал среди мужчин")
    private int countStudentsHaveMaxScoreMale;

    @DatabaseField(canBeNull = false, columnName = "Количество студентов сделавших задание не на максимальный бал среди мужчин")
    private int countStudentDontHaveMaxScoreMale;

    @DatabaseField(canBeNull = false, columnName = "Количество студентов не сделавших задание среди мужчин")
    private int countSudentHaveZeroScoreMale;

    public TaskDb(String name, String tasktype, String modulenamedb, int maxScore, int allScoreFromStudent, int allScoreFromStudentMale, int countStudentsHaveMaxScore,  int countStudentsHaveMaxScoreMale, int countStudentDontHaveMaxScore,  int countStudentDontHaveMaxScoreMale, int countSudentHaveZeroScore,  int countSudentHaveZeroScoreMale) {
        this.name = name;
        this.tasktype = tasktype;
        this.modulenamedb = modulenamedb;
        this.maxScore = maxScore;
        this.allScoreFromStudent = allScoreFromStudent;
        this.allScoreFromStudentMale = allScoreFromStudentMale;
        this.countStudentsHaveMaxScore = countStudentsHaveMaxScore;
        this.countStudentDontHaveMaxScore = countStudentDontHaveMaxScore;
        this.countSudentHaveZeroScore = countSudentHaveZeroScore;
        this.countStudentsHaveMaxScoreMale = countStudentsHaveMaxScoreMale;
        this.countStudentDontHaveMaxScoreMale = countStudentDontHaveMaxScoreMale;
        this.countSudentHaveZeroScoreMale = countSudentHaveZeroScoreMale;
    }

    TaskDb(){}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTasktype() {
        return tasktype;
    }

    public String getModulenamedb(){return modulenamedb;}

    public int getMaxScore() {
        return maxScore;
    }

    public int getAllScoreFromStudent() {
        return allScoreFromStudent;
    }

    public int getCountStudentsHaveMaxScore(){return countStudentsHaveMaxScore;}

    public int getCountStudentDontHaveMaxScore() {
        return countStudentDontHaveMaxScore;
    }

    public int getCountSudentHaveZeroScore() {
        return countSudentHaveZeroScore;
    }

    public int getAllScoreFromStudentMale() {
        return allScoreFromStudentMale;
    }

    public int getCountStudentsHaveMaxScoreMale() {
        return countStudentsHaveMaxScoreMale;
    }

    public int getCountStudentDontHaveMaxScoreMale() {
        return countStudentDontHaveMaxScoreMale;
    }

    public int getCountSudentHaveZeroScoreMale() {
        return countSudentHaveZeroScoreMale;
    }

    @Override
    public String toString() {
        return "TaskDb{" +
                "name='" + name + '\'' +
                ", tasktype='" + tasktype + '\'' +
                ", modulenamedb='" + modulenamedb + '\'' +
                ", maxScore=" + maxScore +
                ", allScoreFromStudent=" + allScoreFromStudent +
                ", allScoreFromStudentMale=" + allScoreFromStudentMale +
                ", countStudentsHaveMaxScore=" + countStudentsHaveMaxScore +
                ", countStudentDontHaveMaxScore=" + countStudentDontHaveMaxScore +
                ", countSudentHaveZeroScore=" + countSudentHaveZeroScore +
                ", countStudentsHaveMaxScoreMale=" + countStudentsHaveMaxScoreMale +
                ", countStudentDontHaveMaxScoreMale=" + countStudentDontHaveMaxScoreMale +
                ", countSudentHaveZeroScoreMale=" + countSudentHaveZeroScoreMale +
                '}';
    }
}
