package antoniocostantini.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "riviste")
public class Rivista extends Publicazione {
    @Enumerated(EnumType.STRING)
    private Periodicità periodicità;

    public Rivista(String titolo, int anno_publicazione, int n_pagine, Periodicità periodicità) {
        super(titolo, anno_publicazione, n_pagine);
        this.periodicità = periodicità;
    }

    public Periodicità getPeriodicità() {
        return periodicità;
    }

    public void setPeriodicità(Periodicità periodicità) {
        this.periodicità = periodicità;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "periodicità=" + periodicità +
                "} " + super.toString();
    }

    public Rivista() {
    }
}
