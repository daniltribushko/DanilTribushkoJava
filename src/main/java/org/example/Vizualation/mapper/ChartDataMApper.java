package org.example.Vizualation.mapper;

import org.example.Studentrtf.Modulemain;
import org.example.Studentrtf.StudentrRtf;
import org.example.Studentrtf.Taskmain;
import org.example.databaseORM.DbModelsTask.ModulesDb;
import org.example.databaseORM.DbModelsTask.TaskDb;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ChartDataMApper {
    public static PieDataset createStudentByGender(List<StudentrRtf> students){

        var studentCountByGender = students.stream()
                .collect(
                        Collectors.groupingBy(
                                StudentrRtf::getGender,
                                HashMap::new,
                                Collectors.counting()
                        )
                );

        DefaultPieDataset dataset = new DefaultPieDataset();

        studentCountByGender.forEach(dataset::setValue);

        return dataset;
    }

    public static PieDataset createTaskByGender(List<Modulemain> tasks, ArrayList<StudentrRtf> studentrRtfs){
        var smoduleCountTask = 0;
        var smoduleCountTask1 = 0;
        var countmale = 0;
        var countFemale = 0;
        var max = 0;

        for(var i : tasks){
            smoduleCountTask = i.getAllScoreFromStudent() + smoduleCountTask;
        }

        for(var i2 : tasks){
            smoduleCountTask1 = i2.getAllScoreFromStudentMale() + smoduleCountTask1;
        }

        for(var i1 : tasks){
            max = max + i1.getMaxScore();
        }

        for (var m : studentrRtfs){
            if(m.getGender().equals("MALE")){
                countmale++;
            }
            else {
                countFemale++;
            }
        }



        DefaultPieDataset dataset = new DefaultPieDataset();

        dataset.setValue("Средняя успеваемость среди женщин",smoduleCountTask);
        dataset.setValue("Средняя успеваемость среди мужчин",smoduleCountTask1);
        //smoduleCountTask1.forEach(dataset::setValue);

        return dataset;
    }

    public static CategoryDataset createTaskDataset(ArrayList<Modulemain> tasks, ArrayList<StudentrRtf> students){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int countMale =0;
        int countFemale = 0;
        for (var person : students){
            if(person.getGender().equals("MALE")){
                countMale++;
            }

            else {
                countFemale++;
            }
        }

        int finalCountMale = countMale;
        tasks.forEach(p -> dataset.setValue((p.getCountStudentsHaveMaxScoreMale()*100/ finalCountMale), "Успеваемость студентов м", p.getModulenamedb()));
        tasks.forEach(p -> dataset.setValue((p.getCountStudentDontHaveMaxScoreMale()*100/finalCountMale), "Успеваемость студентов1", p.getModulenamedb()));
        tasks.forEach(p -> dataset.setValue((p.getCountSudentHaveZeroScoreMale()*100/finalCountMale), "Успеваемость студентов 3", p.getModulenamedb()));

        return dataset;
    }

    public static CategoryDataset createTaskDataset1(ArrayList<Modulemain> tasks, ArrayList<StudentrRtf> students){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int countMale =0;
        int countFemale = 0;
        for (var person : students){
            if(person.getGender().equals("MALE")){
                countMale++;
            }

            else {
                countFemale++;
            }
        }


        int finalCountFemale = countFemale;
        tasks.forEach(p -> dataset.setValue(p.getCountStudentsHaveMaxScore()*100/ finalCountFemale, "1", p.getModulenamedb()));
        tasks.forEach(p -> dataset.setValue(p.getCountStudentDontHaveMaxScore()*100/finalCountFemale, "2", p.getModulenamedb()));
        tasks.forEach(p -> dataset.setValue(p.getCountSudentHaveZeroScore()*100/finalCountFemale, "3", p.getModulenamedb()));

        return dataset;
    }

    public static CategoryDataset createTaskDataset2(ArrayList<Taskmain> tasks, ArrayList<StudentrRtf> students){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int countMale =0;
        int countFemale = 0;
        for (var person : students){
            if(person.getGender().equals("MALE")){
                countMale++;
            }

            else {
                countFemale++;
            }
        }

        int finalCountMale = countMale;
        int finalCountFemale = countFemale;
        tasks.forEach(p -> dataset.setValue(p.getCountStudentDontHaveMaxScoreMale(), "3", p.getModulenamedb()));
        tasks.forEach(p -> dataset.setValue(p.getCountStudentDontHaveMaxScore() , "4", p.getModulenamedb()));

        return dataset;
    }

    public static CategoryDataset createTaskDataset3(ArrayList<Taskmain> tasks, ArrayList<StudentrRtf> students){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int countMale =0;
        int countFemale = 0;
        for (var person : students){
            if(person.getGender().equals("MALE")){
                countMale++;
            }

            else {
                countFemale++;
            }
        }

        int finalCountMale = countMale;
        int finalCountFemale = countFemale;
        tasks.forEach(p -> dataset.setValue(p.getCountSudentHaveZeroScoreMale() , "5", p.getModulenamedb()));
        tasks.forEach(p -> dataset.setValue(p.getCountSudentHaveZeroScore(), "6", p.getModulenamedb()));

        return dataset;
    }
}
