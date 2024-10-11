package antoniocostantini.DAO;



import antoniocostantini.entities.Libro;
import antoniocostantini.entities.Publicazione;
import antoniocostantini.entities.User;
import antoniocostantini.exceptions.NotFoundExceptionNotUUID;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.UUID;

public class UserDAO {
    private final EntityManager entityManager;

    public UserDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(User user) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(user);
        transaction.commit();
        System.out.println("USer  " + user.getNome() + " inserita con sucesso");

    }
    public User getByID(Long id) {
        User found = entityManager.find(User.class, id);
        if (found == null) throw new NotFoundExceptionNotUUID(id);
        return found;
    }

}
