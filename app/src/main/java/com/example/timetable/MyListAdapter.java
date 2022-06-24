package com.example.timetable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {
    /*
     * Создаем объекты для отображения внешнего вида элемента
     * и объекта списка, с которым будет производиться работа
     */
    private final LayoutInflater LInflater;
    private final List<DateItem> list;
    private final OnStateClickListener onClickListener;
    int selectedPosition = -1;

    /*
     * Конструктор класса. В данном случае лишь транслируется лист с данными
     * в лист адаптера, с которым будет производиться непосредственная работа
     */
    MyListAdapter(Context context, List<DateItem> data, OnStateClickListener onClickListener){
        list = data;
        LInflater = LayoutInflater.from(context);
        this.onClickListener = onClickListener;
    }

    @Override
    public MyListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LInflater.inflate(R.layout.date_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyListAdapter.ViewHolder holder, int position) {
        DateItem state = list.get(position);
        holder.nedeliView.setText(state.getDayNedeli());

        // Checked selected radio button
        holder.nedeliView.setChecked(position
                == selectedPosition);

        // set listener on radio button
        holder.nedeliView.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(
                            CompoundButton compoundButton,
                            boolean b)
                    {
                        // check condition
                        if (b) {
                            // When checked
                            // update selected position
                            selectedPosition
                                    = holder.getAdapterPosition();
                            // Call listener
                            holder.itemView.setOnClickListener(new View.OnClickListener(){
                                @Override
                                public void onClick(View v)
                                {
                                    // вызываем метод слушателя, передавая ему данные
                                    onClickListener.onStateClick(state, position);
                                }
                            });
                        }
                    }
                });
        // обработка нажатия

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override public long getItemId(int position)
    {
        // pass position
        return position;
    }
    @Override public int getItemViewType(int position)
    {
        // pass position
        return position;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final RadioButton nedeliView;
        ViewHolder(View view){
            super(view);
            //dayView = view.findViewById(R.id.dateV);
            nedeliView = view.findViewById(R.id.dateV);
        }
    }


    interface OnStateClickListener{
        void onStateClick(DateItem dateItem, int position);
    }
}
