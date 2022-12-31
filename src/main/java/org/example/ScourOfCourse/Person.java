package org.example.ScourOfCourse;

import java.util.ArrayList;
import java.util.Arrays;

public class Person {
    private final String studentNameSurname;
    private final String group;
    public Person(String studentNameSurname, String group){
        this.studentNameSurname = studentNameSurname;
        this.group = group;
    }

    public String getStudentName() {
        return studentNameSurname;
    }

    public String getGroup() {
        return group;
    }

    public String getGender(){
        String gender = null;
        String male = "ё й ц у к е н г ш щ щ з х ъ ф ы в п р о л д ж э ч с м и т ь б ю";
        ArrayList<String> maleName = new ArrayList<>(Arrays.asList("Дима","Илья","Никита", "Данила","Мустафа", "Бахаа", "Миша"));
        ArrayList<String> foreigners = new ArrayList<>(Arrays.asList("Алехандра", "Абдулвасеа", "Фатма", "Осама"));
        String str = studentNameSurname;
        String[] nameSurname = str.split(" ");
        int lastElement = nameSurname.length-1;
        if (nameSurname[lastElement].equals("Саша") || nameSurname[lastElement].equals("Женя")) {
            if (nameSurname[0].endsWith("а") || nameSurname[0].endsWith("я")) {
                gender = "FEMALE";
            }

            else {
                gender = "MALE";
            }
        }


        else if(nameSurname[0].equals("Саша") || nameSurname[0].equals("Женя")){
            if(nameSurname[lastElement].endsWith("а") || nameSurname[lastElement].endsWith("я")){
                gender = "FEMALE";
            }
            else {
                gender = "MALE";
            }
        }

        else if(nameSurname[lastElement].endsWith("а") || nameSurname[lastElement].endsWith("я")){
            gender = "FEMALE";
            for (var i : maleName) {
                if (nameSurname[lastElement].equals(i) || nameSurname[0].equals(i)) {
                    gender = "MALE";
                }
            }
        }

        for (String i : male.split(" ")){
            if(nameSurname[lastElement].endsWith(i)){
                gender = "MALE";
            }
        }

        for (var w : foreigners){
            if(nameSurname[lastElement].equals(w)){
                gender = null;
            }
        }




        return gender;
    }

    @Override
    public String toString(){
        return String.format("%s (%s) ", studentNameSurname, group);
    }
}