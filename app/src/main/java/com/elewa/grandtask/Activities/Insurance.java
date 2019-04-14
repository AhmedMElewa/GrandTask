package com.elewa.grandtask.Activities;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.elewa.grandtask.Adapters.InsuranceAdapter;
import com.elewa.grandtask.R;
import com.elewa.grandtask.ViewModels.InsuranceViewModel;
import com.elewa.grandtask.util.fabCreation;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import java.util.ArrayList;
import java.util.List;
/**
 * Insurance Activity.
 *
 * @author Ahmed M Elewa
 */
public class Insurance extends AppCompatActivity {


    private TextView toolbarTitle;
    private ImageView imgTitle;
    private View toolbar;
    private RecyclerView recyclerView;
    private InsuranceAdapter insuranceAdapter;
    private List<InsuranceViewModel> insuranceViewModelList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insurance);

        inti();


    }

    private void inti(){
        toolbar = findViewById(R.id.toolbar);
        toolbarTitle = toolbar.findViewById(R.id.toolbarTitle);
        imgTitle = toolbar.findViewById(R.id.imgTitle);
        recyclerView = findViewById(R.id.recInsurance);

        //Toolbar title image
        Glide.with(getApplicationContext())
                .load(R.drawable.shield)
                .into(imgTitle);

        // Toolbar Title
        toolbarTitle.setText(R.string.insurance);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        insuranceViewModelList = new ArrayList<>();


        setData();
        insuranceAdapter = new InsuranceAdapter(insuranceViewModelList,getApplicationContext());
        recyclerView.setAdapter(insuranceAdapter);

        //Fab inti
        fabCreation.createFab(getApplicationContext(),this);
    }

    // Add dummy data to viewModel
    private void setData() {

        int image[]= {R.drawable.insurance1,R.drawable.insurance2,R.drawable.insurance3,R.drawable.insurance4,R.drawable.insurance5,R.drawable.insurance6};
        for (int i = 0; i < image.length; i++) {
            InsuranceViewModel insuranceViewModel  = new InsuranceViewModel();
            insuranceViewModel.setImgInsuranceLogo(image[i]);

            insuranceViewModelList.add(insuranceViewModel);
        }


    }
}
