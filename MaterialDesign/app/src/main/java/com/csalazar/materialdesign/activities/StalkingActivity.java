package com.csalazar.materialdesign.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.csalazar.materialdesign.R;

public class StalkingActivity extends AppCompatActivity {

    private AlertDialog dialogOk;
    private AlertDialog dialogYesNo;
    private AlertDialog dialogItems;
    private AlertDialog dialogSingle;
    private AlertDialog dialogMultiple;

    private ImageView iv_colapsed;

    private Context context;

    private int selectedOption = -1;

    private boolean[] selectedOptions = new boolean[] { false, false, false, false, false, false };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stalking);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        context = this;

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        inicializarComponentes();
    }

    public void inicializarComponentes()
    {
        iv_colapsed = (ImageView) findViewById(R.id.iv_colapsed);

        //Dialogo OK
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.warning);
        builder.setTitle("Alerta!!!");
        builder.setMessage("Este es el mensaje de alerta...");
        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        dialogOk = builder.create();

        //dialogYesNo
        builder = new AlertDialog.Builder(this);
        builder.setMessage("Aquí hay que elegir");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context, "Seleccionamos Aceptar", Toast.LENGTH_LONG).show();
                dialogInterface.cancel();
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context, "Seleccionamos Cancelar", Toast.LENGTH_LONG).show();
                dialogInterface.cancel();
            }
        });
        dialogYesNo = builder.create();

        //dialogItems
        builder = new AlertDialog.Builder(this);
        builder.setTitle("Elegir imagen");
        builder.setItems(R.array.selected_options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int selected) {
                switch (selected)
                {
                    case 0:
                        iv_colapsed.setImageResource(R.drawable.atm);
                        break;
                    case 1:
                        iv_colapsed.setImageResource(R.drawable.bag);
                        break;
                    case 2:
                        iv_colapsed.setImageResource(R.drawable.basket);
                        break;
                    case 3:
                        iv_colapsed.setImageResource(R.drawable.box);
                        break;
                    case 4:
                        iv_colapsed.setImageResource(R.drawable.briefcase);
                        break;
                    case 5:
                        iv_colapsed.setImageResource(R.drawable.calculator);
                        break;
                }
            }
        });
        dialogItems = builder.create();
    }

    public void showDialogoOk(View view)
    {
        dialogOk.show();
    }

    public void showDialogoYesNo(View view)
    {
        dialogYesNo.show();
    }

    public void showDialogItems(View view)
    {
        dialogItems.show();
    }

    public void showDialogSingle(View view)
    {
        //dialogSingle
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Seleccionar opción");
        builder.setSingleChoiceItems(R.array.selected_options, selectedOption, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int selected) {
                selectedOption = selected;
                Toast.makeText(context, "Opción seleccionada: "+selected, Toast.LENGTH_LONG).show();
                dialogInterface.cancel();
            }
        });

        dialogSingle = builder.create();
        dialogSingle.show();
    }

    public void showDialogMultiple(View view)
    {
        //dialogMultiple
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Seleccionar opciones");
        builder.setMultiChoiceItems(R.array.selected_options, selectedOptions, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int option, boolean selected) {
                selectedOptions[option] = selected;
                Toast.makeText(context, "Opciones seleccionadas: " + option, Toast.LENGTH_LONG).show();
            }
        });

        builder.setNeutralButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                for(boolean dato: selectedOptions)
                {
                    Log.e("Es Selected", ""+dato);
                }
                dialogInterface.cancel();
            }
        });

        dialogMultiple = builder.create();
        dialogMultiple.show();
    }
}
