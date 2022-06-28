package com.example.timetable;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsFragment extends Fragment {

    ArrayList<News> list = new ArrayList<News>();
    RecyclerView mRecyclerView;
    SQLiteDatabase db;

    public NewsFragment() {
        // Required empty public constructor
    }

    public static NewsFragment newInstance() {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = view.findViewById(R.id.listNews);
        //открытие или создание бд
        db = getActivity().getBaseContext().openOrCreateDatabase("app.db", getActivity().MODE_PRIVATE, null);

        NewsListAdapter.OnNewsClickListener ClickListener = new NewsListAdapter.OnNewsClickListener() {
            @Override
            public void onNewsClick(News newsItem, int position) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(newsItem.getHref()));
                startActivity(browserIntent);
            }
        };

        // начальная инициализация списка
        setInitialData();

        // создаем адаптер
        NewsListAdapter adapter = new NewsListAdapter(getActivity(), list, ClickListener);

        // устанавливаем для списка адаптер
        mRecyclerView.setAdapter(adapter);
    }

    private void setInitialData() {
        list.clear();

        String queryText = new StringBuilder().append("SELECT * FROM news ").toString();

        //берем значения
        Cursor query = db.rawQuery(queryText, null);

        while(query.moveToNext()){
            News news = new News("", "", "");
            news.setTitle(query.getString(1));
            news.setDescription(query.getString(2));
            news.setHref(query.getString(3));
            list.add(news);
        }
    }
}