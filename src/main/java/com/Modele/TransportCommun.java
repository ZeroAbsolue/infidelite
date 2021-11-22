package com.Modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TransportCommun extends Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
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

    public TransportCommun() {
    }

    

}
