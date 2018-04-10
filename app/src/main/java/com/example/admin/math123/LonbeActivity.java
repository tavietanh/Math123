package com.example.admin.math123;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.math123.core.lonbe;


public class LonbeActivity extends AppCompatActivity {
    lonbe Lonbe = new lonbe();
    int result = 3;
    int count = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lonbe);
        final TextView signview = (TextView)findViewById(R.id.SignView);
        final TextView numbera = (TextView)findViewById(R.id.numberA);
        final TextView numberb = (TextView)findViewById(R.id.numberB);
        final Button btnless = (Button)findViewById(R.id.btnLesssign);
        final Button btnequal = (Button)findViewById(R.id.btnEqualsign);
        final Button btngreater = (Button)findViewById(R.id.btnGreatersign);
        final Button btnnext = (Button)findViewById(R.id.btnNext);
        final TextView countview = (TextView)findViewById(R.id.countView);
        countview.setText(String.valueOf(count));
        numbera.setText(Lonbe.getA());
        numberb.setText(Lonbe.getB());
        result= Lonbe.result(numbera,numberb);
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=count+1;
                countview.setText(String.valueOf(count));
                Lonbe = new lonbe();
                numbera.setText(Lonbe.getA());
                numberb.setText(Lonbe.getB());
                btnless.setEnabled(true);
                btnequal.setEnabled(true);
                btngreater.setEnabled(true);
                btnnext.setVisibility(View.INVISIBLE);
                signview.setText("?");
                result= Lonbe.result(numbera,numberb);
            }
        });
    }
    public void onButtonClick(View v){
        TextView signview = (TextView)findViewById(R.id.SignView);
        Button btnless = (Button)findViewById(R.id.btnLesssign);
        Button btnequal = (Button)findViewById(R.id.btnEqualsign);
        Button btngreater = (Button)findViewById(R.id.btnGreatersign);
        Button btnnext = (Button)findViewById(R.id.btnNext);
        switch (v.getId()){
            case R.id.btnLesssign:
                if(result==2) {
                    Toast.makeText(this, "Đúng ", Toast.LENGTH_LONG).show();
                    signview.setText("<");
                }
                else
                    setResultWhenFalse();
                btnless.setEnabled(false);
                btnequal.setEnabled(false);
                btngreater.setEnabled(false);
                btnnext.setVisibility(View.VISIBLE);
                result=3;
                break;
            case R.id.btnEqualsign:
                if(result==1) {
                    Toast.makeText(this, "Đúng ", Toast.LENGTH_LONG).show();
                    signview.setText("=");
                }
                else
                    setResultWhenFalse();
                btnless.setEnabled(false);
                btnequal.setEnabled(false);
                btngreater.setEnabled(false);
                btnnext.setVisibility(View.VISIBLE);
                result=3;
                break;
            case R.id.btnGreatersign:
                if(result==0) {
                    Toast.makeText(this, "Đúng ", Toast.LENGTH_LONG).show();
                    signview.setText(">");
                }
                else
                    setResultWhenFalse();
                btnless.setEnabled(false);
                btnequal.setEnabled(false);
                btngreater.setEnabled(false);
                btnnext.setVisibility(View.VISIBLE);
                result=3;
                break;
        }
    }
    public void setResultWhenFalse()
    {
        TextView signview = (TextView)findViewById(R.id.SignView);
        if(result==0) signview.setText(">");
        if(result==1) signview.setText("=");
        if(result==2) signview.setText("<");
    }
}
