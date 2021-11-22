package com.Modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CarteInfidelite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    private double nombrePoints;
    private double solde;

    public CarteInfidelite(double solde, double nombrePoints) {
        this.nombrePoints = nombrePoints;
        this.solde = solde;
    }
    /* On aura une variable statique pour attribue les nombres de carte */

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public double getNombrePoints() {
        return nombrePoints;
    }

    public void setNombrePoints(double nombrePoints) {
        this.nombrePoints = nombrePoints;
    }

    /* Permet d'increment le solde de la carte de montant */
    public void charger(double montant) {
        solde += montant;
    }

    /* Permet de reduire le solde de la carte de montant */
    public void deduireSolde(double montant) {
        solde -= montant;
    }

    /* Permet de reduire le nombre de point de points */
    public void deduirePoint(double points) {
        nombrePoints -= points;
    }

    /* Permet d"augmenter le nombre de points de pints */
    public void augmenterPoint(double points) {
        nombrePoints += points;
    }

    public boolean verifierSiSoldeSuperieurOuEgale(double montant) {
        return solde >= montant;
    }

    public CarteInfidelite() {
    }

}
