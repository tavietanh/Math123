package com.example.admin.math123.core;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import java.util.ArrayList;

public class tinhnham {
    int a = (int) (11*Math.random());
    int b = (int) (11*Math.random());
    int c;
    int DapAnA;
    int DapAnB;
    int DapAnC;
    int DapAnD;

    String Signview = "+-";
    String Sign ="";

    Bitmap bitmap ;
    ArrayList<Bitmap> arrayBitmap=new ArrayList<Bitmap>();
    public void setA() {
        this.a = (int) (11*Math.random());
    }
    public void setB() {
        this.b = (int) (10*Math.random());
        while (b > a)
            this.b = (int) (10*Math.random());
    }

    public void setSign(){
        String Dau;
        int temp = (int) Math.round(Math.random() * Signview.length());
        Sign += Signview.charAt(temp);
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = Bitmap.createScaledBitmap(bitmap,80,80,true);
    }

    public String getA() {

        return String.valueOf(a);
    }

    public String getB() {

        return String.valueOf(b);
    }

    public String getSign(){
        return Sign;
    }

    public int result()
    {
        if(Sign.equals("+"))
            c += a + b;
        else
            c += a - b;
        return c;
    }

    public void setDapAnA() {this.DapAnA = c + (int) (4*Math.random());}
    public void setDapAnB() {this.DapAnB = c + (int) (4*Math.random());}
    public void setDapAnC() {this.DapAnC = c + (int) (4*Math.random());}
    public void setDapAnD() {this.DapAnD = c + (int) (4*Math.random());}
    public String getDapAnA(){return String.valueOf(DapAnA);}
    public String getDapAnB(){return String.valueOf(DapAnB);}
    public String getDapAnC(){return String.valueOf(DapAnC);}
    public String getDapAnD(){return String.valueOf(DapAnD);}

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
            if(i==4 || i ==8) {
                Left=left;
                Top=Top+bitmap.get(i).getHeight();
            }
            canvas.drawBitmap(bitmap.get(i), Left, Top, null);

        }
        return temp;
    }
    public Bitmap addBitmapA()
    {
        if(a==0) return null;
        arrayBitmap.clear();
        for(int i = 0;i<a;i++)
        {
            arrayBitmap.add(bitmap);
        }
        return combineImageIntoOne(arrayBitmap,0,0);
    }
    public Bitmap addBitmapB()
    {
        if(b==0) return null;
        arrayBitmap.clear();
        for(int i = 0;i<b;i++)
        {
            arrayBitmap.add(bitmap);
        }
        return combineImageIntoOne(arrayBitmap,0,0);
    }
}
