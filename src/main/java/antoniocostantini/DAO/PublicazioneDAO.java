package antoniocostantini.DAO;

import antoniocostantini.entities.Libro;
import antoniocostantini.entities.Prestito;
import antoniocostantini.entities.Publicazione;
import antoniocostantini.entities.Rivista;
import antoniocostantini.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.UUID;

public class PublicazioneDAO {
    private final EntityManager entityManager;

    public PublicazioneDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Publicazione publicazione) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(publicazione);
        transaction.commit();
        System.out.println("Publicazione " + publicazione.getTitolo() + " inserita con sucesso");

    }

    public Publicazione getPublicazione(String id) {
        Publicazione found = entityManager.find(Publicazione.class, UUID.fromString(id));
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    public Libro getLibro(String id) {
        Libro found = entityManager.find(Libro.class, UUID.fromString(id));
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    public Rivista getRivista(String id) {
        Rivista found = entityManager.find(Rivista.class, UUID.fromString(id));
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    public void deleteByID(String id) {
        Publicazione found = this.getPublicazione(id);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();
        System.out.println("Publicazione " + found.getTitolo() + " eliminata con sucesso");
    }

    public List<Publicazione> findByYear(int year) {
        TypedQuery<Publicazione> query = entityManager.createQuery("SELECT p FROM Publicazione p WHERE p.anno_publicazione = :year", Publicazione.class);
        query.setParameter("year", year);
        return query.getResultList();
    }

    public List<Publicazione> findByTitolo(String titolo) {
        TypedQuery<Publicazione> query = entityManager.createQuery("SELECT p FROM Publicazione p WHERE lower(p.titolo) like lower(concat('%', :titolo,'%')) ", Publicazione.class);
        query.setParameter("titolo", titolo);
        return query.getResultList();
    }

    public List<Libro> getByAuthor(String author) {
        TypedQuery<Libro> query = entityManager.createQuery("SELECT p FROM Libro p WHERE lower(p.autore) = lower(:author) ", Libro.class);
        query.setParameter("author", author);
        return query.getResultList();
    }
}
