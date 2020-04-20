package com.kodilla.bankApp.decorator;

import java.math.BigDecimal;

public class BasicInsuranceDecorator extends AbstractInsurancePurchaseDecorator {

    public BasicInsuranceDecorator(InsurancePurchase insurancePurchase){
        super(insurancePurchase);
    }

    @Override
    public BigDecimal getCost(){

        return super.getCost().add(new BigDecimal(20));
    }

    @Override
    public String getDescription(){
        return super.getDescription()+" with life protection";
    }

}
