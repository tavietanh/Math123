package com.example.admin.math123;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

import com.example.admin.math123.core.tinhnham;
import com.example.admin.math123.core.CustomDialogResult;

import static com.example.admin.math123.settingActivity.musicEffectChecked;
import static com.example.admin.math123.settingActivity.musicfail;
import static com.example.admin.math123.settingActivity.musicsuccess;

public class TinhnhamActivity extends AppCompatActivity {

    tinhnham TinhNham = new tinhnham();
    int result = 1;
    int count = 1;
    int point = 0;
    boolean istest = false;
    TextView sign;
    TextView sign2;
    TextView numbera;
    TextView numberb;
    TextView numberc;
    TextView signequal;
    TextView countview;
    TextView pointView;
    Button btnDapAnA;
    Button btnDapAnB;
    Button btnDapAnC;
    Button btnDapAnD;
    Button btnnext;
    ImageView imgViewLeft;
    ImageView imgViewRight;

    Bitmap icon;
    int type = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinhnham);
        Intent intenttest = getIntent();
        count = intenttest.getIntExtra("count",1);
        point = intenttest.getIntExtra("point",0);
        istest=intenttest.getBooleanExtra("istest",false);
        sign = (TextView)findViewById(R.id.Sign);
        sign2 = (TextView)findViewById(R.id.Sign2);
        signequal = (TextView)findViewById(R.id.signequal);
        numbera = (TextView)findViewById(R.id.numbera);
        numberb = (TextView)findViewById(R.id.numberb);
        numberc = (TextView)findViewById(R.id.numberc);
        btnDapAnA = (Button)findViewById(R.id.btnDapAnA);
        btnDapAnB = (Button)findViewById(R.id.btnDapAnB);
        btnDapAnC = (Button)findViewById(R.id.btnDapAnC);
        btnDapAnD = (Button)findViewById(R.id.btnDapAnD);
        btnnext = (Button)findViewById(R.id.btnNext);
        imgViewLeft = (ImageView)findViewById(R.id.imageTinhNhamLeft);
        imgViewRight = (ImageView)findViewById(R.id.imageTinhNhamRight);
        pointView = (TextView)findViewById(R.id.pointTinhNham);
        countview = (TextView)findViewById(R.id.countTinhnham);
        countview.setText(String.valueOf("Câu " + count));
        pointView.setText(String.valueOf(point));
        randomType(type);
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count==10)
                {
                    Intent intent = new Intent(TinhnhamActivity.this,ResultActivity.class);
                    intent.putExtra("point",String.valueOf(point));
                    startActivity(intent);
                }
                else {
                    if(count==6&&istest)
                    {
                        Intent intent = new Intent(TinhnhamActivity.this, ToandoActivity.class);
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
        if(type != 3)
            switch (v.getId()){
                case R.id.btnDapAnA:
                    if(result == 0) {
                        setReultWhenTrue();
                    }
                    else
                        setResultWhenFalse();
                    setResultContent(type);
                    activeButton(View.INVISIBLE,View.VISIBLE);
                    result=4;
                    break;
                case R.id.btnDapAnB:
                    if(result==1) {
                        setReultWhenTrue();
                    }
                    else
                        setResultWhenFalse();
                    setResultContent(type);
                    activeButton(View.INVISIBLE,View.VISIBLE);
                    result=4;
                    break;
                case R.id.btnDapAnC:
                    if(result==2) {
                        setReultWhenTrue();
                    }
                    else
                        setResultWhenFalse();
                    setResultContent(type);
                    activeButton(View.INVISIBLE,View.VISIBLE);
                    result=4;
                    break;
                case R.id.btnDapAnD:
                    if(result==3) {
                        setReultWhenTrue();
                    }
                    else
                        setResultWhenFalse();
                    setResultContent(type);
                    activeButton(View.INVISIBLE,View.VISIBLE);
                    result=4;
                    break;
            }
        else
            switch (v.getId()){
                case R.id.btnDapAnB:
                    if(result == 0)
                        setReultWhenTrue();
                    else
                        setResultWhenFalse();
                    setResultContent(type);
                    activeButton(View.INVISIBLE,View.VISIBLE);
                    result=4;
                    break;
                case R.id.btnDapAnC:
                    if(result == 1) {
                        setReultWhenTrue();
                    }
                    else
                        setResultWhenFalse();
                    setResultContent(type);
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
        CustomDialogResult dialog = new CustomDialogResult(TinhnhamActivity.this,true);
        dialog.showdialog();
    }

    public void setResultWhenFalse()
    {
        if(musicEffectChecked)
        {
            musicfail.start();
        }
        CustomDialogResult dialog = new CustomDialogResult(TinhnhamActivity.this,false);
        dialog.showdialog();
    }
    public void activeButton(int enable,int visible)
    {
        btnDapAnA.setVisibility(enable);
        btnDapAnB.setVisibility(enable);
        btnDapAnC.setVisibility(enable);
        btnDapAnD.setVisibility(enable);
        btnnext.setVisibility(visible);
    }

    public void addani()
    {
        TinhNham.setBitmap(this.getApplicationContext());
        imgViewLeft.setImageBitmap(TinhNham.addBitmapA());
        imgViewRight.setImageBitmap(TinhNham.addBitmapB());
    }

    public void randomType(int Type)
    {
        TinhNham = new tinhnham();
        numbera.setText("");
        numberb.setText("");
        numberc.setText("");
        btnDapAnA.setText("");
        btnDapAnB.setText("");
        btnDapAnC.setText("");
        btnDapAnD.setText("");
        TinhNham.setA();
        TinhNham.setB();
        TinhNham.setSign();
        TinhNham.setC();
        TinhNham.randomResult();
        result= TinhNham.getResult();
        Type= TinhNham.getType();
        type = Type;

        numbera.setText(TinhNham.getA());
        numberb.setText(TinhNham.getB());
        sign.setText(TinhNham.getSign());
        sign2.setText(TinhNham.getSign());
        numberc.setText(TinhNham.getC());
        TinhNham.setResultToButton(btnDapAnA,btnDapAnB,btnDapAnC,btnDapAnD);
        switch (Type){
            case 0:
                numberc.setText("?");
                visible(Type);
                break;
            case 1:
                numbera.setText("?");
                visible(Type);
                break;
            case 2:
                numberb.setText("?");
                visible(Type);
                break;
            case 3:
                sign.setText("?");
                visible(Type);
                break;
            case 4:
                addani();
                visible(Type);
                break;
        }

    }

    public void visible(int a) {
        if (a == 3) {
            numbera.setVisibility(View.VISIBLE);
            numberb.setVisibility(View.VISIBLE);
            numberc.setVisibility(View.VISIBLE);
            sign.setVisibility(View.VISIBLE);
            signequal.setVisibility((View.VISIBLE));
            sign2.setVisibility(View.INVISIBLE);
            btnDapAnA.setVisibility(View.INVISIBLE);
            btnDapAnD.setVisibility(View.INVISIBLE);
            imgViewLeft.setVisibility(View.INVISIBLE);
            imgViewRight.setVisibility(View.INVISIBLE);
        } else if (a == 4){
            numbera.setVisibility(View.INVISIBLE);
            numberb.setVisibility(View.INVISIBLE);
            numberc.setVisibility(View.INVISIBLE);
            sign.setVisibility(View.INVISIBLE);
            signequal.setVisibility((View.INVISIBLE));
            sign2.setVisibility(View.VISIBLE);
            btnDapAnA.setVisibility(View.VISIBLE);
            btnDapAnD.setVisibility(View.VISIBLE);
            imgViewLeft.setVisibility(View.VISIBLE);
            imgViewRight.setVisibility(View.VISIBLE);
        } else{
            numbera.setVisibility(View.VISIBLE);
            numberb.setVisibility(View.VISIBLE);
            numberc.setVisibility(View.VISIBLE);
            sign.setVisibility(View.VISIBLE);
            signequal.setVisibility((View.VISIBLE));
            sign2.setVisibility(View.INVISIBLE);
            btnDapAnA.setVisibility(View.VISIBLE);
            btnDapAnD.setVisibility(View.VISIBLE);
            imgViewLeft.setVisibility(View.INVISIBLE);
            imgViewRight.setVisibility(View.INVISIBLE);
        }
    }

    public void setResultContent(int x){
        switch (x) {
            case 0:
                numberc.setText(TinhNham.getC());
                break;
            case 1:
                numbera.setText(TinhNham.getA());
                break;
            case 2:
                numberb.setText(TinhNham.getB());
                break;
            case 3:
                sign.setText(TinhNham.getSign());
                break;
            case 4:
                break;
        }
    }
}
