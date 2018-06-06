package com.example.admin.math123;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.math123.core.Xephang;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class ResultActivity extends AppCompatActivity {
    int point;
    int Layout = 3;
    TextView textPoint;
    TextView textFalse;
    TextView textTrue;
    Button btnNext;
    Xephang XepHang = new Xephang(10, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = this.getIntent();
        point = Integer.parseInt(intent.getStringExtra("point"));
        textPoint = (TextView) findViewById(R.id.textPointResult);
        textFalse = (TextView) findViewById(R.id.textFalseResult);
        textTrue = (TextView) findViewById(R.id.textTrueResult);
        Layout = Integer.parseInt(intent.getStringExtra("LayoutBaiTap"));
        int True = point / 10;
        int False = 10 - True;
        textPoint.setText(String.valueOf(point));
        textFalse.setText(String.valueOf(False));
        textTrue.setText(String.valueOf(True));
        btnNext = (Button) findViewById(R.id.btnNextResult);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent NextIntent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(NextIntent);
            }
        });
        readData();
        KiemTraDiem();
        saveData();
    }

    public void saveData(){
        try {
            FileOutputStream f = new FileOutputStream("");
            switch (Layout) {
                case 1:
                    f = new FileOutputStream("XepHangTest.txt");
                    break;
                case 2:
                    f = new FileOutputStream("XepHangTapDem.txt");
                    break;
                case 3:
                    f = new FileOutputStream("XepHangLonBe.txt");
                    break;
                case 4:
                    f = new FileOutputStream("XepHangToanHinh.txt");
                    break;
                case 5:
                    f = new FileOutputStream("XepHangTinhNham.txt");
                    break;
                case 6:
                    f = new FileOutputStream("XepHangToanDo.txt");
                    break;
            }
            ObjectOutputStream oOT = new ObjectOutputStream(f); // Sử dụng để ghi file theo từng Object
            oOT.writeObject(XepHang);
            oOT.close();
            f.close();
        } catch (IOException e) {
        }
    }

    private void readData() {
        try {
            FileInputStream f = new FileInputStream("");
            switch (Layout) {
                case 1:
                    f = new FileInputStream("XepHangTest.txt");
                    break;
                case 2:
                    f = new FileInputStream("XepHangTapDem.txt");
                    break;
                case 3:
                    f = new FileInputStream("XepHangLonBe.txt");
                    break;
                case 4:
                    f = new FileInputStream("XepHangToanHinh.txt");
                    break;
                case 5:
                    f = new FileInputStream("XepHangTinhNham.txt");
                    break;
                case 6:
                    f = new FileInputStream("XepHangToanDo.txt");
                    break;
            }
            ObjectInputStream oIT = new ObjectInputStream(f); // Sử dụng để đọc file theo từng Object
            XepHang = (Xephang) oIT.readObject();
            oIT.close();
            f.close();
        } catch (IOException io) {
        } catch (ClassNotFoundException ex) {
        }
    }

    public void KiemTraDiem() {
        if (point > XepHang.get1()) {
            XepHang.set10(XepHang.get9());
            XepHang.set9(XepHang.get8());
            XepHang.set8(XepHang.get7());
            XepHang.set7(XepHang.get6());
            XepHang.set6(XepHang.get5());
            XepHang.set5(XepHang.get4());
            XepHang.set4(XepHang.get3());
            XepHang.set3(XepHang.get2());
            XepHang.set2(XepHang.get1());
            XepHang.set1(point);
        } else if (point > XepHang.get2()) {
            XepHang.set10(XepHang.get9());
            XepHang.set9(XepHang.get8());
            XepHang.set8(XepHang.get7());
            XepHang.set7(XepHang.get6());
            XepHang.set6(XepHang.get5());
            XepHang.set5(XepHang.get4());
            XepHang.set4(XepHang.get3());
            XepHang.set3(XepHang.get2());
            XepHang.set2(point);
        } else if (point > XepHang.get3()) {
            XepHang.set10(XepHang.get9());
            XepHang.set9(XepHang.get8());
            XepHang.set8(XepHang.get7());
            XepHang.set7(XepHang.get6());
            XepHang.set6(XepHang.get5());
            XepHang.set5(XepHang.get4());
            XepHang.set4(XepHang.get3());
            XepHang.set3(point);
        } else if (point > XepHang.get4()) {
            XepHang.set10(XepHang.get9());
            XepHang.set9(XepHang.get8());
            XepHang.set8(XepHang.get7());
            XepHang.set7(XepHang.get6());
            XepHang.set6(XepHang.get5());
            XepHang.set5(XepHang.get4());
            XepHang.set4(point);
        } else if (point > XepHang.get5()) {
            XepHang.set10(XepHang.get9());
            XepHang.set9(XepHang.get8());
            XepHang.set8(XepHang.get7());
            XepHang.set7(XepHang.get6());
            XepHang.set6(XepHang.get5());
            XepHang.set5(point);
        } else if (point > XepHang.get6()) {
            XepHang.set10(XepHang.get9());
            XepHang.set9(XepHang.get8());
            XepHang.set8(XepHang.get7());
            XepHang.set7(XepHang.get6());
            XepHang.set6(point);
        } else if (point > XepHang.get7()) {
            XepHang.set10(XepHang.get9());
            XepHang.set9(XepHang.get8());
            XepHang.set8(XepHang.get7());
            XepHang.set7(point);
        } else if (point > XepHang.get8()) {
            XepHang.set10(XepHang.get9());
            XepHang.set9(XepHang.get8());
            XepHang.set8(point);
        } else if (point > XepHang.get9()) {
            XepHang.set10(XepHang.get9());
            XepHang.set9(point);
        } else if (point > XepHang.get10()) {
            XepHang.set10(point);
        }
    }
}