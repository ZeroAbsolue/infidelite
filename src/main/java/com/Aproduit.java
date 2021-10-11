package com;

public abstract class Aproduit {
    /*
     * protected String nom; protected double prix;
     */

    public abstract String description();

    public abstract double getCout();

    public void ajouterProduit(Aproduit produit) {
        throw new UnsupportedOperationException();
    }

    public void retirerProduit(Aproduit produit) {
        throw new UnsupportedOperationException();
    }
}
