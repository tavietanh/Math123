package com.example.admin.math123;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.admin.math123.settingActivity.musicEffectChecked;
import static com.example.admin.math123.settingActivity.musicfail;
import static com.example.admin.math123.settingActivity.musicsuccess;

public class XephangMenuActivity extends AppCompatActivity {
    public static MediaPlayer music;
    int Layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xephang_menu);

        Intent intenttest = getIntent();
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
                Layout = 1;
                intent.putExtra("Layout",String.valueOf(Layout));
                startActivity(intent);
            }
        });
        Button btnTapDem = (Button)findViewById(R.id.btnTapDem);
        btnTapDem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(XephangMenuActivity.this, XephangActivity.class);
                Layout = 2;
                intent.putExtra("Layout",String.valueOf(Layout));
                startActivity(intent);
            }
        });
        final Button btnLonBe = (Button)findViewById(R.id.btnLonBe);
        btnLonBe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(XephangMenuActivity.this, XephangActivity.class);
                Layout = 3;
                intent.putExtra("Layout",String.valueOf(Layout));
                startActivity(intent);
            }
        });

        Button btnToanHinh = (Button)findViewById(R.id.btnToanHinh);
        btnToanHinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(XephangMenuActivity.this, XephangActivity.class);
                Layout = 4;
                intent.putExtra("Layout",String.valueOf(Layout));
                startActivity(intent);
            }
        });

        Button btnTinhNham = (Button)findViewById(R.id.btnTinhNham);
        btnTinhNham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(XephangMenuActivity.this, XephangActivity.class);
                Layout = 5;
                intent.putExtra("Layout",String.valueOf(Layout));
                startActivity(intent);
            }
        });

        Button btnToanDo = (Button)findViewById(R.id.btnToanDo);
        btnToanDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(XephangMenuActivity.this, XephangActivity.class);
                Layout = 6;
                intent.putExtra("Layout",String.valueOf(Layout));
                startActivity(intent);
            }
        });
    }
}
