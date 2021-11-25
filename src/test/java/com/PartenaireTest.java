package com;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.Modele.Abonne;
import com.Modele.Cadeau;
import com.Modele.CarteInfidelite;
import com.Modele.Partenaire;
import com.Modele.Produit;

import org.junit.Before;
import org.junit.Test;

public class PartenaireTest {
    Partenaire stm;
    Produit ticketParking;
    Produit ticketTransportEnCommun;
    Abonne nicolas;
    CarteInfidelite carte;
    Cadeau naya;

    @Before
    public void setup() {
        stm = new Partenaire("Societe de transport de montreal", "800 Rue De La Gauchetière O, Montréal, QC H5A 1J6");
        ticketParking = new Produit("Parking UQAM Pavillon SH", 25);
        ticketTransportEnCommun = new Produit("Transport commun", 3.50);
        carte = new CarteInfidelite(1000, 100);
        nicolas = new Abonne("Nicolas", carte);
        naya = new Cadeau("Eau mineral naya", 25, stm);

    }

    @Test
    public void constructorTest() {
        assertEquals("Societe de transport de montreal", stm.getNom());
        assertEquals("800 Rue De La Gauchetière O, Montréal, QC H5A 1J6", stm.getAdresse());
    }

    @Test
    public void listeDesProduitsTest() {
        stm.ajouterProduit(ticketParking);
        stm.ajouterProduit(ticketTransportEnCommun);
        assertEquals(
                "Partenaire: Societe de transport de montreal, adresse: 800 Rue De La Gauchetière O, Montréal, QC H5A 1J6\n"
                        + "Catalogue des produits:\n" + "Parking UQAM Pavillon SH, prix: 25.0$\n"
                        + "Transport commun, prix: 3.5$",
                stm.catalogueProduits());
    }

   

   
    @Test
    public void validerCarteTest() {
        assertTrue(stm.validerMontant(((Abonne) nicolas).getCarteInfidelite(), 50.0));
        assertTrue(stm.validerPoint(((Abonne) nicolas).getCarteInfidelite(), 10));
    }
}
