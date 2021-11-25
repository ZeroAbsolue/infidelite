package com.Modele;

import java.util.Date;

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
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "partenaire_id")
    private Partenaire partenaire;
    private Date date;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "abonne_id")
    private Abonne abonne;

    private String type;
    private double montant;
    private double point;
    
    
    

    public Operation(Partenaire partenaire, Date date, Abonne abonne, String type) {
        this.partenaire = partenaire;
        this.date = date;
        this.abonne = abonne;
        this.type = type;
    }

    public Operation(Partenaire partenaire, Date date, Abonne abonne, String type, double montant, double point) {
        this.partenaire = partenaire;
        this.date = date;
        this.abonne = abonne;
        this.type = type;
        this.montant = montant;
        this.point = point;
    }


    public Operation(Partenaire partenaire, Date date, Abonne abonne, String type, double montant) {
        this.partenaire = partenaire;
        this.date = date;
        this.abonne = abonne;
        this.type = type;
        this.montant = montant;
    }

    public String getType() {
        return type;
    }


    public double getPoint() {
        return point;
    }


    public void setPoint(double point) {
        this.point = point;
    }

    public void setType(String type) {
        this.type = type;
    }


    public Operation(Partenaire partenaire, Date date) {
        this.partenaire = partenaire;
        this.date = date;
    }

    
    public double getMontant() {
        return montant;
    }


    public void setMontant(double montant) {
        this.montant = montant;
    }


    public Abonne getAbonne() {
        return abonne;
    }


    public Operation(Partenaire partenaire, Date date, Abonne abonne) {
        this.partenaire = partenaire;
        this.date = date;
        this.abonne = abonne;
    }


    public void setAbonne(Abonne abonne) {
        this.abonne = abonne;
    }


    public Partenaire getPartenaire() {
        return this.partenaire;
    }

    public void setPartenaire(Partenaire partenaire) {
        this.partenaire = partenaire;
    }

    public Date getDate() {
        return this.date;
    }
    
    public String getDateOperation() {
        return this.date.toString();
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public Operation() {
    }

    

}
