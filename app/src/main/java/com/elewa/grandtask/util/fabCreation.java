package com.elewa.grandtask.util;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.elewa.grandtask.R;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

public class fabCreation {



    public static void createFab(Context context, Activity activity){
        final ImageView icon;
        icon = new ImageView(context); // Create an icon
        icon.setImageResource(R.drawable.baseline_add_white_24);
        icon.setBackground(context.getResources().getDrawable(R.drawable.menuback));

        FloatingActionButton.LayoutParams starParams = new FloatingActionButton.LayoutParams(120, 120);
        starParams.setMargins(8,
                8,
                8,
                8);
        icon.setLayoutParams(starParams);

        FloatingActionButton.LayoutParams fabIconStarParams = new FloatingActionButton.LayoutParams(120, 120);
        fabIconStarParams.setMargins(8,
                8,
                8,
                8);

        FloatingActionButton actionButton = new FloatingActionButton.Builder(activity)
                .setContentView(icon,fabIconStarParams)
                .setPosition(5)
                .setLayoutParams(starParams)
                .build();

        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(activity);

        int[] drawable = {R.drawable.outline_home_white_24, R.drawable.bottom_chat, R.drawable.bottom_locaton, R.drawable.bottom_person};
        ImageView itemIcon1 = new ImageView(context);
        itemIcon1.setImageResource(drawable[0]);
        SubActionButton button1 = itemBuilder.setContentView(itemIcon1).setBackgroundDrawable(context.getResources().getDrawable(R.drawable.round)).build();
        ImageView itemIcon2 = new ImageView(context);
        itemIcon2.setImageResource(drawable[1]);
        SubActionButton button2 = itemBuilder.setContentView(itemIcon2).setBackgroundDrawable(context.getResources().getDrawable(R.drawable.submenu_checked)).build();
        ImageView itemIcon3 = new ImageView(context);
        itemIcon3.setImageResource(drawable[2]);
        SubActionButton button3 = itemBuilder.setContentView(itemIcon3).setBackgroundDrawable(context.getResources().getDrawable(R.drawable.submenu_checked)).build();
        ImageView itemIcon4 = new ImageView(context);
        itemIcon4.setImageResource(drawable[3]);
        SubActionButton button4 = itemBuilder.setContentView(itemIcon4).setBackgroundDrawable(context.getResources().getDrawable(R.drawable.round)).build();

        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(activity)
                .setStartAngle(0)
                .setEndAngle(-180)
                .addSubActionView(button1)
                .addSubActionView(button2)
                .addSubActionView(button3)
                .addSubActionView(button4)
                .attachTo(actionButton)
                .setRadius(200)
                .enableAnimations()
                .build();

        actionMenu.setStateChangeListener(new FloatingActionMenu.MenuStateChangeListener() {
            @Override
            public void onMenuOpened(FloatingActionMenu menu) {
                // Rotate the icon of rightLowerButton 45 degrees clockwise
                icon.setRotation(0);
                PropertyValuesHolder pvhR = PropertyValuesHolder.ofFloat(View.ROTATION, 45);
                ObjectAnimator animation = ObjectAnimator.ofPropertyValuesHolder(icon, pvhR);
                animation.start();
            }

            @Override
            public void onMenuClosed(FloatingActionMenu floatingActionMenu) {
                icon.setRotation(45);
                PropertyValuesHolder pvhR = PropertyValuesHolder.ofFloat(View.ROTATION, 0);
                ObjectAnimator animation = ObjectAnimator.ofPropertyValuesHolder(icon, pvhR);
                animation.start();
            }

        });
    }

}
