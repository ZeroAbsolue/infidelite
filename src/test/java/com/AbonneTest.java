package com;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.Modele.Abonne;
import com.Modele.CarteInfidelite;
import com.Modele.Partenaire;
import com.Modele.Produit;

import org.junit.Before;
import org.junit.Test;

public class AbonneTest {
    Abonne nicolas;
    CarteInfidelite carte;
    Produit ticketParking;
    Partenaire stm;
    Partenaire rtl;
    Produit ticketTransportEnCommun;

    @Before
    public void setup() {
        carte = new CarteInfidelite(1000, 100);
        nicolas = new Abonne("Nicolas", carte);
        ticketParking = new Produit("Parking UQAM Pavillon SH", 25);
        stm = new Partenaire("Societe de transport de montreal", "800 Rue De La Gauchetière O, Montréal, QC H5A 1J6");
        rtl = new Partenaire("Reseau de transport de longueuil", "800 Rue De La Gauchetière O, Montréal, QC H5A 1J6");
        ticketTransportEnCommun = new Produit("Transport commun",3.50);
        nicolas = new Abonne("Nicolas", carte);
    }

    @Test
    public void test() {
        assertEquals("Nicolas", nicolas.getNom());
    }

    @Test
    public void isVuptTest() {
        assertFalse(((Abonne) nicolas).isVup());
        ((Abonne) nicolas).setVup(true);
        assertTrue(((Abonne) nicolas).isVup());
    }

   
}
