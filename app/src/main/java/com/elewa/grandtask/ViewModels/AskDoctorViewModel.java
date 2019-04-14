package com.elewa.grandtask.ViewModels;

import com.elewa.grandtask.Models.AskDoctorModel;
/**
 * Ask Doctor ViewModel
 *
 * @author Ahmed M Elewa
 */
public class AskDoctorViewModel {
    // Fields
    private int imgInsuranceLogo;
    private String DoctorName;

    // Constructors

    //Default constructor.
    public AskDoctorViewModel() {
    }

    //Parameterized constructor.
    public AskDoctorViewModel(AskDoctorModel askDoctorModel) {
        this.imgInsuranceLogo = askDoctorModel.getImgInsuranceLogo();
        DoctorName = askDoctorModel.getDoctorName();
    }

    // Public methods
    /*
     * Returns the image.
     */
    public int getImgInsuranceLogo() {
        return imgInsuranceLogo;
    }

    /*
     * set the (int) image.
     */
    public void setImgInsuranceLogo(int imgInsuranceLogo) {
        this.imgInsuranceLogo = imgInsuranceLogo;
    }

    /*
     * set the string.
     */
    public String getDoctorName() {
        return DoctorName;
    }

    /*
     * return string
     */
    public void setDoctorName(String doctorName) {
        DoctorName = doctorName;
    }
}
