package com.Modele;

public class DixPourCentPoint implements IStrategyPoint {
    /* Retourne dix pour cent du montant passe en argument */
    @Override
    public double getNombrePoints(double montant) {
        return (montant * 10) / 100;
    }

}
