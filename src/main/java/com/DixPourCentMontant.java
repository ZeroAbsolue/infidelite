package com;

public class DixPourCentMontant implements IStrategyCout{
   
    @Override
    public double getCout(double montant) {
        return 0.9 * montant;
    }

}
