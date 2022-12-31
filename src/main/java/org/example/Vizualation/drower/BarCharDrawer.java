package org.example.Vizualation.drower;

import org.example.Studentrtf.Modulemain;
import org.example.Studentrtf.StudentrRtf;
import org.example.Studentrtf.Taskmain;
import org.example.Vizualation.mapper.ChartDataMApper;
import org.example.databaseORM.DbModelsTask.ModulesDb;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.RectangleInsets;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static org.jfree.chart.ChartFactory.createBarChart;

public class BarCharDrawer extends JFrame {
    public BarCharDrawer(String title, ArrayList<Modulemain> tasks, ArrayList<StudentrRtf> students, int index) {
        super(title);

        setContentPane(createStudentsByTasks(title, tasks, students, index));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(600,300);
    }

    public static JPanel createStudentsByTasks(String title, ArrayList<Modulemain> tasks, ArrayList<StudentrRtf> students, int index){

        JFreeChart chart = null;
        if(index == 0) {
            chart = createBarChart(title, ChartDataMApper.createTaskDataset(tasks, students));
        }
        else {
            chart = createBarChart(title, ChartDataMApper.createTaskDataset1(tasks, students));
        }

        chart.setPadding(new RectangleInsets(4, 8, 2, 2));
        return new ChartPanel(chart);
    }

    private static JFreeChart createBarChart(String title, CategoryDataset dataset){
        JFreeChart chart = ChartFactory.createBarChart(
                title,
                "Module",
                "TaskScore",
                dataset,
                PlotOrientation.HORIZONTAL,
                false,
                false,
                false

        );

        chart.setBackgroundPaint(Color.WHITE);

        return chart;
    }
}
