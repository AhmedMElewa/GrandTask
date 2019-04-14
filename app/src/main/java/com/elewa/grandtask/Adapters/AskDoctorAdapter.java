package com.elewa.grandtask.Adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.elewa.grandtask.R;
import com.elewa.grandtask.ViewModels.AskDoctorViewModel;
import com.elewa.grandtask.databinding.AskDoctorBinding;
import com.elewa.grandtask.listener.ClickListener;
import com.elewa.grandtask.util.ScreenUtils;

import java.util.List;
/**
 * Ask Doctor Adapter.
 *
 * @author Ahmed M Elewa
 */
public class AskDoctorAdapter extends RecyclerView.Adapter<AskDoctorAdapter.RecyclerViewHolder> {

    List<AskDoctorViewModel> askDoctorViewModel;

    private LayoutInflater layoutInflater;
    private Context context;

    public AskDoctorAdapter(List<AskDoctorViewModel> askDoctorViewModel,Context context) {
        this.askDoctorViewModel = askDoctorViewModel;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {


        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }


        final AskDoctorBinding askDoctorBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_doctor, parent, false);

        //set item view width depend on screen size
        askDoctorBinding.imgDoctor.getLayoutParams().width= ((ScreenUtils.getScreenWidth(context)/3)-16);

        return new RecyclerViewHolder(askDoctorBinding);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {


        AskDoctorViewModel askDoctorViewModels = askDoctorViewModel.get(position);
        holder.bind(askDoctorViewModels);


    }

    @Override
    public int getItemCount() {
        return askDoctorViewModel.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private AskDoctorBinding askDoctorBinding;

        public RecyclerViewHolder(AskDoctorBinding askDoctorBinding) {
            super(askDoctorBinding.getRoot());

            this.askDoctorBinding = askDoctorBinding;

        }

        public void bind(AskDoctorViewModel askDoctorViewModel) {

            this.askDoctorBinding.setAskDoctorView(askDoctorViewModel);
        }


        public AskDoctorBinding askDoctorBinding() {
            return askDoctorBinding;
        }

    }
}