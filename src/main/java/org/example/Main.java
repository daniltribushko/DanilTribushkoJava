package org.example;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import org.example.CSVparser.CSVParser;
import org.example.ScourOfCourse.Report;
import org.example.VKAPI.VKapi;


import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClientException, InterruptedException, ApiException {
        var pesons = CSVParser.getReportFromCSV("CSV/basicprogramming_2.csv");
        var countPersons = pesons.getPersonCount();
        Scanner scanner = new Scanner(System.in);
        //System.out.println("Введите имя студента");

        System.out.println(pesons.getCourse());
        System.out.println("Количество студентов - " + countPersons);
        Report report = new Report(pesons.getCourse(), pesons.getPersons());
        System.out.println(report.getStudent("Петренко Владислав"));
        /*VKapi vk = new VKapi();
        var students = pesons.getStudentslist();
        var VkIformations = vk.getStudentsFromVk(students);
        for(var i : VkIformations) {
            System.out.println(i);
        }
        System.out.println(vk.getMe());*/

    }


}