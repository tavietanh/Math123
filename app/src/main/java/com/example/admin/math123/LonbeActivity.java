package com.example.admin.math123;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.math123.core.lonbe;
import com.example.admin.math123.core.CustomDialogResult;

import static com.example.admin.math123.settingActivity.musicEffectChecked;
import static com.example.admin.math123.settingActivity.musicfail;
import static com.example.admin.math123.settingActivity.musicsuccess;

public class LonbeActivity extends AppCompatActivity {
    lonbe Lonbe = new lonbe();
    int result = 3;
    int count = 1;
    int point = 0;
    boolean istest= false;
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
    TextView pointView;
    int type= (int) (2*Math.random());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lonbe);
        Intent intenttest = getIntent();
        count = intenttest.getIntExtra("count",1);
        point = intenttest.getIntExtra("point",0);
        istest=intenttest.getBooleanExtra("istest",false);
        signview = (TextView)findViewById(R.id.SignView);
        numbera = (TextView)findViewById(R.id.numbera);
        numberb = (TextView)findViewById(R.id.numberb);
        btnless = (Button)findViewById(R.id.btnLesssign);
        btnequal = (Button)findViewById(R.id.btnEqualsign);
        btngreater = (Button)findViewById(R.id.btnGreatersign);
        btnnext = (Button)findViewById(R.id.btnNext);
        countview = (TextView)findViewById(R.id.countLonbe);
        countview.setText(String.valueOf(count));
        imgViewLeft = (ImageView)findViewById(R.id.imageLonbeLeft);
        imgViewRight = (ImageView)findViewById(R.id.imageLonbeRight);
        pointView = (TextView)findViewById(R.id.pointLonbe);
        countview.setText(String.valueOf("Câu "+count));
        pointView.setText(String.valueOf(point));
        randomType(type);
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count==10)
                {
                    Intent intent = new Intent(LonbeActivity.this,ResultActivity.class);
                    intent.putExtra("point",String.valueOf(point));
                    startActivity(intent);
                }
                else {
                    if(count==4&&istest)
                    {
                        Intent intent = new Intent(LonbeActivity.this, TinhnhamActivity.class);
                        intent.putExtra("point", point);
                        intent.putExtra("count", count + 1);
                        intent.putExtra("istest", istest);
                        startActivity(intent);
                    }
                    count = count + 1;
                    countview.setText(String.valueOf("Câu " + count));
                    activeButton(View.VISIBLE, View.INVISIBLE);
                    signview.setText("?");
                    randomType(type);
                }
            }
        });
    }

    public void onButtonClick(View v){
        switch (v.getId()){
            case R.id.btnLesssign:
                if(result==2) {
                    setReultWhenTrue();
                    signview.setText("<");
                }
                else
                    setResultWhenFalse();
                activeButton(View.INVISIBLE,View.VISIBLE);
                result=3;
                break;
            case R.id.btnEqualsign:
                if(result==1) {
                    setReultWhenTrue();
                    signview.setText("=");
                }
                else
                    setResultWhenFalse();
                activeButton(View.INVISIBLE,View.VISIBLE);
                result=3;
                break;
            case R.id.btnGreatersign:
                if(result==0) {
                    setReultWhenTrue();
                    signview.setText(">");
                }
                else
                    setResultWhenFalse();
                activeButton(View.INVISIBLE,View.VISIBLE);
                result=3;
                break;
        }
    }
    public void setResultWhenFalse()
    {
        if(result==0) signview.setText(">");
        if(result==1) signview.setText("=");
        if(result==2) signview.setText("<");
        if(musicEffectChecked)
        {
            musicfail.start();
        }
        CustomDialogResult dialog = new CustomDialogResult(LonbeActivity.this,false);
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
        CustomDialogResult dialog = new CustomDialogResult(LonbeActivity.this,true);
        dialog.showdialog();
    }
    public void activeButton(int enable,int visible)
    {
        btnless.setVisibility(enable);
        btnequal.setVisibility(enable);
        btngreater.setVisibility(enable);
        btnnext.setVisibility(visible);
    }
    public void addani()
    {
        Lonbe.setBitmap(this.getApplicationContext());
        imgViewLeft.setImageBitmap(Lonbe.addBitmapA());
        imgViewRight.setImageBitmap(Lonbe.addBitmapB());
    }
    public void randomType(int Type)
    {
        Lonbe = new lonbe();
        imgViewLeft.setImageResource(0);
        imgViewRight.setImageResource(0);
        numbera.setText("");
        numberb.setText("");
        result= Lonbe.result();
        switch (Type){
            case 0:
                numbera.setText(Lonbe.getA());
                numberb.setText(Lonbe.getB());
                break;
            case 1:
                addani();
        }
        type= (int) (2*Math.random());
    }

}
