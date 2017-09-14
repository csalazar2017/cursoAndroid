package com.csalazar.materialdesign.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.csalazar.materialdesign.R;

public class ListViewActivity extends AppCompatActivity {

    private ListView lv_lista;
    private ImageView ivLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        initComponents();
    }

    private void initComponents(){
        ivLista = (ImageView) findViewById(R.id.iv_list);
        lv_lista = (ListView) findViewById(R.id.lv_list);

        String[] listado = getResources().getStringArray(R.array.selected_options);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listado);
        lv_lista.setAdapter(adapter);

        lv_lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position){
                    case 0:
                        ivLista.setImageResource(R.drawable.atm);
                        break;
                    case 1:
                        ivLista.setImageResource(R.drawable.bag);
                        break;
                    case 2:
                        ivLista.setImageResource(R.drawable.basket);
                        break;
                    case 3:
                        ivLista.setImageResource(R.drawable.box);
                        break;
                    case 4:
                        ivLista.setImageResource(R.drawable.briefcase);
                        break;
                    case 5:
                        ivLista.setImageResource(R.drawable.calculator);
                        break;
                }
            }
        });
    }
}
