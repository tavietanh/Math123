package com.example.admin.math123;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.math123.core.lonbe;




public class LonbeActivity extends AppCompatActivity {
    lonbe Lonbe = new lonbe();
    int result = 3;
    int count = 1;
    TextView signview;
    TextView numbera;
    TextView numberb;
    Button btnless;
    Button btnequal;
    Button btngreater;
    Button btnnext;
    TextView countview;
    ImageView imgViewLeft;
    ImageView imgViewRight;
    Bitmap icon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lonbe);
        signview = (TextView)findViewById(R.id.SignView);
        numbera = (TextView)findViewById(R.id.numbera);
        numberb = (TextView)findViewById(R.id.numberb);
        btnless = (Button)findViewById(R.id.btnLesssign);
        btnequal = (Button)findViewById(R.id.btnEqualsign);
        btngreater = (Button)findViewById(R.id.btnGreatersign);
        btnnext = (Button)findViewById(R.id.btnNext);
        countview = (TextView)findViewById(R.id.countView);
        countview.setText(String.valueOf(count));
        numbera.setText(Lonbe.getA());
        numberb.setText(Lonbe.getB());
        result= Lonbe.result();
        imgViewLeft = (ImageView)findViewById(R.id.imageView2) ;
        imgViewRight = (ImageView)findViewById(R.id.imageView3) ;
        addani();
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=count+1;
                countview.setText(String.valueOf(count));
                Lonbe = new lonbe();
                numbera.setText(Lonbe.getA());
                numberb.setText(Lonbe.getB());
                activeButton(true,View.INVISIBLE);
                signview.setText("?");
                result= Lonbe.result();
                imgViewLeft.setImageResource(0);
                imgViewRight.setImageResource(0);
                addani();
            }
        });
    }

    public void onButtonClick(View v){
        //signview = (TextView)findViewById(R.id.SignView);
        //btnless = (Button)findViewById(R.id.btnLesssign);
        //btnequal = (Button)findViewById(R.id.btnEqualsign);
        //btngreater = (Button)findViewById(R.id.btnGreatersign);
        //btnnext = (Button)findViewById(R.id.btnNext);
        switch (v.getId()){
            case R.id.btnLesssign:
                if(result==2) {
                    Toast.makeText(this, "Đúng ", Toast.LENGTH_LONG).show();
                    signview.setText("<");
                }
                else
                    setResultWhenFalse();
                activeButton(false,View.VISIBLE);
                result=3;
                break;
            case R.id.btnEqualsign:
                if(result==1) {
                    Toast.makeText(this, "Đúng ", Toast.LENGTH_LONG).show();
                    signview.setText("=");
                }
                else
                    setResultWhenFalse();
                activeButton(false,View.VISIBLE);
                result=3;
                break;
            case R.id.btnGreatersign:
                if(result==0) {
                    Toast.makeText(this, "Đúng ", Toast.LENGTH_LONG).show();
                    signview.setText(">");
                }
                else
                    setResultWhenFalse();
                activeButton(false,View.VISIBLE);
                result=3;
                break;
        }
    }
    public void setResultWhenFalse()
    {
        //signview = (TextView)findViewById(R.id.SignView);
        if(result==0) signview.setText(">");
        if(result==1) signview.setText("=");
        if(result==2) signview.setText("<");
    }
    public void activeButton(boolean enable,int visible)
    {
        btnless.setEnabled(enable);
        btnequal.setEnabled(enable);
        btngreater.setEnabled(enable);
        btnnext.setVisibility(visible);
    }
    public void addani()
    {
        Lonbe.setBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.ani_1));
        imgViewLeft.setImageBitmap(Lonbe.addBitmapA());
        imgViewRight.setImageBitmap(Lonbe.addBitmapB());
        imgViewLeft.setY(250);
        imgViewRight.setX(400);
        imgViewRight.setY(250);

    }
}
