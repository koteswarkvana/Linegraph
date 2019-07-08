package com.kvanasample.linegraph;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

// https://www.codingdemos.com/draw-android-line-chart/
//http://nipunswritings.blogspot.com/2016/06/hellocharts-for-android-example.html
public class MainActivity extends AppCompatActivity {
    private LineChartView lineChartView;
    private String[] xAxisData = {"J", "F", "M", "A", "M", "J", "J", "A", "S", "O", "N", "D"};
    private int[] yAxisData = {50, 20, 15, 30, 20, 60, 15, 40, 45, 10, 90, 18};

    private List xAxisValues = new ArrayList();
    private List yAxisValues = new ArrayList();

    private Line yAxisLine = new Line(yAxisValues);
    private Line xAxisLine = new Line(xAxisValues);

    private LineChartData lineChartData = new LineChartData();
    private List lines = new ArrayList();

    private Axis xAxis = new Axis();
    private Axis yAxis = new Axis();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lineChartView = findViewById(R.id.chart);
        for (int i = 0; i < xAxisData.length; i++) {
            xAxisValues.add(i, new AxisValue(i).setLabel(xAxisData[i]));
        }

        for (int j = 0; j < yAxisData.length; j++) {
            yAxisValues.add(new PointValue(j, yAxisData[j]));
        }

        lines.add(yAxisLine);
        lineChartData.setLines(lines);
        lineChartView.setLineChartData(lineChartData);
        lineChartView.setZoomEnabled(true);
        xAxis.setValues(xAxisValues);
        lineChartData.setAxisXBottom(xAxis);
        lineChartData.setAxisYLeft(yAxis);

        // Set the top, bottom, left and right values by using Viewport.
        lineChartView.setLineChartData(lineChartData);
        Viewport viewport = new Viewport(lineChartView.getMaximumViewport());
        viewport.top = 200;
        viewport.bottom = 0;
        viewport.left = 0;
        viewport.right = 12;

        lineChartView.setMaximumViewport(viewport);
        lineChartView.setCurrentViewport(viewport);
        lineChartView.setScrollEnabled(false);
        lineChartView.setZoomEnabled(false);

        Line line = new Line(yAxisValues).setColor(Color.parseColor("#9C27B0"));
        xAxis.setTextSize(10);
        xAxis.setName("x - Axis data");
        xAxis.setTextColor(Color.parseColor("#03A9F4"));
        yAxis.setTextColor(Color.parseColor("#03A9F4"));
        yAxis.setTextSize(10);
        lineChartView.getRight();
    }
}
