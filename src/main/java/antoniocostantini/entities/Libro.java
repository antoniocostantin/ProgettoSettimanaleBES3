package antoniocostantini.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "libri")
public class Libro extends Publicazione {
    private String autore;
    private String genere;

    public Libro(String titolo, int anno_publicazione, int n_pagine, String autore, String genere) {
        super(titolo, anno_publicazione, n_pagine);
        this.autore = autore;
        this.genere = genere;
    }

    public Libro(String autore, String genere) {
        this.autore = autore;
        this.genere = genere;
    }

    public Libro() {
    }

    @Override
    public String toString() {
        return "Libro{" +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                "} " + super.toString();
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }
}
