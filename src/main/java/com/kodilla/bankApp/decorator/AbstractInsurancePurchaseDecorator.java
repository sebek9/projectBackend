package com.kodilla.bankApp.decorator;

import java.math.BigDecimal;

public class AbstractInsurancePurchaseDecorator implements InsurancePurchase {

    private final InsurancePurchase insurancePurchase;

    protected AbstractInsurancePurchaseDecorator(InsurancePurchase insurancePurchase){
        this.insurancePurchase=insurancePurchase;
    }

    @Override
    public BigDecimal getCost(){
        return insurancePurchase.getCost();
    }

    @Override
    public String getDescription(){
        return insurancePurchase.getDescription();
    }
}
