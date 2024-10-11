package antoniocostantini;

import antoniocostantini.DAO.PrestitoDAO;
import antoniocostantini.DAO.PublicazioneDAO;
import antoniocostantini.DAO.UserDAO;
import jakarta.persistence.*;


public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogobibliografico");

    public static void main(String[] args) {

        //Ho optato per un doppio manytoone perchè ho immaginato che un utente possa fare più prestiti
        // magari con una gestione del salvataggio del prestito che controlla se ha prestiti in sospeso
        EntityManager em = emf.createEntityManager();

        PublicazioneDAO pdao = new PublicazioneDAO(em);
        UserDAO udao = new UserDAO(em);
        PrestitoDAO prdao = new PrestitoDAO(em);

//        Libro lib = new Libro("libr2",1598, 240,"nostmus","gee");
//        Libro lib2 = new Libro("libr3",2000, 248,"nomus","gauee");
//        Rivista riv = new Rivista("tutu ", 2014,23,Periodicità.SEMESTRALE);
//        pdao.save(lib);
//        pdao.save(lib2);
//        pdao.save(riv);
//
//        List<Publicazione> list = new ArrayList<>();
//        list.add(lib);
//        list.add(lib2);
//        list.add(riv);

//        User user = udao.getByID(1L);
//        Libro lib = new Libro("titolone", 2012, 54, "simpson", "nn so che dirti");
//        pdao.save(lib);
//        pdao.findByTitolo("titolone");
//
//        Prestito prestito = new Prestito(LocalDate.now().plusDays(34), user ,pdao.findByTitolo("titolone").getFirst());
//
//        prdao.save(prestito);
//       prdao.save(pre);
//
//        udao.save(us);
//
//        Prestito prest = new Prestito(LocalDate.now(),us,list);
//        prdao.save(prest);
        //        pdao.save(lib);

//        User us = new User("nomino", "mimino", LocalDate.of(1967,12,4));
//       udao.save(us);
//
//        User user = udao.getByID(2L);
//
//        Publicazione pub = pdao.getPublicazione("ad417178-0063-466c-be60-da90b14bbc27");
//
//        Prestito prestito = new Prestito(LocalDate.now(), user, pub);
//        prdao.save(prestito);
//
//        prdao.getByUserId(2L).forEach(System.out::println);
//        prdao.findNonRestituito().forEach(System.out::println);

        em.close();
        emf.close();
    }
}
