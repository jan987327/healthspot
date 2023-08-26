package com.example.healthspot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HealthArticleActivity extends AppCompatActivity {
    private String[][] packages=
            {
                    {"Walking Daily"," "," "," ","Click More Details"},
                    {"Home care for COVID 19"," "," "," ","Click More Details"},
                    {"Stop Smoking"," "," "," ","Click More Details"},
                    {"Menstrual Cramps"," "," "," ","Click More Details"},
                    {"Healthy Habits"," "," "," ","Click More Details"},
            };
    private int[] images={
      R.drawable.health1,
            R.drawable.health1,
            R.drawable.health2,
            R.drawable.health3,
            R.drawable.health4,
            R.drawable.health5,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_article);
        HashMap<String,String> item;
        ArrayList list;
        SimpleAdapter sa;
        Button btnGoToCart, btnBack;
        ListView listView;

        listView = findViewById(R.id.ListViewHA);
        btnBack = findViewById(R.id.buttonHABack);
        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(HealthArticleActivity.this,HomeActivity.class));
            }
        });
            list=new ArrayList();
            for(int i=0;i<packages.length;i++){
                item=new HashMap<String,String>();
                item.put("line1",packages[i][0]);
                item.put("line2",packages[i][1]);
                item.put("line3",packages[i][2]);
                item.put("line4",packages[i][3]);
                item.put("line5",packages[i][4]);
                list.add( item );
            }

            sa= new SimpleAdapter(this,list,
                    R.layout.multi_lines,
                    new String[] {"line1","line2","line3","line4","line5"},
                    new int[] {R.id.line_a,R.id.line_b,R.id.line_c, R.id.line_d,R.id.line_e});
            listView.setAdapter(sa);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView,View view, int i, long l) {
                Intent it =new Intent(HealthArticleActivity.this,HealthArticlesDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",images[i]);
                startActivity(it);
            }
        });
        }
}




