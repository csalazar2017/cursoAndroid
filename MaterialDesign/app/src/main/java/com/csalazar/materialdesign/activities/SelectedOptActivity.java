package com.csalazar.materialdesign.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.csalazar.materialdesign.R;

public class SelectedOptActivity extends AppCompatActivity {

    private Spinner sOptions;
    private ImageView ivSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_opt);

        initComponents();
    }

    private void initComponents(){
        ivSelected = (ImageView) findViewById(R.id.iv_select);

        sOptions = (Spinner) findViewById(R.id.s_options);

        //para agregar valores a desplegar
        String[] options = getResources().getStringArray(R.array.selected_options);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, options);
        sOptions.setAdapter(adapter);

        sOptions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position){
                    case 0:
                        ivSelected.setImageResource(R.drawable.atm);
                        break;
                    case 1:
                        ivSelected.setImageResource(R.drawable.bag);
                        break;
                    case 2:
                        ivSelected.setImageResource(R.drawable.basket);
                        break;
                    case 3:
                        ivSelected.setImageResource(R.drawable.box);
                        break;
                    case 4:
                        ivSelected.setImageResource(R.drawable.briefcase);
                        break;
                    case 5:
                        ivSelected.setImageResource(R.drawable.calculator);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
