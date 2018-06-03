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

import static com.example.admin.math123.settingActivity.musicEffectChecked;
import static com.example.admin.math123.settingActivity.musicfail;
import static com.example.admin.math123.settingActivity.musicsuccess;

public class MainActivity extends AppCompatActivity {
    public static MediaPlayer music;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(musicEffectChecked)
        {
            musicsuccess = MediaPlayer.create(MainActivity.this,R.raw.music_success);
            musicfail = MediaPlayer.create(MainActivity.this,R.raw.music_fail);
        }
        if(music == null)
        {
            music = MediaPlayer.create(MainActivity.this,R.raw.music_background);
            music.setLooping(true);
            music.start();
        }
        Button btnpractice = (Button)findViewById(R.id.btnPractice);
        btnpractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PracticeActivity.class);
                startActivity(intent);
            }
        });
        Button btnTest = (Button)findViewById(R.id.btnTest);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,testActivity.class);
                startActivity(intent);
            }
        });
        final Button btnSetting = (Button)findViewById(R.id.btnSetting);
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,settingActivity.class);
                startActivity(intent);
            }
        });

        Button btnAbout = (Button)findViewById(R.id.btnAbout);
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER_HORIZONTAL,0,0);

                TextView tv = new TextView(MainActivity.this);
                tv.setTextSize(20);
                tv.setBackgroundColor(Color.WHITE);

                Typeface t = Typeface.create("serif", Typeface.BOLD_ITALIC);
                tv.setTypeface(t);
                tv.setPadding(5,5,5,5);
                tv.setText("Thành viên nhóm:\n \nTạ Thành Việt Anh \nLê Nhật Khánh");
                toast.setView(tv);
                toast.show();
            }
        });

        Button btnXephang = (Button)findViewById(R.id.btnXepHang);
        btnXephang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,XephangActivity.class);
                startActivity(intent);
            }
        });
    }
}
