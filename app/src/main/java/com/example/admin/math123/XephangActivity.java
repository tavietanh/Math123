package com.example.admin.math123;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class XephangActivity extends AppCompatActivity{
    int point;
    Button btnNext;
    ListView Listview;
    private String[] listData;
    private ArrayAdapter adapter;
    String simpleFileName = "Xephang.txt";
    TextView ReadFile;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xephang);
//        Intent intent = this.getIntent();
//        point = Integer.parseInt(intent.getStringExtra("point"));
        btnNext = (Button)findViewById(R.id.btnNextResult);
        Listview = (ListView)findViewById(R.id.listxephang);
        ReadFile = (TextView)findViewById(R.id.ReadFile);
        readData();
/*        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent NextIntent = new Intent(XephangActivity.this,MainActivity.class);
                startActivity(NextIntent);
            }
        });*/
        listData = new String[]{
                "Hạng 1: 100 điểm",
                "Hạng 2: 80 điểm",
                "Hạng 3: 70 điểm",
                "Hạng 4: 60 điểm",
                "Hạng 5: 50 điểm",
                "Hạng 6: 40 điểm",
                "Hạng 7: 30 điểm",
                "Hạng 8: 20 điểm",
                "Hạng 9: 10 điểm",
                "Hạng 10: 0 điểm"
        };


        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1 , listData);
        Listview.setAdapter(adapter);
    }

    private void readData() {
        try {

            // Mở một luồng đọc file.
            FileInputStream in = this.openFileInput(simpleFileName);

            BufferedReader br= new BufferedReader(new InputStreamReader(in));

            StringBuilder sb= new StringBuilder();
            String s= null;
            while((s= br.readLine())!= null)  {
                sb.append(s).append("");
            }
            this.ReadFile.setText(sb.toString() + " điểm");
        } catch (Exception e) {
        }
    }
}
