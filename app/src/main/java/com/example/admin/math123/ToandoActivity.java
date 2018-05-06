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
import java.util.Random;

import com.example.admin.math123.core.toando;
import com.example.admin.math123.core.CustomDialogResult;

public class ToandoActivity extends AppCompatActivity {

    toando ToanDo = new toando();
    int result = 1;
    int count = 1;
    int point = 0;
    int signb = 0;
    int SoA,SoB;
    TextView firstText;
    TextView numbera;
    TextView secondText;
    TextView numberb;
    TextView thirdText;
    TextView countview;
    TextView pointView;
    TextView SignA;
    TextView SignB;
    TextView KQA;
    TextView KQB;
    TextView KQText;
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

    Random rd=new Random();
    int type = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toando);
        firstText = (TextView)findViewById(R.id.firstText);
        numbera = (TextView)findViewById(R.id.numbera);
        secondText = (TextView)findViewById(R.id.secondText);
        numberb = (TextView)findViewById(R.id.numberb);
        thirdText = (TextView)findViewById(R.id.thirdText);
        btnDapAnA = (Button)findViewById(R.id.btnDapAnA);
        btnDapAnB = (Button)findViewById(R.id.btnDapAnB);
        btnDapAnC = (Button)findViewById(R.id.btnDapAnC);
        btnDapAnD = (Button)findViewById(R.id.btnDapAnD);
        btnnext = (Button)findViewById(R.id.btnNext);
        pointView = (TextView)findViewById(R.id.pointlogic);
        countview = (TextView)findViewById(R.id.countlogic);
        countview.setText(String.valueOf(count));
        SignA = (TextView)findViewById(R.id.SignA);
        SignB = (TextView)findViewById(R.id.SignB);
        KQA = (TextView)findViewById(R.id.KQA);
        KQB = (TextView)findViewById(R.id.KQB);
        KQText = (TextView)findViewById(R.id.KqText);
        imgViewTopLeft = (ImageView)findViewById(R.id.imageLogicTopLeft);
        imgViewTopRight = (ImageView)findViewById(R.id.imageLogicTopRight);
        imgViewButtonLeft = (ImageView)findViewById(R.id.imageLogicButtonLeft);
        imgViewButtonRight = (ImageView)findViewById(R.id.imageLogicButtonRight);
        imgViewKQ = (ImageView)findViewById(R.id.imageKetQua);
        randomType(type);
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count==10)
                {
                    Intent intent = new Intent(ToandoActivity.this,PracticeActivity.class);
                    startActivity(intent);
                }
                else count=count+1;
                countview.setText(String.valueOf("Câu "+count));
                activeButton(View.VISIBLE,View.INVISIBLE);
                randomType(type);
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

    }

    public void setReultWhenTrue()
    {
        point +=10;
        pointView.setText(String.valueOf(point));
        CustomDialogResult dialog = new CustomDialogResult(ToandoActivity.this,true);
        dialog.showdialog();
    }

    public void setResultWhenFalse()
    {
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
        firstText.setText("");
        numbera.setText("");
        secondText.setText("");
        numberb.setText("");
        thirdText.setText("");
        btnDapAnA.setText("");
        btnDapAnB.setText("");
        btnDapAnC.setText("");
        btnDapAnD.setText("");
        ToanDo.setA();
        ToanDo.setB();
        ToanDo.setC();
        ToanDo.setD();
        result= ToanDo.getResult();
        Type= ToanDo.getType();
        type = Type;
        signb = ToanDo.getSignB();
        SoA = ToanDo.geta();
        SoB = ToanDo.getb();

        firstText.setText(ToanDo.getFirst());
        numbera.setText(ToanDo.getA());
        secondText.setText(ToanDo.getSecond());
        numberb.setText(ToanDo.getB());
        thirdText.setText(ToanDo.getThird());

        KQA.setText(ToanDo.getC());
        KQB.setText(ToanDo.getD());
        SignA.setText(ToanDo.getASign());
        SignB.setText(ToanDo.getBSign());

        ToanDo.setResultToButton(btnDapAnA,btnDapAnB,btnDapAnC,btnDapAnD);
        switch (type){
            case 0:
                visible(type);
                break;
            case 1:
                addani();
                visible(type);
                break;
            case 2:
               addani();
                visible(type);
                break;
        }
    }

    public void visible(int a) {
        if (a == 0) {
            firstText.setVisibility(View.VISIBLE);
            numbera.setVisibility(View.VISIBLE);
            secondText.setVisibility(View.VISIBLE);
            numberb.setVisibility(View.VISIBLE);
            thirdText.setVisibility(View.VISIBLE);
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
            firstText.setVisibility(View.INVISIBLE);
            numbera.setVisibility(View.INVISIBLE);
            secondText.setVisibility(View.INVISIBLE);
            numberb.setVisibility(View.INVISIBLE);
            thirdText.setVisibility(View.INVISIBLE);
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
            firstText.setVisibility(View.INVISIBLE);
            numbera.setVisibility(View.INVISIBLE);
            secondText.setVisibility(View.INVISIBLE);
            numberb.setVisibility(View.INVISIBLE);
            thirdText.setVisibility(View.INVISIBLE);
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
}
