package com.csalazar.formularioventas.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.csalazar.formularioventas.R;
import com.csalazar.formularioventas.holder.ItemHolderCliente;
import com.csalazar.formularioventas.modelo.Cliente;

import java.util.List;

/**
 * Created by csalazar on 28/09/2017.
 */

public class ListClienteAdapter extends RecyclerView.Adapter<ItemHolderCliente> {

    private Context context;
    private Cursor cursorCliente;

    public ListClienteAdapter() {
    }

    public ListClienteAdapter(Context context, Cursor cursorCliente) {
        this.context = context;
        this.cursorCliente = cursorCliente;
    }

    @Override
    public ItemHolderCliente onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(context);
        View view = li.inflate(R.layout.lista_usuarios, parent, false);

        return new ItemHolderCliente(view);
    }

    @Override
    public void onBindViewHolder(ItemHolderCliente holder, int position) {
        cursorCliente.moveToPosition(position);
        Log.i("Adapter cliente", cursorCliente.getString(4));
        holder.setDataCliente(cursorCliente.getString(9), cursorCliente.getString(1), cursorCliente.getString(2),
                cursorCliente.getString(4));

    }

    @Override
    public int getItemCount() {
        if(cursorCliente != null){
            return cursorCliente.getCount();
        }else{
            return 0;
        }

    }
}
