package com.example.spacetravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class QuestionsActivity extends AppCompatActivity {
    List<String> planets_que;
    List<String> planets_ans;
    List<String> stars_que;
    List<String> stars_ans;
    int f_q = -1, s_q = -1, t_q = -1;
    private int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        ImageButton buttonForward = findViewById(R.id.forward);
        float deg = buttonForward.getRotation() + 180F;
        buttonForward.animate().rotation(deg).setInterpolator(new AccelerateDecelerateInterpolator());
        if (MainActivity.section_name == 1) {
            workWithPlanets();
        } else if (MainActivity.section_name == 2) {
            workWithStars();
        }
        ImageButton buttonBack = findViewById(R.id.backButton);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuestionsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        buttonForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuestionsActivity.this, PicturesActivity.class);
                startActivity(intent);
            }
        });

    }

    private int getRandomNumber() {
        Random random = new Random();
        int x;
        if (f_q == -1) {
            return random.nextInt(10);
        } else if (s_q == -1) {
            x = random.nextInt(10);
            while (x == f_q) {
                x = random.nextInt(10);
            }
            return x;
        } else {
            x = random.nextInt(10);
            while (x == f_q || x == s_q) {
                x = random.nextInt(10);
            }
        }
        return x;
    }

    private void workWithPlanets() {
        planets_que = Arrays.asList(getResources().getStringArray(R.array.q_planets_array));
        planets_ans = Arrays.asList(getResources().getStringArray(R.array.a_planets_array));
        f_q = getRandomNumber();
        s_q = getRandomNumber();
        t_q = getRandomNumber();
        TextView first_que = findViewById(R.id.first_question);
        TextView second_que = findViewById(R.id.second_question);
        TextView third_que = findViewById(R.id.third_question);
        first_que.setText("1) " + planets_que.get(f_q));
        second_que.setText("2) " + planets_que.get(s_q));
        third_que.setText("3) " + planets_que.get(t_q));
        Button buttonCheck = findViewById(R.id.buttonCheck);
        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPlanets();
            }
        });
    }

    private void checkPlanets() {
        ImageView image1 = findViewById(R.id.imFirstQue);
        ImageView image2 = findViewById(R.id.imSecondQue);
        ImageView image3 = findViewById(R.id.imThirdQue);
        EditText edit_1 = findViewById(R.id.first_answer);
        EditText edit_2 = findViewById(R.id.second_answer);
        EditText edit_3 = findViewById(R.id.third_answer);
        if (edit_1.getText().toString().equals(planets_ans.get(f_q))) {
            points++;
            MainActivity.result_points++;
            image1.setBackgroundResource(R.drawable.green);
        } else {
            image1.setBackgroundResource(R.drawable.red);
        }
        if (edit_2.getText().toString().equals(planets_ans.get(s_q))) {
            points++;
            MainActivity.result_points++;
            image2.setBackgroundResource(R.drawable.green);
        } else {
            image2.setBackgroundResource(R.drawable.red);
        }
        if (edit_3.getText().toString().equals(planets_ans.get(t_q))) {
            points++;
            MainActivity.result_points++;
            image3.setBackgroundResource(R.drawable.green);
        } else {
            image3.setBackgroundResource(R.drawable.red);
        }
        TextView textPoints = findViewById(R.id.points);
        textPoints.setText("You get " + points + " point(s) for this section");
        points = 0;
    }

    private void workWithStars() {
        stars_que = Arrays.asList(getResources().getStringArray(R.array.q_stars_array));
        stars_ans = Arrays.asList(getResources().getStringArray(R.array.a_stars_array));
        f_q = getRandomNumber();
        s_q = getRandomNumber();
        t_q = getRandomNumber();
        TextView first_que = findViewById(R.id.first_question);
        TextView second_que = findViewById(R.id.second_question);
        TextView third_que = findViewById(R.id.third_question);
        first_que.setText("1) " + stars_que.get(f_q));
        second_que.setText("2) " + stars_que.get(s_q));
        third_que.setText("3) " + stars_que.get(t_q));
        Button buttonCheck = findViewById(R.id.buttonCheck);
        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkStars();
            }
        });
    }

    private void checkStars() {
        ImageView image1 = findViewById(R.id.imFirstQue);
        ImageView image2 = findViewById(R.id.imSecondQue);
        ImageView image3 = findViewById(R.id.imThirdQue);
        EditText edit_1 = findViewById(R.id.first_answer);
        EditText edit_2 = findViewById(R.id.second_answer);
        EditText edit_3 = findViewById(R.id.third_answer);
        if (edit_1.getText().toString().equals(stars_ans.get(f_q))) {
            points++;
            MainActivity.result_points++;
            image1.setBackgroundResource(R.drawable.green);
        } else {
            image1.setBackgroundResource(R.drawable.red);
        }
        if (edit_2.getText().toString().equals(stars_ans.get(s_q))) {
            points++;
            MainActivity.result_points++;
            image2.setBackgroundResource(R.drawable.green);
        } else {
            image2.setBackgroundResource(R.drawable.red);
        }
        if (edit_3.getText().toString().equals(stars_ans.get(t_q))) {
            points++;
            MainActivity.result_points++;
            image3.setBackgroundResource(R.drawable.green);
        } else {
            image3.setBackgroundResource(R.drawable.red);
        }
        TextView textPoints = findViewById(R.id.points);
        textPoints.setText("You get " + points + " point(s) for this section");
        points = 0;
    }
}