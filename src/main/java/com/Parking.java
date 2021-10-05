package com;

public class Parking extends Produit{
    private double duree;

    public Parking(String nom, double prix, double duree) {
        super(nom,prix);
        this.duree = duree;
    }

    public double getDuree() {
        return this.duree;
    }

    public void setDuree(double duree) {
        this.duree = duree;
    }

    @Override
    public String toString(){
      return  super.toString()+", duree: "+getDuree()+" heure(s), point(s): "+getNombrePoints();
    }

    public double getNombreHeures() {
        return duree;
    }
}
