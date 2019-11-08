package com.company;

public class TaxSquare extends Square {

    int taxAmount;

    public TaxSquare(String name, int taxAmount){
        super(name);
        this.taxAmount = taxAmount;
    }

    public int getTaxAmount(){
        return taxAmount;
    }
    public void setTaxAmount(int tax){
        this.taxAmount = tax;
    }

}
