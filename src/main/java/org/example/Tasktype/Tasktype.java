package org.example.Tasktype;

public class Tasktype {

    private String string;
    private String type;
    public Tasktype(String string){
        this.string = string;
    }

    public String getTaskType(){
        type = null;
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
        if (getTaskType() == null){
            result = null;
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