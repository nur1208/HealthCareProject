package com.example.sproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 = {
            {"Doctor Name : Gisella Wheatley", "Hosptial Address : 3 Arrowood Circle", "Exp : 1", "Mobile No : 152-561-7528", "600"},
            {"Doctor Name : Claudius Nutton", "Hosptial Address : 684 Melby Point", "Exp : 6", "Mobile No : 214-600-5661", "900"},
            {"Doctor Name : Obadias Berndt", "Hosptial Address : 66 Brickson Park Point", "Exp : 7", "Mobile No : 820-247-7312", "300"},
            {"Doctor Name : Sebastien Horsburgh", "Hosptial Address : 361 Barnett Avenue", "Exp : 8", "Mobile No : 301-988-3067", "500"},
            {"Doctor Name : Glory Storah", "Hosptial Address : 3 Eastlawn Place", "Exp : 9", "Mobile No : 662-849-8541", "800"},
    };

    private String[][] doctor_details2 = {
            {"Doctor Name : Gisella Wheatley", "Hosptial Address : 3 Arrowood Circle", "Exp : 1", "Mobile No : 152-561-7528", "600"},
            {"Doctor Name : Claudius Nutton", "Hosptial Address : 684 Melby Point", "Exp : 6", "Mobile No : 214-600-5661", "900"},
            {"Doctor Name : Obadias Berndt", "Hosptial Address : 66 Brickson Park Point", "Exp : 7", "Mobile No : 820-247-7312", "300"},
            {"Doctor Name : Sebastien Horsburgh", "Hosptial Address : 361 Barnett Avenue", "Exp : 8", "Mobile No : 301-988-3067", "500"},
            {"Doctor Name : Glory Storah", "Hosptial Address : 3 Eastlawn Place", "Exp : 9", "Mobile No : 662-849-8541", "800"},
    };

    private String[][] doctor_details3 = {
            {"Doctor Name : Gisella Wheatley", "Hosptial Address : 3 Arrowood Circle", "Exp : 1", "Mobile No : 152-561-7528", "600"},
            {"Doctor Name : Claudius Nutton", "Hosptial Address : 684 Melby Point", "Exp : 6", "Mobile No : 214-600-5661", "900"},
            {"Doctor Name : Obadias Berndt", "Hosptial Address : 66 Brickson Park Point", "Exp : 7", "Mobile No : 820-247-7312", "300"},
            {"Doctor Name : Sebastien Horsburgh", "Hosptial Address : 361 Barnett Avenue", "Exp : 8", "Mobile No : 301-988-3067", "500"},
            {"Doctor Name : Glory Storah", "Hosptial Address : 3 Eastlawn Place", "Exp : 9", "Mobile No : 662-849-8541", "800"},
    };

    private String[][] doctor_details4 = {
            {"Doctor Name : Gisella Wheatley", "Hosptial Address : 3 Arrowood Circle", "Exp : 1", "Mobile No : 152-561-7528", "600"},
            {"Doctor Name : Claudius Nutton", "Hosptial Address : 684 Melby Point", "Exp : 6", "Mobile No : 214-600-5661", "900"},
            {"Doctor Name : Obadias Berndt", "Hosptial Address : 66 Brickson Park Point", "Exp : 7", "Mobile No : 820-247-7312", "300"},
            {"Doctor Name : Sebastien Horsburgh", "Hosptial Address : 361 Barnett Avenue", "Exp : 8", "Mobile No : 301-988-3067", "500"},
            {"Doctor Name : Glory Storah", "Hosptial Address : 3 Eastlawn Place", "Exp : 9", "Mobile No : 662-849-8541", "800"},
    };

    private String[][] doctor_details5 = {
            {"Doctor Name : Gisella Wheatley", "Hosptial Address : 3 Arrowood Circle", "Exp : 1", "Mobile No : 152-561-7528", "600"},
            {"Doctor Name : Claudius Nutton", "Hosptial Address : 684 Melby Point", "Exp : 6", "Mobile No : 214-600-5661", "900"},
            {"Doctor Name : Obadias Berndt", "Hosptial Address : 66 Brickson Park Point", "Exp : 7", "Mobile No : 820-247-7312", "300"},
            {"Doctor Name : Sebastien Horsburgh", "Hosptial Address : 361 Barnett Avenue", "Exp : 8", "Mobile No : 301-988-3067", "500"},
            {"Doctor Name : Glory Storah", "Hosptial Address : 3 Eastlawn Place", "Exp : 9", "Mobile No : 662-849-8541", "800"},
    };

    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    ArrayList list;
    HashMap<String, String> item;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.titleDoctorDetails);
        btn = findViewById(R.id.buttonDoctorDetails);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Family Physicians") == 0)
            doctor_details = doctor_details1;
        else if (title.compareTo("Dietician") == 0)
            doctor_details = doctor_details2;
        else if (title.compareTo("Dentist") == 0)
            doctor_details = doctor_details3;
        else if (title.compareTo("Surgeon") == 0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });

        list = new ArrayList<>();

        for (int i = 0; i < doctor_details.length; i++) {
            item = new HashMap<String, String>();
            item.put("Line1", doctor_details[i][0]);
            item.put("Line2", doctor_details[i][1]);
            item.put("Line3", doctor_details[i][2]);
            item.put("Line4", doctor_details[i][3]);
            item.put("Line5", "Cons Fees: " + doctor_details[i][4] + "/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list, R.layout.multi_lines,
                new String[]{"Line1", "Line2", "Line3", "Line4", "Line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );

        ListView lv = findViewById(R.id.listViewDD);

        lv.setAdapter(sa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1", title);
                it.putExtra("text2", doctor_details[i][0]);
                it.putExtra("text3", doctor_details[i][1]);
                it.putExtra("text4", doctor_details[i][2]);
                it.putExtra("text5", doctor_details[i][3]);

                startActivity(it);
            }
        });
    }
}