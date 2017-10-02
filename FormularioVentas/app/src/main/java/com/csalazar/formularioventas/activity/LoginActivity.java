package com.csalazar.formularioventas.activity;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.csalazar.formularioventas.R;
import com.csalazar.formularioventas.controlador.ControladorBase;

public class LoginActivity extends AppCompatActivity {

    private EditText usuario;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initComponents();
    }

    private void initComponents(){
        ControladorBase controladorBase = new ControladorBase(this);
        usuario = findViewById(R.id.et_usuario);
        password = findViewById(R.id.et_password);
    }

    public void validaIngreso(View view){
        String textUsuario = usuario.getText().toString().trim();
        String textPasseord = password.getText().toString().trim();
        if(textUsuario.isEmpty()){
            Snackbar.make(view, "Ingrese un usuario registrado...", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }else if (textPasseord.isEmpty()){
            Snackbar.make(view, "Ingrese su password...", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }else{
            Intent intent = new Intent(this, ListaActivity.class);

            startActivity(intent);

            usuario.setText("");
            password.setText("");
        }
    }
}
