package ru.synergy.androidstartproj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        final Button calculate = (Button) findViewById(R.id.button);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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

        float numone = Integer.parseInt(numOne.getText().toString());
        float numtwo = Integer.parseInt(numTwo.getText().toString());

        float solution = 0;

        if (add.isChecked()){
            solution = numone + numtwo;
        }
        if (sub.isChecked()){
            solution = numone - numtwo;
        }
        if (mul.isChecked()){
            solution = numone * numtwo;
        }
        if (div.isChecked()){
            if (numtwo == 0){
                Toast.makeText(this, "Число два не может быть нулевым", Toast.LENGTH_SHORT).show();
                return;
            }
            solution = numone / numtwo;
        }

        answer.setText("Ответ таков  " + solution);


    }
}