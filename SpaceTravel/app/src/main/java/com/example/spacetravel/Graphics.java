package com.example.spacetravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;
import org.w3c.dom.Text;

public class Graphics extends AppCompatActivity {
    private GraphicalView mChart;
    private XYMultipleSeriesDataset mDataSet = new XYMultipleSeriesDataset();
    private XYMultipleSeriesRenderer mRender = new XYMultipleSeriesRenderer();
    private XYSeries mCurrentSeries;
    private XYSeriesRenderer mCurrentRender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphics);
        TextView text_res = findViewById(R.id.text_result);
        if (MainActivity.which_graphic.equals("planets")) {
            text_res.setText("Your results on section planets:");
        } else {
            text_res.setText("Your results on section stars:");
        }
        Button button_back = findViewById(R.id.back_main);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Graphics.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initChart() {
        if (MainActivity.which_graphic.equals("planets")) {
            mCurrentSeries = new XYSeries("Planets results");
        } else {
            mCurrentSeries = new XYSeries("Stars results");
        }
        mDataSet.addSeries(mCurrentSeries);
        if (MainActivity.which_graphic.equals("planets")) {
            for (int i = 0; i < MainActivity.planets_points.size(); i++) {
                mCurrentSeries.add(i + 1, MainActivity.planets_points.get(i));
            }
        } else {
            for (int i = 0; i < MainActivity.stars_points.size(); i++) {
                mCurrentSeries.add(i + 1, MainActivity.stars_points.get(i));
            }
        }
        mCurrentRender = new XYSeriesRenderer();
        mCurrentRender.setLineWidth(4);
        mRender.addSeriesRenderer(mCurrentRender);
        mRender.setShowGrid(true);
        mRender.setPanEnabled(false, false);
        mRender.setLabelsTextSize(25);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LinearLayout layout = findViewById(R.id.graphic);
        if (mChart == null) {
            initChart();
            mChart = ChartFactory.getLineChartView(this, mDataSet, mRender);
            layout.addView(mChart);
            mChart.repaint();
        }
    }
}