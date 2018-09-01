package com.santiago.tsp.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.santiago.tsp.R;

import java.util.ArrayList;

public class InicioActivity extends AppCompatActivity {

    ListView lista;
    ArrayList<String> projects;
    ArrayAdapter<String>adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        lista=findViewById(R.id.listProjects);
        projects=new ArrayList<String>(){{
            add("project 1");
            add("project 2");
            add("project 3");
            add("project 4");
            add("project 5");
            add("project 6");
            add("project 7");
            add("project 8");
            add("project 9");
        }};
        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,projects);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final CharSequence items[]={"Time Log","Defect Log","Project Plan Summary"};

                AlertDialog.Builder builder=new AlertDialog.Builder(InicioActivity.this);
                builder.setTitle("Menú");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (items[i].equals("Time Log")){
                            startActivity(new Intent(InicioActivity.this,TimeLogActivity.class));
                        }else if (items[i].equals("Defect Log")){
                            startActivity(new Intent(InicioActivity.this,DefectLogActivity.class));
                        }else if (items[i].equals("Project Plan Summary")){
                            startActivity(new Intent(InicioActivity.this,ProjectPlanSummaryActivity.class));
                        }
                    }
                }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog=builder.create();
                dialog.show();
            }
        });


    }
}
