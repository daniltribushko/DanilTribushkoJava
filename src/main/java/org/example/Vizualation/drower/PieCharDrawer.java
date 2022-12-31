package org.example.Vizualation.drower;

import org.example.Studentrtf.StudentrRtf;
import org.example.Studentrtf.Taskmain;
import org.example.Vizualation.mapper.ChartDataMApper;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleInsets;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class PieCharDrawer extends JFrame {


    public PieCharDrawer(String title, ArrayList<StudentrRtf> studentrRtfs){
        super(title);
        setContentPane(createStudentsByTeamsPanel(studentrRtfs));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(600, 300);
    }

    public static JPanel createStudentsByTeamsPanel(ArrayList<StudentrRtf> studentrRtfs) {

        JFreeChart chart = createPieChart("Genders", ChartDataMApper.createStudentByGender(studentrRtfs));
        chart.setPadding(new RectangleInsets(4, 8, 2, 2));
        return new ChartPanel(chart);
    }



    private static JFreeChart createPieChart(String title,PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                title,  // chart title
                dataset,             // data
                false,               // no legend
                true,                // tooltips
                false                // no URL generation
        );


        chart.setBackgroundPaint(
                new GradientPaint(
                        new Point(0, 0),
                        new Color(20, 20, 20),
                        new Point(400, 200),
                        Color.DARK_GRAY
                )
        );

        TextTitle t = chart.getTitle();
        t.setHorizontalAlignment(HorizontalAlignment.LEFT);
        t.setPaint(new Color(240, 240, 240));
        t.setFont(new Font("Arial", Font.BOLD, 26));
        t.setText(title);

        return chart;

    }
}
