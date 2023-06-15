package com.example.sproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HealthArticleDetailsActivity extends AppCompatActivity {

    TextView tv;
    ImageView img;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_article_details);

        btn = findViewById(R.id.buttonHAD);
        tv = findViewById(R.id.titleHAD);
        img = findViewById(R.id.imageViewHAD);

        Intent intent = getIntent();
        tv.setText(intent.getStringExtra("text1"));
//        edDetails.setText(intent.getStringExtra("text2"));

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            int resId = bundle.getInt("text2");
            img.setImageResource(resId);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HealthArticleDetailsActivity.this, HealthArticleActivity.class));
            }
        });
    }
}