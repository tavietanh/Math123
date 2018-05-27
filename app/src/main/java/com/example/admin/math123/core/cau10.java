package com.example.admin.math123.core;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.math123.R;

import java.util.Random;

public class cau10 {
    int numbera=6;
    int result=-1;
    public int getResult()
    {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
    public void setResultToButton(Button A, Button B, Button C) {
        int a;
        int b;
        int c;
        switch (result) {
            case 0:
                A.setText(String.valueOf(numbera));
                do {
                    b = (int) (11 * Math.random());
                    B.setText(String.valueOf(b));
                } while (b == numbera);
                do {
                    c = (int) (11 * Math.random());
                    C.setText(String.valueOf(c));
                } while (c == numbera || b == c);
                break;
            case 1:
                B.setText(String.valueOf(numbera));
                do {
                    a = (int) (11 * Math.random());
                    A.setText(String.valueOf(a));
                } while (a == numbera);
                do {
                    c = (int) (11 * Math.random());
                    C.setText(String.valueOf(c));
                } while (c == numbera || a == c);
                break;
            case 2:
                C.setText(String.valueOf(numbera));
                do {
                    b = (int) (11 * Math.random());
                    B.setText(String.valueOf(b));
                } while (b == numbera);
                do {
                    a = (int) (11 * Math.random());
                    A.setText(String.valueOf(a));
                } while (a == numbera || b == a);
                break;
        }
    }
    public void setQuestion(TextView Question, ImageView imgview)
    {
        Random mRand = new Random();
        int x = mRand.nextInt(4);
        switch (x) {
            case 0:
                Question.setText("Có bao nhiêu hình vuông?");
                this.numbera=6;
                imgview.setImageResource(R.drawable.cau10_1);
                break;
            case 1:
                Question.setText("Có bao nhiêu hình tam giác?");
                this.numbera=6;
                imgview.setImageResource(R.drawable.cau10_2);
                break;
        }
    }
    public void setItemToActivity(TextView Question, ImageView imgview, Button A, Button B, Button C)
    {
        setQuestion(Question,imgview);
        setResultToButton(A,B,C);
    }
}
