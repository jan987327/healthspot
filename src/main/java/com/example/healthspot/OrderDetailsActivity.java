package com.example.healthspot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderDetailsActivity extends AppCompatActivity {
    private String[][] packages =
            {
                    {"Package 1 : Full Body Checkup","","", "","999"},
                    { "Thelma 40mg","HyperTension","", "","80"},
                    {"Flexon","Pain Killer","", "","49"},
                    {"Package 4 : Thyroid Check","","", "","499"},
                    {"Asprin","Head Ache","", "","109"},
            };

    private String[][] order_details={};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView listView;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        btn=findViewById(R.id.buttonODBack);
        listView=findViewById(R.id.ListViewOD);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(OrderDetailsActivity.this,HomeActivity.class));
            }
        });

        Database db=new Database(getApplicationContext(),"healthcare",null,1);
        SharedPreferences sharedPreferences = getSharedPreferences("shared_pref", Context.MODE_PRIVATE);
        String username=sharedPreferences.getString("username","").toString();
      //  ArrayList dbdata = db.getOrderData(username);
        HashMap<String,String> item;
        ArrayList list;
        SimpleAdapter sa;

            list=new ArrayList();
            for(int i=0;i<packages.length;i++){
                item=new HashMap<String,String>();
                item.put("line1",packages[i][0]);
                item.put("line2",packages[i][1]);
                item.put("line3",packages[i][2]);
                item.put("line4",packages[i][3]);
                item.put("line5","cost: "+packages[i][4]);
                list.add( item );
            }

            sa= new SimpleAdapter(this,list,
                    R.layout.multi_lines,
                    new String[] {"line1","line2","line3","line4","line5"},
                    new int[] {R.id.line_a,R.id.line_b,R.id.line_c, R.id.line_d,R.id.line_e});
            listView.setAdapter(sa);
        }
}