package com.example.maximilianodimito.asistancechecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.maximilianodimito.asistancechecker.Helper.CalendarHelper;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private CompactCalendarView calendar;
    private TextView monthText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendar = (CompactCalendarView) findViewById(R.id.compactcalendar_view);
        monthText = (TextView) findViewById(R.id.monthText);

        monthText.setText(CalendarHelper.getMonthName(new Date()));

        calendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {

            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                monthText.setText(CalendarHelper.getMonthName(firstDayOfNewMonth));
            }
        });
    }
}
