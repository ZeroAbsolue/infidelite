package com.Modele;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cadeau extends Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "partenaire_id")
    private Partenaire partenaire;
    private double point;

    public Cadeau() {
    }


    public Cadeau(String nom, double point) {
        super(nom, 0);
        this.point = point;
    }

    public Cadeau(String nom, double point, Partenaire partenaire) {
        super(nom, 0);
        this.point = point;
        this.partenaire = partenaire;
    }

    @Override
    public String description() {
        return super.toString() + ", point(s): " + point + ", " + partenaire;
    }

    @Override
    public String toString() {
        return super.toString() + ", point(s): " + point;
    }

    @Override
    public double getCout() {
        return 0;
    }

    public double getNombrePoints() {
        return - super.getNombrePoints();
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public String getPartenaire() {
        return partenaire.getNom();
    }

}
