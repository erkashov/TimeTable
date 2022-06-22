package com.example.timetable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity2 extends AppCompatActivity {

    ArrayList<DateItem> list = new ArrayList<DateItem>();
    ArrayList<ParaItem> listPara = new ArrayList<ParaItem>();
    RecyclerView mRecyclerView;
    RecyclerView mRecyclerViewPara;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView groupNum = (TextView)findViewById(R.id.groupText);
        groupNum.setText(LoginActivity.GroupNumber);

        MyListAdapter.OnStateClickListener stateClickListener = new MyListAdapter.OnStateClickListener() {
            @Override
            public void onStateClick(DateItem state, int position) {
                Toast.makeText(getApplicationContext(), "Был выбран пункт " + state.getDay(),
                        Toast.LENGTH_SHORT).show();
            }
        };

        //открытие или создание бд
        db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
        //создание таблиц
        db.execSQL("CREATE TABLE IF NOT EXISTS pary (id INTEGER,   date TEXT,  startTime TEXT, endTime TEXT, naim TEXT,prepod TEXT ,group_num INTEGER )");
        StringBuilder queryText ;//= new StringBuilder().append("INSERT INTO pary VALUES(1,  '2022-06-05', '8:00', '9:30', 'РМП', 'Гимадиев', ").append(LoginActivity.GroupNumber ).append(")");
        //db.execSQL(queryText.toString());
        //queryText = new StringBuilder().append("INSERT INTO pary VALUES(2,  '2022-06-05', '9:40', '11:20', 'РПМ', 'Лоповок', ").append(LoginActivity.GroupNumber ).append(")");
        //db.execSQL(queryText.toString());

        LinearLayoutManager layoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView = findViewById(R.id.listViews);
        mRecyclerView.setLayoutManager(layoutManager);

        LinearLayoutManager layoutManagerPara = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        mRecyclerViewPara = findViewById(R.id.listPara);
        //mRecyclerViewPara.setLayoutManager(layoutManager);

        // начальная инициализация списка
        setInitialData();
        //RecyclerView recyclerView = findViewById(R.id.listViews);
        // создаем адаптер
        MyListAdapter adapter = new MyListAdapter(this, list, stateClickListener);

        // устанавливаем для списка адаптер
        mRecyclerView.setAdapter(adapter);

        // начальная инициализация списка
        setInitialDataPara();
        //RecyclerView recyclerView = findViewById(R.id.listViews);
        // создаем адаптер
        ParaListAdapter adapterPara = new ParaListAdapter(this, listPara);

        // устанавливаем для списка адаптер
        mRecyclerViewPara.setAdapter(adapterPara);
    }

    private void setInitialDataPara() {
        String queryText = new StringBuilder().append("SELECT * FROM pary Where date ").append(" = ").append("'2022-06-05'").toString();

        //берем значения
        Cursor query = db.rawQuery(queryText, null);

        int i = 0;

        while(query.moveToNext()){
            i++;
            ParaItem para = new ParaItem("", "", "", "", "", new Date());
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
            try {
                para.setDate(ft.parse(query.getString(1)));
            }catch (ParseException e) {
            }
            para.setNomer(Integer.toString(i));
            para.setStartTime(query.getString(2));
            para.setEndTime(query.getString(3));
            para.setNaim(query.getString(4));
            para.setPrepod(query.getString(5));
            listPara.add(para);
        }

        /*listPara.add(new ParaItem("1", "8:30", "10:00", "OAIP", "ZZZZZAID", new Date()));
        listPara.add(new ParaItem("2", "10:10", "11:40", "EVM", "SMIRNOVVVVVV", new Date()));*/
    }

    private void setInitialData(){

        list.add(new DateItem(11, "ПН", new Date()));
        list.add(new DateItem(12, "ВТ", new Date()));
        list.add(new DateItem(13, "СР", new Date()));
    }
}