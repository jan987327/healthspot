package com.example.healthspot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HealthArticlesDetailsActivity extends AppCompatActivity {
    TextView tv1;
    ImageView img;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_articles_details);

        tv1 = findViewById(R.id.textViewHADtitle);
        btnBack = findViewById(R.id.buttonHADBack);
        img = findViewById(R.id.imageViewHAD);

        Intent intent=getIntent();
               tv1.setText(intent.getStringExtra("text1"));

               Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            int resID=bundle.getInt("text2");
            img.setImageResource(resID);
        }

        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(HealthArticlesDetailsActivity.this,HealthArticleActivity.class));
            }
        });

    }
}