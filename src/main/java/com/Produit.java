package com;

public class Produit extends Aproduit implements Cloneable {
    private String nom;
    private double prix;


    public Produit() {
    }

    public Produit(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
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

    public String toString(){
      return  getNom()+","+" prix: "+getPrix()+"$";
    }
    /* Par defaut la strategie de point est de dixPourCent */
    /* Par defaut la strategie de cout est normale */

    @Override
    public double getCout(Client client) {
        // TODO Realiser ceci en utilisant les strategies
        return getPrix();
    }

    @Override
    public double getNombrePoints(Client client) {
        // TODO Realiser ceci en utilisant les strategies
        return (getPrix()*10)/100;
    }

    @Override
    protected Object clone()
        throws CloneNotSupportedException
    {
        return super.clone();
    }

    @Override
    public double getCout() {
        // TODO Auto-generated method stub
        return getPrix();
    }

    @Override
    public double getNombrePoints() {
        // TODO Auto-generated method stub
        return (getPrix()*10)/100;
    }

}
