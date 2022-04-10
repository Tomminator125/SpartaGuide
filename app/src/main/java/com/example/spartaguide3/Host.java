package com.example.spartaguide3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class Host extends AppCompatActivity{
    Button newPath, add, removeLast;
    Spinner pathSelector;

    ArrayAdapter<String> spinnerAdapter;
    Path currentPath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);

        newPath = findViewById(R.id.button_new_path);
        add = findViewById(R.id.button_add);
        removeLast = findViewById(R.id.button_remove_last);
        pathSelector = findViewById(R.id.spinner_path_selector);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, android.R.id.text1);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pathSelector.setAdapter(spinnerAdapter);
        spinnerAdapter.add("Atrium");
        spinnerAdapter.add("Bathrooms");
//        pathSelector.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//            }
//        });
    }

    /** Called when the user taps the new path button */
    public void sendMessage() {
        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
        String name = editText.getText().toString();
        spinnerAdapter.add(name);
        GlobalVariables.Paths.add(new Path(name));
    }

}