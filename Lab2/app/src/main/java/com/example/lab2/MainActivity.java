package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editFullName;
    EditText editCrossSalary;
    Button btnCalculator;
    ListView lvPersonalNetSalary;
    ArrayList<active_PersonalSalary> arrayPersonalSalary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editFullName = (EditText) findViewById(R.id.EditTextFullName);
        editCrossSalary = (EditText) findViewById(R.id.EditTextGrossSalary);
        btnCalculator = (Button) findViewById(R.id.ButtonCalculate);
        lvPersonalNetSalary = (ListView) findViewById(R.id.ListViewPersonalNetSalary);
        arrayPersonalSalary = new ArrayList<active_PersonalSalary>();

        ArrayAdapter<active_PersonalSalary> adapter = new ArrayAdapter<active_PersonalSalary>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrayPersonalSalary
        );
        btnCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                active_PersonalSalary ps = new active_PersonalSalary();
                ps.setFullName(editFullName.getText().toString());
                long CrossSalary = Long.parseLong(editCrossSalary.getText().toString());
                long sl =(long) (CrossSalary - CrossSalary *0.105);
                if ( sl <= 11000000)
                    ps.setSalary(sl);
                else
                    ps.setSalary((long)(sl - (sl-11000000)*0.05));
                arrayPersonalSalary.add(ps);
                adapter.notifyDataSetChanged();
            }
        });
        lvPersonalNetSalary.setAdapter(adapter);
    }
}