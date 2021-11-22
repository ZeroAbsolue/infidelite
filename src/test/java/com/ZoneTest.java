package com;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import com.Modele.Partenaire;
import com.Modele.Zone;

import org.junit.Before;

public class ZoneTest {
    Zone sainteCatherine;
    Partenaire stm;
    Partenaire saq;
    

    @Before
    public void setup() {
        sainteCatherine = new Zone("Sainte catherine", "J5C");
        stm = new Partenaire("Societe de transport de montreal", "800 Rue De La Gauchetière O, Montréal, QC H5A 1J6");
        saq = new Partenaire("Société des alcools du Québec", "1747 Rue De La Rue Berri, Montréal, QC H3L 2H3");

    }

    @Test
    public void constructortest() {
        assertEquals("Sainte catherine", sainteCatherine.getNom());
       assertEquals("J5C", sainteCatherine.getCodePostal());
    }
   
    @Test
    public void listerLesPartenairesTest() {
        sainteCatherine.ajouterPartenaire(stm);
        // sainteCatherine.ajouterPartenaire(saq);
        assertEquals(
                "Zone de Sainte catherine, code postal: J5C\nListe des partenaires:\nPartenaire: Societe de transport de montreal, adresse: 800 Rue De La Gauchetière O, Montréal, QC H5A 1J6",
                sainteCatherine.listerLesPartenaires());
        sainteCatherine.retirerPartenaire(stm);
        
        assertEquals("Zone de Sainte catherine, code postal: J5C\nAucun partenaire",
                sainteCatherine.listerLesPartenaires());

    }
}
