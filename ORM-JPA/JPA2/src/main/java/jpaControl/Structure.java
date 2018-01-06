/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaControl;

import entity.Book;
import entity.EBook;
import entity.PaperBook;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MartinLodahl
 */
public class Structure {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPU");
        EntityManager em = emf.createEntityManager();
        EBook eb = new EBook("WWW.1.COM", 22, "Peter", 828, "Nice Java");
        //CRUD
        //Create - Read - Update - Delete
        em.getTransaction().begin();
        em.persist(eb);
        System.out.println(em.find(EBook.class, eb.getIsbn()).toString());
        eb.setAuthor("Stephan");
        eb.setDownloadUrl("CPHBUSINESS.DK");
        eb.setPrice(2323);
        eb.setSizeMB(222);
        eb.setTitle("En masse banditter");
        em.merge(eb);
        System.out.println(em.find(EBook.class, eb.getIsbn()).toString());
        EBook eb1 = new EBook("Ali.DK", 2323, "Christians Lovløse Banditter", 29, "The bestest of best books");
        PaperBook pb2 = new PaperBook(25, true, "AliBaba", 29, "The Greatest of best books");
        EBook eb3 = new EBook("Svend-Ali.DK", 2323, "Svend-Alis bogklub", 29, "The story of a man called Daaaario");
        List<Book> list = new ArrayList<Book>();
        list.add(eb1);
        list.add(pb2);
        list.add(eb3);
        for (int i = 0; i < list.size(); i++) {
            em.persist(list.get(i));
        }

        em.getTransaction().commit();

        em.getTransaction().begin();
        EBook ebr = em.find(EBook.class, eb.getIsbn());
        em.remove(ebr);
        em.getTransaction().commit();
        em.close();
    }

}
