package com.example.admin.math123.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.widget.Button;

import com.example.admin.math123.R;

import java.util.ArrayList;
import java.util.Random;

public class tapdem {
    Bitmap bitmap ;
    ArrayList<Bitmap> arrayBitmap=new ArrayList<Bitmap>();
    int number = (int) (11*Math.random());
    int result = (int) (4*Math.random());

    public int getResult() {
        return result;
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
        this.bitmap = Bitmap.createScaledBitmap(bm,220,220,true);
    }
    Bitmap combineImageIntoOne(ArrayList<Bitmap> bitmap, int left, int top) {

        Bitmap temp = Bitmap.createBitmap(1280, 960, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(temp);
        int Left = (int) (800*Math.random());
        int Top = (int) (600*Math.random());
        for (int i = 0; i < bitmap.size(); i++) {
            Left = (int) (1040*Math.random());
            Top = (int) (740*Math.random());
            canvas.drawBitmap(bitmap.get(i), Left, Top, null);
        }
        return temp;
    }
    public Bitmap addBitmap()
    {
        if(number==0) return null;
        arrayBitmap.clear();
        for(int i = 0;i<number;i++)
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
        switch (result){
            case 0:
                A.setText(String.valueOf(number));
                do{
                    b = (int) (11*Math.random());
                    B.setText(String.valueOf(b));
                }while(b==number);
                do{
                    c = (int) (11*Math.random());
                    C.setText(String.valueOf(c));
                }while(c==number||b==c);
                do{
                    d = (int) (11*Math.random());
                    D.setText(String.valueOf(d));
                }while(d==number||c==d||b==d);
                break;
            case 1:
                B.setText(String.valueOf(number));
                do{
                    a = (int) (11*Math.random());
                    A.setText(String.valueOf(a));
                }while(a==number);
                do{
                    c = (int) (11*Math.random());
                    C.setText(String.valueOf(c));
                }while(c==number||a==c);
                do{
                    d = (int) (11*Math.random());
                    D.setText(String.valueOf(d));
                }while(d==number||c==d||a==d);
                break;
            case 2:
                C.setText(String.valueOf(number));
                do{
                    b = (int) (11*Math.random());
                    B.setText(String.valueOf(b));
                }while(b==number);
                do{
                    a = (int) (11*Math.random());
                    A.setText(String.valueOf(a));
                }while(a==number||b==a);
                do{
                    d = (int) (11*Math.random());
                    D.setText(String.valueOf(d));
                }while(d==number||a==d||b==d);
                break;
            case 3:
                D.setText(String.valueOf(number));
                do{
                    b = (int) (11*Math.random());
                    B.setText(String.valueOf(b));
                }while(b==number);
                do{
                    c = (int) (11*Math.random());
                    C.setText(String.valueOf(c));
                }while(c==number||b==c);
                do{
                    a = (int) (11*Math.random());
                    A.setText(String.valueOf(a));
                }while(a==number||c==a||b==a);
                break;
        }
    }
}
