package com;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

public class VilleTest {
    Ville montreal;
    Zone sherbrooke;
    Zone sainteCatherine;

    @Before
    public void setup() {
        montreal = new Ville("Montreal", 36565);
        sherbrooke = new Zone("Sherbrooke Bromptonville", "J1C");
        sainteCatherine = new Zone("Sainte catherine", "J5C");

    }

    @Test
    public void construtorTest() {
        assertEquals("Montreal", montreal.getNom());
        assertEquals(36565, montreal.getSuperficie(), 0.0);
    }

    @Test
    public void listeDesZoneTest() {
        montreal.ajouterZone(sherbrooke);
        montreal.ajouterZone(sainteCatherine);
        assertEquals(
                "Ville de Montreal, Superficie: 36565.0\nListe des zones:\nZone de Sherbrooke Bromptonville, code postal: J1C\nZone de Sainte catherine, code postal: J5C",
                montreal.listerLesZones());
        montreal.retirerZone(sainteCatherine);
        assertEquals(
                "Ville de Montreal, Superficie: 36565.0\nListe des zones:\nZone de Sherbrooke Bromptonville, code postal: J1C",
                montreal.listerLesZones());
        montreal.retirerZone(sherbrooke);
        assertEquals("Ville de Montreal, Superficie: 36565.0\nAucune zone", montreal.listerLesZones());

    }
}
