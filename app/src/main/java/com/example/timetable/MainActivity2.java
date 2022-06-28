package com.example.timetable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity2 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView groupNum = (TextView)findViewById(R.id.groupText);
        groupNum.setText(LoginActivity.GroupNumber);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_view, ParyFragment.class, null)
                .commit();

        View.OnClickListener timetableButtonOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (savedInstanceState == null) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container_view, ParyFragment.class, null)
                            .commit();
                }
            }
        };

        View.OnClickListener newsButtonOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (savedInstanceState == null) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container_view, NewsFragment.class, null)
                            .commit();
                }
            }
        };

        View.OnClickListener mapButtonOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (savedInstanceState == null) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container_view, MapFragment.class, null)
                            .commit();
                }
            }
        };

        ImageView timetableBtn = (ImageView) findViewById(R.id.timetableButton);
        timetableBtn.setOnClickListener(timetableButtonOnClickListener);

        ImageView newsBtn = findViewById(R.id.newButton);
        newsBtn.setOnClickListener(newsButtonOnClickListener);

        ImageView mapButton = findViewById(R.id.mapButton);
        mapButton.setOnClickListener(mapButtonOnClickListener);

    }


}