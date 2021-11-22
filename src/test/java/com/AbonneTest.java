package com;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.Modele.Abonne;
import com.Modele.CarteInfidelite;
import com.Modele.Parking;
import com.Modele.Partenaire;
import com.Modele.Produit;
import com.Modele.TransportCommun;
import com.Modele.Type;

import org.junit.Before;

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
        ticketParking = new Parking("Parking UQAM Pavillon SH", 25, 0.15);
        stm = new Partenaire("Societe de transport de montreal", "800 Rue De La Gauchetière O, Montréal, QC H5A 1J6");
        rtl = new Partenaire("Reseau de transport de longueuil", "800 Rue De La Gauchetière O, Montréal, QC H5A 1J6");
        ticketTransportEnCommun = new TransportCommun("Transport commun", Type.URBAIN, 3.50, 2);
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

    @Test
    public void bonusInfidelite() throws CloneNotSupportedException {
        stm.vendre(ticketParking, 1,nicolas); 
        rtl.vendre(ticketParking, 1,nicolas); 
        nicolas.calculerBonusInfidelite();
        assertEquals(120, nicolas.getNombrePoints(),0.0);
    }
}
