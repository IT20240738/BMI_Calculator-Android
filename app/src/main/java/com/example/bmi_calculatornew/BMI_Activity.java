package com.example.bmi_calculatornew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BMI_Activity extends AppCompatActivity {

    android.widget.Button mrecalculatebmi;

    TextView mbmiDisplay,mbmiCategory, mGender;
    Intent intent;
    ImageView mImageview;
    String mbmi;
    float intBmi;

    String height;
    String weight;
    float intHeight, intWeight;
    RelativeLayout mBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);


        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1e1d1d"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        intent = getIntent();

        mrecalculatebmi = findViewById(R.id.recalBtn);
        mbmiDisplay = findViewById(R.id.bmiDisplay);
        mbmiCategory = findViewById(R.id.bmicategorydisplay);
        mGender = findViewById(R.id.genderDisplay);
        mBackground = findViewById(R.id.detail);
        mImageview = findViewById(R.id.ok);

        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");

        intHeight = Float.parseFloat(height);
        intWeight = Float.parseFloat(weight);

        //cm convert to m
        intHeight = intHeight/100;

        //calculation BMI
        intBmi = intWeight/(intHeight*intHeight);

        mbmi = Float.toString(intBmi);

        if(intBmi<16){
            mbmiCategory.setText("Server Thinness");
            mBackground.setBackgroundColor(Color.RED);
            mImageview.setImageResource(R.drawable.crosss);
        }
        else if(intBmi<16.9 && intBmi > 16){
            mbmiCategory.setText("Moderate Thinness");
            mBackground.setBackgroundColor(Color.RED);
            mImageview.setImageResource(R.drawable.warning);
        }

        else if(intBmi<18.4 && intBmi > 17){
            mbmiCategory.setText("Mild Thinness");
            mBackground.setBackgroundColor(Color.RED);
            mImageview.setImageResource(R.drawable.warning);
        }
        else if(intBmi<25 && intBmi > 18.4){
            mbmiCategory.setText("Normal");
//            mBackground.setBackgroundColor(Color.YELLOW);
            mImageview.setImageResource(R.drawable.ok);
        }
        else if(intBmi<29.4 && intBmi > 25){
            mbmiCategory.setText("Overweight");
            mBackground.setBackgroundColor(Color.RED);
            mImageview.setImageResource(R.drawable.warning);
        }
        else{
                mbmiCategory.setText("Obese Class I");
                mBackground.setBackgroundColor(Color.RED);
                mImageview.setImageResource(R.drawable.warning);
        }

        mGender.setText(intent.getStringExtra("gender"));
        mbmiDisplay.setText(mbmi);

//        getSupportActionBar().hide();
//        mrecalculatebmi = findViewById(R.id.recalBtn);

        mrecalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(BMI_Activity.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
}