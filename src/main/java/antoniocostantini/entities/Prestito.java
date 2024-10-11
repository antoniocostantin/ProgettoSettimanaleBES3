package antoniocostantini.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "prestiti")
public class Prestito {
    @Id
    @GeneratedValue
    private UUID id;

    private LocalDate data_inizio;
    private LocalDate data_fine_prevista;
    private LocalDate data_fine_effettiva;
    @ManyToOne
    private User user;
    @ManyToOne
    @JoinColumn(name = "publicazione_id")
    private Publicazione publicazione ;


    public Prestito(LocalDate data_inizio, User user, Publicazione publicazione) {
        this.data_inizio = data_inizio;
        this.data_fine_prevista = data_inizio.plusDays(30);
        this.user = user;
        this.publicazione = publicazione;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", data_inizio=" + data_inizio +
                ", data_fine_prevista=" + data_fine_prevista +
                ", data_fine_effettiva=" + data_fine_effettiva +
                ", user=" + user +
                ", publicazione=" + publicazione +
                '}';
    }

    public Prestito() {
    }


    public LocalDate getData_fine_prevista() {
        return data_fine_prevista;
    }

    public void setData_fine_prevista(LocalDate data_fine_prevista) {
        this.data_fine_prevista = data_fine_prevista;
    }

    public LocalDate getData_inizio() {
        return data_inizio;
    }

    public void setData_inizio(LocalDate data_inizio) {
        this.data_inizio = data_inizio;
    }

    public LocalDate getData_fine_effettiva() {
        return data_fine_effettiva;
    }

    public void setData_fine_effettiva(LocalDate data_fine_effettiva) {
        this.data_fine_effettiva = data_fine_effettiva;
    }

    public Publicazione getPublicazione() {
        return publicazione;
    }

    public void setPublicazioniprestate(Publicazione publicazioniprestate) {
        this.publicazione = publicazioniprestate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
