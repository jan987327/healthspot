package com.example.healthspot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] packages =
            {
                    {"Ajay Singh", "Moti Nagar", "Exp: 8yr", "No.: 984563328", "900"},
                    {"Santosh Jain", "Kirti Nagar", "Exp: 4yr", "No.: 785148966", "200"},
                    {"Durga Shankar", "Rajouri Garden", "Exp: 7yr", "No: 98756331", "800"},
                    {"Preeti Skula", "Shivaji Place", "Exp: 3yr", "No.: 92559633", "400"},
                    {"Arjun Thapper", "Tilak Nagar", "Exp: 5yr", "No.: 955571236", "600"},
            };
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button  btnBack;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        btnBack = findViewById(R.id.buttonHABack);
        listView = findViewById(R.id.ListViewHA);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, HomeActivity.class));
            }
        });

        list = new ArrayList();
        for (int i = 0; i < packages.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Conslt Fee: " + packages[i][4]);
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        listView.setAdapter(sa);
    }
}

