package org.example.Course;


public class Task{


    private final int maxSocres;
    private final String taskName;
    private final String tasktype;



    public Task(String tasktype, String taskName, int maxSocres) {
        this.taskName = taskName;
        this.tasktype = tasktype;
        this.maxSocres = maxSocres;
    }

    public String getTasktype() {
        return tasktype;
    }

    public int getMaxSocres() {
        return maxSocres;
    }

    public String getTaskName() {
        return taskName;
    }

    public String toString(){
        return String.format("%s %s: %s - %d", tasktype, taskName, "Максимальное количество баллов ", maxSocres);
    }

}