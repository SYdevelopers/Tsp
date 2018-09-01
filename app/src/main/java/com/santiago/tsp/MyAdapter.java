package com.santiago.tsp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.santiago.tsp.models.Projects;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private int layout;
    private ArrayList<Projects>projects;

    public MyAdapter(int layout, ArrayList<Projects> projects) {
        this.layout = layout;
        this.projects = projects;
    }

    @Override
    public int getCount() {
        return projects.size();
    }

    @Override
    public Object getItem(int i) {
        return projects.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view==null){
            view=LayoutInflater.from(viewGroup.getContext()).inflate(layout,null);
            holder=new ViewHolder();
            holder.nombre=view.findViewById(R.id.content_nom_project);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }
        Projects projects= (Projects) getItem(i);
        holder.nombre.setText(projects.getNombre());
        return view;
    }

    static class ViewHolder{
        TextView nombre;
    }
}
