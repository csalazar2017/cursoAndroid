package com.csalazar.formularioventas.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.csalazar.formularioventas.R;

/**
 * Created by csalazar on 28/09/2017.
 */

public class ItemHolderCliente extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView textViewNombre;
    private TextView textViewDireccion;
    private TextView textViewTelefono;
    private String numeroFormulario;

    public ItemHolderCliente(View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.iv_imagen_cliente);
        textViewNombre = itemView.findViewById(R.id.tv_nombre_cliente);
        textViewDireccion = itemView.findViewById(R.id.tv_direccion_cliente);
        textViewTelefono = itemView.findViewById(R.id.tv_telefono_cliente);
    }

    public void setDataCliente(String numFormulario, String labelNombre, String labelDireccion, String labelTelefono){

        numeroFormulario = numFormulario;
        textViewNombre.setText(labelNombre);
        textViewDireccion.setText(labelDireccion);
        textViewTelefono.setText(labelTelefono);
    }

}
