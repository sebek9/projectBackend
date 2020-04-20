package com.kodilla.bankApp.decorator;

import java.math.BigDecimal;

public class FlatInsuranceDecorator extends AbstractInsurancePurchaseDecorator {
    public FlatInsuranceDecorator(InsurancePurchase insurancePurchase) {
        super(insurancePurchase);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(15));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + flat insurance";
    }
}