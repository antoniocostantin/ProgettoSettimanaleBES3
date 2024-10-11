package antoniocostantini.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero_tessera;

    private String nome;
    private String cognome;
    private LocalDate data_nascita;

    @OneToMany(mappedBy = "user")
    private List<Prestito> prestiti = new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
                "numero_tessera=" + numero_tessera +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", data_nascita=" + data_nascita +
                '}';
    }

    public User() {
    }

    public User(String nome, String cognome, LocalDate data_nascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.data_nascita = data_nascita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData_nascita() {
        return data_nascita;
    }

    public void setData_nascita(LocalDate data_nascita) {
        this.data_nascita = data_nascita;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Long getNumero_tessera() {
        return numero_tessera;
    }

    public void setNumero_tessera(Long numero_tessera) {
        this.numero_tessera = numero_tessera;
    }
}
