package com.example.spacetravel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button button_planets, button_stars;
    public static int section_name;
    public static int result_points = 0;
    public static int button_flag = 0;
    public static ArrayList<Integer> planets_points = new ArrayList<>();
    public static ArrayList<Integer> stars_points= new ArrayList<>();
    public static String which_graphic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (button_flag != 0) {
            TextView result = findViewById(R.id.result_points);
            if (MainActivity.section_name == 1) {
                result.setText("You get " + MainActivity.result_points + " for section planets");
                planets_points.add(result_points);
            } else {
                result.setText("You get " + MainActivity.result_points + " for section stars");
                stars_points.add(result_points);
            }
            button_flag = 0;
            result_points = 0;
        }
        button_planets = findViewById(R.id.planets_button);
        button_planets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                section_name = 1;
                Intent intent = new Intent(MainActivity.this, QuestionsActivity.class);
                startActivity(intent);
            }
        });
        button_stars = findViewById(R.id.stars_button);
        button_stars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                section_name = 2;
                Intent intent = new Intent(MainActivity.this, QuestionsActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.planets_menu){
            which_graphic ="planets";
        }
        else{
            which_graphic ="stars";
        }
        Intent intent = new Intent(MainActivity.this, Graphics.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}