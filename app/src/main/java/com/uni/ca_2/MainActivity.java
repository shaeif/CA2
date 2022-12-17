package com.uni.ca_2;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText s,e;
    Spinner spn;
    com.uni.ca_2.databaseService db;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s=findViewById(R.id.start0008);
        e=findViewById(R.id.end0008);
        spn=findViewById(R.id.spinner0008);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.Cab_Type));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn.setAdapter(adapter);
        db= new com.uni.ca_2.databaseService(getApplicationContext(),"cab0008", null, 1);

    }
    public void setRecord(View view){
        String s_start = s.getText().toString();
        String s_end = e.getText().toString();
        String s_cab=spn.getSelectedItem().toString();
        db.inserRecord(s_start,s_end,s_cab);
        Toast.makeText(getApplicationContext(), "Inserted successfully!", Toast.LENGTH_SHORT).show();



    }
    public void  removeRecord(View view){
        String s_end = s.getText().toString();
        db.deleteRecord(s_end);
        Toast.makeText(getApplicationContext(), "Deleted successfully!", Toast.LENGTH_SHORT).show();

    }

}