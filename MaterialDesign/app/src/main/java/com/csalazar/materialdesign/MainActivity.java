package com.csalazar.materialdesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.csalazar.materialdesign.activities.ImageOptActivity;
import com.csalazar.materialdesign.activities.SelectedOptActivity;
import com.csalazar.materialdesign.activities.TextActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openText(View view){
        startActivity(new Intent(this, TextActivity.class));

    }

    public void openImage(View view){
        startActivity(new Intent(this, ImageOptActivity.class));
    }

    public void openSelected(View view){
        startActivity(new Intent(this, SelectedOptActivity.class));
    }
}
