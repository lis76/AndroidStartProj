package ru.synergy.androidstartproj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int REQ_C = 1;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        et = (EditText) findViewById(R.id.et);

   }

    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.button:
                i= new Intent(this, MainActivity2.class);
                startActivity(i);
                break;
                case R.id.button2:
                    i= new Intent(this, ToInActivity.class);
                    String eText = et.getText().toString();
                    i.putExtra("et", eText);
                    startActivity(i);
                    break;
                    case R.id.button3:
                        i= new Intent(this, ComeBackActivity.class);
                        startActivityForResult(i, REQ_C);
                        break;
        }
    }
}