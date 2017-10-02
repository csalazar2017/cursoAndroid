package com.csalazar.formularioventas.holder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.csalazar.formularioventas.R;

/**
 * Created by csalazar on 2/10/2017.
 */

public class ItemHolderImagen extends RecyclerView.ViewHolder {

    private CardView cardView;
    private ImageView imageView;

    public ItemHolderImagen(View itemView) {
        super(itemView);

        cardView = (CardView) itemView.findViewById(R.id.cv_card_view_imagen);
        imageView = (ImageView) itemView.findViewById(R.id.iv_imagen_captura);
    }

    public void setDataImagen(int imageResource){
        imageView.setImageResource(imageResource);
    }
}
