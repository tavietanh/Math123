package com.example.admin.math123;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.admin.math123.core.Xephang;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.*;

public class XephangActivity extends AppCompatActivity{
    int point;
    Button btnNext;
    ListView Listview;
    private String[] listData;
    private ArrayAdapter adapter;
    TextView XepHangText;
    int Layout = 3;
    Xephang XepHang = new Xephang(10,0,0,0,0,0,0,0,0,0);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xephang);

        Intent intent = this.getIntent();
        Layout = Integer.parseInt(intent.getStringExtra("Layout"));
        btnNext = (Button)findViewById(R.id.btnNextResult);
        Listview = (ListView)findViewById(R.id.listxephang);
        XepHangText = (TextView)findViewById(R.id.XepHang);
        switch (Layout){
            case 1:
                XepHangText.setText("Xếp hạng Kiểm tra");
                break;
            case 2:
                XepHangText.setText("Xếp hạng Tập đếm");
                break;
            case 3:
                XepHangText.setText("Xếp hạng Lớn bé");
                break;
            case 4:
                XepHangText.setText("Xếp hạng Toán hình");
                break;
            case 5:
                XepHangText.setText("Xếp hạng Tính nhẩm");
                break;
            case 6:
                XepHangText.setText("Xếp hạng Toán đố");
                break;
        }
        readData();
        listData = new String[]{
                "Hạng 1: " + XepHang.get1() + " điểm",
                "Hạng 2: " + XepHang.get2() + " điểm",
                "Hạng 3: " + XepHang.get3() + " điểm",
                "Hạng 4: " + XepHang.get4() + " điểm",
                "Hạng 5: " + XepHang.get5() + " điểm",
                "Hạng 6: " + XepHang.get6() + " điểm",
                "Hạng 7: " + XepHang.get7() + " điểm",
                "Hạng 8: " + XepHang.get8() + " điểm",
                "Hạng 9: " + XepHang.get9() + " điểm",
                "Hạng 10: " + XepHang.get10() + " điểm"
        };

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1 , listData);
        Listview.setAdapter(adapter);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent NextIntent = new Intent(XephangActivity.this,MainActivity.class);
                startActivity(NextIntent);
            }
        });
    }

    private void readData() {
        try {
            FileInputStream f = new FileInputStream("");
            switch (Layout){
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
}
