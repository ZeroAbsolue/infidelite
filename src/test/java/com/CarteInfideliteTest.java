package com;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;

public class CarteInfideliteTest {
    CarteInfidelite carte;

    @Before
    public void setup() {
        carte = new CarteInfidelite(1000, 100);
    }

    @Test
    public void constructeurTest() {
        assertEquals(1000, carte.getSolde());
        assertEquals(100, carte.getNonbrePoints());
    }

    @Test
    public void chargerTest() {
        carte.charger(500);
        assertEquals(1500, carte.getSolde());

    }

    @Test
    public void deduireSoldeTest() {
        carte.deduireSolde(200);
        assertEquals(1300, carte.getSolde());
    }

    @Test
    public void deduirePointTest() {
        carte.deduirePoint(10);
        assertEquals(90, carte.getNombrePoints());
    }
}
