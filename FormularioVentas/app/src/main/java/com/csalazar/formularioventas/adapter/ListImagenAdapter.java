package com.csalazar.formularioventas.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.csalazar.formularioventas.R;
import com.csalazar.formularioventas.holder.ItemHolderImagen;
import com.csalazar.formularioventas.modelo.Imagen;

import java.util.List;

/**
 * Created by csalazar on 2/10/2017.
 */

public class ListImagenAdapter extends RecyclerView.Adapter<ItemHolderImagen> {

    private Context context;
    private List<Imagen> listImagenes;

    public ListImagenAdapter(Context context, List<Imagen> listImagenes) {
        this.context = context;
        this.listImagenes = listImagenes;
    }

    public ListImagenAdapter() {
    }

    @Override
    public ItemHolderImagen onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(context);
        View view = li.inflate(R.layout.lista_imagenes, parent, false);

        return new ItemHolderImagen(view);
    }

    @Override
    public void onBindViewHolder(ItemHolderImagen holder, int position) {
        holder.setDataImagen(listImagenes.get(position).getImagen());

    }

    @Override
    public int getItemCount() {
        return listImagenes.size();
    }
}
