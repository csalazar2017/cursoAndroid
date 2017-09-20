package com.csalazar.materialdesign.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.csalazar.materialdesign.R;
import com.csalazar.materialdesign.holders.ItemHolder;

/**
 * Created by csalazar on 18/09/2017.
 */

public class ItemRecyclerAdapter extends RecyclerView.Adapter<ItemHolder> {

    private int[] imagesResource;
    private String[] labels;
    private Context context;

    public ItemRecyclerAdapter(int[] imagesResource, String[] labels, Context context){
        this.imagesResource = imagesResource;
        this.labels = labels;
        this.context = context;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(context);
        View view = li.inflate(R.layout.item_recycler, parent, false);

        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        holder.setData(imagesResource[position], labels[position]);
    }

    @Override
    public int getItemCount() {
        return imagesResource.length;
    }
}
