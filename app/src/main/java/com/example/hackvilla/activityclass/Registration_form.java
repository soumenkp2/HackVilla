package com.example.hackvilla.activityclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hackvilla.R;

import java.util.Random;

public class Registration_form extends AppCompatActivity {

    int teamcode = 7898;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);


        EditText name = (EditText) findViewById(R.id.name);
        EditText mail = (EditText) findViewById(R.id.mail);
        EditText phone = (EditText) findViewById(R.id.phone);
        EditText code = (EditText) findViewById(R.id.code);

        TextView create = (TextView) findViewById(R.id.newteam);
        TextView join = (TextView) findViewById(R.id.jointeam);
        TextView teamtxt = (TextView) findViewById(R.id.teamtext);
        TextView submit = (TextView) findViewById(R.id.submit);

        LinearLayout linear = (LinearLayout) findViewById(R.id.lineartext);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //teamcode = random.nextInt(1000);
                linear.setVisibility(View.VISIBLE);
                teamtxt.setText("Team Name : ");

            }
        });


        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //teamcode = random.nextInt(1000);
                linear.setVisibility(View.VISIBLE);
                teamtxt.setText("Team Code : ");

            }
        });







    }
}