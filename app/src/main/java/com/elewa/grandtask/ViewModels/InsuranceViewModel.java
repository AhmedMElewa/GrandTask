package com.elewa.grandtask.ViewModels;

import com.elewa.grandtask.Models.InsuranceModel;
/**
 * Insurance ViewModel
 *
 * @author Ahmed M Elewa
 */
public class InsuranceViewModel {
    // Fields
    private int imgInsuranceLogo;

    // Constructors

    //Default constructor.
    public InsuranceViewModel() {
    }

    //Parameterized constructor.
    public InsuranceViewModel(InsuranceModel insuranceModel){
        this.imgInsuranceLogo = insuranceModel.getImgInsuranceLogo();
    }

    // Public methods
    /*
     * Returns the image.
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
}
