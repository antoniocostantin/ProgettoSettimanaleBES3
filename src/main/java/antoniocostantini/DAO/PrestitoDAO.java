package antoniocostantini.DAO;

import antoniocostantini.entities.Libro;
import antoniocostantini.entities.Prestito;
import antoniocostantini.entities.Publicazione;
import antoniocostantini.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;


import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class PrestitoDAO {
    private  final EntityManager entityManager;

    public PrestitoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Prestito prestito) {
        if (isSospeso(prestito)) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(prestito);
            transaction.commit();
            System.out.println("Prestito" + prestito.getUser() + " saved");
        } else System.out.println("Prestito" + prestito.getUser() + " not saved");
    }

    public boolean isSospeso(Prestito prestito) {
        TypedQuery<Prestito> query = entityManager.createQuery("SELECT p FROM Prestito p WHERE p.data_fine_prevista <= local date or p.data_fine_effettiva IS NULL ", Prestito.class);
        List<Prestito> prestiti = query.getResultList().stream().filter(p -> Objects.equals(p.getUser().getNumero_tessera(), prestito.getUser().getNumero_tessera())).toList();
        System.out.println("-----------------------------------------");
        prestiti.forEach(System.out::println);
        return prestiti.isEmpty();

    }

    public Prestito findById(String id) {
    Prestito found = entityManager.find(Prestito.class, UUID.fromString(id));
    if (found == null) throw new NotFoundException(id);
    return found;
    }

    public List<Publicazione> getByUserId(Long userId) {
        TypedQuery<Publicazione> query = entityManager.createQuery("SELECT p.publicazione FROM Prestito p WHERE p.user.numero_tessera = :userId ", Publicazione.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    public List<Prestito> findScaduti() {
        TypedQuery<Prestito> query = entityManager.createQuery("SELECT p FROM Prestito p where p.data_fine_prevista <= local date ", Prestito.class);
        return query.getResultList();
    }

    public List<Prestito> findNonRestituito(){
        TypedQuery<Prestito> query = entityManager.createQuery("SELECT p FROM Prestito p where p.data_fine_effettiva IS NULL ", Prestito.class);
        return query.getResultList();
    }

}
