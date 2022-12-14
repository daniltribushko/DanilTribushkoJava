package org.example;

import org.example.CSVparser.CSVParser;
import org.example.ScourOfCourse.Report;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var pesons = CSVParser.getReportFromCSV("CSV/basicprogramming_2.csv");
        var countPersons = pesons.getPersonCount();

        System.out.println(pesons.getCourse());
        System.out.println("Количество студентов - " + countPersons);
        Report report = new Report(pesons.getCourse(), pesons.getPersons());
        System.out.println(report.getStudent("Прожерин Владислав"));

    }
}