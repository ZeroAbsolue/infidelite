package com;

import org.junit.Test;
import org.junit.Before;

public class TransportCommunTest {
    Produit ticketTransportEnCommun;

    @Before
    public void setup() {
        ticketTransportEnCommun = new TransportCommun("Transport commun", Type.URBAIN, 3.50, 2);

    }

    // @Test
    // public void constructeurTest() {
    //     assertEquals("Transport commun", ticketTransportEnCommun.getNom());
    //     assertEquals(3.50, ticketTransportEnCommun.getPrix());
    //     assertEquals(2, ticketTransportEnCommun.getNombreHeures());
    //     assertEquals(0.35, ticketTransportEnCommun.getNombrePoints()); 
    //     assertEquals("URBAIN", ticketTransportEnCommun.getType()); 
    // }
}
