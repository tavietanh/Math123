package com.example.admin.math123;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.math123.core.Xephang;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class ResultActivity extends AppCompatActivity {
    int point;
    int Layout;
    TextView textPoint;
    TextView textFalse;
    TextView textTrue;
    Button btnNext;
    String[] temp = new String[10];
    Xephang XepHang = new Xephang();
    int x;
    int y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        /*temp[0] = "";
        temp[1] = "";
        temp[2] = "";
        temp[3] = "";
        temp[4] = "";
        temp[5] = "";
        temp[6] = "";
        temp[7] = "";
        temp[8] = "";
        temp[9] = "";*/

        Intent intent = this.getIntent();
        point = Integer.parseInt(intent.getStringExtra("point"));
        textPoint = (TextView)findViewById(R.id.textPointResult);
        textFalse = (TextView)findViewById(R.id.textFalseResult);
        textTrue = (TextView)findViewById(R.id.textTrueResult);
        Layout = Integer.parseInt(intent.getStringExtra("Layout"));
        int True = point/10;
        int False = 10-True;
        textPoint.setText(String.valueOf(point));
        textFalse.setText(String.valueOf(False));
        textTrue.setText(String.valueOf(True));
        btnNext = (Button)findViewById(R.id.btnNextResult);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent NextIntent = new Intent(ResultActivity.this,MainActivity.class);
                startActivity(NextIntent);
            }
        });
        saveData();
    }
    public void saveData(){
        /*try {
            FileOutputStream fileOutput = openFileOutput("XepHangLonBe.txt",MODE_APPEND);
                /*String s = temp[0] + " " + temp[1] + " " + temp[2] + " " + temp[3]
                        + " " + temp[4] + " " + temp[5] + " " + temp[6] + " " + temp[7]
                        + " " + temp[8] + " " + temp[9];
                String s = String.valueOf(point) + " 0 0 0 0 0 0 0 0";
            byte[] buffer = s.getBytes();
            fileOutput.write(buffer);
            fileOutput.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        KiemTraDiem();
        try {
            FileOutputStream f = new FileOutputStream("");
            switch (Layout){
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

    public void KiemTraDiem(){
        if(point > XepHang.get1()) {
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
        } else if (point > XepHang.get2()){
            XepHang.set10(XepHang.get9());
            XepHang.set9(XepHang.get8());
            XepHang.set8(XepHang.get7());
            XepHang.set7(XepHang.get6());
            XepHang.set6(XepHang.get5());
            XepHang.set5(XepHang.get4());
            XepHang.set4(XepHang.get3());
            XepHang.set3(XepHang.get2());
            XepHang.set2(point);
        } else if (point > XepHang.get3()){
            XepHang.set10(XepHang.get9());
            XepHang.set9(XepHang.get8());
            XepHang.set8(XepHang.get7());
            XepHang.set7(XepHang.get6());
            XepHang.set6(XepHang.get5());
            XepHang.set5(XepHang.get4());
            XepHang.set4(XepHang.get3());
            XepHang.set3(point);
        } else if (point > XepHang.get4()){
            XepHang.set10(XepHang.get9());
            XepHang.set9(XepHang.get8());
            XepHang.set8(XepHang.get7());
            XepHang.set7(XepHang.get6());
            XepHang.set6(XepHang.get5());
            XepHang.set5(XepHang.get4());
            XepHang.set4(point);
        } else if (point > XepHang.get5()){
            XepHang.set10(XepHang.get9());
            XepHang.set9(XepHang.get8());
            XepHang.set8(XepHang.get7());
            XepHang.set7(XepHang.get6());
            XepHang.set6(XepHang.get5());
            XepHang.set5(point);
        } else if (point > XepHang.get6()){
            XepHang.set10(XepHang.get9());
            XepHang.set9(XepHang.get8());
            XepHang.set8(XepHang.get7());
            XepHang.set7(XepHang.get6());
            XepHang.set6(point);
        } else if (point > XepHang.get7()){
            XepHang.set10(XepHang.get9());
            XepHang.set9(XepHang.get8());
            XepHang.set8(XepHang.get7());
            XepHang.set7(point);
        } else if (point > XepHang.get8()){
            XepHang.set10(XepHang.get9());
            XepHang.set9(XepHang.get8());
            XepHang.set8(point);
        } else if (point > XepHang.get9()){
            XepHang.set10(XepHang.get9());
            XepHang.set9(point);
        } else if (point > XepHang.get10()){
            XepHang.set10(point);
        }
    }
}
