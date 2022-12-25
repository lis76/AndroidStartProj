package ru.synergy.androidstartproj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {
    private static final String LogcatTag = "CALCULATOR_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        final Button calculate = (Button) findViewById(R.id.button);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(LogcatTag, "Button have been pushed");
                calculateAnswe();
            }
        });

    }

    private void calculateAnswe() {
        EditText numOne = (EditText) findViewById(R.id.editTextNumberDecimal);
        EditText numTwo = (EditText) findViewById(R.id.editTextNumberDecimal2);

        RadioButton add = (RadioButton) findViewById(R.id.radioButton11);
        RadioButton sub = (RadioButton) findViewById(R.id.radioButton12);
        RadioButton mul = (RadioButton) findViewById(R.id.radioButton13);
        RadioButton div = (RadioButton) findViewById(R.id.radioButton14);

        TextView answer = (TextView) findViewById(R.id.textView);
        TextView answer1 = (TextView) findViewById(R.id.textView6);

        Log.d(LogcatTag, "All views have been founded");

        float numone = Integer.parseInt(numOne.getText().toString());
        float numtwo = Integer.parseInt(numTwo.getText().toString());

        Log.d(LogcatTag, "Successfully grabbed data from input fields");
        Log.d(LogcatTag, "numone is: " + numone + ";" + "numtwo is: " + numtwo );

        float solution = 0;

        if (add.isChecked()){
            Log.d(LogcatTag, "Operations is add");
            solution = numone + numtwo;
        }
        if (sub.isChecked()){
            Log.d(LogcatTag, "Operations is sub");
            solution = numone - numtwo;
        }
        if (mul.isChecked()){
            Log.d(LogcatTag, "Operations is mul");
            solution = numone * numtwo;
        }
        if (div.isChecked()){
            Log.d(LogcatTag, "Operations is div");
            if (numtwo == 0){
                Toast.makeText(this, "Число два не может быть нулевым", Toast.LENGTH_SHORT).show();
                return;
            }
            solution = numone / numtwo;
        }


        Log.d(LogcatTag, "The result of operations is: " + solution);

        answer.setText("Готово же  " + solution);
        answer1.setText("Давай ещё )))");


    }
}