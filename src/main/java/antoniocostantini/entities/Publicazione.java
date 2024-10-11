package antoniocostantini.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "publicazioni")
public abstract class Publicazione {
    @Id
    @GeneratedValue
    private UUID ISBN;
    private String titolo;
    private int anno_publicazione;
    private int n_pagine;
    @OneToMany(mappedBy = "publicazione")
    private List<Prestito> inprestito = new ArrayList<>();


    public Publicazione(String titolo, int anno_publicazione, int n_pagine) {
        this.titolo = titolo;
        this.anno_publicazione = anno_publicazione;
        this.n_pagine = n_pagine;
    }

    public Publicazione() {
    }

    public UUID getISBN() {
        return ISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnno_publicazione() {
        return anno_publicazione;
    }

    public void setAnno_publicazione(int anno_publicazione) {
        this.anno_publicazione = anno_publicazione;
    }

    public int getN_pagine() {
        return n_pagine;
    }

    public void setN_pagine(int n_pagine) {
        this.n_pagine = n_pagine;
    }

    @Override
    public String toString() {
        return "Publicazione{" +
                "ISBN=" + ISBN +
                ", titolo='" + titolo + '\'' +
                ", anno_publicazione=" + anno_publicazione +
                ", n_pagine=" + n_pagine +
                '}';
    }
}
