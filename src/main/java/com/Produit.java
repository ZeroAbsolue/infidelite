package com;

public class Produit extends Aproduit implements Cloneable {
    private String nom;
    private double prix;
    private IStrategyPoint strategiePoint;
    private IStrategyCout strategieCout;

    /* Par defaut la strategie de cout est normale */

    public IStrategyCout getStrategieCout() {
        return strategieCout;
    }

    public void setStrategieCout(IStrategyCout strategieCout) {
        this.strategieCout = strategieCout;
    }

    public IStrategyPoint getStrategiePoint() {
        return strategiePoint;
    }

    public void setStrategiePoint(IStrategyPoint strategiePoint) {
        this.strategiePoint = strategiePoint;
    }

    public Produit(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
        setStrategiePoint(new DixPourCentPoint());
        setStrategieCout(new CoutNormale());
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return this.prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String toString() {
        return getNom() + "," + " prix: " + getCout() + "$";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public double getCout() {
        return strategieCout.getCout(getPrix());
    }

    /* Permet de calucler le nombre de points selon la strategie definie */
    public double getNombrePoints() {
        return strategiePoint.getNombrePoints(getCout());
    }

    @Override
    public String description() {
        return toString() + ", point(s): " + getNombrePoints();
    }

}
