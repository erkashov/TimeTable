package com.example.timetable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    public static String GroupNumber = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.loginBtn).setOnClickListener(v->
        {
            EditText editText = findViewById(R.id.groupNum);
            GroupNumber =  editText.getText().toString();
            startActivity(new Intent(this, MainActivity2.class));
        });

    }
}