package com.example.maximilianodimito.asistancechecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.maximilianodimito.asistancechecker.Helper.CalendarHelper;
import com.example.maximilianodimito.asistancechecker.Helper.ServiceFactory;
import com.example.maximilianodimito.asistancechecker.model.Person;
import com.example.maximilianodimito.asistancechecker.model.PersonResponse;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private CompactCalendarView calendar;
    private TextView monthText;
    private ListView personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        monthText = (TextView) findViewById(R.id.monthText);
        monthText.setText(CalendarHelper.getMonthName(new Date()));

        personList = (ListView) findViewById(R.id.personList);
        final ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,new ArrayList<String>());
        personList.setAdapter(itemsAdapter);

        calendar = (CompactCalendarView) findViewById(R.id.compactcalendar_view);
        calendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                Call<PersonResponse> call = ServiceFactory.getWebService().getPersons();

                call.enqueue(new Callback<PersonResponse>(){

                    @Override
                    public void onResponse(Call<PersonResponse> call,final Response<PersonResponse> response) {
                        if(response.body().getResponse())
                        {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    itemsAdapter.clear();
                                    for(Person p: response.body().getPersons())
                                    {
                                        itemsAdapter.add(p.toString());
                                    }
                                }
                            });
                        }
                    }

                    @Override
                    public void onFailure(Call<PersonResponse> call, Throwable t) {

                    }
                });
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                monthText.setText(CalendarHelper.getMonthName(firstDayOfNewMonth));
            }
        });
    }
}
