package com.example.admin.math123;

import android.content.Intent;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import com.example.admin.math123.core.cau9;
import com.example.admin.math123.core.cau10;
import com.example.admin.math123.core.CustomDialogResult;

import org.w3c.dom.Text;

import java.util.Locale;

import static com.example.admin.math123.settingActivity.musicEffectChecked;
import static com.example.admin.math123.settingActivity.musicSpeechChecked;
import static com.example.admin.math123.settingActivity.musicfail;
import static com.example.admin.math123.settingActivity.musicsuccess;

public class testActivity extends AppCompatActivity {
    boolean istest = true;
    int count = 0;
    int point = 0;
    int result = (int) (3*Math.random());
    TextView TextQuestion;
    Button btnA;
    Button btnB;
    Button btnC;
    Button btnNext;
    TextView imgQuestion;
    cau9 cau9 = new cau9();
    cau10 cau10 = new cau10();
    TextView countview;
    ImageView imgView;
    TextView pointView;
    TextToSpeech toSpeech;

    private String simpleFileName = "Xephang.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Intent intenttest = getIntent();
        count = intenttest.getIntExtra("count",1);
        point = intenttest.getIntExtra("point",0);
        istest=intenttest.getBooleanExtra("istest",false);
        btnA = (Button)findViewById(R.id.btnTestA);
        btnB = (Button)findViewById(R.id.btnTestB);
        btnC = (Button)findViewById(R.id.btnTestC);
        btnNext=(Button)findViewById(R.id.btnNextTest);
        TextQuestion = (TextView)findViewById(R.id.textViewTest);
        imgQuestion = (TextView)findViewById(R.id.questionTest);
        imgView=(ImageView)findViewById(R.id.imgTest);
        countview = (TextView)findViewById(R.id.countTest);
        pointView= (TextView)findViewById(R.id.pointTest);
        countview.setText(String.valueOf("Câu " + count));
        TextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(musicSpeechChecked)
                {
                    toSpeech = new TextToSpeech(testActivity.this, new TextToSpeech.OnInitListener() {
                        @Override
                        public void onInit(int status) {
                            if(status != TextToSpeech.ERROR){
                                toSpeech.setLanguage(new Locale("vi","VN"));
                                toSpeech.speak(TextQuestion.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
                            }
                        }
                    });
                }
            }
        });
        imgQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(musicSpeechChecked)
                {
                    toSpeech = new TextToSpeech(testActivity.this, new TextToSpeech.OnInitListener() {
                        @Override
                        public void onInit(int status) {
                            if(status != TextToSpeech.ERROR){
                                toSpeech.setLanguage(new Locale("vi","VN"));
                                toSpeech.speak(TextQuestion.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
                            }
                        }
                    });
                }
            }
        });
        cau9.setResult(result);
        if(count<9) {
            istest = true;
            Intent intent = new Intent(testActivity.this, TapdemActivity.class);
            intent.putExtra("istest", istest);
            startActivity(intent);
        } else
        {
            imgQuestion.setVisibility(View.INVISIBLE);
            imgView.setVisibility(View.INVISIBLE);
            cau9.setItemToActivity(TextQuestion,btnA,btnB,btnC);
            countview.setText(String.valueOf("Câu " + count));
            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(count==10)
                    {
                        Intent intent = new Intent(testActivity.this,ResultActivity.class);
                        intent.putExtra("point",String.valueOf(point));
                        saveData();
                        startActivity(intent);
                    }
                    else {
                        TextQuestion.setVisibility(View.INVISIBLE);
                        imgQuestion.setVisibility(View.VISIBLE);
                        imgView.setVisibility(View.VISIBLE);
                        result = (int) (3*Math.random());
                        cau10.setResult(result);
                        cau10.setItemToActivity(TextQuestion,imgView,btnA,btnB,btnC);
                        count = count + 1;
                        countview.setText(String.valueOf("Câu " + count));
                        activeButton(View.VISIBLE, View.INVISIBLE);
                    }
                }
            });
        }

    }
    public void onButtonClick(View v){
        switch (v.getId()){
            case R.id.btnTestA:
                if(result==0) {
                    setReultWhenTrue();
                }
                else
                    setResultWhenFalse();
                activeButton(View.INVISIBLE,View.VISIBLE);
                break;
            case R.id.btnTestB:
                if(result==1) {
                    setReultWhenTrue();

                }
                else
                    setResultWhenFalse();
                activeButton(View.INVISIBLE,View.VISIBLE);
                break;
            case R.id.btnTestC:
                if(result==2) {
                    setReultWhenTrue();
                }
                else
                    setResultWhenFalse();
                activeButton(View.INVISIBLE,View.VISIBLE);
                break;
        }
    }
    public void setResultWhenFalse()
    {
        if(musicEffectChecked)
        {
            musicfail.start();
        }
        if(count ==9) TextQuestion.setText(cau9.getAnswer());
        CustomDialogResult dialog = new CustomDialogResult(testActivity.this,false);
        dialog.showdialog();
    }
    public void setReultWhenTrue()
    {
        point +=10;
        pointView.setText(String.valueOf(point));
        if(musicEffectChecked)
        {
            musicsuccess.start();
        }
        if(count ==9) TextQuestion.setText(cau9.getAnswer());
        CustomDialogResult dialog = new CustomDialogResult(testActivity.this,true);
        dialog.showdialog();
    }
    public void activeButton(int enable,int visible)
    {
        btnA.setVisibility(enable);
        btnB.setVisibility(enable);
        btnC.setVisibility(enable);
        btnNext.setVisibility(visible);
    }

    private void saveData() {
        String data = this.pointView.getText().toString();
        try {

            // Mở một luồng ghi file.
            FileOutputStream out = this.openFileOutput(simpleFileName, MODE_PRIVATE);
            // Ghi dữ liệu.
            out.write(data.getBytes());
            out.close();
        } catch (Exception e) {
        }
    }

    private void readData() {
        try {

            // Mở một luồng đọc file.
            FileInputStream in = this.openFileInput(simpleFileName);

            BufferedReader br= new BufferedReader(new InputStreamReader(in));

            StringBuilder sb= new StringBuilder();
            String s= null;
            while((s= br.readLine())!= null)  {
                sb.append(s).append("\n");
            }
        } catch (Exception e) {
        }
    }
}

