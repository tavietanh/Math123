package com.example.admin.math123.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.math123.R;

import java.util.ArrayList;
import java.util.Random;

public class toanhinh {
    int result = -1;
    Bitmap bmRetangle;
    Bitmap bmTriangle;
    Bitmap bmCircle;
    Bitmap bmSquare;
    ArrayList<Bitmap> arrayBitmap=new ArrayList<Bitmap>();
    int nTriangle = (int) (11*Math.random());
    int nRetangle = (int) (11*Math.random());
    int nCircle = (int) (11*Math.random());
    int nSquare = (int) (11*Math.random());


    public int getResult() {
        return result;
    }

    Bitmap addBorderRetangle(Bitmap bmp, int borderSize) {
        Bitmap bmpWithBorder = Bitmap.createBitmap(bmp.getWidth() + borderSize * 2, bmp.getHeight() + borderSize * 2, bmp.getConfig());
        Canvas canvas = new Canvas(bmpWithBorder);
        canvas.drawColor(Color.BLACK);
        canvas.drawBitmap(bmp, borderSize, borderSize, null);
        return bmpWithBorder;
    }
    public void setBitmap(Context context) {
        Random mRand = new Random();
        Bitmap bm = Bitmap.createBitmap(200,200,Bitmap.Config.ARGB_8888);
        int x = mRand.nextInt(3);
        switch (x) {
            case 0:
                bm.eraseColor(context.getResources().getColor(R.color.colorPrimary));
                break;
            case 1:
                bm.eraseColor(Color.RED);
                break;
            case 2:
                bm.eraseColor(context.getResources().getColor(R.color.colorBrown));
                break;
        }
        this.bmCircle = getCircleBitmap(bm,200);
        x = mRand.nextInt(3);
        switch (x) {
            case 0:
                bm.eraseColor(context.getResources().getColor(R.color.colorAccent));
                break;
            case 1:
                bm.eraseColor(Color.GREEN);
                break;
            case 2:
                bm.eraseColor(context.getResources().getColor(R.color.colorYellowDark));
                break;
        }
        this.bmTriangle=getTriangleBitmap(bm,200);
        x = mRand.nextInt(3);
        switch (x) {
            case 0:
                bm.eraseColor(context.getResources().getColor(R.color.colorGreenLight));
                break;
            case 1:
                bm.eraseColor(Color.YELLOW);
                break;
            case 2:
                bm.eraseColor(context.getResources().getColor(R.color.colorBrownDark));
                break;
        }
        this.bmSquare=addBorderRetangle(bm,3);
        bm = Bitmap.createBitmap(200,mRand.nextInt(50)+100,Bitmap.Config.ARGB_8888);
        x = mRand.nextInt(3);
        switch (x) {
            case 0:
                bm.eraseColor(context.getResources().getColor(R.color.colorRedDark));
                break;
            case 1:
                bm.eraseColor(Color.MAGENTA);
                break;
            case 2:
                bm.eraseColor(context.getResources().getColor(R.color.colorBlackGreen));
                break;
        }
        this.bmRetangle=addBorderRetangle(bm,3);
    }
    Bitmap addBorderTriangle(Bitmap bitmap, int borderSize) {
        Bitmap finalBitmap;
        finalBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getWidth(),
                    false);
        Bitmap output = Bitmap.createBitmap(finalBitmap.getWidth(),
                finalBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, finalBitmap.getWidth(),
                finalBitmap.getHeight());

        Point point1_draw = new Point(75, 0);
        Point point2_draw = new Point(0, 180);
        Point point3_draw = new Point(180, 180);

