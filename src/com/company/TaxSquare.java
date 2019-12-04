package com.company;

public class TaxSquare extends Square {

    int taxAmount;

    public TaxSquare(String name, int taxAmount, int position){
        super(name, false, position);
        this.taxAmount = taxAmount;
    }

    public int getTaxAmount(){
        return taxAmount;
    }
    public void setTaxAmount(int tax){
        this.taxAmount = tax;
    }

    @Override
    public void Speak() {

    }
}
