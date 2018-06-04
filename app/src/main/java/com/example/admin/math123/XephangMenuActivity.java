package com.example.admin.math123;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.math123.core.Xephang;

import static com.example.admin.math123.settingActivity.musicEffectChecked;
import static com.example.admin.math123.settingActivity.musicfail;
import static com.example.admin.math123.settingActivity.musicsuccess;

public class XephangMenuActivity extends AppCompatActivity {
    public static MediaPlayer music;
    int Layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(musicEffectChecked)
        {
            musicsuccess = MediaPlayer.create(XephangMenuActivity.this,R.raw.music_success);
            musicfail = MediaPlayer.create(XephangMenuActivity.this,R.raw.music_fail);
        }
        if(music == null)
        {
            music = MediaPlayer.create(XephangMenuActivity.this,R.raw.music_background);
            music.setLooping(true);
            music.start();
        }
        Button btnTest = (Button)findViewById(R.id.btnTest);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(XephangMenuActivity.this, XephangActivity.class);
                startActivity(intent);
                Layout = 1;
            }
        });
        Button btnTapDem = (Button)findViewById(R.id.btnTapDem);
        btnTapDem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(XephangMenuActivity.this, XephangActivity.class);
                startActivity(intent);
                Layout = 2;
            }
        });
        final Button btnLonBe = (Button)findViewById(R.id.btnLonBe);
        btnLonBe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(XephangMenuActivity.this, XephangActivity.class);
                startActivity(intent);
                Layout = 3;
            }
        });

        Button btnToanHinh = (Button)findViewById(R.id.btnToanHinh);
        btnToanHinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(XephangMenuActivity.this, XephangActivity.class);
                startActivity(intent);
                Layout = 4;
            }
        });

        Button btnTinhNham = (Button)findViewById(R.id.btnTinhNham);
        btnTinhNham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(XephangMenuActivity.this, XephangActivity.class);
                startActivity(intent);
                Layout = 5;
            }
        });

        Button btnToanDo = (Button)findViewById(R.id.btnToanDo);
        btnToanDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(XephangMenuActivity.this, XephangActivity.class);
                startActivity(intent);
                Layout = 6;
            }
        });
    }
}
