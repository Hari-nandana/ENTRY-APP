package com.example.entrylog;

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




public class MainActivity extends AppCompatActivity {

    EditText  e1,e2;
    AppCompatButton b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
       e1=(EditText) findViewById(R.id.uname);
       e2=(EditText) findViewById(R.id.pass);
       b1=(AppCompatButton) findViewById(R.id.login);

       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String username=e1.getText().toString();
               String password=e2.getText().toString();
               Toast.makeText(getApplicationContext(),username+" "+password,Toast.LENGTH_LONG).show();
           }
       });

    }
}