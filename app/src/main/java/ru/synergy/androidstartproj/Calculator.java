package ru.synergy.androidstartproj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.SimpleCursorAdapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {
    private static final String LogcatTag = "CALCULATOR_ACTIVITY";
    private static final String LifecycleTag = "LIFECYCLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LifecycleTag, "I'm onCreate() and i'm started");
        setContentView(R.layout.activity_calculator);

        final Button calculate = (Button) findViewById(R.id.button);

        // Context trending
//        TextView textView = new TextView(this);
//        ListAdapter adapter = new SimpleCursorAdapter(getApplicationContext(),);
//
//                // Доступ из класса Activity -- наследник Context
//        getSystemService(LAYOUT_INFLATER_SERVICE);
//                // Shared prefs доступ с использованием контекста приложения
//        SharedPreferences prefs = getApplicationContext().getSharedPreferences("PREFS", MODE_PRIVATE);
        ////


        //// intent - это посылка
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(LogcatTag, "Button have been pushed");
                calculateAnswe();
                Intent i = new Intent(Calculator.this, MainActivity.class); //Написать письмо
                startActivity(i);// Отправить письмо
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LifecycleTag, "I'm onStart(), and i'm started");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LifecycleTag, "I'm onStop(), and i'm started");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LifecycleTag, "I'm onDestroy(), and i'm started");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LifecycleTag, "I'm onPause(), and i'm started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LifecycleTag, "I'm onResume(), and i'm started");
    }

    private void calculateAnswe() {
        EditText numOne = (EditText) findViewById(R.id.editTextNumberDecimal);
        EditText numTwo = (EditText) findViewById(R.id.editTextNumberDecimal2);

        RadioButton add = (RadioButton) findViewById(R.id.radioButton11);
        RadioButton sub = (RadioButton) findViewById(R.id.radioButton12);
        RadioButton mul = (RadioButton) findViewById(R.id.radioButton13);
        RadioButton div = (RadioButton) findViewById(R.id.radioButton14);

        numOne.setText("0");
        numTwo.setText("0");
        add.setChecked(true);

        TextView answer = (TextView) findViewById(R.id.textView);
        TextView answer1 = (TextView) findViewById(R.id.textView6);

        Log.d(LogcatTag, "All views have been founded");

        float numtwo = 0;
        float numone = 0;
        String num1 = numOne.getText().toString();
        String num2 = numTwo.getText().toString();

        if (num1.equals("")  && num1 != null) {
            numone = Integer.parseInt(numOne.getText().toString());
        }

        if (num2.equals("") && num2 != null) {
            numtwo = Integer.parseInt(numTwo.getText().toString());
        }

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

        Context contextApp = getApplicationContext();
        Context context = getBaseContext();

    }
}