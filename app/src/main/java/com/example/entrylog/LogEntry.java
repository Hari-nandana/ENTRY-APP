package com.example.entrylog;

import android.content.Intent;
import android.content.SharedPreferences;
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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LogEntry extends AppCompatActivity {

    EditText e1,e2,e3,e4;
    AppCompatButton b1,b2;
     String apiurl="http://10.0.4.16:3000/api/students";
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
                //Value reading
                String name=e1.getText().toString();
                String admissionno=e2.getText().toString();
                String system=e2.getText().toString();
                String department =e2.getText().toString();

                //Json Object creation
                JSONObject student=new JSONObject();
                try
                {
                    student.put("name",name);
                    student.put("admission_number",admissionno);
                    student.put("system_number",system);
                    student.put("department",department);
                }
                catch(JSONException e)
                {
                    throw new RuntimeException(e) ;

                }
                //Json Object Request creation
                JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(
                        Request.Method.POST,
                        apiurl,
                        student,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(getApplicationContext(), "added successfully", Toast.LENGTH_LONG).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(),"something went wrong",Toast.LENGTH_LONG).show();
                            }
                        }
                );
                //request queue
                RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(jsonObjectRequest);



            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences=getSharedPreferences("entrylog",MODE_PRIVATE);
                SharedPreferences.Editor editor= preferences.edit();
                editor.clear();
                editor.apply();
                Intent i=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);

            }
        });

    }
}