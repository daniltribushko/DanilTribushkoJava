package org.example.ScourOfCourse;

public class MaxScore {
    private final  int scoreOfActivities;
    private final int scoreOfExercises;

    private final int scoreOfHomeworks;
    private final int scoreOfSiminars;

    public MaxScore(int scoreOfActivities, int scoreOfExercises, int scoreOfHomeworks, int scoreOfSiminars){
        this.scoreOfActivities = scoreOfActivities;
        this.scoreOfExercises = scoreOfExercises;
        this.scoreOfHomeworks = scoreOfHomeworks;
        this.scoreOfSiminars = scoreOfSiminars;
    }

    public int getScoreOfActivities() {
        return scoreOfActivities;
    }

    public int getScoreOfExercises() {
        return scoreOfExercises;
    }

    public int getScoreOfHomeworks() {
        return scoreOfHomeworks;
    }

    public int getScoreOfSiminars() {
        return scoreOfSiminars;
    }

    @Override
    public String toString() {
        return String.format("Общее количество баллов за активности - %s; Общее количество баллов за упражнения - %s;" +
                "Общее количество баллов за дз - %s; Общее количество баллов за семинары - %s",
                scoreOfActivities, scoreOfExercises, scoreOfHomeworks, scoreOfSiminars);
    }
}
