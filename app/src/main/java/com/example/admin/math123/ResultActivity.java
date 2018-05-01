package com.example.admin.math123;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {
    int point;
    TextView textPoint;
    TextView textFalse;
    TextView textTrue;
    Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = this.getIntent();
        point = Integer.parseInt(intent.getStringExtra("point"));
        textPoint = (TextView)findViewById(R.id.textPointResult);
        textFalse = (TextView)findViewById(R.id.textFalseResult);
        textTrue = (TextView)findViewById(R.id.textTrueResult);
        int True = point/10;
        int False = 10-True;
        textPoint.setText(String.valueOf(point));
        textFalse.setText(String.valueOf(False));
        textTrue.setText(String.valueOf(True));
        btnNext = (Button)findViewById(R.id.btnNextResult);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent NextIntent = new Intent(ResultActivity.this,MainActivity.class);
                startActivity(NextIntent);
            }
        });
    }
}
