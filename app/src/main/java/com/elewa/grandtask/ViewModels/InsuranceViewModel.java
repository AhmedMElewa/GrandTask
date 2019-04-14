package com.elewa.grandtask.ViewModels;

import com.elewa.grandtask.Models.InsuranceModel;

public class InsuranceViewModel {

    private int imgInsuranceLogo;

    public InsuranceViewModel() {
    }

    public InsuranceViewModel(InsuranceModel insuranceModel){
        this.imgInsuranceLogo = insuranceModel.getImgInsuranceLogo();
    }

    public int getImgInsuranceLogo() {
        return imgInsuranceLogo;
    }

    public void setImgInsuranceLogo(int imgInsuranceLogo) {
        this.imgInsuranceLogo = imgInsuranceLogo;
    }
}
