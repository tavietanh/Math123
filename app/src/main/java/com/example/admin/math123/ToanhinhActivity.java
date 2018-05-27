package com.example.admin.math123;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.math123.core.toanhinh;
import com.example.admin.math123.core.CustomDialogResult;

import java.util.Locale;

import static com.example.admin.math123.settingActivity.musicEffectChecked;
import static com.example.admin.math123.settingActivity.musicSpeechChecked;
import static com.example.admin.math123.settingActivity.musicfail;
import static com.example.admin.math123.settingActivity.musicsuccess;


public class ToanhinhActivity extends AppCompatActivity {
    toanhinh toanhinh = new toanhinh();
    int result = -1;
    int count = 1;
    int point = 0;
    boolean istest = false;
    ImageView imageToanHinh;
    TextView question;
    Button btnA;
    Button btnB;
    Button btnC;
    Button btnD;
    Button btnNext;
    TextView pointView;
    TextView countView;
    TextToSpeech toSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toanhinh);
        Intent intenttest = getIntent();
        count = intenttest.getIntExtra("count",1);
        point = intenttest.getIntExtra("point",0);
        istest=intenttest.getBooleanExtra("istest",false);
        imageToanHinh = (ImageView)findViewById(R.id.imageToanHinh);
        question=(TextView)findViewById(R.id.txtQuestionToanHinh);
        btnA=(Button)findViewById(R.id.btnToanHinhA);
        btnB=(Button)findViewById(R.id.btnToanHinhB);
        btnC=(Button)findViewById(R.id.btnToanHinhC);
        btnD=(Button)findViewById(R.id.btnToanHinhD);
        btnNext=(Button)findViewById(R.id.btnNextToanHinh);
        pointView=(TextView)findViewById(R.id.pointToanHinh);
        countView=(TextView)findViewById(R.id.countToanHinh);
        countView.setText(String.valueOf("Câu " + count));
        pointView.setText(String.valueOf(point));
        toanhinh.setBitmap(this.getApplicationContext());
        toanhinh.addItemToActivity(question,imageToanHinh,btnA,btnB,btnC,btnD,count);
        question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(musicSpeechChecked)
                {
                    toSpeech = new TextToSpeech(ToanhinhActivity.this, new TextToSpeech.OnInitListener() {
                        @Override
                        public void onInit(int status) {
                            if(status != TextToSpeech.ERROR){
                                toSpeech.setLanguage(new Locale("vi","VN"));
                                toSpeech.speak(question.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
                            }
                        }
                    });
                }
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (count == 10) {
                        Intent intent = new Intent(ToanhinhActivity.this, ResultActivity.class);
                        intent.putExtra("point", String.valueOf(point));
                        startActivity(intent);
                    } else {
                        if(count==2&&istest)
                        {
                            Intent intent = new Intent(ToanhinhActivity.this, LonbeActivity.class);
                            intent.putExtra("point", point);
                            intent.putExtra("count", count + 1);
                            intent.putExtra("istest", istest);
                            startActivity(intent);
                        }
                        count = count + 1;
                        countView.setText(String.valueOf("Câu " + count));
                        addSource();
                        activeButton(View.VISIBLE, View.INVISIBLE);
                    }
                }
        });
    }
    public void onButtonClick(View v){
        switch (v.getId()){
            case R.id.btnToanHinhA:
               if(toanhinh.getResult()==0)
               {
                   setReultWhenTrue();
               }
               else
                   setResultWhenFalse();
                activeButton(View.INVISIBLE,View.VISIBLE);
                break;
            case R.id.btnToanHinhB:
                if(toanhinh.getResult()==1)
                {
                    setReultWhenTrue();
                }
                else
                    setResultWhenFalse();
                activeButton(View.INVISIBLE,View.VISIBLE);
                break;
            case R.id.btnToanHinhC:
                if(toanhinh.getResult()==2)
                {
                    setReultWhenTrue();
                }
                else
                    setResultWhenFalse();
                activeButton(View.INVISIBLE,View.VISIBLE);
                break;
            case R.id.btnToanHinhD:
                if(toanhinh.getResult()==3)
                {
                    setReultWhenTrue();
                }
                else
                    setResultWhenFalse();
                activeButton(View.INVISIBLE,View.VISIBLE);
                break;
        }
    }
    public void setReultWhenTrue()
    {
        point +=10;
        pointView.setText(String.valueOf(point));
        if(musicEffectChecked)
        {
            musicsuccess.start();
        }
        CustomDialogResult dialog = new CustomDialogResult(ToanhinhActivity.this,true);
        dialog.showdialog();
    }
    public void setResultWhenFalse()
    {
        if(musicEffectChecked)
        {
            musicfail.start();
        }
        CustomDialogResult dialog = new CustomDialogResult(ToanhinhActivity.this,false);
        dialog.showdialog();
    }
    public void activeButton(int enable,int visible)
    {
        btnA.setVisibility(enable);
        btnB.setVisibility(enable);
        btnC.setVisibility(enable);
        btnD.setVisibility(enable);
        btnNext.setVisibility(visible);
    }
    public void addSource()
    {
        toanhinh = new toanhinh();
        toanhinh.setBitmap(this.getApplicationContext());
        toanhinh.addItemToActivity(question,imageToanHinh,btnA,btnB,btnC,btnD,count);
    }
}
