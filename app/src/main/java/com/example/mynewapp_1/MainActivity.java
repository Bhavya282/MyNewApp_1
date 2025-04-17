package com.example.mynewapp_1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        TextView result;
        EditText edtWeight , edtHeightFt , edtHeightInch;
        Button btnCalc;
        LinearLayout main;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        edtHeightInch = findViewById(R.id.edtHeightInch);
        btnCalc = findViewById(R.id.btnCalc);
        result = findViewById(R.id.result);
        main = findViewById(R.id.main);


        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(edtWeight.getText().toString());
                int ft = Integer.parseInt(edtHeightFt.getText().toString());
                int inch = Integer.parseInt((edtHeightInch.getText().toString()));

                int totalIn = ft*12 + inch;

                double totalCm = totalIn * 2.53;

                double totalM = totalCm / 100;

                double bmi = wt/(totalM*totalM);

                if(bmi>25){
                    result.setText("You Are Over Weight Nigga");
                    main.setBackgroundColor(getResources().getColor(R.color.red));
                } else if (bmi < 18) {
                    result.setText("You Are Under Weight Nigruu");
                    main.setBackgroundColor(getResources().getColor(R.color.yellow));
                }
                else{
                    result.setText("You Are All Great Nigga Chan");
                    main.setBackgroundColor(getResources().getColor(R.color.green));
                }

            }
        });



    }
}