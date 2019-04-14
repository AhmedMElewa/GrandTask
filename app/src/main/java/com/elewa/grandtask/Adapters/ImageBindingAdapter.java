package com.elewa.grandtask.Adapters;


import android.databinding.BindingAdapter;
import android.util.Log;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

public class ImageBindingAdapter {

    @BindingAdapter({"bind:imgInsuranceLogo"})
    public static void loadImage(ImageView imageView, int  imgInsuranceLogo) {
            try {
                Glide.with(imageView.getContext())
                        .load(imgInsuranceLogo)
                        .into(imageView);
            }catch (NullPointerException e)
            {
                Log.d("","image exception "+e );
            }
        }
}