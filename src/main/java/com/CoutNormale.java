package com;

public class CoutNormale  implements IStrategyCout {
    /* Retourne le prix initiale */
    @Override
    public double getCout(double montant) {
        return montant;
    }
}
