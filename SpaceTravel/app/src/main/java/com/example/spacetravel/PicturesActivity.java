package com.example.spacetravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PicturesActivity extends AppCompatActivity {
    private int[] myPlanetsList;
    private int[] myStarsList;
    private List<String> planets_answers;
    private List<String> stars_answers;
    int generateNumber;
    private int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pictures);
        if (MainActivity.section_name == 1) {
            TextView task_second = findViewById(R.id.task_second);
            task_second.setText(R.string.task_name_planets);
            task_second.setTextSize(23);
            workWithPlanets();
        } else if (MainActivity.section_name == 2) {
            TextView task_second = findViewById(R.id.task_second);
            task_second.setText(R.string.task_name_stars);
            task_second.setTextSize(20);
            workWithStars();
        }
        Button button_home = findViewById(R.id.home_screen);
        button_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.button_flag = 1;
                Intent intent = new Intent(PicturesActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void workWithPlanets() {
        planets_answers = Arrays.asList(getResources().getStringArray(R.array.a_image_planet_array));
        myPlanetsList = new int[]{R.drawable.earth, R.drawable.jupiter,
                R.drawable.mars, R.drawable.mercury, R.drawable.neptune, R.drawable.pluto,
                R.drawable.saturn, R.drawable.uranus, R.drawable.venus};
        Random random = new Random();
        generateNumber = random.nextInt(9);
        ImageView imagePlanet = findViewById(R.id.imageShow);
        imagePlanet.setImageResource(myPlanetsList[generateNumber]);
        ImageButton checkImage = findViewById(R.id.checkImage);
        checkImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView image_tick = findViewById(R.id.tick);
                EditText edit = findViewById(R.id.answer_image);
                String answer = edit.getText().toString();
                if (generateNumber == planets_answers.indexOf(answer)) {
                    image_tick.setImageResource(R.drawable.green);
                    MainActivity.result_points += 2;
                    points += 2;
                } else {
                    image_tick.setImageResource(R.drawable.red);
                }
                TextView points_image = findViewById(R.id.points_image);
                points_image.setText("You get " + points + " point(s) for this section");
                points = 0;
            }
        });
    }

    private void workWithStars() {
        stars_answers = Arrays.asList(getResources().getStringArray(R.array.a_image_stars_array));
        myStarsList = new int[]{R.drawable.centaurus, R.drawable.cepheus,
                R.drawable.dragon, R.drawable.hydra, R.drawable.kassiopeya};
        Random random = new Random();
        generateNumber = random.nextInt(5);
        ImageView imageShow = findViewById(R.id.imageShow);
        imageShow.setImageResource(myStarsList[generateNumber]);
        ImageButton checkImage = findViewById(R.id.checkImage);
        checkImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView image_tick = findViewById(R.id.tick);
                EditText edit = findViewById(R.id.answer_image);
                String answer = edit.getText().toString();
                if (generateNumber == stars_answers.indexOf(answer)) {
                    image_tick.setImageResource(R.drawable.green);
                    MainActivity.result_points += 2;
                    points += 2;
                } else {
                    image_tick.setImageResource(R.drawable.red);
                }
                TextView points_image = findViewById(R.id.points_image);
                points_image.setText("You get " + points + " point(s) for this section");
                points = 0;
            }
        });
    }
}