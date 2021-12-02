package com.example.bmi_calculatornew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button ccalBmi;

    TextView mcurrentHeight;
    TextView mcurrentWeight, mcurrentAge;
    ImageView mincrementWeight,mdecrementWeight,mincrementAge,mdecrementAge;
    SeekBar mseekbarForHeight;
    RelativeLayout mMale, mFemale;

    int intWeight = 50;
    int intAge = 20;
    int currentprogress;
    String mintprogress = "170";
    String typeofUser = "0";
    String weight2 = "50";
    String age2 = "20";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        ccalBmi= findViewById(R.id.calBtn);
        mcurrentHeight = findViewById(R.id.currentHeight);
        mcurrentWeight = findViewById(R.id.currentWeight);
        mcurrentAge = findViewById(R.id.currentAge);
        mincrementWeight = findViewById(R.id.incrementWeight);
        mdecrementWeight = findViewById(R.id.decrementWeight);
        mincrementAge = findViewById(R.id.incrementAge);
        mdecrementAge = findViewById(R.id.decrementAge);
        mseekbarForHeight = findViewById(R.id.seekbarforheight);
        mMale = findViewById(R.id.male);
        mFemale = findViewById(R.id.female);

        //Click after change the background
        mMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocuse));
                mFemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeofUser="Male";
            }
        });

        mFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocuse));
                mMale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeofUser="Female";
            }
        });

        //seekbar set the max value
        mseekbarForHeight.setMax(300);
        mseekbarForHeight.setProgress(170);

        mseekbarForHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                currentprogress = i;
                mintprogress = String.valueOf(currentprogress);
                mcurrentHeight.setText(mintprogress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mincrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intAge = intAge +1;
                age2 = String.valueOf(intAge);
                mcurrentAge.setText(age2);

            }
        });

        mdecrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intAge = intAge - 1;
                age2 = String.valueOf(intAge);
                mcurrentAge.setText(age2);
            }
        });


        mincrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intWeight = intWeight +1;
                weight2 = String.valueOf(intWeight);
                mcurrentWeight.setText(weight2);
            }
        });

        mdecrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intWeight = intWeight - 1;
                weight2 = String.valueOf(intWeight);
                mcurrentWeight.setText(weight2);
            }
        });





        ccalBmi.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(typeofUser.equals("0")){
                    Toast.makeText(getApplicationContext(), "Select Your Gender First", Toast.LENGTH_SHORT).show();
                }
                else if(mintprogress.equals("0")){
                    Toast.makeText(getApplicationContext(), "Select Your Height First", Toast.LENGTH_SHORT).show();
                }
                else if(intAge==0 || intAge<0){
                    Toast.makeText(getApplicationContext(), "Your Age Is Invalid", Toast.LENGTH_SHORT).show();
                }
                else if(intWeight == 0 || intWeight<0){
                    Toast.makeText(getApplicationContext(), "Your Weight Is Invalid", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(MainActivity.this,BMI_Activity.class);

                    //pass the data
                    intent.putExtra("gender",typeofUser);
                    intent.putExtra("height",mintprogress);
                    intent.putExtra("weight",weight2);
                    intent.putExtra("age",age2);

                    startActivity(intent);

                }


            }
        });
    }
}