package com.example.admin.math123.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import java.util.ArrayList;
import android.widget.Button;

import com.example.admin.math123.R;

import java.util.Random;

public class tinhnham {
    int numbera = (int) (10*Math.random());
    int numberb = (int) (10*Math.random());
    int numberc;
    Bitmap bitmap ;
    ArrayList<Bitmap> arrayBitmap=new ArrayList<Bitmap>();

    String Sign ="";
    Random rd=new Random();
    int x = rd.nextInt((1-0+1)+0);
    int type = rd.nextInt((4-0+1)+0);
    int result;
    public void randomResult() {
        if(type == 3)
            result = x;
        else
            result = rd.nextInt((3-0+1)+0);
    }

    public int getResult() {
        return result;
    }

    public void setSign() {
        switch (x) {
            case 0:
                Sign = "+";
                break;
            case 1:
                Sign = "-";
                break;
        }
    }

    public void setA() {
        this.numbera = rd.nextInt((9-1+1)+1);
        while (numbera == 0) {
            this.numbera = rd.nextInt((9-0+1)+0);
        }
    }
    public void setB() {
        this.numberb = rd.nextInt((9-1+1)+1);
        if(type == 3)
            while (numberb == 0) {
                this.numberb = rd.nextInt((9-0+1)+0);
            }
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

    public String getA() {
        return String.valueOf(numbera);
    }

    public String getB() {

        return String.valueOf(numberb);
    }

    public String getC(){
        return String.valueOf(numberc);
    }

    public String getSign(){
        return Sign;
    }

    public int getType(){
        return type;
    }

    public void setBitmap(Context context) {
        Random mRand = new Random();
        int mResource = R.drawable.ani_1;
        int x = mRand.nextInt(4);
        switch (x) {
            case 0:
                mResource = R.drawable.ani_1;
                break;
            case 1:
                mResource = R.drawable.ani_2;
                break;
            case 2:
                mResource = R.drawable.ani_3;
                break;
            case 3:
                mResource = R.drawable.ani_4;
                break;
        }
        Bitmap bm = BitmapFactory.decodeResource(context.getResources(), mResource);
        this.bitmap = Bitmap.createScaledBitmap(bm,80,80,true);
    }

    Bitmap combineImageIntoOne(ArrayList<Bitmap> bitmap,int left,int top) {
        int w = 0, h = bitmap.get(0).getHeight();
        for (int i = 0; i < bitmap.size(); i++) {
            if (i < 4) {
                w += bitmap.get(i).getWidth();
            }
            if(i==3 || i==7) {
                h += bitmap.get(i).getHeight();
            }
        }

        Bitmap temp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(temp);
        int Left = left;
        int Top = top;
        for (int i = 0; i < bitmap.size(); i++) {
            Left = (i==0?Left:Left+bitmap.get(i).getWidth());
            if(i==3 || i ==6) {
                Left=left;
                Top=Top+bitmap.get(i).getHeight();
            }
            canvas.drawBitmap(bitmap.get(i), Left, Top, null);

        }
        return temp;
    }

    public Bitmap addBitmapA()
    {
        if(numbera==0) return null;
        arrayBitmap.clear();
        for(int i = 0;i<numbera;i++)
        {
            arrayBitmap.add(bitmap);
        }
        return combineImageIntoOne(arrayBitmap,0,0);
    }
    public Bitmap addBitmapB()
    {
        if(numberb==0) return null;
        arrayBitmap.clear();
        for(int i = 0;i<numberb;i++)
        {
            arrayBitmap.add(bitmap);
        }
        return combineImageIntoOne(arrayBitmap,0,0);
    }

    public void setResultToButton(Button A, Button B,Button C,Button D)
        {
            int a;
            int b;
            int c;
            int d;
            if (type == 0){
                switch (result){
                    case 0:
                        A.setText(String.valueOf(numberc));
                        do{
                            b = (int) (11*Math.random());
                            B.setText(String.valueOf(b));
                        }while(b==numberc);
                        do{
                            c = (int) (11*Math.random());
                            C.setText(String.valueOf(c));
                        }while(c==numberc||b==c);
                        do{
                            d = (int) (11*Math.random());
                            D.setText(String.valueOf(d));
                        }while(d==numberc||c==d||b==d);
                        break;
                    case 1:
                        B.setText(String.valueOf(numberc));
                        do{
                            a = (int) (11*Math.random());
                            A.setText(String.valueOf(a));
                        }while(a==numberc);
                        do{
                            c = (int) (11*Math.random());
                            C.setText(String.valueOf(c));
                        }while(c==numberc||a==c);
                        do{
                            d = (int) (11*Math.random());
                            D.setText(String.valueOf(d));
                        }while(d==numberc||c==d||a==d);
                        break;
                    case 2:
                        C.setText(String.valueOf(numberc));
                        do{
                            b = (int) (11*Math.random());
                            B.setText(String.valueOf(b));
                        }while(b==numberc);
                        do{
                            a = (int) (11*Math.random());
                            A.setText(String.valueOf(a));
                        }while(a==numberc||b==a);
                        do{
                            d = (int) (11*Math.random());
                            D.setText(String.valueOf(d));
                        }while(d==numberc||a==d||b==d);
                        break;
                    case 3:
                        D.setText(String.valueOf(numberc));
                        do{
                            b = (int) (11*Math.random());
                            B.setText(String.valueOf(b));
                        }while(b==numberc);
                        do{
                            c = (int) (11*Math.random());
                            C.setText(String.valueOf(c));
                        }while(c==numberc||b==c);
                        do{
                            a = (int) (11*Math.random());
                            A.setText(String.valueOf(a));
                        }while(a==numberc||c==a||b==a);
                        break;
                }
                }
            else if(type == 1){
                switch (result){
                    case 0:
                        A.setText(String.valueOf(numbera));
                        do{
                            b = (int) (11*Math.random());
                            B.setText(String.valueOf(b));
                        }while(b==numbera);
                        do{
                            c = (int) (11*Math.random());
                            C.setText(String.valueOf(c));
                        }while(c==numbera||b==c);
                        do{
                            d = (int) (11*Math.random());
                            D.setText(String.valueOf(d));
                        }while(d==numbera||c==d||b==d);
                        break;
                    case 1:
                        B.setText(String.valueOf(numbera));
                        do{
                            a = (int) (11*Math.random());
                            A.setText(String.valueOf(a));
                        }while(a==numbera);
                        do{
                            c = (int) (11*Math.random());
                            C.setText(String.valueOf(c));
                        }while(c==numbera||a==c);
                        do{
                            d = (int) (11*Math.random());
                            D.setText(String.valueOf(d));
                        }while(d==numbera||c==d||a==d);
                        break;
                    case 2:
                        C.setText(String.valueOf(numbera));
                        do{
                            b = (int) (11*Math.random());
                            B.setText(String.valueOf(b));
                        }while(b==numbera);
                        do{
                            a = (int) (11*Math.random());
                            A.setText(String.valueOf(a));
                        }while(a==numbera||b==a);
                        do{
                            d = (int) (11*Math.random());
                            D.setText(String.valueOf(d));
                        }while(d==numbera||a==d||b==d);
                        break;
                    case 3:
                        D.setText(String.valueOf(numbera));
                        do{
                            b = (int) (11*Math.random());
                            B.setText(String.valueOf(b));
                        }while(b==numbera);
                        do{
                            c = (int) (11*Math.random());
                            C.setText(String.valueOf(c));
                        }while(c==numbera||b==c);
                        do{
                            a = (int) (11*Math.random());
                            A.setText(String.valueOf(a));
                        }while(a==numbera||c==a||b==a);
                        break;
                }
            }
            else if (type == 2){
                switch (result){
                    case 0:
                        A.setText(String.valueOf(numberb));
                        do{
                            b = (int) (11*Math.random());
                            B.setText(String.valueOf(b));
                        }while(b==numberb);
                        do{
                            c = (int) (11*Math.random());
                            C.setText(String.valueOf(c));
                        }while(c==numberb||b==c);
                        do{
                            d = (int) (11*Math.random());
                            D.setText(String.valueOf(d));
                        }while(d==numberb||c==d||b==d);
                        break;
                    case 1:
                        B.setText(String.valueOf(numberb));
                        do{
                            a = (int) (11*Math.random());
                            A.setText(String.valueOf(a));
                        }while(a==numberb);
                        do{
                            c = (int) (11*Math.random());
                            C.setText(String.valueOf(c));
                        }while(c==numberb||a==c);
                        do{
                            d = (int) (11*Math.random());
                            D.setText(String.valueOf(d));
                        }while(d==numberb||c==d||a==d);
                        break;
                    case 2:
                        C.setText(String.valueOf(numberb));
                        do{
                            b = (int) (11*Math.random());
                            B.setText(String.valueOf(b));
                        }while(b==numberb);
                        do{
                            a = (int) (11*Math.random());
                            A.setText(String.valueOf(a));
                        }while(a==numberb||b==a);
                        do{
                            d = (int) (11*Math.random());
                            D.setText(String.valueOf(d));
                        }while(d==numberb||a==d||b==d);
                        break;
                    case 3:
                        D.setText(String.valueOf(numberb));
                        do{
                            b = (int) (11*Math.random());
                            B.setText(String.valueOf(b));
                        }while(b==numberb);
                        do{
                            c = (int) (11*Math.random());
                            C.setText(String.valueOf(c));
                        }while(c==numberb||b==c);
                        do{
                            a = (int) (11*Math.random());
                            A.setText(String.valueOf(a));
                        }while(a==numberb||c==a||b==a);
                        break;
                }
            }
            else if (type == 3)
            {
                B.setText(String.valueOf("+"));
                C.setText(String.valueOf("-"));
            }
            else if (type == 4){
                switch (result){
                    case 0:
                        A.setText(String.valueOf(numberc));
                        do{
                            b = (int) (11*Math.random());
                            B.setText(String.valueOf(b));
                        }while(b==numberc);
                        do{
                            c = (int) (11*Math.random());
                            C.setText(String.valueOf(c));
                        }while(c==numberc||b==c);
                        do{
                            d = (int) (11*Math.random());
                            D.setText(String.valueOf(d));
                        }while(d==numberc||c==d||b==d);
                        break;
                    case 1:
                        B.setText(String.valueOf(numberc));
                        do{
                            a = (int) (11*Math.random());
                            A.setText(String.valueOf(a));
                        }while(a==numberc);
                        do{
                            c = (int) (11*Math.random());
                            C.setText(String.valueOf(c));
                        }while(c==numberc||a==c);
                        do{
                            d = (int) (11*Math.random());
                            D.setText(String.valueOf(d));
                        }while(d==numberc||c==d||a==d);
                        break;
                    case 2:
                        C.setText(String.valueOf(numberc));
                        do{
                            b = (int) (11*Math.random());
                            B.setText(String.valueOf(b));
                        }while(b==numberc);
                        do{
                            a = (int) (11*Math.random());
                            A.setText(String.valueOf(a));
                        }while(a==numberc||b==a);
                        do{
                            d = (int) (11*Math.random());
                            D.setText(String.valueOf(d));
                        }while(d==numberc||a==d||b==d);
                        break;
                    case 3:
                        D.setText(String.valueOf(numberc));
                        do{
                            b = (int) (11*Math.random());
                            B.setText(String.valueOf(b));
                        }while(b==numberc);
                        do{
                            c = (int) (11*Math.random());
                            C.setText(String.valueOf(c));
                        }while(c==numberc||b==c);
                        do{
                            a = (int) (11*Math.random());
                            A.setText(String.valueOf(a));
                        }while(a==numberc||c==a||b==a);
                        break;
                }
            }
        }
}



