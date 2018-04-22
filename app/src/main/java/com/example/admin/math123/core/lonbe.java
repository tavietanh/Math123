package com.example.admin.math123.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.example.admin.math123.R;

import java.util.ArrayList;
import java.util.Random;

public class lonbe {
    int a = (int) (11*Math.random());
    int b = (int) (11*Math.random());
    Bitmap bitmap ;
    ArrayList<Bitmap> arrayBitmap=new ArrayList<Bitmap>();


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

    public String getA() {

        return String.valueOf(a);
    }

    public String getB() {
        return String.valueOf(b);
    }

    public int result()
    {
        if(a > b) return 0;
        if(a == b) return 1;
        if(a < b) return 2;
        return 3;
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
