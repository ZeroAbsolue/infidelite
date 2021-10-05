package com;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;    
    
public class ProduitTest {
    Produit biscuit;
    @Before
    public void setup(){
        biscuit = new Produit("Biscuit",2.50);
    }
        
    @Test
    public void constructeurTest() {
        assertEquals("Biscuit", biscuit.getNom());
        assertEquals(2.50, biscuit.getPrix(),0.0);
        assertEquals(0.25, biscuit.getNombrePoints(),0.0);
    }
    
    @Test 
    public void toStringTest() {
            assertEquals("Biscuit, prix: 2.5$", biscuit.toString());
    }
}
    