        Path path = new Path();
        path.moveTo(point1_draw.x, point1_draw.y);
        path.lineTo(point2_draw.x, point2_draw.y);
        path.lineTo(point3_draw.x, point3_draw.y);
        path.lineTo(point1_draw.x, point1_draw.y);
        path.close();
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(Color.BLACK);
        canvas.drawPath(path, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawColor(Color.BLACK);
        canvas.drawBitmap(finalBitmap, +borderSize*2, borderSize*2, paint);
        return output;
    }
    Bitmap getTriangleBitmap(Bitmap bitmap, int radius) {
        Bitmap finalBitmap;
        if (bitmap.getWidth() != radius || bitmap.getHeight() != radius)
            finalBitmap = Bitmap.createScaledBitmap(bitmap, radius, radius,
                    false);
        else
            finalBitmap = bitmap;
        Bitmap output = Bitmap.createBitmap(finalBitmap.getWidth(),
                finalBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, finalBitmap.getWidth(),
                finalBitmap.getHeight());

        Point point1_draw = new Point(75, 0);
        Point point2_draw = new Point(0, 180);
        Point point3_draw = new Point(180, 180);

        Path path = new Path();
        path.moveTo(point1_draw.x, point1_draw.y);
        path.lineTo(point2_draw.x, point2_draw.y);
        path.lineTo(point3_draw.x, point3_draw.y);
        path.lineTo(point1_draw.x, point1_draw.y);
        path.close();
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(Color.parseColor("#BAB399"));
        canvas.drawPath(path, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(finalBitmap, rect, rect, paint);

        return output;
    }
    Bitmap addBorderCircle(Bitmap bitmap, int borderSize) {
        Bitmap finalBitmap;
        finalBitmap = bitmap;
        Bitmap output = Bitmap.createBitmap(finalBitmap.getWidth(),
                finalBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        canvas.drawCircle(finalBitmap.getWidth() / 2, finalBitmap.getHeight() / 2,
                finalBitmap.getWidth() / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawColor(Color.BLACK);
        canvas.drawBitmap(finalBitmap, borderSize*2, borderSize*2, paint);
        return output;
    }
    Bitmap getCircleBitmap(Bitmap bitmap, int radius) {
        Bitmap finalBitmap;
        if (bitmap.getWidth() != radius || bitmap.getHeight() != radius)
            finalBitmap = Bitmap.createScaledBitmap(bitmap, radius, radius,
                    false);
        else
            finalBitmap = bitmap;
        Bitmap output = Bitmap.createBitmap(finalBitmap.getWidth(),
                finalBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, finalBitmap.getWidth(),
                finalBitmap.getHeight());
        paint.setColor(Color.parseColor("#BAB399"));
        canvas.drawCircle(finalBitmap.getWidth() / 2, finalBitmap.getHeight() / 2,
                finalBitmap.getWidth() / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(finalBitmap, rect, rect, paint);

        return output;
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
    public Bitmap addnTriangle()
    {
        if(nTriangle==0) return null;
        arrayBitmap.clear();
        bmTriangle=addBorderTriangle(bmTriangle,3);
        for(int i = 0;i<nTriangle;i++)
        {

            arrayBitmap.add(bmTriangle);
        }
        return combineImageIntoOne(arrayBitmap,0,0);
    }
    public void addnGeometryFake(int mark)
    {
        Random mRand = new Random();
        int n = mRand.nextInt(11);
        arrayBitmap.clear();
        for(int i = 0;i<n;i++) {
            int x = mRand.nextInt(4);
            switch (x) {
                case 0:
                    if (mark == 0) {
                        i--;
                    }
                    else
                        arrayBitmap.add(bmSquare);
                    break;
                case 1:
                    if (mark == 1) {
                        i--;
                    }
                    else
                        arrayBitmap.add(bmCircle);

                    break;
                case 2:
                    if (mark == 2) {
                        i--;
                    }
                    else
                        arrayBitmap.add(bmRetangle);
                    break;
                case 3:
                    if (mark == 3) {
                        i--;
                    }
                    else
                        arrayBitmap.add(bmTriangle);
                    break;
            }
        }
    }
    public Bitmap addnGeometry(int mark,int nGeometry,Bitmap bmGeometry)
    {
        addnGeometryFake(mark);
        bmTriangle=addBorderTriangle(bmTriangle,3);
        bmCircle=addBorderCircle(bmCircle,3);
        if(nGeometry==0) return null;
        for(int i = 0;i<nGeometry;i++)
        {
            arrayBitmap.add(bmGeometry);
        }
        return combineImageIntoOne(arrayBitmap,0,0);
    }
    void setResultButton(Button A,Button B,Button C,Button D,int True)
    {
        int a;
        int b;
        int c;
        int d;
        Random mRand = new Random();
        result= mRand.nextInt(4);
        switch (result) {
            case 0:
                A.setText(String.valueOf(True));
                do{
                    b = (int) (11*Math.random());
                    B.setText(String.valueOf(b));
                }while(b==True);
                do{
                    c = (int) (11*Math.random());
                    C.setText(String.valueOf(c));
                }while(c==True||b==c);
                do{
                    d = (int) (11*Math.random());
                    D.setText(String.valueOf(d));
                }while(d==True||c==d||b==d);
                break;
            case 1:
                B.setText(String.valueOf(True));
                do{
                    a = (int) (11*Math.random());
                    A.setText(String.valueOf(a));
                }while(a==True);
                do{
                    c = (int) (11*Math.random());
                    C.setText(String.valueOf(c));
                }while(c==True||a==c);
                do{
                    d = (int) (11*Math.random());
                    D.setText(String.valueOf(d));
                }while(d==True||c==d||a==d);
                break;
            case 2:
                C.setText(String.valueOf(True));
                do{
                    b = (int) (11*Math.random());
                    B.setText(String.valueOf(b));
                }while(b==True);
                do{
                    a = (int) (11*Math.random());
                    A.setText(String.valueOf(a));
                }while(a==True||b==a);
                do{
                    d = (int) (11*Math.random());
                    D.setText(String.valueOf(d));
                }while(d==True||a==d||b==d);
                break;
            case 3:
                D.setText(String.valueOf(True));
                do{
                    b = (int) (11*Math.random());
                    B.setText(String.valueOf(b));
                }while(b==True);
                do{
                    c = (int) (11*Math.random());
                    C.setText(String.valueOf(c));
                }while(c==True||b==c);
                do{
                    a = (int) (11*Math.random());
                    A.setText(String.valueOf(a));
                }while(a==True||c==a||b==a);
                break;
        }
    }
    public void addItemToActivity(TextView question, ImageView img,Button btnA,Button btnB,Button btnC,Button btnD,int count)
    {
        result=-1;
        Random mRand = new Random();
        Bitmap bitmap;
        if(count <4)
        {
            question.setText("Đây là hình gì?");
            btnA.setText("Vuông");
            btnA.setTextSize(15);
            btnB.setText("Tròn");
            btnB.setTextSize(15);
            btnC.setText("Chữ nhật");
            btnC.setTextSize(15);
            btnD.setText("Tam Giác");
            btnD.setTextSize(15);
            int x = mRand.nextInt(4);
            switch (x) {
                    case 0:
                        bitmap = Bitmap.createScaledBitmap(bmSquare, 300, 300, true);
                        img.setImageBitmap(bitmap);
                        result=0;
                        break;
                    case 1:
                        bitmap = Bitmap.createScaledBitmap(bmCircle, 300, 300, true);
                        img.setImageBitmap(bitmap);
                        result = 1;
                        break;
                    case 2:
                        bitmap = Bitmap.createScaledBitmap(bmRetangle, 300, 200, true);
                        img.setImageBitmap(bitmap);
                        result=2;
                        break;
                    case 3:
                        bitmap = Bitmap.createScaledBitmap(bmTriangle, 300, 300, true);
                        img.setImageBitmap(bitmap);
                        result = 3;
                        break;
            }
        }
        if(count >=4)
        {
            btnA.setTextSize(30);
            btnB.setTextSize(30);
            btnC.setTextSize(30);
            btnD.setTextSize(30);
            String Squestion = "Có bao nhiêu hình ";
            int x = mRand.nextInt(4);
            switch (x) {
                case 0:
                    question.setText(Squestion+"Vuông?");
                    img.setImageBitmap(addnGeometry(0,nSquare,bmSquare));
                    setResultButton(btnA,btnB,btnC,btnD,nSquare);
                    break;
                case 1:
                    question.setText(Squestion+"Tròn?");
                    img.setImageBitmap(addnGeometry(1,nCircle,bmCircle));
                    setResultButton(btnA,btnB,btnC,btnD,nCircle);
                    break;
                case 2:
                    question.setText(Squestion+"Chữ Nhật?");
                    img.setImageBitmap(addnGeometry(2,nRetangle,bmRetangle));
                    setResultButton(btnA,btnB,btnC,btnD,nRetangle);
                    break;
                case 3:
                    question.setText(Squestion+"Tam Giác?");
                    img.setImageBitmap(addnGeometry(3,nTriangle,bmTriangle));
                    setResultButton(btnA,btnB,btnC,btnD,nTriangle);
                    break;
            }
        }
    }
}

