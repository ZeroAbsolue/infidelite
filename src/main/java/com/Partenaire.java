package com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* Permet d'identifier un partenaire */
public class Partenaire {
    private String nom;
    private String adresse;
    private List<Produit> listeDesProduits;
    private List<Produit> listeDesVentes;
    private List<Produit> listeDesOffres;

    public Partenaire(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
        listeDesProduits = new ArrayList<Produit>();
        listeDesVentes = new ArrayList<Produit>();
        listeDesOffres = new ArrayList<Produit>();
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /* Permet d'ajouter un produit a la liste des produits du partenaire */
    public void ajouterProduit(Produit produit) {
        listeDesProduits.add(produit);
    }

    /* Permet de retirer un produit a la liste des produits du partenaire */
    public void retirerProduit(Produit produit) {
        listeDesProduits.remove(produit);
    }

    /* Permet le catalogue de produits du partenaire */
    public String catalogueProduits() {
        String result = toString() + "/n";
        if (listeDesProduits.size() == 0)
            result += "Aucun produit";
        else {
            result += "Catalogue des produits:/n";
            Iterator<Produit> iterator = listeDesProduits.iterator();
            while (iterator.hasNext()) {
                Produit produit = iterator.next();
                result += produit;
                if (iterator.hasNext())
                    result += "/n";
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Partenaire: " + getNom() + "," + " adresse: " + getAdresse();
    }

    /* Permet de vendre un produit */
    public void vendre(Produit produit, Client client) throws CloneNotSupportedException {
        Produit cloneProduit = (Produit) produit.clone();
        cloneProduit.setPrix(produit.getCout(client));
        listeDesVentes.add(cloneProduit);
        // TODO ajouter le partenaire a la liste des magasins ou le client a fait des
        // achats
    }

    /* Permet d'afficher la liste des ventes d'un partenaire */
    public String listeDesVentes() {
        String result = toString() + "/n";
        if (listeDesVentes.size() == 0)
            result += "Aucune operation";
        else {
            result += "Produits vendu(s):/n";
            Iterator<Produit> iterator = listeDesVentes.iterator();
            while (iterator.hasNext()) {
                Produit operation = iterator.next();
                result += operation;
                if (iterator.hasNext())
                    result += "/n";
            }
        }
        return result;
    }

    /*
     * Permet d'ajouter un produit a la liste des produits offert par le partenaire
     */
    public void offrir(Produit produit, Client client) {
        listeDesOffres.add(produit);
        // TODO ajouter le bout de code qui permet de reduire le nombre de points dans
        // la carte du client
    }

    /*
     * Permet d'afficher la liste des offres qui ont été effectuées par le
     * partenaire
     */
    public String listeDesOffres() {
        String result = toString() + "/n";
        if (listeDesOffres.size() == 0)
            result += "Aucune offre";
        else {
            result += "Produits offert(s):/n";
            Iterator<Produit> iterator = listeDesOffres.iterator();
            while (iterator.hasNext()) {
                Produit operation = iterator.next();
                result += operation;
                if (iterator.hasNext())
                    result += "/n";
            }
        }
        return result;
    }

    /* Permet de valider une carte */
    public boolean validerCarte(CarteInfidelite carte, double montant, double point) {
        return carte.getNombrePoints() >= point && carte.getSolde() >= montant;
    }

}
