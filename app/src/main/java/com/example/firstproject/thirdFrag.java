package com.example.firstproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class thirdFrag extends Fragment {

   View view;
   Button button;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_third, container, false);
        button = view.findViewById(R.id.uploadButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBaseHelper db = new DataBaseHelper(getActivity());
                ArrayList data = db.readData();
                for(int i=0;i<data.size();i++){
                    FirebaseDatabase.getInstance().getReference().child("First Project").child("item" + i).setValue(data.get(i));
                }
            }
        });
        return view;
    }
}