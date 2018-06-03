package com.example.admin.math123;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

import java.util.Locale;
import java.util.Random;

import com.example.admin.math123.core.toando;
import com.example.admin.math123.core.CustomDialogResult;

import org.w3c.dom.Text;

import static com.example.admin.math123.settingActivity.musicEffectChecked;
import static com.example.admin.math123.settingActivity.musicSpeechChecked;
import static com.example.admin.math123.settingActivity.musicfail;
import static com.example.admin.math123.settingActivity.musicsuccess;

public class ToandoActivity extends AppCompatActivity {

    toando ToanDo = new toando();
    int result = 1;
    int count = 1;
    int point = 0;
    boolean istest = false;
    int signb = 0;
    int SoA,SoB;
    TextView ContentText;
    TextView countview;
    TextView pointView;
    TextView SignA;
    TextView SignB;
    TextView KQA;
    TextView KQB;
    TextView KQText;
    TextView CachGiai;
    Button btnDapAnA;
    Button btnDapAnB;
    Button btnDapAnC;
    Button btnDapAnD;
    Button btnnext;
    ImageView imgViewTopLeft;
    ImageView imgViewTopRight;
    ImageView imgViewButtonLeft;
    ImageView imgViewButtonRight;
    ImageView imgViewKQ;
    TextToSpeech toSpeech;

