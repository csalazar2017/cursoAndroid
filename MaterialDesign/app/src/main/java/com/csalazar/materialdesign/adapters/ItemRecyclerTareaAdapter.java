package com.csalazar.materialdesign.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.csalazar.materialdesign.R;
import com.csalazar.materialdesign.holders.ItemHolderTarea;
import com.csalazar.materialdesign.models.Imagen;

import java.util.ArrayList;

/**
 * Created by csalazar on 19/09/2017.
 */

public class ItemRecyclerTareaAdapter extends RecyclerView.Adapter<ItemHolderTarea> {

    private Context context;
    private ArrayList<Imagen> imagenClass;

    public ItemRecyclerTareaAdapter(Context context, ArrayList<Imagen> imagenClass) {
        this.context = context;
        this.imagenClass = imagenClass;
    }

    public ItemRecyclerTareaAdapter() {

    }

    @Override
    public ItemHolderTarea onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(context);
        View view = li.inflate(R.layout.item_recycler_tarea, parent, false);

        return new ItemHolderTarea(view);
    }

    @Override
    public void onBindViewHolder(ItemHolderTarea holder, int position) {
        holder.setDataTarea(imagenClass.get(position).getImagen(), imagenClass.get(position).getNombre());

    }

    @Override
    public int getItemCount() {
        return imagenClass.size();
    }
}
