package com.example.admin.math123;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.math123.core.tapdem;
import com.example.admin.math123.core.CustomDialogResult;

import static com.example.admin.math123.settingActivity.musicEffectChecked;
import static com.example.admin.math123.settingActivity.musicfail;
import static com.example.admin.math123.settingActivity.musicsuccess;

public class TapdemActivity extends AppCompatActivity {
    tapdem Tapdem;
    int result = -1;
    int count = 1;
    int point = 0;
    boolean istest = false;
    Button A;
    Button B;
    Button C;
    Button D;
    Button btnNext;
    TextView countview;
    TextView pointView;
    ImageView imageTapdem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tapdem);
        Intent intenttest = this.getIntent();
        istest = intenttest.getBooleanExtra("istest",false);
        A = (Button)findViewById(R.id.btnTapdemA);
        B = (Button)findViewById(R.id.btnTapdemB);
        C = (Button)findViewById(R.id.btnTapdemC);
        D = (Button)findViewById(R.id.btnTapdemD);
        imageTapdem = (ImageView)findViewById(R.id.imageTapdem);
        pointView = (TextView)findViewById(R.id.pointTapdem);
        countview = (TextView)findViewById(R.id.countTapdem);
        btnNext = (Button)findViewById(R.id.btnNextTapdem);
        setData();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (count == 10) {
                        Intent intent = new Intent(TapdemActivity.this, ResultActivity.class);
                        intent.putExtra("point", String.valueOf(point));
                        startActivity(intent);
                    } else {
                        if(count==1&&istest)
                        {
                            Intent intent = new Intent(TapdemActivity.this, ToanhinhActivity.class);
                            intent.putExtra("point", point);
                            intent.putExtra("count", count + 1);
                            intent.putExtra("istest", istest);
                            startActivity(intent);
                        }
                        count = count + 1;
                        countview.setText(String.valueOf("Câu " + count));
                        activeButton(View.VISIBLE, View.INVISIBLE);
                        setData();
                    }
                }
        });
    }
    public void onButtonClick(View v){
        switch (v.getId()){
            case R.id.btnTapdemA:
                if(result==0)
                    setReultWhenTrue();
                else
                    setResultWhenFalse();
                activeButton(View.INVISIBLE,View.VISIBLE);
                result=-1;
                break;
            case R.id.btnTapdemB:
                if(result==1)
                    setReultWhenTrue();
                else
                    setResultWhenFalse();
                activeButton(View.INVISIBLE,View.VISIBLE);
                result=-1;
                break;
            case R.id.btnTapdemC:
                if(result==2)
                    setReultWhenTrue();
                else
                    setResultWhenFalse();
                activeButton(View.INVISIBLE,View.VISIBLE);
                result=-1;
                break;
            case R.id.btnTapdemD:
                if(result==3)
                    setReultWhenTrue();

                else
                    setResultWhenFalse();
                activeButton(View.INVISIBLE,View.VISIBLE);
                result=-1;
                break;
        }
    }
    public void activeButton(int enable,int visible)
    {
        A.setVisibility(enable);
        B.setVisibility(enable);
        C.setVisibility(enable);
        D.setVisibility(enable);
        btnNext.setVisibility(visible);
    }
    public void setReultWhenTrue()
    {
        point +=10;
        pointView.setText(String.valueOf(point));
        if(musicEffectChecked)
        {
            musicsuccess.start();
        }
        CustomDialogResult dialog = new CustomDialogResult(TapdemActivity.this,true);
        dialog.showdialog();
    }
    public void setResultWhenFalse()
    {
        if(musicEffectChecked)
        {
            musicfail.start();
        }
        CustomDialogResult dialog = new CustomDialogResult(TapdemActivity.this,false);
        dialog.showdialog();
    }
    public void addanimation()
    {
        Tapdem.setBitmap(this.getApplicationContext());
        imageTapdem.setImageBitmap(Tapdem.addBitmap());
    }
    public void setData(){
        Tapdem = new tapdem();
        Tapdem.setResultToButton(A,B,C,D);
        imageTapdem.setImageResource(0);
        addanimation();
        result=Tapdem.getResult();
    }

}