    Random rd=new Random();
    int type = 2;
    int HinhAnh = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toando);
        Intent intenttest = getIntent();
        count = intenttest.getIntExtra("count",1);
        point = intenttest.getIntExtra("point",0);
        istest=intenttest.getBooleanExtra("istest",false);
        ContentText = (TextView)findViewById(R.id.Content);
        btnDapAnA = (Button)findViewById(R.id.btnDapAnA);
        btnDapAnB = (Button)findViewById(R.id.btnDapAnB);
        btnDapAnC = (Button)findViewById(R.id.btnDapAnC);
        btnDapAnD = (Button)findViewById(R.id.btnDapAnD);
        btnnext = (Button)findViewById(R.id.btnNext);
        pointView = (TextView)findViewById(R.id.pointlogic);
        countview = (TextView)findViewById(R.id.countlogic);
        countview.setText(String.valueOf("Câu " + count));
        SignA = (TextView)findViewById(R.id.SignA);
        SignB = (TextView)findViewById(R.id.SignB);
        KQA = (TextView)findViewById(R.id.KQA);
        KQB = (TextView)findViewById(R.id.KQB);
        KQText = (TextView)findViewById(R.id.KqText);
        CachGiai = (TextView)findViewById(R.id.CachGiai);
        imgViewTopLeft = (ImageView)findViewById(R.id.imageLogicTopLeft);
        imgViewTopRight = (ImageView)findViewById(R.id.imageLogicTopRight);
        imgViewButtonLeft = (ImageView)findViewById(R.id.imageLogicButtonLeft);
        imgViewButtonRight = (ImageView)findViewById(R.id.imageLogicButtonRight);
        imgViewKQ = (ImageView)findViewById(R.id.imageKetQua);
        pointView.setText(String.valueOf(point));
        randomType(type);
        ContentText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(musicSpeechChecked)
                {
                    toSpeech = new TextToSpeech(ToandoActivity.this, new TextToSpeech.OnInitListener() {
                        @Override
                        public void onInit(int status) {
                            if(status != TextToSpeech.ERROR){
                                toSpeech.setLanguage(new Locale("vi","VN"));
                                toSpeech.speak(ContentText.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
                            }
                        }
                    });
                }
            }
        });
        CachGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(musicSpeechChecked)
                {
                    toSpeech = new TextToSpeech(ToandoActivity.this, new TextToSpeech.OnInitListener() {
                        @Override
                        public void onInit(int status) {
                            if(status != TextToSpeech.ERROR){
                                toSpeech.setLanguage(new Locale("vi","VN"));
                                toSpeech.speak(CachGiai.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
                            }
                        }
                    });
                }
            }
        });
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count==10)
                {
                    Intent intent = new Intent(ToandoActivity.this,ResultActivity.class);
                    intent.putExtra("point",String.valueOf(point));
                    startActivity(intent);
                }
                else {
                    if(count==8&&istest)
                    {
                        Intent intent = new Intent(ToandoActivity.this, testActivity.class);
                        intent.putExtra("point", point);
                        intent.putExtra("count", count + 1);
                        intent.putExtra("istest", istest);
                        startActivity(intent);
                    }
                    count = count + 1;
                    countview.setText(String.valueOf("Câu " + count));
                    activeButton(View.VISIBLE, View.INVISIBLE);
                    randomType(type);
                }
            }
        });
    }

    public void onButtonClick(View v){
            switch (v.getId()){
                case R.id.btnDapAnA:
                    if(result == 0) {
                        setReultWhenTrue();
                    }
                    else
                        setResultWhenFalse();
                    setResultContent();
                    activeButton(View.INVISIBLE,View.VISIBLE);

                    result=4;
                    break;
                case R.id.btnDapAnB:
                    if(result==1) {
                        setReultWhenTrue();
                    }
                    else
                        setResultWhenFalse();
                    setResultContent();
                    activeButton(View.INVISIBLE,View.VISIBLE);
                    result=4;
                    break;
                case R.id.btnDapAnC:
                    if(result==2) {
                        setReultWhenTrue();
                    }
                    else
                        setResultWhenFalse();
                    setResultContent();
                    activeButton(View.INVISIBLE,View.VISIBLE);
                    result=4;
                    break;
                case R.id.btnDapAnD:
                    if(result==3) {
                        setReultWhenTrue();
                    }
                    else
                        setResultWhenFalse();
                    setResultContent();
                    activeButton(View.INVISIBLE,View.VISIBLE);
                    result=4;
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
        CustomDialogResult dialog = new CustomDialogResult(ToandoActivity.this,true);
        dialog.showdialog();
    }

    public void setResultWhenFalse()
    {
        if(musicEffectChecked)
        {
            musicfail.start();
        }
        CustomDialogResult dialog = new CustomDialogResult(ToandoActivity.this,false);
        dialog.showdialog();
    }

    public void activeButton(int enable,int visible)
    {
        btnDapAnA.setVisibility(enable);
        btnDapAnB.setVisibility(enable);
        btnDapAnC.setVisibility(enable);
        btnDapAnD.setVisibility(enable);
        btnnext.setVisibility(visible);
        if(HinhAnh != 1) {
            CachGiai.setVisibility(visible);
            ContentText.setVisibility(pointView.INVISIBLE);
        }

    }

    public void addani()
    {
        if(SoA < SoB && signb == 0) {
            imgViewTopLeft.setBackgroundResource(R.drawable.ani_3);
            imgViewTopRight.setBackgroundResource(R.drawable.ani_4);
            imgViewButtonLeft.setBackgroundResource(R.drawable.ani_4);
            imgViewButtonRight.setBackgroundResource(R.drawable.ani_3);
        }
        else{
            imgViewTopLeft.setBackgroundResource(R.drawable.ani_3);
            imgViewTopRight.setBackgroundResource(R.drawable.ani_4);
            imgViewButtonLeft.setBackgroundResource(R.drawable.ani_3);
            imgViewButtonRight.setBackgroundResource(R.drawable.ani_4);
        }
    }

    public void randomType(int Type)
    {
        ToanDo = new toando();
        ContentText.setText("");
        btnDapAnA.setText("");
        btnDapAnB.setText("");
        btnDapAnC.setText("");
        btnDapAnD.setText("");
        ToanDo.setA();
        ToanDo.setB();
        ToanDo.setC();
        ToanDo.setD();
        ToanDo.setMauCau();
        result= ToanDo.getResult();
        Type= ToanDo.getType();
        type = Type;
        signb = ToanDo.getSignB();
        SoA = ToanDo.geta();
        SoB = ToanDo.getb();
        if(type != 0)
        {
            HinhAnh = rd.nextInt((1-0+1)+0);
        }

        ContentText.setText(ToanDo.getContent());

        KQA.setText(ToanDo.getC());
        KQB.setText(ToanDo.getD());
        SignA.setText(ToanDo.getASign());
        SignB.setText(ToanDo.getBSign());
        CachGiai.setText(ToanDo.getCachGiai());

        ToanDo.setResultToButton(btnDapAnA,btnDapAnB,btnDapAnC,btnDapAnD);
        switch (type){
            case 0:
                visible(type);
                break;
            case 1:
                if(HinhAnh == 1){
                    addani();
                    visible(1);
                    KQText.setText("= ?");
                    break;
                }
                else{
                    visible(0);
                    break;
                }
            case 2:
                if(HinhAnh == 1){
                    addani();
                    visible(2);
                    KQText.setText("= ?");
                    break;
                }
                else{
                    visible(0);
                    break;
                }
        }
    }

    public void visible(int a) {
        if (a == 0) {
            ContentText.setVisibility(View.VISIBLE);
            imgViewTopLeft.setVisibility(View.INVISIBLE);
            imgViewTopRight.setVisibility(View.INVISIBLE);
            imgViewButtonLeft.setVisibility(View.INVISIBLE);
            imgViewButtonRight.setVisibility(View.INVISIBLE);
            SignA.setVisibility(View.INVISIBLE);
            SignB.setVisibility(View.INVISIBLE);
            KQA.setVisibility(View.INVISIBLE);
            KQB.setVisibility(View.INVISIBLE);
            imgViewKQ.setVisibility(View.INVISIBLE);
            KQText.setVisibility(View.INVISIBLE);
        } else if (a == 1){
            ContentText.setVisibility(View.INVISIBLE);
            imgViewTopLeft.setVisibility(View.VISIBLE);
            imgViewTopRight.setVisibility(View.VISIBLE);
            imgViewButtonLeft.setVisibility(View.VISIBLE);
            imgViewButtonRight.setVisibility(View.VISIBLE);
            SignA.setVisibility(View.VISIBLE);
            SignB.setVisibility(View.VISIBLE);
            KQA.setVisibility(View.VISIBLE);
            KQB.setVisibility(View.VISIBLE);
            imgViewKQ.setVisibility(View.VISIBLE);
            KQText.setVisibility(View.VISIBLE);
            imgViewKQ.setBackgroundResource(R.drawable.ani_3);
        } else{
            ContentText.setVisibility(View.INVISIBLE);
            imgViewTopLeft.setVisibility(View.VISIBLE);
            imgViewTopRight.setVisibility(View.VISIBLE);
            imgViewButtonLeft.setVisibility(View.VISIBLE);
            imgViewButtonRight.setVisibility(View.VISIBLE);
            SignA.setVisibility(View.VISIBLE);
            SignB.setVisibility(View.VISIBLE);
            KQA.setVisibility(View.VISIBLE);
            KQB.setVisibility(View.VISIBLE);
            imgViewKQ.setVisibility(View.VISIBLE);
            KQText.setVisibility(View.VISIBLE);
            imgViewKQ.setBackgroundResource(R.drawable.ani_4);
        }
    }

    public void setResultContent(){
        if(HinhAnh == 1 && type == 1){
            KQText.setText("= " + ToanDo.getA());
        }
        if(HinhAnh == 1 && type == 2) {
            KQText.setText("= " + ToanDo.getB());
        }
    }
}
