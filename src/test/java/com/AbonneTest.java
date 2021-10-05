package com;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;

public class AbonneTest {
    Client nicolas;
    CarteInfidelite carte;

    @Before
    public void setup() {
        carte = new CarteInfidelite(1000,100);
        nicolas = new Abonne("Nicolas", carte);
    }

    @Test
    public void test() {
        assertEquals("Nicolas", nicolas.getNom());
    }

    @Test
    public void isVuptTest() {
        assertFalse(((Abonne)nicolas).isVup());
        ((Abonne)nicolas).setVup(true);
        assertTrue(((Abonne)nicolas).isVup());
    }
}
