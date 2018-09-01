package com.santiago.tsp;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TimeLogActivity extends AppCompatActivity {

    Button start,stop,register;
    TextView txtStart,txtStop,txtDelta;
    TextInputEditText interruptions;
    Spinner phase;
    ArrayList<String>phases;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_log);
        inicializar();
        horasSistema();

    }

    private void horasSistema() {
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateFormat hora =new SimpleDateFormat("hh:mm");
                DateFormat fecha =new SimpleDateFormat("dd/mm/yy");
                txtStart.setText(fecha +" " +hora);
            }
        });
    }


    private void inicializar() {
         start=findViewById(R.id.btn_start);
         stop=findViewById(R.id.btn_stop);
         register=findViewById(R.id.btn_register);
         txtStart=findViewById(R.id.txt_start);
         txtStop=findViewById(R.id.txt_stop);
         txtDelta=findViewById(R.id.txt_delta);
         interruptions=findViewById(R.id.txt_interruption);
         phase=findViewById(R.id.spinner_phase);
         phases=new ArrayList<String>(){{
             add("PLAN");
             add("DLD");
             add("CODE");
             add("COMPILE");
             add("UT");
             add("PM");
         }};
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,phases);
        phase.setAdapter(adapter);

    }
}
