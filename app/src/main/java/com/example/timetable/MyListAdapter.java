package com.example.timetable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        holder.dayView.setText(state.getDay());
        holder.nedeliView.setText(state.getDayNedeli());

        // обработка нажатия
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                // вызываем метод слушателя, передавая ему данные
                onClickListener.onStateClick(state, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView dayView, nedeliView;
        ViewHolder(View view){
            super(view);
            dayView = view.findViewById(R.id.dayV);
            nedeliView = view.findViewById(R.id.dayNedeliV);
        }
    }

    interface OnStateClickListener{
        void onStateClick(DateItem dateItem, int position);
    }
    /*
     * Далее идут стандартные методы родительского класса BaseAdapter.
     * Внимательно ознакомьтесь с отличиями методов в уроке и методов,
     * которые автоматически создает Android Studio.
     * Данные методы должны работать непосредственно с используемым нами ArrayList
     * и структурой данных, формируемой классом DataFlags
     */
    /*@Override
    public int getCount() {
        return list.size();
    }

    @Override
    public DateItem getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    *//*
     * Метод, в котором формируется внешний вид элементов с его наполнением
     *//*
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        View v = convertView;

        *//*
         * В том случае, если вид элемента не создан, производится его создание
         * с помощью ViewHolder и тегирование данного элемента конкретным holder объектом
         *//*
        if ( v == null){
            holder = new ViewHolder();
            v = LInflater.inflate(R.layout.date_item, parent, false);
            holder.day = "11";
            holder.dayNedeli = "ПН";
            v.setTag(holder);
        }

        *//*
         * После того, как все элементы определены, производится соотнесение
         * внешнего вида, данных и конкретной позиции в ListView.
         * После чего из ArrayList забираются данные для элемента ListView и
         * передаются во внешний вид элемента
         *//*
        holder = (ViewHolder) v.getTag();
        DateItem dataFlags = getData(position);

        holder.day = Integer.toString(dataFlags.getDay());
        holder.dayNedeli = dataFlags.getDayNedeli();

        return v;
    }

    *//*
     * Метод, который забирает объект из ArrayList для дальнейшей работы с ним
     * и передачи его данных в элемент ListView
     *//*
    DateItem getData(int position){
        return (getItem(position));
    }

    *//*
     * Данная структура данных необходима для того, чтобы при пролистывании
     * большого списка не возникало артефактов и перескакивания данных с одной позиции ListView
     * на другую, что достигается тегированием каждого элемента ListView
     *//*
    private static class ViewHolder {
        private String day;
        private String dayNedeli;
    }*/
}
