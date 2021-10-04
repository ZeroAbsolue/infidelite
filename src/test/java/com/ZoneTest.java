package com;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

public class ZoneTest {
    Zone sainteCatherine;
    Partenaire stm;

    @Before
    public void setup() {
        sainteCatherine = new Zone("Sainte catherine", "J5C");
        stm = new Partenaire("Societe de transport de montreal", "800 Rue De La Gauchetière O, Montréal, QC H5A 1J6");
    }

    @Test
    public void constructortest() {
        assertEquals("Sainte catherine", sainteCatherine.getNom());
        assertEquals("J5C", sainteCatherine.getCodePostal()); 
    }

    // @Test
    // public void listerLesPartenairesTest() {
    //     sainteCatherine.ajouterPartenaire(stm);
    //     assertEquals(
    //             "Zone de Sainte catherine, code postal: J5C/r/nListe des partenaires:/r/nPartenaire: Societe de transport de montreal, adresse: 800 Rue De La Gauchetière O, Montréal, QC H5A 1J6",
    //             sainteCatherine.listerLesPartenaires());
    //     sainteCatherine.retirerPartenaire(stm);
    //     assertEquals("Zone de Sainte catherine, code postal: J5C/r/nAucun partenaire",
    //             sainteCatherine.listerLesPartenaires());

    // }
}
