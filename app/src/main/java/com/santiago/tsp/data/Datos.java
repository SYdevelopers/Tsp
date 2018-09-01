package com.santiago.tsp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.santiago.tsp.models.Projects;

import java.util.ArrayList;

public class Datos extends SQLiteOpenHelper {
    SQLiteDatabase db;
    Cursor cursor;
    public Datos(Context context) {
        super(context, "1", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+Constantes.TBL_PROJECTS +"("+
                                Constantes._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                                Constantes.NOMBRE + " TEXT,"+
                                Constantes.TIEMPO + " INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
     public boolean guardarProjecto(Projects projects){
        db=getWritableDatabase();
         ContentValues values=new ContentValues();
         values.put(Constantes.NOMBRE,projects.getNombre());
         values.put(Constantes.TIEMPO,projects.getTiempo());
         return db.insert(Constantes.TBL_PROJECTS,null,values)>0;
     }
     public ArrayList<Projects> listarProjectos(){
        db=getReadableDatabase();
         ArrayList<Projects>projects =new ArrayList();
        cursor=db.rawQuery("SELECT * FROM " + Constantes.TBL_PROJECTS,null);
        if (cursor.moveToFirst()){
            do {
                Projects project=new Projects();
                project.setNombre(cursor.getString(cursor.getColumnIndex(Constantes.NOMBRE)));
                projects.add(project);

            }while (cursor.moveToNext());
            return projects;
        }else {
            return null;
        }
     }
}
