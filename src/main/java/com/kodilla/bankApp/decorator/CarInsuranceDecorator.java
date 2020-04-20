package com.kodilla.bankApp.decorator;

import java.math.BigDecimal;


public class CarInsuranceDecorator extends AbstractInsurancePurchaseDecorator {
    public CarInsuranceDecorator(InsurancePurchase insurancePurchase) {
        super(insurancePurchase);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(10));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + car insurance";
    }
}