package com.csalazar.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
    }

    public void retornarResultado(View view){
        Intent iResult = new Intent();
        iResult.putExtra("message", "Este es un parametro.");
        this.setResult(RESULT_OK, iResult);

        finish();
    }
}
