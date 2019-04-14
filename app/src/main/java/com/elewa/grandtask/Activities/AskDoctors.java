package com.elewa.grandtask.Activities;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.elewa.grandtask.Adapters.AskDoctorAdapter;
import com.elewa.grandtask.Adapters.InsuranceAdapter;
import com.elewa.grandtask.R;
import com.elewa.grandtask.ViewModels.AskDoctorViewModel;
import com.elewa.grandtask.util.RecyclerViewDisabler;
import com.elewa.grandtask.util.ScreenUtils;
import com.elewa.grandtask.util.fabCreation;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import java.util.ArrayList;
import java.util.List;


/**
 * Ask Doctor Activity .
 *
 * @author Ahmed M Elewa
 */
public class AskDoctors extends AppCompatActivity {

    private TextView toolbarTitle;
    private ImageView imgTitle;
    private View toolbar;

    private RecyclerView recyclerView;
    private AskDoctorAdapter askDoctorAdapter;
    private List<AskDoctorViewModel> askDoctorViewModelList;

    private RelativeLayout relativeForward,relativeBack;
    private LinearLayoutManager mLayoutManager;

    private TextView txtSend;
    private EditText etextMessage;
    private ImageView imgSelected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_doctors);

        inti();
    }


    private void inti(){
        toolbar = findViewById(R.id.toolbar);
        toolbarTitle = toolbar.findViewById(R.id.toolbarTitle);
        imgTitle = toolbar.findViewById(R.id.imgTitle);

        relativeForward = findViewById(R.id.relativeForward);
        relativeBack = findViewById(R.id.relativeBack);
        txtSend = findViewById(R.id.txtSend);
        etextMessage = findViewById(R.id.etextMessage);
        recyclerView = findViewById(R.id.recDoctors);

        //Toolbar title Image
        Glide.with(getApplicationContext())
                .load(R.drawable.message)
                .into(imgTitle);

        // Toolbar title
        toolbarTitle.setText(R.string.ask_doctor);

        // send Message
        txtSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = etextMessage.getText().toString();
                if (message.isEmpty()){
                    etextMessage.setError("Message required");
                    etextMessage.requestFocus();
                    return;
                }

                etextMessage.setText("");
                Toast.makeText(getApplicationContext(), R.string.sentMessage, Toast.LENGTH_LONG).show();
            }
        });


        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        int padding = (ScreenUtils.getScreenWidth(this)/3)-16;
        recyclerView.setPadding(padding, 0, padding, 0);
        // To disable scroll
        RecyclerView.OnItemTouchListener disabler = new RecyclerViewDisabler();
        recyclerView.addOnItemTouchListener(disabler);

        askDoctorViewModelList = new ArrayList<>();
        setData();
        askDoctorAdapter = new AskDoctorAdapter(askDoctorViewModelList,getApplicationContext());
        recyclerView.setAdapter(askDoctorAdapter);



        //set selected image width depend on screen size
        imgSelected = findViewById(R.id.imgSelected);
        imgSelected.getLayoutParams().width= padding;


        //forward button of recyclerView
        relativeForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mLayoutManager.findFirstVisibleItemPosition() > 0) {
                    recyclerView.smoothScrollToPosition(mLayoutManager.findFirstVisibleItemPosition() - 1);
                } else {
                    recyclerView.smoothScrollToPosition(0);
                }
            }
        });

        //back button of recyclerView
        relativeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.smoothScrollToPosition(mLayoutManager.findLastVisibleItemPosition() + 1);
            }
        });


        //Fab inti
        fabCreation.createFab(getApplicationContext(),this);


    }

    // Add dummy data to viewModel
    private void setData() {

        int image[]= {R.drawable.doctor,R.drawable.doctor1,R.drawable.doctor2,R.drawable.doctor3,R.drawable.doctor4,R.drawable.doctor5};
        String doctorName[]= {"Ahmed","Ali","Mahmoud","Abd-Allah","Khaled","Mohammed"};
        for (int i = 0; i < image.length; i++) {
            AskDoctorViewModel askDoctorViewModel  = new AskDoctorViewModel();
            askDoctorViewModel.setImgInsuranceLogo(image[i]);
            askDoctorViewModel.setDoctorName(doctorName[i]);
            askDoctorViewModelList.add(askDoctorViewModel);
        }


    }


}
