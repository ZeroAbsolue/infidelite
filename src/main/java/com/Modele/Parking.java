package com.Modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Parking extends Produit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
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

    public Parking() {
    }

    
}
