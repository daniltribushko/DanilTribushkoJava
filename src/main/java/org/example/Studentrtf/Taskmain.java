package org.example.Studentrtf;




public class Taskmain {


    private String name;


    private String tasktype;


    private String modulenamedb;


    private int maxScore;


    private int allScoreFromStudent;




    private int allScoreFromStudentMale;


    private int countStudentsHaveMaxScore;

    private int countStudentsHaveMaxScoreMale;


    private int countStudentDontHaveMaxScore;

    private int countStudentDontHaveMaxScoreMale;

    private int countSudentHaveZeroScore;

    private int countSudentHaveZeroScoreMale;

    public Taskmain(String name, String tasktype, String modulenamedb, int maxScore, int allScoreFromStudent, int allScoreFromStudentMale, int countStudentsHaveMaxScore, int countStudentsHaveMaxScoreMale, int countStudentDontHaveMaxScore, int countStudentDontHaveMaxScoreMale, int countSudentHaveZeroScore, int countSudentHaveZeroScoreMale) {
        this.name = name;
        this.tasktype = tasktype;
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
        return "Taskmain{" +
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
