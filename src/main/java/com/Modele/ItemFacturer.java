package com.Modele;

public class ItemFacturer {
    private Produit produit;
    private int quantite;

    public ItemFacturer(Produit produit, int quantite) {
        this.produit = produit;
        this.quantite = quantite;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getNom() {
        return this.produit.toString();
    }

    public double getPrix() {
        return quantite * produit.getCout();
    }

    public double getPoints() {
        return quantite * produit.getNombrePoints();
    }

    public ItemFacturer() {
    }

    
}
