package com.kodilla.bankApp.decorator;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsurancePurchaseTest {

    @Test
    public void testInsurancePurchaseCost(){
        //Given

        InsurancePurchase purchase=new BasicInsurancePurchase();
        //When

        BigDecimal calculatedCost=purchase.getCost();

        //Then
        assertEquals(new  BigDecimal(15),calculatedCost);

    }

    @Test
    public void testInsurancePurchaseDescription(){
        //Given

        InsurancePurchase purchase=new BasicInsurancePurchase();
        //When
        String description=purchase.getDescription();

        //Then
        assertEquals("Basic insurance",description);
    }

    @Test
    public void testBasicInsurancePurchaseCost(){
        //Given
        InsurancePurchase purchase=new BasicInsurancePurchase();
        purchase=new BasicInsuranceDecorator(purchase);
        //When
        BigDecimal theCost=purchase.getCost();
        //Then
        assertEquals(new BigDecimal(35),theCost);
    }
    @Test
    public void testBasicInsurancePurchaseDescription() {
        //Given
        InsurancePurchase purchase=new BasicInsurancePurchase();
        purchase=new BasicInsuranceDecorator(purchase);
        //When
        String description=purchase.getDescription();
        //Then
        assertEquals("Basic insurance with life protection",description);
    }

    @Test
    public void testCarInsuranceDecoratorCost() {
        //Given
        InsurancePurchase purchase=new BasicInsurancePurchase();
        purchase=new BasicInsuranceDecorator(purchase);
        purchase=new CarInsuranceDecorator(purchase);
        //When
        BigDecimal theCost=purchase.getCost();
        //Then
        assertEquals(new BigDecimal(45),theCost);
    }

    @Test
    public void testCarInsuranceDecoratorDescription() {
        //Given
        InsurancePurchase purchase=new BasicInsurancePurchase();
        purchase=new BasicInsuranceDecorator(purchase);
        purchase=new CarInsuranceDecorator(purchase);
        //When
        String description=purchase.getDescription();
        //Then
        assertEquals("Basic insurance with life protection + car insurance",description);
    }

    @Test
    public void testFlatInsuranceDecoratorCost() {
        //Given
        InsurancePurchase purchase=new BasicInsurancePurchase();
        purchase=new BasicInsuranceDecorator(purchase);
        purchase=new FlatInsuranceDecorator(purchase);
        //When
        BigDecimal theCost=purchase.getCost();
        //Then
        assertEquals(new BigDecimal(50),theCost);
    }

    @Test
    public void testFlatInsuranceDecoratorDescription() {
        //Given
        InsurancePurchase purchase=new BasicInsurancePurchase();
        purchase=new BasicInsuranceDecorator(purchase);
        purchase=new FlatInsuranceDecorator(purchase);
        //When
        String description=purchase.getDescription();
        //Then
        assertEquals("Basic insurance with life protection + flat insurance",description);
    }
}
