package com;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import com.Modele.Aproduit;
import com.Modele.Cadeau;
import com.Modele.CollectionProduit;
import com.Modele.DixPourCentMontant;
import com.Modele.Partenaire;
import com.Modele.Produit;

import org.junit.Before;

public class CollectionProduitTest {
    Aproduit collectionProduit;
    Aproduit liquidation;

    @Before
    public void setup() throws CloneNotSupportedException {
        Produit chemise = new Produit("Chemise ", 100);
        Produit lchemise = (Produit) chemise.clone();
        Produit pantalon = new Produit("Pantalon ", 150);
        Produit lpantalon = (Produit) pantalon.clone();
        Produit jupe = new Produit("Jupes ", 90);
        Produit ljupe = (Produit) jupe.clone();
        Produit sac = new Produit("Sac ", 100);
        Produit lsac = (Produit) sac.clone();
        Cadeau cadeau = new Cadeau("Voiture", 500,
                new Partenaire("BMW", "4090 Rue Jean-Talon O, Montréal, QC H4P 1V5"));
        collectionProduit = new CollectionProduit("Rayon");
        collectionProduit.ajouterProduit(chemise);
        collectionProduit.ajouterProduit(pantalon);
        collectionProduit.ajouterProduit(jupe);
        collectionProduit.ajouterProduit(sac);
        liquidation = new CollectionProduit("Liquidation");
        lchemise.setStrategieCout(new DixPourCentMontant());
        lpantalon.setStrategieCout(new DixPourCentMontant());
        ljupe.setStrategieCout(new DixPourCentMontant());
        lsac.setStrategieCout(new DixPourCentMontant());
        liquidation.ajouterProduit(lchemise);
        liquidation.ajouterProduit(lpantalon);
        liquidation.ajouterProduit(ljupe);
        liquidation.ajouterProduit(lsac);
        collectionProduit.ajouterProduit(liquidation);
        collectionProduit.ajouterProduit(cadeau);

    }

    @Test
    public void test() {
        assertEquals(
                "Collection Rayon\nListe des produits ou cadeau de la collection\nChemise , prix: 100.0$, point(s): 10.0\nPantalon , prix: 150.0$, point(s): 15.0\nJupes , prix: 90.0$, point(s): 9.0\nSac , prix: 100.0$, point(s): 10.0\nCollection Liquidation\nListe des produits ou cadeau de la collection\nChemise , prix: 90.0$, point(s): 9.0\nPantalon , prix: 135.0$, point(s): 13.5\nJupes , prix: 81.0$, point(s): 8.1\nSac , prix: 90.0$, point(s): 9.0\nVoiture, prix: 0.0$, point(s): 500.0, Partenaire: BMW, adresse: 4090 Rue Jean-Talon O, Montréal, QC H4P 1V5",
                collectionProduit.description());
        assertEquals(836.0, collectionProduit.getCout(), 0.0);
    }
}
