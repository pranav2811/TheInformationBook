package com.pranav.theinformationbook.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.pranav.theinformationbook.adapters.AdapterClass;
import com.pranav.theinformationbook.ModelClass;
import com.pranav.theinformationbook.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private ArrayList<ModelClass> arrayList;
    private AdapterClass adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);
        //determining whether data will vbe displayed horizontally or vertically
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
          recyclerView.setLayoutManager(new GridLayoutManager(this,2));//in case of the grid we can specify the number of columns
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        arrayList = new ArrayList<>();

        ModelClass modelClass1 = new ModelClass("countries","The Countries");
        ModelClass modelClass2 = new ModelClass("leaders","The Leaders");
        ModelClass modelClass3 = new ModelClass("museums","The Museums");
        ModelClass modelClass4 = new ModelClass("wonders","Seven Wonders of the World");

        arrayList.add(modelClass1);
        arrayList.add(modelClass2);
        arrayList.add(modelClass3);
        arrayList.add(modelClass4);


        adapter = new AdapterClass(arrayList,this);
        recyclerView.setAdapter(adapter);
    }
}