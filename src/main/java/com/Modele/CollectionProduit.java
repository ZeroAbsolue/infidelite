package com.Modele;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionProduit extends Aproduit {
    private String nom;
    private List<Aproduit> produits;

    public List<Aproduit> getProduits() {
        return produits;
    }

    public void setProduits(List<Aproduit> produits) {
        this.produits = produits;
    }

    public CollectionProduit(String nom) {
        this.nom = nom;
        produits = new ArrayList<Aproduit>();
    }

    public void ajouterProduit(Aproduit produit) {
        produits.add(produit);
    }

    public void retirerProduit(Aproduit produit) {
        produits.remove(produit);
    }

    @Override
    public String description() {
        String result = "Collection " + nom;
        if (produits.size() >= 0) {
            Iterator<Aproduit> produitsIterator = produits.iterator();
            result += "\nListe des produits ou cadeau de la collection";
            while (produitsIterator.hasNext()) {
                result += "\n";
                Aproduit iterator = produitsIterator.next();
                result += iterator.description();

            }
        } else {
            result = " Aucun produit ou cadeau dans la collection";
        }
        return result;
    }

    @Override
    public double getCout() {
        double result = 0;

        Iterator<Aproduit> produitsIterator = produits.iterator();
        while (produitsIterator.hasNext()) {
            Aproduit iterator = produitsIterator.next();
            result += iterator.getCout();
        }
        return result;
    }

}
