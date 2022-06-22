package com.example.timetable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ArrayList<DateItem> list = new ArrayList<DateItem>();
    ArrayList<ParaItem> listPara = new ArrayList<ParaItem>();
    RecyclerView mRecyclerView;
    RecyclerView mRecyclerViewPara;

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
        listPara.add(new ParaItem("1", "8:30", "10:00", "OAIP", "ZZZZZAID"));
        listPara.add(new ParaItem("2", "10:10", "11:40", "EVM", "SMIRNOVVVVVV"));
    }

    private void setInitialData(){
        list.add(new DateItem(11, "ПН"));
        list.add(new DateItem(12, "ВТ"));
        list.add(new DateItem(13, "СР"));
        /*Toast toast = Toast.makeText(this, list.size(), Toast.LENGTH_LONG);
        toast.show();*/
    }
}