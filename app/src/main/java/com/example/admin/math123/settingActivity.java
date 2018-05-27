package com.example.admin.math123;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import static com.example.admin.math123.MainActivity.music;

public class settingActivity extends AppCompatActivity {
    CheckBox CBmusic;
    CheckBox CBeffect;
    CheckBox CBspeech;
    public static MediaPlayer musicfail;
    public static MediaPlayer musicsuccess;
    public static boolean musicEffectChecked = true;
    public static boolean musicSpeechChecked= true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        CBmusic=(CheckBox)findViewById(R.id.CBMusic);
        CBeffect=(CheckBox)findViewById(R.id.CBEffect);
        CBspeech=(CheckBox)findViewById(R.id.CBSpeech);
        CBmusic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    music = MediaPlayer.create(settingActivity.this,R.raw.music_background);
                    music.setLooping(true);
                    music.start();
                }
                else music.stop();
            }
        });
        CBeffect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    musicEffectChecked=true;
                    musicsuccess = MediaPlayer.create(settingActivity.this,R.raw.music_success);
                    musicfail = MediaPlayer.create(settingActivity.this,R.raw.music_fail);
                }
                else
                {
                    musicEffectChecked=false;
                    musicsuccess = null;
                    musicfail=null;
                }
            }
        });
        CBspeech.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                   musicSpeechChecked=true;
                }
                else musicSpeechChecked=false;
            }
        });
    }
}
