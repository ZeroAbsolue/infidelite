package com.Modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Aproduit {
    /*
     * protected String nom; protected double prix;
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private int id;

    public abstract String description();

    public abstract double getCout();

    public void ajouterProduit(Aproduit produit) {
        throw new UnsupportedOperationException();
    }

    public void retirerProduit(Aproduit produit) {
        throw new UnsupportedOperationException();
    }
}
