package com.kvanasample.linegraph;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
public class MainActivity extends AppCompatActivity {
    private LineChartView lineChartView;
    private String[] axisData = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept",
            "Oct", "Nov", "Dec"};
    private int[] yAxisData = {50, 20, 15, 30, 20, 60, 15, 40, 45, 10, 90, 18};
    private List yAxisValues = new ArrayList();
    private List axisValues = new ArrayList();
    private Line line = new Line(yAxisValues);
    private LineChartData data = new LineChartData();
    private List lines = new ArrayList();
    Axis yAxis = new Axis();
    Axis axis = new Axis();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lineChartView = findViewById(R.id.chart);
        for(int i = 0; i < axisData.length; i++){
            axisValues.add(i, new AxisValue(i).setLabel(axisData[i]));
        }

        for (int i = 0; i < yAxisData.length; i++){
            yAxisValues.add(new PointValue(i, yAxisData[i]));
        }
        lines.add(line);
        data.setLines(lines);
        lineChartView.setLineChartData(data);
//        lineChartView.draw();
//        lineChartView.
        axis.setValues(axisValues);
        data.setAxisXBottom(axis);
        data.setAxisYLeft(yAxis);
        Line line = new Line(yAxisValues).setColor(Color.parseColor("#9C27B0"));
        axis.setTextSize(16);
//        axis.setTextColor(Color.parseColor("#FFFFFF"));
        axis.setTextColor(Color.parseColor("#03A9F4"));
        yAxis.setTextColor(Color.parseColor("#03A9F4"));
        yAxis.setTextSize(16);

        Viewport viewport = new Viewport(lineChartView.getMaximumViewport());
        viewport.top =110;
        lineChartView.setMaximumViewport(viewport);
        lineChartView.setCurrentViewport(viewport);

        // Add label
//        yAxis.setName("Sales in millions");
    }
}
