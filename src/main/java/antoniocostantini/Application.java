package antoniocostantini;

import antoniocostantini.DAO.PrestitoDAO;
import antoniocostantini.DAO.PublicazioneDAO;
import antoniocostantini.DAO.UserDAO;
import antoniocostantini.entities.*;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogobibliografico");

    public static void main(String[] args) {
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
//
        User usFromDb = udao.getByID(2L);
        Rivista rivDb = pdao.getRivista("20871c5c-4ece-48c2-9746-3539c8dd845f");

        Prestito pre = new Prestito(LocalDate.now(),usFromDb,rivDb);
        prdao.save(pre);
//        User us = new User("nome", "cognome", LocalDate.of(1978,3,12));
//
//        udao.save(us);
//
//        Prestito prest = new Prestito(LocalDate.now(),us,list);
//        prdao.save(prest);
        //        pdao.save(lib);



        prdao.getByUserId(2L).forEach(System.out::println);

        em.close();
        emf.close();
    }
}
