package com.example.admin.math123.core;

import android.widget.Button;
import android.widget.TextView;

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
    public void setItemToActivity(TextView Question, Button A, Button B, Button C)
    {
        Question.setText("Có bao nhiêu hình vuông?");
        setResultToButton(A,B,C);
    }
}
