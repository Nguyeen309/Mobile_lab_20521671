package com.example.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonAddInfo, buttonQueryInfo;
    EditText editTextPhone, editTextFullName;
    ListView lvListView;
    ArrayAdapter infoArrayAdapter;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAddInfo = findViewById(R.id.buttonAddInfo);
        buttonQueryInfo = findViewById(R.id.buttonQueryInfo);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextFullName = findViewById(R.id.editTextFullName);
        lvListView = findViewById(R.id.lvListView);

        databaseHelper = new DatabaseHelper(MainActivity.this);
        ShowInfoOnListView(databaseHelper);

        buttonAddInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                InfoActivity info = new InfoActivity(-1, editTextFullName.getText().toString(), editTextPhone.getText().toString());

                Toast.makeText(MainActivity.this, info.toString(), Toast.LENGTH_SHORT).show();

                DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);

                boolean success = databaseHelper.addOne(info);

                Toast.makeText(MainActivity.this, "Success= " + success, Toast.LENGTH_SHORT).show();

                infoArrayAdapter = new ArrayAdapter<InfoActivity>(MainActivity.this, android.R.layout.simple_list_item_1, databaseHelper.getEveryone());
                lvListView.setAdapter(infoArrayAdapter);
            }
        });

        buttonQueryInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);

                MainActivity.this.ShowInfoOnListView(databaseHelper);
                //Toast.makeText(MainActivity.this, all.toString(), Toast.LENGTH_SHORT).show();


            }
        });

        lvListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                InfoActivity clickedInfo = (InfoActivity) adapterView.getItemAtPosition(i);
                databaseHelper.deleteOne(clickedInfo);
                ShowInfoOnListView(databaseHelper);
                Toast.makeText(MainActivity.this, "Deleted" + clickedInfo.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void ShowInfoOnListView(DatabaseHelper databaseHelper) {
        infoArrayAdapter = new ArrayAdapter<InfoActivity>(MainActivity.this, android.R.layout.simple_list_item_1, databaseHelper.getEveryone());
        lvListView.setAdapter(infoArrayAdapter);
    }
}