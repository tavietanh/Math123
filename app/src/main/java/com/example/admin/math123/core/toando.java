package com.example.admin.math123.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import java.util.ArrayList;
import android.widget.Button;

import com.example.admin.math123.R;

import java.util.Random;

public class toando {
    int numbera = (int) (10*Math.random());
    int numberb = (int) (10*Math.random());
    int numberc;
    int numberd;


    Random rd=new Random();
    int x = rd.nextInt((1-0+1)+0);
    int type = rd.nextInt((2-0+1)+0);
    int result = rd.nextInt((3-0+1)+0);

    public int getResult() {
        return result;
    }

    public void setA() {
        this.numbera = rd.nextInt((9-1+1)+1);
        while (numbera == 0) {
            this.numbera = rd.nextInt((9-0+1)+0);
        }
    }

    public void setB() {
        this.numberb = rd.nextInt((9-1+1)+1);
        while ((x == 1) && (this.numberb > this.numbera)) {
            this.numberb = rd.nextInt((9-1+1)+1);
        }
    }

    public void setC(){
        if(x == 0)
            this.numberc = this.numbera + this.numberb;
        else
            this.numberc = this.numbera - this.numberb;
    }

    public void setD(){
        if(x == 0){
            if(numberb > numbera)
                this.numberd = this.numberb - this.numbera;
            else
                this.numberd = this.numbera - this.numberb;}
        else
            this.numberd = this.numbera + this.numberb;
    }

    public String getFirst(){
        return String.valueOf("Bạn Toàn có");
    }

    public String getA() {
        return String.valueOf(numbera) + " viên bi,";
    }

    public String getSecond(){
        if(x == 0)
            return "Bạn Toàn thắng";
        else
            return "Bạn Toàn thua";
    }

    public String getB() {

        return String.valueOf(numberb) + " viên bi.";
    }

    public String getThird(){
        return "Hỏi bạn Toàn có mấy viên bi?";
    }

    public String getC(){
        return "= " + String.valueOf(numberc);
    }

    public String getD(){
        return "= " + String.valueOf(numberd);
    }

    public String getASign(){
        if(x == 0)
            return "+";
        else
            return "-";
    }

    public String getBSign(){
        if(x == 0)
            return "-";
        else
            return "+";
    }

    public int getType(){
        return type;
    }

    public int getSignB(){
        return x;
    }

    public int geta(){
        return numbera;
    }

    public int getb(){
        return numberb;
    }

    public void setResultToButton(Button A, Button B,Button C,Button D)
    {
        int a;
        int b;
        int c;
        int d;
        if(type == 0)
            switch (result) {
                case 0:
                    A.setText(String.valueOf(numberc));
                    do {
                        b = (int) (11 * Math.random());
                        B.setText(String.valueOf(b));
                    } while (b == numberc);
                    do {
                        c = (int) (11 * Math.random());
                        C.setText(String.valueOf(c));
                    } while (c == numberc || b == c);
                    do {
                        d = (int) (11 * Math.random());
                        D.setText(String.valueOf(d));
                    } while (d == numberc || c == d || b == d);
                    break;
                case 1:
                    B.setText(String.valueOf(numberc));
                    do {
                        a = (int) (11 * Math.random());
                        A.setText(String.valueOf(a));
                    } while (a == numberc);
                    do {
                        c = (int) (11 * Math.random());
                        C.setText(String.valueOf(c));
                    } while (c == numberc || a == c);
                    do {
                        d = (int) (11 * Math.random());
                        D.setText(String.valueOf(d));
                    } while (d == numberc || c == d || a == d);
                    break;
                case 2:
                    C.setText(String.valueOf(numberc));
                    do {
                        b = (int) (11 * Math.random());
                        B.setText(String.valueOf(b));
                    } while (b == numberc);
                    do {
                        a = (int) (11 * Math.random());
                        A.setText(String.valueOf(a));
                    } while (a == numberc || b == a);
                    do {
                        d = (int) (11 * Math.random());
                        D.setText(String.valueOf(d));
                    } while (d == numberc || a == d || b == d);
                    break;
                case 3:
                    D.setText(String.valueOf(numberc));
                    do {
                        b = (int) (11 * Math.random());
                        B.setText(String.valueOf(b));
                    } while (b == numberc);
                    do {
                        c = (int) (11 * Math.random());
                        C.setText(String.valueOf(c));
                    } while (c == numberc || b == c);
                    do {
                        a = (int) (11 * Math.random());
                        A.setText(String.valueOf(a));
                    } while (a == numberc || c == a || b == a);
                    break;
            }
        else if(type == 1)
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
                    do {
                        d = (int) (11 * Math.random());
                        D.setText(String.valueOf(d));
                    } while (d == numbera || c == d || b == d);
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
                    do {
                        d = (int) (11 * Math.random());
                        D.setText(String.valueOf(d));
                    } while (d == numbera || c == d || a == d);
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
                    do {
                        d = (int) (11 * Math.random());
                        D.setText(String.valueOf(d));
                    } while (d == numbera || a == d || b == d);
                    break;
                case 3:
                    D.setText(String.valueOf(numbera));
                    do {
                        b = (int) (11 * Math.random());
                        B.setText(String.valueOf(b));
                    } while (b == numbera);
                    do {
                        c = (int) (11 * Math.random());
                        C.setText(String.valueOf(c));
                    } while (c == numbera || b == c);
                    do {
                        a = (int) (11 * Math.random());
                        A.setText(String.valueOf(a));
                    } while (a == numbera || c == a || b == a);
                    break;
            }
        else if (type == 2)
            switch (result) {
                case 0:
                    A.setText(String.valueOf(numberb));
                    do {
                        b = (int) (11 * Math.random());
                        B.setText(String.valueOf(b));
                    } while (b == numberb);
                    do {
                        c = (int) (11 * Math.random());
                        C.setText(String.valueOf(c));
                    } while (c == numberb || b == c);
                    do {
                        d = (int) (11 * Math.random());
                        D.setText(String.valueOf(d));
                    } while (d == numberb || c == d || b == d);
                    break;
                case 1:
                    B.setText(String.valueOf(numberb));
                    do {
                        a = (int) (11 * Math.random());
                        A.setText(String.valueOf(a));
                    } while (a == numberb);
                    do {
                        c = (int) (11 * Math.random());
                        C.setText(String.valueOf(c));
                    } while (c == numberb || a == c);
                    do {
                        d = (int) (11 * Math.random());
                        D.setText(String.valueOf(d));
                    } while (d == numberb || c == d || a == d);
                    break;
                case 2:
                    C.setText(String.valueOf(numberb));
                    do {
                        b = (int) (11 * Math.random());
                        B.setText(String.valueOf(b));
                    } while (b == numberb);
                    do {
                        a = (int) (11 * Math.random());
                        A.setText(String.valueOf(a));
                    } while (a == numberb || b == a);
                    do {
                        d = (int) (11 * Math.random());
                        D.setText(String.valueOf(d));
                    } while (d == numberb || a == d || b == d);
                    break;
                case 3:
                    D.setText(String.valueOf(numberb));
                    do {
                        b = (int) (11 * Math.random());
                        B.setText(String.valueOf(b));
                    } while (b == numberb);
                    do {
                        c = (int) (11 * Math.random());
                        C.setText(String.valueOf(c));
                    } while (c == numberb || b == c);
                    do {
                        a = (int) (11 * Math.random());
                        A.setText(String.valueOf(a));
                    } while (a == numberb || c == a || b == a);
                    break;
            }
    }
}
