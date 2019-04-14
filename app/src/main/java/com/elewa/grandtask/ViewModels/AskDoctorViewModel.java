package com.elewa.grandtask.ViewModels;

import com.elewa.grandtask.Models.AskDoctorModel;

public class AskDoctorViewModel {

    private int imgInsuranceLogo;
    private String DoctorName;

    public AskDoctorViewModel() {
    }

    public AskDoctorViewModel(AskDoctorModel askDoctorModel) {
        this.imgInsuranceLogo = askDoctorModel.getImgInsuranceLogo();
        DoctorName = askDoctorModel.getDoctorName();
    }

    public int getImgInsuranceLogo() {
        return imgInsuranceLogo;
    }

    public void setImgInsuranceLogo(int imgInsuranceLogo) {
        this.imgInsuranceLogo = imgInsuranceLogo;
    }

    public String getDoctorName() {
        return DoctorName;
    }

    public void setDoctorName(String doctorName) {
        DoctorName = doctorName;
    }
}
