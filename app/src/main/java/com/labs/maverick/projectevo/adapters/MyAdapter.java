package com.labs.maverick.projectevo.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.labs.maverick.projectevo.R;
import com.labs.maverick.projectevo.model.Servicios;

import java.util.List;

/**
 * Created by Maverick on 25/11/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Servicios> servicios;

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater
        .from(parent.getContext())
        .inflate(R.layout.servicio_card_view,parent,false));
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        holder.nameTextView.setText(servicios.get(position).getName());
        holder.dateTextView.setText(servicios.get(position).getDate());
        holder.timeTextView.setText(servicios.get(position).getTime());
    }
    public List<Servicios> getServicios(){
        return servicios;
    }
    public void setServicios(List<Servicios> servicios){
        this.servicios = servicios;
    }

    @Override
    public int getItemCount() {
        return servicios.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nameTextView;
        private TextView dateTextView;
        private TextView timeTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView)itemView.findViewById(R.id.name_textView);
            dateTextView = (TextView)itemView.findViewById(R.id.date_textView);
            timeTextView = (TextView)itemView.findViewById(R.id.time_textView);
        }
    }
}
