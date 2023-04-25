package com.example.firstproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;


public class secondFrag extends Fragment {

  View view;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_second, container, false);
        DataBaseHelper db = new DataBaseHelper(getActivity());
        ArrayList data = db.readData();
        RecyclerView recyclerView = view.findViewById(R.id.rview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(data);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.notifyItemInserted(data.size() - 1);
        return view;
    }
}