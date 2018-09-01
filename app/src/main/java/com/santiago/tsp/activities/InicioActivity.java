package com.santiago.tsp.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.santiago.tsp.MyAdapter;
import com.santiago.tsp.R;
import com.santiago.tsp.data.Datos;
import com.santiago.tsp.models.Projects;

import java.util.ArrayList;

public class InicioActivity extends AppCompatActivity implements View.OnClickListener {

    ListView lista;
    Projects project;
    TextInputEditText nombreProjecto;
    FloatingActionButton fab;
    Datos datos;
    ArrayList<Projects>projects;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        inicializar();
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

    private void inicializar() {
        datos=new Datos(this);
        lista=findViewById(R.id.listProjects);
        fab=findViewById(R.id.fabNewProject);
        nombreProjecto=findViewById(R.id.nom_project);
        projects=datos.listarProjectos();
        adapter=new MyAdapter(R.layout.content_item_list,projects);
        lista.setAdapter(adapter);
        fab.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {
        if (nombreProjecto.getText().toString().isEmpty()){
            Toast.makeText(this, "Debe ingresar un nombre de projecto", Toast.LENGTH_SHORT).show();
        }else {
            project =new Projects();
            project.setNombre(nombreProjecto.getText().toString());
            project.setTiempo(0);
            if (datos.guardarProjecto(project)){
                Toast.makeText(this, "projecto guardado", Toast.LENGTH_SHORT).show();
                adapter.notifyDataSetChanged();


            }else {
                Toast.makeText(this, "projecto no guardado", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
