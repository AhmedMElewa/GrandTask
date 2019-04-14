package com.elewa.grandtask.Models;

public class AskDoctorModel {
    private int imgInsuranceLogo;
    private String DoctorName;

    public AskDoctorModel() {
    }

    public AskDoctorModel(int imgInsuranceLogo, String doctorName) {
        this.imgInsuranceLogo = imgInsuranceLogo;
        DoctorName = doctorName;
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
