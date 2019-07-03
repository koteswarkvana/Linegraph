package com.kvanasample.linegraph;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

// http://shaoniiuc.com/android/android-line-chart-example/
public class LineChartWithoutDotsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart_without_dots);
        drawLineChart();
    }

    private void drawLineChart() {
        LineChart lineChart = findViewById(R.id.lineChart);
        List<Entry> lineEntries = getDataSet();
        LineDataSet lineDataSet = new LineDataSet(lineEntries, getString(R.string.oil_price));
//        lineDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
//        lineDataSet.setHighlightEnabled(true);
        lineDataSet.setLineWidth(2);
        lineDataSet.setColor(Color.RED);
//        lineDataSet.setCircleColor(Color.YELLOW);
//        lineDataSet.setCircleRadius(0);
//        lineDataSet.setCircleHoleRadius(0);
//        lineDataSet.setDrawHighlightIndicators(true);
//        lineDataSet.setHighLightColor(Color.RED);
//        lineDataSet.setValueTextSize(12);
//        lineDataSet.setValueTextColor(Color.DKGRAY);

        ///
//        lineDataSet.
        ///

        LineData lineData = new LineData(lineDataSet);
//        lineChart.getDescription().setText(getString(R.string.price_in_last_12_days));
        lineChart.getDescription().setTextSize(12);
//        lineChart.setDrawMarkers(false);
        /*lineChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTH_SIDED);
        lineChart.animateY(1000);*/
        lineChart.getXAxis().setGranularityEnabled(true);
        lineChart.getXAxis().setGranularity(1.0f);
        lineChart.getXAxis().setLabelCount(lineDataSet.getEntryCount());
        lineChart.setData(lineData);

//        lineChart.

        ///

        lineChart.setDrawGridBackground(false);
        lineChart.setBackgroundColor(Color.TRANSPARENT);
        lineChart.getXAxis().setDrawGridLines(false);
        lineChart.getAxisLeft().setDrawGridLines(false);
        lineChart.getAxisRight().setDrawGridLines(false);
        lineChart.getAxisLeft().setLabelCount(4);
        lineChart.setDrawMarkers(false);
        ///
    }

    private List<Entry> getDataSet() {
        List<Entry> lineEntries = new ArrayList<Entry>();
        lineEntries.add(new Entry(0, 1));
        lineEntries.add(new Entry(1, 2));
        lineEntries.add(new Entry(4, 3));
        lineEntries.add(new Entry(3, 4));
        /*lineEntries.add(new Entry(4, 2));
        lineEntries.add(new Entry(5, 3));
        lineEntries.add(new Entry(6, 1));
        lineEntries.add(new Entry(7, 5));
        lineEntries.add(new Entry(8, 7));
        lineEntries.add(new Entry(9, 6));
        lineEntries.add(new Entry(10, 4));
        lineEntries.add(new Entry(11, 5));*/
        return lineEntries;
    }

}
