package com.csalazar.materialdesign.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.csalazar.materialdesign.R;
import com.csalazar.materialdesign.adapters.ItemRecyclerAdapter;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemRecyclerAdapter itemAdapter;
    private int[] imagesResource;
    private String[] labels;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //agregar un elemento nuevo al ReclyclerView

            }
        });

        initComponents();
    }

    private void initComponents(){
        context = this;
        recyclerView = (RecyclerView) findViewById(R.id.rv_recycler_content);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 3);
        recyclerView.setLayoutManager(gridLayoutManager);

        imagesResource = new int[]{R.drawable.atm,R.drawable.bag,R.drawable.basket,R.drawable.box,R.drawable.briefcase,R.drawable.calculator};
        labels = new String[]{"Cajero","Bolsa","Canasta","Caja","Maletin","Calculadora"};

        itemAdapter = new ItemRecyclerAdapter(imagesResource,labels,context);
        recyclerView.setAdapter(itemAdapter);

    }

}
