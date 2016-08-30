package com.example.maximilianodimito.asistancechecker.modules.dashboard;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.maximilianodimito.asistancechecker.R;
import com.example.maximilianodimito.asistancechecker.helper.CalendarHelper;
import com.example.maximilianodimito.asistancechecker.helper.RecyclerViewAdapter;
import com.example.maximilianodimito.asistancechecker.model.Asistance;
import com.example.maximilianodimito.asistancechecker.model.Person;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DashBoardFragment extends Fragment implements DashBoardView, CompactCalendarView.CompactCalendarViewListener {

    @BindView(R.id.compactcalendar_view)
    CompactCalendarView calendar;
    @BindView(R.id.personList)
    RecyclerView personList;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private final DashBoardPresenter presenter = DashBoardPresenter.getInstance(this);
    private RecyclerViewAdapter itemsAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dashboard_layout, container, false);
        ButterKnife.bind(this,view);
        toolbar.setTitle(StringUtils.capitalize(CalendarHelper.getMonthName(new Date())));
        //((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);


        itemsAdapter = new RecyclerViewAdapter(new ArrayList<String>(),getContext());
        personList.setAdapter(itemsAdapter);
        personList.setLayoutManager(new LinearLayoutManager(getContext()));
        personList.setHasFixedSize(true);

        calendar.setListener(this);

        return view;
    }

    @Override
    public void setAsistancesList(final List<Asistance> asistances) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                itemsAdapter.clear();
                for(Asistance a : asistances)
                {
                    itemsAdapter.add(a.getPerson().toString());
                }
                itemsAdapter.notifyDataSetChanged();
            }
        });
    }

    //////// CompatCalendarViewListener
    @Override
    public void onDayClick(Date dateClicked) {
        presenter.loadAsistancesPersonsForDay(dateClicked);
    }

    @Override
    public void onMonthScroll(Date firstDayOfNewMonth) {
        toolbar.setTitle(StringUtils.capitalize(CalendarHelper.getMonthName(firstDayOfNewMonth)));
        presenter.loadAsistancesPersonsForDay(firstDayOfNewMonth);
    }



}
