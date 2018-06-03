package com.example.admin.math123.core;

import android.widget.Button;

import java.util.Random;

public class toando {
    int numbera = (int) (10*Math.random());
    int numberb = (int) (10*Math.random());
    int numberc;
    int numberd;
    int temp;


    Random rd=new Random();
    int x = rd.nextInt((1-0+1)+0);
    int type = rd.nextInt((2-0+1)+0);
    int result = rd.nextInt((3-0+1)+0);
    int MauCau = rd.nextInt((2-0+1)+0);

    public void setMauCau(){
        while(MauCau == temp)
            MauCau = rd.nextInt((2-0+1)+0);
        temp = MauCau;
    }

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
        while (((x == 1) && (this.numberb > this.numbera)) || (this.numberb == 0)) {
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

    public String getContent(){
        if(type == 0)
            switch (MauCau) {
                case 0:
                    if (x == 0)
                        return "Bạn Toàn có " + String.valueOf(numbera) + " viên bi, bạn Toàn thắng " + String.valueOf(numberb)
                                + " viên bi. Hỏi bạn Toàn có bao nhiêu viên bi?";
                    else
                        return "Bạn Toàn có " + String.valueOf(numbera) + " viên bi, bạn Toàn thua " + String.valueOf(numberb)
                                + " viên bi. Hỏi bạn Toàn có bao nhiêu viên bi?";
                case 1:
                    if (x == 0)
                        return "Lan hái được " + String.valueOf(numbera) + " bông hoa, Thanh hái được " +String.valueOf(numberb)
                                + " bông hoa. Hỏi cả hai bạn hái được bao nhiêu bông hoa?";
                    else
                        return "Lan hái được " + String.valueOf(numbera) + " bông hoa, Lan cho Thanh " +String.valueOf(numberb)
                                + " bông hoa. Hỏi Lan còn bao nhiêu bông hoa?";
                case 2:
                    if (x == 0)
                        return "Bạn Nam có " + String.valueOf(numbera) + " quả bóng màu đỏ, " +String.valueOf(numberb)
                                + " quả bóng màu xanh. Hỏi bạn Nam có bao nhiêu quả bóng?";
                    else
                        return "Bạn Nam có " + String.valueOf(numbera) + " quả bóng màu đỏ, " +String.valueOf(numberb)
                                + " quả bóng màu xanh. Hỏi bóng màu đỏ nhiều hơn bóng màu xanh bao nhiêu?";
            }
        else if (type == 2){
            switch (MauCau) {
                case 0:
                    if (x == 0)
                        return "Bạn Dũng có " + String.valueOf(numbera) + " nhãn vở. Sau khi được cho, bạn Dũng có "
                                + String.valueOf(numberc) + " nhãn vở. Hỏi bạn Dũng đã được cho bao nhiêu nhãn vở?";
                    else
                        return "Bạn Dũng có " + String.valueOf(numbera) + " nhãn vở. Sau khi cho bạn thì Dũng còn "
                                + String.valueOf(numberc) + " nhãn vở. Hỏi bạn Dũng đã cho bạn bao nhiêu nhãn vở?";
                case 1:
                    if (x == 0)
                        return "Lớp 1A có " + String.valueOf(numbera) + " học sinh giỏi. Cả 2 lớp có "
                                +String.valueOf(numberc) + " học sinh giỏi. Hỏi lớp 1B có bao nhiêu học sinh giỏi?";
                    else
                        return "Lớp 1A có " + String.valueOf(numbera) + " học sinh giỏi. Lớp 1A nhiều hơn lớp 1B "
                                +String.valueOf(numberc) + " học sinh giỏi. Hỏi lớp 1B có bao nhiêu học sinh giỏi?";
                case 2:
                    if (x == 0)
                        return "Lớp Lan có " + String.valueOf(numberc) + " bạn học sinh, " + String.valueOf(numbera)
                                + " bạn học vẽ, các bạn còn lại học hát. Hỏi có bao nhiêu bạn học hát?";
                    else
                        return "Lớp Lan có số bạn học vẽ nhiều hơn số bạn học hát là " + String.valueOf(numberc) +
                                " bạn, biết số bạn học vẽ là " + String.valueOf(numbera) + " bạn. Hỏi có bao nhiêu bạn học hát?";
            }
        }
        else if (type == 1){
            switch (MauCau) {
                case 0:
                    if (x == 0)
                        return "2 anh em có " + String.valueOf(numberc) + " que tính. Người em có "
                                + String.valueOf(numberb) + " que tính. Hỏi người anh có bao nhiêu que tính?";
                    else
                        return "Người anh hơn người em " + String.valueOf(numberc) + " que tính. Người em có "
                                + String.valueOf(numberb) + " que tính. Hỏi người anh có bao nhiêu que tính?";
                case 1:
                    if (x == 0)
                        return "Lan và Hồng có " + String.valueOf(numberc) + " quyển vở. Hồng có "
                                +String.valueOf(numberb) + " quyển vở. Hỏi Lan có bao nhiêu quyển vở?";
                    else
                        return "Lan cho Hồng " + String.valueOf(numberb) + " quyển vở. Lan còn lại "
                                +String.valueOf(numberc) + " quyển vở. Hỏi Lan có bao nhiêu quyển vở?";
                case 2:
                    if (x == 0)
                        return "Lớp 1A và lớp 1B có " + String.valueOf(numberc) + " bạn, biết lớp 1B có" + String.valueOf(numberb)
                                + " bạn. Lớp 1A có bao nhiêu bạn?";
                    else
                        return "Lớp 1A nhiều hơn lớp 1B " + String.valueOf(numberc) +
                                " bạn, biết lớp 1B có " + String.valueOf(numberb) + " bạn. Hỏi lớp 1A có bao nhiêu bạn?";
            }
        }
        return null;
    }

    public String getCachGiai(){
        if(type == 0)
            switch (MauCau) {
                case 0:
                    if (x == 0)
                        return "Bạn Toàn có " + String.valueOf(numbera) + " viên bi và bạn Toàn thắng " + String.valueOf(numberb) + " viên bi."
                                + "\nVì bạn Toàn 'Thắng' nên đây là bài toán tổng 2 số với kết quả là \n"
                                + String.valueOf(numberc) + " = " + String.valueOf(numbera) + " + " + String.valueOf(numberb);
                    else
                        return "Bạn Toàn có " + String.valueOf(numbera) + " viên bi và bạn Toàn thua " + String.valueOf(numberb) + " viên bi."
                                + "\nVì bạn Toàn 'Thua' nên đây là bài toán hiệu 2 số với số trừ là " + String.valueOf(numbera) + ", số bị trừ là " + String.valueOf(numberb)
                                + "\nKết quả là \n"
                                + String.valueOf(numberc) + " = " + String.valueOf(numbera) + " - " + String.valueOf(numberb);
                case 1:
                    if (x == 0)
                        return "Lan hái được " + String.valueOf(numbera) + " bông hoa, và Thanh hái được " +String.valueOf(numberb) + " bông hoa"
                                + "\nVì hỏi 2 bạn có bao nhiêu bông hoa nên đây là bài toán tổng 2 số với kết quả là \n"
                                + String.valueOf(numberc) + " = " + String.valueOf(numbera) + " + " + String.valueOf(numberb);
                    else
                        return "Lan hái được " + String.valueOf(numbera) + " bông hoa, và Lan cho Thanh " +String.valueOf(numberb) + " bông hoa"
                                + "\nVì hỏi 2 Lan còn bao nhiêu bông hoa nên đây là bài toán hiệu 2 số với số trừ là " + String.valueOf(numbera) + ", số bị trừ là " + String.valueOf(numberb)
                                + "\nKết quả là \n"
                                + String.valueOf(numberc) + " = " + String.valueOf(numbera) + " - " + String.valueOf(numberb);
                case 2:
                    if (x == 0)
                        return "Bạn Nam có " + String.valueOf(numbera) + " quả bóng màu đỏ và " + String.valueOf(numberb) + " quả bóng xanh"
                                + "\nVì hỏi tổng số bóng nên đây là bài toán tổng 2 số với kết quả là \n"
                                + String.valueOf(numberc) + " = " + String.valueOf(numbera) + " + " + String.valueOf(numberb);
                    else
                        return "Bạn Nam có " + String.valueOf(numbera) + " quả bóng màu đỏ và " + String.valueOf(numberb) + " quả bóng xanh"
                                + "\nVì hỏi số bóng đỏ nhiều hơn số bóng xanh bao nhiêu nên đây là bài toán hiệu 2 số với số trừ là " + String.valueOf(numbera) + ", số bị trừ là " + String.valueOf(numberb)
                                + "\nKết quả là \n"
                                + String.valueOf(numberc) + " = " + String.valueOf(numbera) + " - " + String.valueOf(numberb);
            }
        else if (type == 2){
            switch (MauCau) {
                case 0:
                    if (x == 0)
                        return "Bạn Dũng có " + String.valueOf(numbera) + " nhãn vở và sau khi được cho, bạn Dũng có " + String.valueOf(numberc) + " nhãn vở"
                                + "\nVì hỏi bạn Dũng được cho bao nhiêu? Đây là bài toán tổng 2 số nên ta tìm theo cách sau:\n"
                                + String.valueOf(numberc) + " = " + String.valueOf(numbera) + " + ?\n"
                                + String.valueOf(numberb) + " = " + String.valueOf(numberc) + " - " + String.valueOf(numbera);

                    else
                        return "Bạn Dũng có " + String.valueOf(numbera) + " nhãn vở và sau khi bạn Dũng cho bạn thì còn " + String.valueOf(numberc) + " nhãn vở"
                                + "\nVì hỏi bạn Dũng đã cho bạn bao nhiêu? Đây là bài toán hiệu 2 số nên ta tìm theo cách sau:\n"
                                + String.valueOf(numberc) + " = " + String.valueOf(numbera) + " - ?\n"
                                + String.valueOf(numberb) + " = " + String.valueOf(numbera) + " - " + String.valueOf(numberc);
                case 1:
                    if (x == 0)
                        return "Lớp 1A có " + String.valueOf(numbera) + " học sinh giỏi và cả 2 lớp có " +String.valueOf(numberc) + " học sinh giỏi"
                                +"\nHỏi số sinh giỏi lớp 1B? Đây là bài toán tổng 2 số nên ta tìm theo cách sau:\n"
                                + String.valueOf(numberc) + " = " + String.valueOf(numbera) + " + ?\n"
                                + String.valueOf(numberb) + " = " + String.valueOf(numberc) + " - " + String.valueOf(numbera);
                    else
                        return "Lớp 1A có " + String.valueOf(numbera) + " học sinh giỏi và lớp 1A nhiều hơn lớp 1B " +String.valueOf(numberc) + " học sinh giỏi"
                                +"\nHỏi số sinh giỏi lớp 1B? Đây là bài toán hiệu 2 số nên ta tìm theo cách sau:\n"
                                + String.valueOf(numberc) + " = " + String.valueOf(numbera) + " - ?\n"
                                + String.valueOf(numberb) + " = " + String.valueOf(numbera) + " - " + String.valueOf(numberc);
                case 2:
                    if (x == 0)
                        return "Lớp Lan có " + String.valueOf(numberc) + " bạn học sinh, có " + String.valueOf(numbera) + " bạn học vẽ và các bạn còn lại học hát"
                                +"\nHỏi lớp Lan có bao nhiêu bạn học hát? Đây là bài toán tổng 2 số nên ta tìm theo cách sau\n"
                                + String.valueOf(numberc) + " = " + String.valueOf(numbera) + " + ?\n"
                                + String.valueOf(numberb) + " = " + String.valueOf(numberc) + " - " + String.valueOf(numbera);
                    else
                        return "Lớp Lan có số bạn học vẽ nhiều hơn số bạn học hát là " + String.valueOf(numberc) + " bạn và biết số bạn học vẽ là " + String.valueOf(numbera) + " bạn"
                                + "\nHỏi có bao nhiêu bạn học hát? ? Đây là bài toán hiệu 2 số nên ta tìm theo cách sau\n"
                                + String.valueOf(numberc) + " = " + String.valueOf(numbera) + " - ?\n"
                                + String.valueOf(numberb) + " = " + String.valueOf(numbera) + " - " + String.valueOf(numberc);
            }
        }
        else if (type == 1){
            switch (MauCau) {
                case 0:
                    if (x == 0)
                        return "2 anh em có " + String.valueOf(numberc) + " que tính và người em có " + String.valueOf(numberb) + " que tính"
                                + "\nHỏi người anh có bao nhiêu que tính? Đây là bài toán tổng 2 số nên ta tìm theo cách sau:\n"
                                + String.valueOf(numberc) + " = " + "? + " + String.valueOf(numberb) + "\n"
                                + String.valueOf(numbera) + " = " + String.valueOf(numberc) + " - " + String.valueOf(numberb);
                    else
                        return "Người anh hơn người em " + String.valueOf(numberc) + " que tính và người em có " + String.valueOf(numberb) + " que tính"
                                + "\nHỏi người anh có bao nhiêu que tính? Đây là bài toán hiệu 2 số nên ta tìm theo cách sau:\n"
                                + String.valueOf(numberc) + " = " + "? - " + String.valueOf(numberb) + "\n"
                                + String.valueOf(numbera) + " = " + String.valueOf(numberc) + " + " + String.valueOf(numberb);
                case 1:
                    if (x == 0)
                        return "Lan và Hồng có " + String.valueOf(numberc) + " quyển vở và Hồng có " +String.valueOf(numberb) + " quyển vở"
                                + "\nHỏi Lan có bao nhiêu quyển vở? Đây là bài toán tổng 2 số nên ta tìm theo cách sau:\n"
                                + String.valueOf(numberc) + " = " + "? + " + String.valueOf(numberb) + "\n"
                                + String.valueOf(numbera) + " = " + String.valueOf(numberc) + " - " + String.valueOf(numberb);
                    else
                        return "Lan cho Hồng " + String.valueOf(numberb) + " quyển vở và Lan còn lại " +String.valueOf(numberc) + " quyển vở"
                                + "\nHỏi Lan có bao nhiêu quyển vở? Đây là bài toán hiệu 2 số nên ta tìm theo cách sau:\n"
                                + String.valueOf(numberc) + " = " + "? - " + String.valueOf(numberb) + "\n"
                                + String.valueOf(numbera) + " = " + String.valueOf(numberc) + " + " + String.valueOf(numberb);
                case 2:
                    if (x == 0)
                        return "Lớp 1A và lớp 1B có " + String.valueOf(numberc) + " bạn và biết lớp 1B có " + String.valueOf(numberb) + " bạn"
                                + "\nLớp 1A có bao nhiêu bạn? Đây là bài toán tổng 2 số nên ta tìm theo cách sau:\n"
                                + String.valueOf(numberc) + " = " + "? + " + String.valueOf(numberb) + "\n"
                                + String.valueOf(numbera) + " = " + String.valueOf(numberc) + " - " + String.valueOf(numberb);
                    else
                        return "Lớp 1A nhiều hơn lớp 1B " + String.valueOf(numberc) + " bạn và biết lớp 1B có " + String.valueOf(numberb) + " bạn"
                                + "\nLớp 1A có bao nhiêu bạn? Đây là bài toán hiệu 2 số nên ta tìm theo cách sau:\n"
                                + String.valueOf(numberc) + " = " + "? - " + String.valueOf(numberb) + "\n"
                                + String.valueOf(numbera) + " = " + String.valueOf(numberc) + " + " + String.valueOf(numberb);
            }
        }
        return null;
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

    public String getA(){
        return String.valueOf(numbera);
    }

    public String getB(){
        return String.valueOf(numberb);
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
