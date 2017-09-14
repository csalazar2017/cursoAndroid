package com.csalazar.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("LifeCycle", "onCreate");

        if((savedInstanceState != null) && (savedInstanceState.containsKey("valor"))){
            String valor = savedInstanceState.getString("valor");
            Log.i("InstanceState", valor);
        }
    }

    @Override
    protected void onStart(){
        super.onStart();

        Log.i("LifeCycle", "onStart");
    }

    @Override
    protected  void onResume(){
        super.onResume();

        Log.i("LifeCycle", "onResume");
    }

    @Override
    protected void onRestart(){
        super.onRestart();

        Log.i("Lifecycle", "onRestart");
    }

    @Override
    protected void onStop(){
        super.onStop();

        Log.i("LifeCycle", "onStop");
    }

    @Override
    protected void onPause(){
        super.onPause();

        Log.i("LifeCycle", "onPause");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        Log.i("LifeCycle", "onDestroy");
    }

    public void openResult(View view){
        Intent intent = new Intent(this, ResultActivity.class);
        startActivityForResult(intent, 1001);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if((resultCode == RESULT_OK) && (requestCode == 1001)){
            String message = data.getStringExtra("message");
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle state){
        super.onSaveInstanceState(state);

        Log.i("LifeCycle", "onSaveInstanceState");
        state.putString("valor", "Valor para restaurar");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);

        Log.i("LifeCycle", "onRestoreInstanceState");
        if((savedInstanceState != null) && (savedInstanceState.containsKey("valor"))){
            String valor = savedInstanceState.getString("valor");
            Log.i("InstanceState", valor);
        }
    }
}
