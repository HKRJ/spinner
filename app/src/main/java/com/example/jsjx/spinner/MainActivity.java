package com.example.jsjx.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Spinner sp1;
    Spinner sp2;
    TextView tv_show;
    ArrayAdapter<String> adapter1,adapter2;
    String []ug={"山西省","河南省"};
    String[][] ux={{"晋城市","长治市","太原市"},{"焦作市","濮阳市","安阳市"}};
    int proPosition;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp1=findViewById(R.id.sp1);
        sp2=findViewById(R.id.sp2);
        tv_show=findViewById(R.id.tv_show);
//
        adapter1=new ArrayAdapter<String>(this,android.R.layout.activity_list_item,ug);
        sp1.setAdapter(adapter1);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                adapter2=new ArrayAdapter<String>(MainActivity.this,android.R.layout.activity_list_item,ux[position]);
                proPosition=position;

        }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tv_show.setText(adapter1.getItem(proPosition)+adapter2.getItem(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
//
    }
}
