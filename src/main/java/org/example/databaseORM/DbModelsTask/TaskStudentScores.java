package org.example.databaseORM.DbModelsTask;

public class TaskStudentScores {
    private final int countStudentHaveMaxScore;

    private final int countSudentDontHaveMAxScore;

    private final int countStudentHaveZeroScore;

    private final int countStudentHaveMaxScoreMale;

    private final int countSudentDontHaveMAxScoreMale;

    private final int countStudentHaveZeroScoreMale;

    public TaskStudentScores(int countStudentHaveMaxScore,  int countStudentHaveMaxScoreMale, int countSudentDontHaveMAxScore, int countSudentDontHaveMAxScoreMale, int countStudentHaveZeroScore,   int countStudentHaveZeroScoreMale) {
        this.countStudentHaveMaxScore = countStudentHaveMaxScore;
        this.countSudentDontHaveMAxScore = countSudentDontHaveMAxScore;
        this.countStudentHaveZeroScore = countStudentHaveZeroScore;
        this.countStudentHaveMaxScoreMale = countStudentHaveMaxScoreMale;
        this.countSudentDontHaveMAxScoreMale = countSudentDontHaveMAxScoreMale;
        this.countStudentHaveZeroScoreMale = countStudentHaveZeroScoreMale;
    }

    public int getCountStudentHaveMaxScore() {
        return countStudentHaveMaxScore;
    }

    public int getCountSudentDontHaveMAxScore() {
        return countSudentDontHaveMAxScore;
    }

    public int getCountStudentHaveZeroScore() {
        return countStudentHaveZeroScore;
    }

    public int getCountStudentHaveMaxScoreMale() {
        return countStudentHaveMaxScoreMale;
    }

    public int getCountSudentDontHaveMAxScoreMale() {
        return countSudentDontHaveMAxScoreMale;
    }

    public int getCountStudentHaveZeroScoreMale() {
        return countStudentHaveZeroScoreMale;
    }
}
