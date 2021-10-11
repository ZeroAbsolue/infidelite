package com;

public class TransportCommun extends Produit {
    private double duree;

    public TransportCommun(String nom, Type type, double prix, double duree) {
        super(nom+" "+type.name(),prix);
        this.duree = duree;
    }
    
    public double getDuree() {
        return this.duree;
    }

    public void setDuree(double duree) {
        this.duree = duree;
    }

    public String toString(){
      return  super.toString()+", duree: "+getDuree()+" heure(s), point(s): "+getNombrePoints();
    }

  

}
