package com.example.sproject;

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

public class HealthArticleActivity extends AppCompatActivity {

    private String[][] health_details = {
            {"Walking Daily", "", "", "", "Click More Details"},
            {"Home care of COVID-19", "", "", "", "Click More Details"},
            {"Stop Smoking", "", "", "", "Click More Details"},
            {"Menstrual Cramps", "", "", "", "Click More Details"},
            {"Health Gut", "", "", "", "Click More Details"},
    };

    private  int[] images = {
            R.drawable.health1,
            R.drawable.health2,
            R.drawable.health3,
            R.drawable.health4,
            R.drawable.health5,
    };

    ArrayList list;
    HashMap<String, String> item;
    SimpleAdapter sa;
    ListView lv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_article);

        btn  = findViewById(R.id.buttonHA);
        lv = findViewById(R.id.listViewHA);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HealthArticleActivity.this, HomeActivity.class));
            }
        });

        for (int i = 0; i < health_details.length; i++) {
            item = new HashMap<String, String>();
            item.put("Line1", health_details[i][0]);
            item.put("Line2", health_details[i][1]);
            item.put("Line3", health_details[i][2]);
            item.put("Line4", health_details[i][3]);
            item.put("Line5", health_details[i][4]);
            list.add(item);
        }


        sa = new SimpleAdapter(this, list, R.layout.multi_lines,
                new String[]{"Line1", "Line2", "Line3", "Line4", "Line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );

        lv.setAdapter(sa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(HealthArticleActivity.this, HealthArticleDetailsActivity.class);
                it.putExtra("text1", health_details[i][1]);
                it.putExtra("text2", images[i]);

                startActivity(it);
            }
        });

    }
}