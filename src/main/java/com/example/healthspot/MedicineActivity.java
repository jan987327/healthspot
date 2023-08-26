package com.example.healthspot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MedicineActivity extends AppCompatActivity {

        private String[][] packages =
                {
                        {"Thelma 40mg","HyperTension","", "","80"},
                        {"Flexon","Pain Killer","", "","49"},
                        {"Crocin","Cold","", "","29"},
                        {"Asprin","Head Ache","", "","109"},
                        {"PudinHara","Stomach Ache","", "","19"},
                };
        HashMap<String,String> item;
        ArrayList list;
        SimpleAdapter sa;
        Button btnGoToCart, btnBack;
        ListView listView;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_medicine);

            btnGoToCart=findViewById(R.id.buttonMGoToCart);
            btnBack=findViewById(R.id.buttonMBack);
            listView=findViewById(R.id.ListViewM);

            btnBack.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    startActivity(new Intent(MedicineActivity.this,HomeActivity.class));
                }
            });
            btnGoToCart.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    startActivity(new Intent(MedicineActivity.this,OrderDetailsActivity.class));
                }
            });

            list=new ArrayList();
            for(int i=0;i<packages.length;i++){
                item=new HashMap<String,String>();
                item.put("line1",packages[i][0]);
                item.put("line2",packages[i][1]);
                item.put("line3",packages[i][2]);
                item.put("line4",packages[i][3]);
                item.put("line5","Price: "+packages[i][4]);
                list.add( item );
            }

            sa= new SimpleAdapter(this,list,
                    R.layout.multi_lines,
                    new String[] {"line1","line2","line3","line4","line5"},
                    new int[] {R.id.line_a,R.id.line_b,R.id.line_c, R.id.line_d,R.id.line_e});
            listView.setAdapter(sa);
        }
}