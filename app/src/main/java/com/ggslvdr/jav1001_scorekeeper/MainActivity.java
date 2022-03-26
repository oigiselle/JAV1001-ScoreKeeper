package com.ggslvdr.jav1001_scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
int goals1 = 0;
int goals2 = 0;
private Spinner spinnerPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initialize spinner
        spinnerPoints = findViewById(R.id.spinnerPoints);
        spinnerValues();
    }

    // set values into spinner
    private void spinnerValues(){
        String[] points = new String[]{
             "1", "2", "3"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (
                this, android.R.layout.simple_spinner_item, points
                );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPoints.setAdapter( adapter );
    }

    // actions to increase points to team 1
    public void teamOneAttack(View view){
        TextView text1 = findViewById(R.id.team1points);
        String pointsString1 = spinnerPoints.getSelectedItem().toString();
        int points1 = Integer.parseInt(pointsString1);
        goals1 += points1;
        text1.setText("" + goals1);
    }

    // actions to increase points to team 2
    public void teamTwoAttack(View view){
        TextView text2 = findViewById(R.id.team2points);
        String pointsString2 = spinnerPoints.getSelectedItem().toString();
        int points2 = Integer.parseInt(pointsString2);
        goals2 += points2;
        text2.setText("" + goals2);
    }

    // actions to decrease points to team1
    public void teamOneDefense(View view){
        TextView text1 = findViewById(R.id.team1points);
        String pointsString1 = spinnerPoints.getSelectedItem().toString();
        int points1 = Integer.parseInt(pointsString1);
        goals1 -= points1;
        if (goals1 > 0) {
            text1.setText("" + goals1);
        }else{
            text1.setText("0");
            goals1 = 0;
        }

        }
    // actions to decrease points to team2
    public void teamTwoDefense(View view){
        TextView text2 = findViewById(R.id.team2points);
        String pointsString2 = spinnerPoints.getSelectedItem().toString();
        int points2 = Integer.parseInt(pointsString2);
        goals2 -= points2;
        if (goals2 > 0) {
            text2.setText("" + goals2);
        }else{
            text2.setText("0");
            goals2 = 0;
        }
    }



}