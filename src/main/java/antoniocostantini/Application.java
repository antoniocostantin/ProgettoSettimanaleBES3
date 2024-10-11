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
//        User us = new User("nome", "cognome", LocalDate.of(1978,3,12));
//
//        udao.save(us);
//
//        Prestito prest = new Prestito(LocalDate.now(),us,list);
//        prdao.save(prest);
        //        pdao.save(lib);


        System.out.println(pdao.getPublicazione("2ce94ce7-84b3-4a24-b224-a16f507b4177"));

        prdao.getByUserId(2L).forEach(System.out::println);

        em.close();
        emf.close();
    }
}
