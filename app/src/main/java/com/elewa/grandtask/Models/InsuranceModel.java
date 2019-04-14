package com.elewa.grandtask.Models;

/**
 * Insurance Model
 *
 * @author Ahmed M Elewa
 */

public class InsuranceModel {
    // Fields
    private int imgInsuranceLogo;

    // Constructors

    //Default constructor.
    public InsuranceModel() {
    }
    //Parameterized constructor.
    public InsuranceModel(int imgInsuranceLogo) {
        this.imgInsuranceLogo = imgInsuranceLogo;
    }

    // Public methods
    /*
     * set the image.
     */
    public int getImgInsuranceLogo() {
        return imgInsuranceLogo;
    }

    /*
     * Returns the image.
     */
    public void setImgInsuranceLogo(int imgInsuranceLogo) {
        this.imgInsuranceLogo = imgInsuranceLogo;
    }
}
