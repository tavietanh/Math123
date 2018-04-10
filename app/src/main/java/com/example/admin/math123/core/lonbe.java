package com.example.admin.math123.core;

import android.widget.TextView;

import org.w3c.dom.Text;

public class lonbe {
    int a = (int) (10*Math.random());
    int b = (int) (10*Math.random());

    public void setA() {
        this.a = (int) (10*Math.random());
    }
    public void setB() {
        this.b = (int) (10*Math.random());
    }

    public String getA() {

        return String.valueOf(a);
    }

    public String getB() {
        return String.valueOf(b);
    }

    public int result(TextView a, TextView b)
    {
        int NumberA = Integer.parseInt(a.getText().toString());
        int NumberB = Integer.parseInt(b.getText().toString());
        if(NumberA > NumberB) return 2;
        if(NumberA == NumberB) return 1;
        if(NumberA < NumberB) return 0;
        return 3;
    }
}
