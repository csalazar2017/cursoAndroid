package com.csalazar.materialdesign.holders;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.csalazar.materialdesign.R;

/**
 * Created by csalazar on 19/09/2017.
 */

public class ItemHolderTarea extends RecyclerView.ViewHolder {

    private CardView cvBackgroundTarea;
    private ImageView ivImageTarea;
    private TextView tvLabelTarea;

    public ItemHolderTarea(View itemView) {
        super(itemView);

        cvBackgroundTarea = itemView.findViewById(R.id.cv_tarea_recycler);
        ivImageTarea =  itemView.findViewById(R.id.iv_tarea_image);
        tvLabelTarea =  itemView.findViewById(R.id.tv_tarea_label);
    }

    public void setDataTarea(int imageResource, String label){
        ivImageTarea.setImageResource(imageResource);
        tvLabelTarea.setText(label);
    }
}
