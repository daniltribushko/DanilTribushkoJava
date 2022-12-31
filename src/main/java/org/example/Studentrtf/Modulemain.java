package org.example.Studentrtf;

import com.j256.ormlite.field.DatabaseField;

public class Modulemain {
    private  String modulenamedb;

    private int maxScore;

    private int allScoreFromStudent;

    private int allScoreFromStudentMale;

    private int countStudentsHaveMaxScore;

    private int countStudentsHaveMaxScoreMale;

    private int countStudentDontHaveMaxScore;

    private int countStudentDontHaveMaxScoreMale;

    private int countSudentHaveZeroScore;

    private int countSudentHaveZeroScoreMale;

    public Modulemain(String modulenamedb, int maxScore, int allScoreFromStudent, int allScoreFromStudentMale, int countStudentsHaveMaxScore, int countStudentsHaveMaxScoreMale, int countStudentDontHaveMaxScore, int countStudentDontHaveMaxScoreMale, int countSudentHaveZeroScore, int countSudentHaveZeroScoreMale) {
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
