package com.example.timetable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ParaListAdapter extends RecyclerView.Adapter<ParaListAdapter.ViewHolder> {

    private final LayoutInflater LInflater;
    private final List<ParaItem> list;

    ParaListAdapter(Context context, List<ParaItem> data) {
        list = data;
        LInflater = LayoutInflater.from(context);
    }

    @Override
    public ParaListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LInflater.inflate(R.layout.para_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ParaListAdapter.ViewHolder holder, int position) {
        ParaItem state = list.get(position);
        holder.nomerView.setText(state.getNomer());

        holder.startView.setText(state.getStartTime());
        holder.endView.setText(state.getEndTime());
        holder.naimView.setText(state.getNaim());
        holder.prepodView.setText(state.getPrepod());
        holder.tipZanView.setText(state.getTip_zan());
        holder.auditView.setText(state.getAudit() + " аудитория, " + state.getZdanie() + " здание");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nomerView, startView, endView, naimView, prepodView, tipZanView, auditView;

        ViewHolder(View view) {
            super(view);
            nomerView = view.findViewById(R.id.nomerPara);
            startView = view.findViewById(R.id.startTime);
            endView = view.findViewById(R.id.EndTime);
            naimView = view.findViewById(R.id.naimPara);
            prepodView = view.findViewById(R.id.prepodPara);
            tipZanView = view.findViewById(R.id.tipPara);
            auditView = view.findViewById(R.id.auditPara);

        }
    }
}