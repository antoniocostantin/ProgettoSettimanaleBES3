package antoniocostantini.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Prestito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private LocalDate data_inizio;
    private LocalDate data_fine_prevista;
    private LocalDate data_fine_effettiva;
    @ManyToMany(mappedBy = "inprestito")
    private List<Publicazione> publicazioniprestate = new ArrayList<>();

    @ManyToOne
    private User user;


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

    public List<Publicazione> getPublicazioniprestate() {
        return publicazioniprestate;
    }

    public void setPublicazioniprestate(List<Publicazione> publicazioniprestate) {
        this.publicazioniprestate = publicazioniprestate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
