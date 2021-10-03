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
        assertEquals(2.50, biscuit.getPrix());
        assertEquals(0.25, biscuit.getNombrePoint());
    }
    
    @Test 
    public void toStringTest() {
        assertEquals("Produit: Biscuit, prix: 3.50$, point(s): 0.25/r/n", biscuit);
    }
}
    