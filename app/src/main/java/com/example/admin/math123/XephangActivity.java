package com.example.admin.math123;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.*;

public class XephangActivity extends AppCompatActivity{
    int point;
    Button btnNext;
    ListView Listview;
    private String[] listData;
    private ArrayAdapter adapter;
    TextView XepHangText;
    int Layout = 3;
    String[] temp = new String[10];
    FileInputStream f;
    String Filename;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xephang);

        temp[0] = "";
        temp[1] = "";
        temp[2] = "";
        temp[3] = "";
        temp[4] = "";
        temp[5] = "";
        temp[6] = "";
        temp[7] = "";
        temp[8] = "";
        temp[9] = "";

        Intent intent = this.getIntent();
        Layout = Integer.parseInt(intent.getStringExtra("Layout"));
        btnNext = (Button)findViewById(R.id.btnNextResult);
        Listview = (ListView)findViewById(R.id.listxephang);
        XepHangText = (TextView)findViewById(R.id.XepHang);
        GetFileName();
        try {
            f = openFileInput(Filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
                "Hạng 1: " + temp[0] + " điểm",
                "Hạng 2: " + temp[1] + " điểm",
                "Hạng 3: " + temp[2] + " điểm",
                "Hạng 4: " + temp[3] + " điểm",
                "Hạng 5: " + temp[4] + " điểm",
                "Hạng 6: " + temp[5] + " điểm",
                "Hạng 7: " + temp[6] + " điểm",
                "Hạng 8: " + temp[7] + " điểm",
                "Hạng 9: " + temp[8] + " điểm",
                "Hạng 10: " + temp[9] + " điểm"
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

            int c;
            int i = 0;
            String a = " ";
            while( (c = f.read()) != -1){
                if(Character.toString((char)c).equals(a))
                    i++;
                else
                    temp[i] = temp[i] + Character.toString((char) c);
            }

            f.close();
        } catch (IOException io) {
        }
    }

    public void GetFileName(){
        switch (Layout){
            case 1:
                Filename = "XepHangTest.txt";
                break;
            case 2:
                Filename = "XepHangTapDem.txt";
                break;
            case 3:
                Filename = "XepHangLonBe.txt";
                break;
            case 4:
                Filename = "XepHangToanHinh.txt";
                break;
            case 5:
                Filename = "XepHangTinhNham.txt";
                break;
            case 6:
                Filename = "XepHangToanDo.txt";
                break;
        }
    }
}
