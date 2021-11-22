package com;

import static org.junit.Assert.assertEquals;

import com.Modele.CarteInfidelite;

import org.junit.Before;
import org.junit.Test;

public class CarteInfideliteTest {
    CarteInfidelite carte;

    @Before
    public void setup() {
        carte = new CarteInfidelite(1000, 100);
    }

    @Test
    public void constructeurTest() {
        assertEquals(1000.0, carte.getSolde(), 0.0);
        assertEquals(100.0, carte.getNombrePoints(), 0.0);
    }

    @Test
    public void chargerTest() {
        carte.charger(500);
        assertEquals(1500, carte.getSolde(), 0.0);

    }

    @Test
    public void deduireSoldeTest() {
        carte.deduireSolde(200);
        assertEquals(800, carte.getSolde(), 0.0);
    }

    @Test
    public void deduirePointTest() {
        carte.deduirePoint(10);
        assertEquals(90, carte.getNombrePoints(), 0.0);
    }

    @Test
    public void augmenterPointTest() {
        carte.augmenterPoint(10);
        assertEquals(110, carte.getNombrePoints(), 0.0);
    }
}
