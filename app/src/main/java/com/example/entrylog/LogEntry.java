package com.example.entrylog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LogEntry extends AppCompatActivity {

    EditText e1,e2,e3,e4;
    AppCompatButton b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_log_entry);

        b1=(AppCompatButton) findViewById(R.id.logout);
        e1=(EditText) findViewById(R.id.name);
        e2=(EditText) findViewById(R.id.adno);
        b2=(AppCompatButton) findViewById(R.id.add);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=e1.getText().toString();
                String admissionno=e2.getText().toString();
                String system=e2.getText().toString();
                String department =e2.getText().toString();

                Toast.makeText(getApplicationContext(),name+" "+admissionno+" "+system+" "+department,Toast.LENGTH_LONG).show();

            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);

            }
        });

    }
}