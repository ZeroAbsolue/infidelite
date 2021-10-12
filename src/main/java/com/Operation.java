package com;

import java.util.Date;

public class Operation {
    private Partenaire partenaire;
    private Date date;


    public Operation(Partenaire partenaire, Date date) {
        this.partenaire = partenaire;
        this.date = date;
    }

    public Partenaire getPartenaire() {
        return this.partenaire;
    }

    public void setPartenaire(Partenaire partenaire) {
        this.partenaire = partenaire;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
