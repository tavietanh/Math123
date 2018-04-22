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

import com.example.admin.math123.core.tinhnham;
public class TinhnhamActivity extends AppCompatActivity {

    tinhnham TinhNham = new tinhnham();
    int result = 2;
    int count = 1;
    int dem;
    TextView signview;
    TextView numbera;
    TextView numberb;
    TextView DiemSo;
    TextView countview;
    Button btnDapAnA;
    Button btnDapAnB;
    Button btnDapAnC;
    Button btnDapAnD;
    Button btnnext;
    ImageView imgViewLeft;
    ImageView imgViewRight;
    Bitmap icon;
    int type= (int) (2*Math.random());


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
        btnnext = (Button)findViewById(R.id.btnNext);
        countview = (TextView)findViewById(R.id.countTinhnham);
        countview.setText(String.valueOf(count));
        imgViewLeft = (ImageView)findViewById(R.id.imageView2) ;
        imgViewRight = (ImageView)findViewById(R.id.imageView3) ;
        randomType(type);
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=count+1;
                countview.setText(String.valueOf(count));
                activeButton(true,View.INVISIBLE);
                randomType(type);
            }
        });
    }
    public void onButtonClick(View v){
        switch (v.getId()){
            case R.id.btnDapAnA:
                if(dem==0) {
                    Toast.makeText(this, "Đúng ", Toast.LENGTH_LONG).show();
                }
                else
                    setResultWhenFalse();
                activeButton(false,View.VISIBLE);
                result=4;
                break;
            case R.id.btnDapAnB:
                if(result==1) {
                    Toast.makeText(this, "Đúng ", Toast.LENGTH_LONG).show();
                }
                else
                    setResultWhenFalse();
                activeButton(false,View.VISIBLE);
                result=4;
                break;
            case R.id.btnDapAnC:
                if(result==2) {
                    Toast.makeText(this, "Đúng ", Toast.LENGTH_LONG).show();
                }
                else
                    setResultWhenFalse();
                activeButton(false,View.VISIBLE);
                result=4;
                break;
            case R.id.btnDapAnD:
                if(result==3) {
                    Toast.makeText(this, "Đúng ", Toast.LENGTH_LONG).show();
                }
                else
                    setResultWhenFalse();
                activeButton(false,View.VISIBLE);
                result=4;
                break;
        }
    }
    public void setResultWhenFalse()
    {
        if(dem==0) Toast.makeText(this,"Sai! Đáp án đúng là A", Toast.LENGTH_LONG).show();
        if(dem==1) Toast.makeText(this,"Sai! Đáp án đúng là B", Toast.LENGTH_LONG).show();
        if(dem==2) Toast.makeText(this,"Sai! Đáp án đúng là C", Toast.LENGTH_LONG).show();
        if(dem==3) Toast.makeText(this,"Sai! Đáp án đúng là D", Toast.LENGTH_LONG).show();
    }
    public void activeButton(boolean enable,int visible)
    {
        btnDapAnA.setEnabled(enable);
        btnDapAnB.setEnabled(enable);
        btnDapAnC.setEnabled(enable);
        btnDapAnD.setEnabled(enable);
        btnnext.setVisibility(visible);
    }

    public void addani()
    {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int screenHeight = metrics.heightPixels;
        int screenWidth =  metrics.widthPixels;
        TinhNham.setBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.ani_1));
        imgViewLeft.setImageBitmap(TinhNham.addBitmapA());
        imgViewRight.setImageBitmap(TinhNham.addBitmapB());
    }

    public void randomType(int Type)
    {
        TinhNham = new tinhnham();
        imgViewLeft.setImageResource(0);
        imgViewRight.setImageResource(0);
        numbera.setText("");
        numberb.setText("");
        signview.setText("");
        btnDapAnA.setText("");
        btnDapAnA.setText("");
        btnDapAnA.setText("");
        btnDapAnA.setText("");
        result= TinhNham.result();
        switch (Type){
            case 0:
                numbera.setText(TinhNham.getA());
                numberb.setText(TinhNham.getB());
                signview.setText(TinhNham.getSign());
                btnDapAnA.setText(TinhNham.getDapAnA());
                btnDapAnB.setText(TinhNham.getDapAnB());
                btnDapAnC.setText(TinhNham.getDapAnC());
                btnDapAnD.setText(TinhNham.getDapAnD());
                int dem = (int) (4*Math.random());
                if(dem == 0)
                {
                    btnDapAnA.setText(String.valueOf(TinhNham.result()));
                }
                if(dem == 1)
                {
                    btnDapAnB.setText(String.valueOf(TinhNham.result()));
                }
                if(dem == 2)
                {
                    btnDapAnC.setText(String.valueOf(TinhNham.result()));
                }
                if(dem==3){
                    btnDapAnD.setText(String.valueOf(TinhNham.result()));
                 }
                break;
            case 1:
                addani();
        }
        type= (int) (2*Math.random());
    }
}
