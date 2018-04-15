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

import com.example.admin.math123.core.lonbe;
public class TinhnhamActivity extends AppCompatActivity {

    int result = 2;
    int count = 1;
    TextView signview;
    TextView numbera;
    TextView numberb;
    TextView DiemSo;
    TextView countview;
    Button btnDapAnA;
    Button btnDapAnB;
    Button btnDapAnC;
    Button btnDapAnD;
    Button btnHome;
    Button btnnext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinhnham);
        signview = (TextView)findViewById(R.id.SignView);
        numbera = (TextView)findViewById(R.id.numbera);
        numberb = (TextView)findViewById(R.id.numberb);
        DiemSo = (TextView)findViewById(R.id.DiemSo);
        btnDapAnA = (Button)findViewById(R.id.btnDapAnA);
        btnDapAnB = (Button)findViewById(R.id.btnDapAnB);
        btnDapAnC = (Button)findViewById(R.id.btnDapAnC);
        btnDapAnD = (Button)findViewById(R.id.btnDapAnD);
        btnHome = (Button)findViewById(R.id.btnHome);
        btnnext = (Button)findViewById(R.id.btnNext);
        countview = (TextView)findViewById(R.id.countView);
        countview.setText(String.valueOf(count));

    }
    public void onButtonClick(View v){
        switch (v.getId()){
            case R.id.btnDapAnA:
                if(result==0) {
                    Toast.makeText(this, "Đúng ", Toast.LENGTH_LONG).show();
                }
                else
                    setResultWhenFalse();
                activeButton(false,View.VISIBLE);
                result=2;
                break;
            case R.id.btnDapAnB:
                if(result==1) {
                    Toast.makeText(this, "Đúng ", Toast.LENGTH_LONG).show();
                }
                else
                    setResultWhenFalse();
                activeButton(false,View.VISIBLE);
                result=2;
                break;
            case R.id.btnDapAnC:
                if(result==2) {
                    Toast.makeText(this, "Đúng ", Toast.LENGTH_LONG).show();
                }
                else
                    setResultWhenFalse();
                activeButton(false,View.VISIBLE);
                result=2;
                break;
            case R.id.btnDapAnD:
                if(result==3) {
                    Toast.makeText(this, "Đúng ", Toast.LENGTH_LONG).show();
                }
                else
                    setResultWhenFalse();
                activeButton(false,View.VISIBLE);
                result=2;
                break;
        }
    }
    public void setResultWhenFalse()
    {
        if(result==0) Toast.makeText(this,"Sai! Đáp án đúng là A", Toast.LENGTH_LONG).show();
        if(result==1) Toast.makeText(this,"Sai! Đáp án đúng là B", Toast.LENGTH_LONG).show();
        if(result==2) Toast.makeText(this,"Sai! Đáp án đúng là C", Toast.LENGTH_LONG).show();
        if(result==3) Toast.makeText(this,"Sai! Đáp án đúng là D", Toast.LENGTH_LONG).show();
    }
    public void activeButton(boolean enable,int visible)
    {
        btnDapAnA.setEnabled(enable);
        btnDapAnB.setEnabled(enable);
        btnDapAnC.setEnabled(enable);
        btnDapAnD.setEnabled(enable);
        btnnext.setVisibility(visible);
    }
}
