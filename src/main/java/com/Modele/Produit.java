package com.Modele;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Produit extends Aproduit implements Cloneable, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    private String nom;
    private double prix;

    @Transient
    public IStrategyPoint strategiePoint;
    @Transient
    public IStrategyCout strategieCout;

    // Permet de créer une clé étrangère avec l'entité vente
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "produit")
    public Set<Vente> vente;

    /* Par defaut la strategie de cout est normale */

    public IStrategyCout getStrategieCout() {
        return strategieCout;
    }

    public Produit() {
        setStrategiePoint(new DixPourCentPoint());
        setStrategieCout(new CoutNormale());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        // partenaires = new ArrayList<Partenaire>();
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
    public Object clone() throws CloneNotSupportedException {
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
