package com.elewa.grandtask.Adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.elewa.grandtask.Activities.AskDoctors;
import com.elewa.grandtask.R;
import com.elewa.grandtask.ViewModels.InsuranceViewModel;
import com.elewa.grandtask.databinding.InsuranceBinding;
import com.elewa.grandtask.listener.ClickListener;

import java.util.List;

public class InsuranceAdapter extends RecyclerView.Adapter<InsuranceAdapter.RecyclerViewHolder> {

    List<InsuranceViewModel> insuranceViewModels;
    Context context;

    private LayoutInflater layoutInflater;


    public InsuranceAdapter(List<InsuranceViewModel> insuranceViewModels,Context context) {
        this.insuranceViewModels = insuranceViewModels;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {


        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }


        final InsuranceBinding insuranceBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_insurance, parent, false);

        insuranceBinding.setMove(new ClickListener() {
            @Override
            public void onclickListener() {
                Intent intent = new Intent(context,AskDoctors.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });


        insuranceBinding.setPresenter(new ClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onclickListener() {

                LinearLayout linearLayout= insuranceBinding.linerItemMenu.findViewById(R.id.liner_item_menu);
                if (linearLayout.isEnabled()){
                    linearLayout.setVisibility(View.VISIBLE);
                    linearLayout.setEnabled(false);
                    insuranceBinding.imgInsurance.setBackgroundResource( R.drawable.round_ins_checked );

                }else {
                    linearLayout.setVisibility(View.GONE);
                    linearLayout.setEnabled(true);
                    insuranceBinding.imgInsurance.setBackgroundResource( R.drawable.round_ins );
                }

            }
        });

        return new RecyclerViewHolder(insuranceBinding);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {


        InsuranceViewModel insuranceViewModel = insuranceViewModels.get(position);
        holder.bind(insuranceViewModel);





    }

    @Override
    public int getItemCount() {
        return insuranceViewModels.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private InsuranceBinding insuranceBinding;

        public RecyclerViewHolder(InsuranceBinding insuranceBinding) {
            super(insuranceBinding.getRoot());

            this.insuranceBinding = insuranceBinding;

        }

        public void bind(InsuranceViewModel newsModel) {
            this.insuranceBinding.setInsuranceView(newsModel);
        }



        public InsuranceBinding insuranceBinding() {
            return insuranceBinding;
        }

    }
}