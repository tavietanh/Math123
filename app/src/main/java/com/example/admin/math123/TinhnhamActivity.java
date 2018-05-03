package com.example.admin.math123;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import com.example.admin.math123.core.tinhnham;
import com.example.admin.math123.core.CustomDialogResult;

public class TinhnhamActivity extends AppCompatActivity {

    tinhnham TinhNham = new tinhnham();
    int result = 2;
    int count = 1;
    int point = 0;
    TextView sign;
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

    Bitmap icon;
    int type= (int) (2*Math.random());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinhnham);
        sign = (TextView)findViewById(R.id.Sign);
        signequal = (TextView)findViewById(R.id.signequal);
        numbera = (TextView)findViewById(R.id.numbera);
        numberb = (TextView)findViewById(R.id.numberb);
        numberc = (TextView)findViewById(R.id.numberc);
        btnDapAnA = (Button)findViewById(R.id.btnDapAnA);
        btnDapAnB = (Button)findViewById(R.id.btnDapAnB);
        btnDapAnC = (Button)findViewById(R.id.btnDapAnC);
        btnDapAnD = (Button)findViewById(R.id.btnDapAnD);
        btnnext = (Button)findViewById(R.id.btnNext);
        pointView = (TextView)findViewById(R.id.pointTinhNham);
        countview = (TextView)findViewById(R.id.countTinhnham);
        countview.setText(String.valueOf(count));
        randomType(type);
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count==10)
                {
                    Intent intent = new Intent(TinhnhamActivity.this,PracticeActivity.class);
                    startActivity(intent);
                }
                else count=count+1;
                countview.setText(String.valueOf("Câu "+count));
                activeButton(View.VISIBLE,View.INVISIBLE);
                randomType(type);
                if(type == 3){
                    btnDapAnA.setVisibility(View.INVISIBLE);
                    btnDapAnD.setVisibility(View.INVISIBLE);
                }
            }
        });
        if(type == 3){
            btnDapAnA.setVisibility(View.INVISIBLE);
            btnDapAnD.setVisibility(View.INVISIBLE);
        }
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
                    activeButton(View.INVISIBLE,View.VISIBLE);
                    result=4;
                    break;
                case R.id.btnDapAnB:
                    if(result==1) {
                        setReultWhenTrue();
                    }
                    else
                        setResultWhenFalse();
                    activeButton(View.INVISIBLE,View.VISIBLE);
                    result=4;
                    break;
                case R.id.btnDapAnC:
                    if(result==2) {
                        setReultWhenTrue();
                    }
                    else
                        setResultWhenFalse();
                    activeButton(View.INVISIBLE,View.VISIBLE);
                    result=4;
                    break;
                case R.id.btnDapAnD:
                    if(result==3) {
                        setReultWhenTrue();
                    }
                    else
                        setResultWhenFalse();
                    activeButton(View.INVISIBLE,View.VISIBLE);
                    result=4;
                    break;
            }
        else
            switch (v.getId()){
                case R.id.btnDapAnB:
                    if(result == 0 || result==1) {
                        setReultWhenTrue();
                    }
                    else
                        setResultWhenFalse();
                    activeButton(View.INVISIBLE,View.VISIBLE);
                    result=4;
                    break;
                case R.id.btnDapAnC:
                    if(result==2 || result == 3) {
                        setReultWhenTrue();
                    }
                    else
                        setResultWhenFalse();
                    activeButton(View.INVISIBLE,View.VISIBLE);
                    result=4;
                    break;
            }
    }

    public void setReultWhenTrue()
    {
        point +=10;
        pointView.setText(String.valueOf(point));
        CustomDialogResult dialog = new CustomDialogResult(TinhnhamActivity.this,true);
        dialog.showdialog();
    }

    public void setResultWhenFalse()
    {
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
        result= TinhNham.getResult();
        type= TinhNham.getType();

        numbera.setText(TinhNham.getA());
        numberb.setText(TinhNham.getB());
        sign.setText(TinhNham.getSign());
        numberc.setText(TinhNham.getC());
        TinhNham.setResultToButton(btnDapAnA,btnDapAnB,btnDapAnC,btnDapAnD);
        switch (type){
            case 0:
                numberc.setText("?");
                break;
            case 1:
                numbera.setText("?");
                break;
            case 2:
                numberb.setText("?");
                break;
            case 3:
                sign.setText("?");
                break;
        }

    }
}
