package com;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;    
    
public class ParkingTest {
    Produit ticketParking; 
    @Before
    public void setup(){
        ticketParking = new Parking("Parking UQAM Pavillon SH", 25, 0.15);
    }
        
    @Test
    public void constructorTest() {
        assertEquals("Parking UQAM Pavillon SH", ticketParking.getNom());
        assertEquals(25, ticketParking.getPrix(),0.0);
        assertEquals(0.15, ((Parking)ticketParking).getNombreHeures(),0.0);
        assertEquals(2.5, ticketParking.getNombrePoints(),0.0); 
    }
}
    