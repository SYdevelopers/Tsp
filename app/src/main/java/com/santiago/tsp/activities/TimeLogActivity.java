package com.santiago.tsp.activities;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.santiago.tsp.R;

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
    Date date1;
    Date date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_log);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        inicializar();
        horasSistema();

    }

    private void horasSistema() {
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                date=new Date();
                DateFormat fechaStart =new SimpleDateFormat("dd/MM/yy hh:mm");
                String fechaS=fechaStart.format(date);
                txtStart.setText(fechaS);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                date1=new Date();
                DateFormat fechaStop =new SimpleDateFormat("dd/MM/yy hh:mm");
                String fechaST=fechaStop.format(date1);
                txtStop.setText(fechaST);


            }
        });
    }

    private void  calcularDiferencia(Date stop,Date start) {
        if (interruptions.getText().toString().isEmpty()){
            long diferencia=(stop.getTime()-start.getTime());
            long sengMill=1000;
            long minsMill=sengMill*60;
            long minutos=diferencia/minsMill;
            txtDelta.setText(minutos+"");
        }else {
            long interrupcion= Long.parseLong(interruptions.getText().toString());
            long diferencia=(stop.getTime()-start.getTime()-interrupcion);
            long sengMill=1000;
            long minsMill=sengMill*60;
            long minutos=diferencia/minsMill;
            txtDelta.setText(minutos+"");
        }

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
