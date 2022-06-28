package com.example.timetable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ViewHolder> {

    private final LayoutInflater LInflater;
    private final List<News> list;
    private final NewsListAdapter.OnNewsClickListener onClickListener;

    NewsListAdapter(Context context, List<News> data, OnNewsClickListener listen) {
        list = data;
        LInflater = LayoutInflater.from(context);
        this.onClickListener = listen;
    }

    @Override
    public NewsListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LInflater.inflate(R.layout.news_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsListAdapter.ViewHolder holder, int position) {
        News news = list.get(position);
        holder.descrView.setText(news.getDescription());
        holder.titleView.setText(news.getTitle());
        holder.titleView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                // вызываем метод слушателя, передавая ему данные
                onClickListener.onNewsClick(news, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView titleView, descrView;

        ViewHolder(View view) {
            super(view);
            titleView = view.findViewById(R.id.title);
            descrView = view.findViewById(R.id.decription);

        }
    }

    interface OnNewsClickListener{
        void onNewsClick(News newsItem, int position);
    }
}
