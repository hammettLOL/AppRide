package com.labs.maverick.projectevo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.labs.maverick.projectevo.R;
import com.labs.maverick.projectevo.adapters.MyAdapter;
import com.labs.maverick.projectevo.model.Servicios;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maverick on 4/11/2017.
 */

public class HistorialFragment extends Fragment {

    RecyclerView serviciosRecyclerView;
    MyAdapter myAdapter;
    List<Servicios> servicios;

    public HistorialFragment() {
        // Required empty public constructor



    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Initialize dataset, this data would usually come from a local content provider or
        // remote server
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v;
        v = inflater.inflate(R.layout.fragment_historial,container,false);
        myAdapter = new MyAdapter();

        servicios = new ArrayList<>();
        servicios.add(new Servicios("Maverick Távara","10/11/2017","10:43 am"));
        servicios.add(new Servicios("Json Bica Bica","07/07/2017","05:22 pm"));
        servicios.add(new Servicios("Bryan Cuchillo","10/02/2017","01:55 pm"));
        servicios.add(new Servicios("Maverick Távara","10/11/2017","10:43 am"));
        servicios.add(new Servicios("Json Bica Bica","07/07/2017","05:22 pm"));
        servicios.add(new Servicios("Bryan Cuchillo","10/02/2017","01:55 pm"));
        servicios.add(new Servicios("Maverick Távara","10/11/2017","10:43 am"));
        servicios.add(new Servicios("Json Bica Bica","07/07/2017","05:22 pm"));
        servicios.add(new Servicios("Bryan Cuchillo","10/02/2017","01:55 pm"));
        servicios.add(new Servicios("Maverick Távara","10/11/2017","10:43 am"));
        servicios.add(new Servicios("Json Bica Bica","07/07/2017","05:22 pm"));
        servicios.add(new Servicios("Bryan Cuchillo","10/02/2017","01:55 pm"));
        servicios.add(new Servicios("Maverick Távara","10/11/2017","10:43 am"));
        servicios.add(new Servicios("Json Bica Bica","07/07/2017","05:22 pm"));
        servicios.add(new Servicios("Bryan Cuchillo","10/02/2017","01:55 pm"));
        serviciosRecyclerView = (RecyclerView)v.findViewById(R.id.servicio_recycleView);
        myAdapter.setServicios(servicios);
        serviciosRecyclerView.setAdapter(myAdapter);
        serviciosRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));



            return v;
    }
    @Override

    public void onResume() {
        super.onResume();

    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

}
