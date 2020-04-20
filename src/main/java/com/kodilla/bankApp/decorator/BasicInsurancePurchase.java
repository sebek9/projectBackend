package com.kodilla.bankApp.decorator;

import java.math.BigDecimal;

public class BasicInsurancePurchase implements InsurancePurchase {
    @Override
    public BigDecimal getCost(){
        return new BigDecimal(15.00);
    }

    @Override
    public String getDescription(){
        return "Basic insurance";
    }
}
