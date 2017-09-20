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
import com.csalazar.materialdesign.adapters.ItemRecyclerTareaAdapter;
import com.csalazar.materialdesign.models.Imagen;

import java.util.ArrayList;
import java.util.List;

public class RecyclerTareaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemRecyclerTareaAdapter item;
    private Context context;
    private ArrayList<Imagen> imagenes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_tarea);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                imagenes.add(new Imagen(R.drawable.imagen2, getResources().getString(R.string.cbx_imagen2)));
                item = new ItemRecyclerTareaAdapter(context, imagenes);
                recyclerView.setAdapter(item);

            }
        });

        initComponents();
    }

    private void initComponents(){
        context = this;
        recyclerView = (RecyclerView) findViewById(R.id.rv_recycler_view);
        GridLayoutManager gridManager = new GridLayoutManager(context, 3);

        recyclerView.setLayoutManager(gridManager);

        llenado();

        item = new ItemRecyclerTareaAdapter(context, imagenes);
        recyclerView.setAdapter(item);
    }

    private void llenado(){
        imagenes = new ArrayList<>();

        imagenes.add(new Imagen(R.drawable.atm,getResources().getString(R.string.cbx_atm)));
        imagenes.add(new Imagen(R.drawable.bag,getResources().getString(R.string.cbx_bag)));
        imagenes.add(new Imagen(R.drawable.basket,getResources().getString(R.string.cbx_basket)));
        imagenes.add(new Imagen(R.drawable.box,getResources().getString(R.string.cbx_box)));
        imagenes.add(new Imagen(R.drawable.briefcase,getResources().getString(R.string.cbx_briefcase)));
        imagenes.add(new Imagen(R.drawable.calculator,getResources().getString(R.string.cbx_calculator)));


    }

}
