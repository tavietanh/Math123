package com.example.admin.math123.core;

import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class cau9 {
    int numberd = (int) (11 * Math.random() + 10);
    int numberb = (int) (11 * Math.random());
    int numberc = (int) (11 * Math.random());
    int numbera = numberd - numberc + numberb;
    int result=-1;
    String question;
    String Answer;
    public void setQuestion() {
        Random mRand = new Random();
        int x = mRand.nextInt(4);
        switch (x) {
            case 0:
                question = "Hà nghĩ ra một số, lấy số đó trừ " + String.valueOf(numberb) + " cộng " + String.valueOf(numberc) + " bằng " + String.valueOf(numberd) + " . Hỏi số Hà nghĩ là bao nhiêu?";
                Answer = "Số dó là: \n\t" + String.valueOf(numberd)+" - " + String.valueOf(numberc)+" + "+String.valueOf(numberb) +" = "+String.valueOf(numbera);
                break;
            case 1:
                question = "Tuấn lấy " + String.valueOf(numberb) + " viên bi trong hộp, sau đó bỏ thêm " + String.valueOf(numberc) + " viên bi thì số bi trong hộp là " + String.valueOf(numberd) + " . Hỏi trong hộp ban đầu trong hộp có mấy viên bi?";
                Answer = "Số bi trong hộp là: \n\t" + String.valueOf(numberd)+" - " + String.valueOf(numberc)+" + "+String.valueOf(numberb) +" = "+String.valueOf(numbera);
                break;
            case 2:
                question = "Bắt " + String.valueOf(numberb) + " con gà trong chuồng, trứng nở thêm " + String.valueOf(numberc) + " con gà thì số gà là " + String.valueOf(numberd) + " . Hỏi trong chuồng ban đầu có bao nhiêu con gà?";
                Answer = "Số gà trong chuồng là: \n\t" + String.valueOf(numberd)+" - " + String.valueOf(numberc)+" + "+String.valueOf(numberb) +" = "+String.valueOf(numbera);
                break;
            case 3:
                question = "Mẹ Dung bỏ " + String.valueOf(numberb) + " quả táo hư, sau đó mua thêm " + String.valueOf(numberc) + " quả táo thì số quả táo trong giỏ là " + String.valueOf(numberd) + " . Mẹ dung ban đầu có bao nhiêu quả táo?";
                Answer = "Số táo là: \n\t" + String.valueOf(numberd)+" - " + String.valueOf(numberc)+" + "+String.valueOf(numberb) +" = "+String.valueOf(numbera);
                break;
        }
    }
    public String getAnswer()
    {
        return this.Answer;
    }
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
        setQuestion();
        Question.setText(question);
        setResultToButton(A,B,C);
    }

}
