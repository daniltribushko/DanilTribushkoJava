package org.example.databaseORM.DbModelsTask;

public class MaxScoresFromGender {
    private final int maxScore;

    private final int maxScoremale;

    public MaxScoresFromGender(int maxScore, int maxScoremale) {
        this.maxScore = maxScore;
        this.maxScoremale = maxScoremale;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public int getMaxScoremale() {
        return maxScoremale;
    }
}
