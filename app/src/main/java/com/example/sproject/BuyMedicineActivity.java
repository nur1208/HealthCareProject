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

public class BuyMedicineActivity extends AppCompatActivity {
    private String[][] packages = {
            {"Medicine 1", "", "", "", "50"},
            {"Medicine 2", "", "", "", "305"},
            {"Medicine 3", "", "", "", "448"},
            {"Medicine 4", "", "", "", "30"},
            {"Medicine 5", "", "", "", "50"},
            {"Medicine 6", "", "", "", "40"},
            {"Medicine 7", "", "", "", "30"},
            {"Medicine 8", "", "", "", "130"},
    };

    private String[] package_details = {"Blood Glucose Fating\n" + "Complete Hemogram\n" + "HbA1c\n" + "Iron Studies\n" + "Kidney Function Test\n" + "LDH Lactate Dehydrogenase, Sarum\n" + "Liver Function Test",
            "Blood Glucose Fasting", "COVID-19 Antibody - IgG",
            "Thyroid Profile -Total (T3, T4 & TSH Ultra-sensitive)", "Complete  Hemogram\n" +
            "CRP (C Reactive Protein) Quantitative, Sarum\n" + "Iron Studies\n" + "Kidney Function Test\n"};

    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnGoToCart, btnBack;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        listView = findViewById(R.id.listViewBM);
        btnBack = findViewById(R.id.btnBMBack);
        btnGoToCart = findViewById(R.id.btnBMGoToCart);

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this, CartBuyMedicineActivity.class));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this, HomeActivity.class));
            }
        });


        list = new ArrayList<>();

        for (int i = 0; i < packages.length; i++) {
            item = new HashMap<String, String>();
            item.put("Line1", packages[i][0]);
            item.put("Line2", packages[i][1]);
            item.put("Line3", packages[i][2]);
            item.put("Line4", packages[i][3]);
            item.put("Line5", "Total Cost: " + packages[i][4] + "/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list, R.layout.multi_lines,
                new String[]{"Line1", "Line2", "Line3", "Line4", "Line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );

        listView.setAdapter(sa);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(BuyMedicineActivity.this, BuyMedicineDetailsActivity.class);
                it.putExtra("text1", packages[i][0]);
                it.putExtra("text2", package_details[i]);
                it.putExtra("text3", packages[i][4]);
                startActivity(it);
            }
        });
    }
}