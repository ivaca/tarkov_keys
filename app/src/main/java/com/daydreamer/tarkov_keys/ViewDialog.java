package com.daydreamer.tarkov_keys;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

public class ViewDialog {

    public void showDialog(Activity activity, Drawable img){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog);

        Glide.with(activity).load(img).into((PhotoView) dialog.findViewById(R.id.fullscreen_content));



        Button dialogButton = (Button) dialog.findViewById(R.id.btn_dialog);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }
}