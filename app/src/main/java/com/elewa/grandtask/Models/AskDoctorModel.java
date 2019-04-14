package com.elewa.grandtask.Models;

/**
 * AskDoctor Model
 *
 * @author Ahmed M Elewa
 */

public class AskDoctorModel {
    private int imgInsuranceLogo;
    private String DoctorName;

    public AskDoctorModel() {
    }

    public AskDoctorModel(int imgInsuranceLogo, String doctorName) {
        this.imgInsuranceLogo = imgInsuranceLogo;
        DoctorName = doctorName;
    }
    // Public methods
    /*
     * Returns the int image.
     */
    public int getImgInsuranceLogo() {
        return imgInsuranceLogo;
    }

    /*
     * set the image.
     */
    public void setImgInsuranceLogo(int imgInsuranceLogo) {
        this.imgInsuranceLogo = imgInsuranceLogo;
    }

    /*
     * return string
     */
    public String getDoctorName() {
        return DoctorName;
    }

    /*
     * set the string.
     */
    public void setDoctorName(String doctorName) {
        DoctorName = doctorName;
    }
}
