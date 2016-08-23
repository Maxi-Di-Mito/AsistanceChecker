package com.example.maximilianodimito.asistancechecker.modules.dashboard;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.maximilianodimito.asistancechecker.R;
import com.example.maximilianodimito.asistancechecker.helper.CalendarHelper;
import com.example.maximilianodimito.asistancechecker.model.Person;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DashBoardFragment extends Fragment implements DashBoardView, CompactCalendarView.CompactCalendarViewListener {

    @BindView(R.id.compactcalendar_view)
    CompactCalendarView calendar;
    @BindView(R.id.monthText)
    TextView monthText;
    @BindView(R.id.personList)
    ListView personList;

    private final DashBoardPresenter presenter = DashBoardPresenter.getInstance(this);
    private  ArrayAdapter<String> itemsAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dashboard_layout, container, false);
        ButterKnife.bind(this,view);

        monthText.setText(CalendarHelper.getMonthName(new Date()));

        itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,new ArrayList<String>());
        personList.setAdapter(itemsAdapter);

        calendar.setListener(this);

        return view;
    }


    @Override
    public void setPersonsList(final List<Person> persons) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                itemsAdapter.clear();
                for(Person p: persons)
                {
                    itemsAdapter.add(p.toString());
                }
                itemsAdapter.notifyDataSetChanged();
            }
        });
    }


    //////// CompatCalendarViewListener
    @Override
    public void onDayClick(Date dateClicked) {
        presenter.loadPersonsForDay(dateClicked);
    }

    @Override
    public void onMonthScroll(Date firstDayOfNewMonth) {
        monthText.setText(CalendarHelper.getMonthName(firstDayOfNewMonth));
    }



}
