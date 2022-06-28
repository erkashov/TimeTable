package com.example.timetable;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ParyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ParyFragment extends Fragment {

    ArrayList<DateItem> list = new ArrayList<DateItem>();
    ArrayList<ParaItem> listPara = new ArrayList<ParaItem>();
    RecyclerView mRecyclerView;
    RecyclerView mRecyclerViewPara;
    SQLiteDatabase db;
    MyListAdapter adapter;

    public ParyFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ParyFragment newInstance() {
        ParyFragment fragment = new ParyFragment();
        Bundle args = new Bundle();
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
        return inflater.inflate(R.layout.fragment_pary, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LocalDate ld = LocalDate.now();
        String date = ld.getDayOfMonth() + " " + ld.getMonth().getDisplayName(TextStyle.FULL, new Locale("ru", "RU"));
        if (ld.get(WeekFields.of(Locale.getDefault()).weekOfYear()) % 2 == 0) date += ", четная";
        else date += ", нечетная";

        int isChet = 0;
        int weekOfYear = ld.get(WeekFields.of(Locale.getDefault()).weekOfYear());

        if (weekOfYear % 2 == 0) isChet = 1;
        else isChet = 0;
        //setInitialDataPara(ld.getDayOfWeek().getValue(), isChet);
        ((TextView) getActivity().findViewById(R.id.textDate)).setText(date);


        MyListAdapter.OnStateClickListener stateClickListener = new MyListAdapter.OnStateClickListener() {
            @Override
            public void onStateClick(DateItem date, int position) {

                // Notify adapter
                mRecyclerView.post(new Runnable() {
                    @Override public void run()
                    {
                        adapter.notifyDataSetChanged();
                    }
                });

                LocalDate dateLocal = LocalDate.of(date.getYear(), date.getMonth(), date.getDayInt());

                int isChet = 0;
                int weekOfYear = dateLocal.get(WeekFields.of(Locale.getDefault()).weekOfYear());

                if (weekOfYear % 2 == 0) isChet = 1;
                else isChet = 0;
                setInitialDataPara(dateLocal.getDayOfWeek().getValue(), isChet);
            }
        };

        //открытие или создание бд
        db = getActivity().getBaseContext().openOrCreateDatabase("app.db", getActivity().MODE_PRIVATE, null);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView = view.findViewById(R.id.listViews);
        mRecyclerView.setLayoutManager(layoutManager);

        LinearLayoutManager layoutManagerPara = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerViewPara = view.findViewById(R.id.listPara);

        // начальная инициализация списка
        setInitialData();

        // создаем адаптер
        adapter = new MyListAdapter(getActivity(), list, stateClickListener);

        // устанавливаем для списка адаптер
        mRecyclerView.setAdapter(adapter);
    }

    private void setInitialDataPara(int day_of_week, int is_chet) {
        listPara.clear();

        String queryText = new StringBuilder().append("SELECT * FROM pary Where dayOfWeek ").append(" = ").append(day_of_week)
                .append(" and isChet").append(" = ").append(is_chet).append(" and group_num = ").append(String.valueOf(LoginActivity.GroupNumber)).toString();

        //берем значения
        Cursor query = db.rawQuery(queryText, null);

        int i = 0;

        while(query.moveToNext()){
            i++;
            ParaItem para = new ParaItem("", "", "", "", "", "", "", "");
            para.setNomer(Integer.toString(i));
            para.setStartTime(query.getString(3));
            para.setEndTime(query.getString(4));
            para.setNaim(query.getString(5));
            para.setPrepod(query.getString(6));
            para.setTip_zan(query.getString(8));
            para.setAudit(query.getString(9));
            para.setZdanie(query.getString(10));
            listPara.add(para);
        }

        ParaListAdapter adapterPara = new ParaListAdapter(getActivity(), listPara);
        // устанавливаем для списка адаптер
        mRecyclerViewPara.setAdapter(adapterPara);
    }

    private void setInitialData(){

        LocalDate date = LocalDate.now();

        for(int i=0; i<14;i++){
            list.add(new DateItem(date.getDayOfMonth(), date.getDayOfMonth() + "\n" + date.getDayOfWeek().getDisplayName(TextStyle.SHORT, new Locale("ru", "RU")), date.getMonthValue(), date.getYear()));

            if (date.getDayOfWeek().name() == "SATURDAY"){
                date = date.plusDays(2);
            }
            else date = date.plusDays(1);
        }
    }
}