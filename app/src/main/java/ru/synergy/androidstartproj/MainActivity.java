package ru.synergy.androidstartproj;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQ_C = 1;
    EditText et;
    private TextView tv;

     ActivityResultLauncher<Intent> mStartActivityForResult = registerForActivityResult(
             new ActivityResultContracts.StartActivityForResult(),
             new ActivityResultCallback<ActivityResult>() {
                 @Override
                 public void onActivityResult(ActivityResult result) {
                     Intent intent = result.getData();
                     tv.setText(intent.getStringExtra("tv"));
                 }
             }
     );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        et = (EditText) findViewById(R.id.et);
        tv = (TextView) findViewById(R.id.tv);


        Button bnt = (Button) findViewById(R.id.button);
        Button bnt2 = (Button) findViewById(R.id.button2);
        Button bnt3 = (Button) findViewById(R.id.button3);

        bnt.setOnClickListener(this);
        bnt2.setOnClickListener(this);
        bnt3.setOnClickListener(this);

   }


    @Override
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
                        mStartActivityForResult.launch(i);
                        break;
        }
    }
}