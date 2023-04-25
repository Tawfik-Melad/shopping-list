package com.example.firstproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class firstFrag extends Fragment {

   View view;
   EditText itemFiled,quantityFiled;
   Button saveButton;
   DataBaseHelper dataBaseHelper;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_first, container, false);
        itemFiled = (EditText) view.findViewById(R.id.itemButton);
        quantityFiled =(EditText) view.findViewById(R.id.qunButton);
        saveButton= (Button) view.findViewById(R.id.saveButton);
        DataBaseHelper db = new DataBaseHelper(getActivity());
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.insertData(itemFiled.getText().toString(), quantityFiled.getText().toString());
            }
        });
        return view;
    }
}