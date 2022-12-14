package org.example.Tasktype;

public class Tasktype {

    private String string;
    private String type;
    public Tasktype(String string){
        this.string = string;
    }

    public String getTaskType(){
        type = "No task";
        String[] str = string.split(":");
        if (str[0].equals("ДЗ") && (str.length != 1)){
            type = "Дз";
        }

        if (str[0].equals("Упр") && (str.length != 1)) {
            type = "Упр";
        }

        if(str[0].equals("Доп")){
            type = "Доп";
        }
        return type;
    }

    public String getNameType(){
        String[] str = string.split(":");
        String result;
        if (getTaskType().equals("No task")){
            result = "Error: No task";
        }

        else if (getTaskType().equals("Доп")){
            result = " ";
        }

        else {
            result = str[1];
        }
        return result;

    }

}