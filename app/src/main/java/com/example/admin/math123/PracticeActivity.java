package com.example.admin.math123;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class PracticeActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practice_activity);
        Button btnToando = (Button)findViewById(R.id.btn_Toando);
        btnToando.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PracticeActivity.this,ToandoActivity.class);
                startActivity(intent);
            }
        });
        Button btnToanhinh = (Button)findViewById(R.id.btn_Toanhinh);
        btnToanhinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PracticeActivity.this,ToanhinhActivity.class);
                startActivity(intent);
            }
        });
        Button btnLonbe = (Button)findViewById(R.id.btn_Lonbe);
        btnLonbe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PracticeActivity.this,LonbeActivity.class);
                startActivity(intent);
            }
        });
        Button btnTinhnham = (Button)findViewById(R.id.btn_Tinhnham);
        btnTinhnham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PracticeActivity.this,TinhnhamActivity.class);
                startActivity(intent);
            }
        });
        Button btnTapdem = (Button)findViewById(R.id.btn_Tapdem);
        btnTapdem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PracticeActivity.this,TapdemActivity.class);
                startActivity(intent);
            }
        });
    }
}
