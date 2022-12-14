package org.example.ScourOfCourse;


public class TaskScore{
    private final int scoreOfTask;
    private final String taskName;
    private final String tasktype;



    public TaskScore(String tasktype, String taskName, int scoreOfTask) {
        this.taskName = taskName;
        this.tasktype = tasktype;
        this.scoreOfTask = scoreOfTask;
    }

    public String getTasktype() {
        return tasktype;
    }

    public int getSocres() {
        return scoreOfTask;
    }

    public String getTaskName() {
        return taskName;
    }

    @Override
    public String toString(){
        return String.format("%s %s: баллов за задание %s", tasktype, taskName, scoreOfTask);
    }

}