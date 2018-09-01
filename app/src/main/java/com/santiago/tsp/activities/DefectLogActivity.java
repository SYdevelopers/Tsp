package com.santiago.tsp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.santiago.tsp.R;

public class DefectLogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defect_log);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
