package com.example.maximilianodimito.asistancechecker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.maximilianodimito.asistancechecker.modules.dashboard.DashBoardFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_layout,new DashBoardFragment())
                .commit();
    }
}
