package com.Modele;

import java.io.Serializable;
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
import javax.persistence.Table;

@Entity
@Table(name = "Partenaire_vente")
public class Vente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "produit_id")
    private Produit produit;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "partenaire_id")
    private Partenaire partenaire;

    private Date date;
    private double prix;
    private int quantite;

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Vente() {
    }

    public Vente(Produit produit, int quantite, Date date, Partenaire partenaire, double prix) {
        this.produit = produit;
        this.date = date;
        this.partenaire = partenaire;
        this.prix = prix;
        this.quantite = quantite;
    }

    public String getNom() {
        return this.produit.getNom();
    }

    public Vente(Produit produit, int quantite, Date date, Partenaire partenaire) {
        this.produit = produit;
        this.date = date;
        this.partenaire = partenaire;
        this.quantite = quantite;
        this.prix = produit.getCout();
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Partenaire getPartenaire() {
        return partenaire;
    }

    public void setPartenaire(Partenaire partenaire) {
        this.partenaire = partenaire;
    }

    @Override
    public String toString() {
        return "Vente [date=" + date + ", partenaire=" + partenaire + ", prix=" + prix + ", produit=" + produit
                + ", quantite=" + quantite + "]";
    }

}
