package com.csalazar.materialdesign.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.csalazar.materialdesign.R;

public class ListViewActivity extends AppCompatActivity {

    private ListView lv_lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
    }

    private void initComponents(){
        lv_lista = (ListView) findViewById(R.id.lv_list);

        String[] listado = getResources().getStringArray(R.array.selected_options);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listado);
        lv_lista.setAdapter(adapter);
    }
}
