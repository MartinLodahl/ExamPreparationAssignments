/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facader;

import entity.Event;
import entity.Pet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author MartinLodahl
 */
public class PetFacade {   
    EntityManagerFactory emf;

    public PetFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public List<Pet> getAllPets(){
        List<Pet> lp = new ArrayList();
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Pet.findAll", Pet.class);
        lp = query.getResultList();
        return lp;
    }
    public List<Event> findEventByDate(int day, int month, int year){
        List<Event> le = new ArrayList();
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Event.findByDate", Event.class);
        query.setParameter("date", new Date(year+102, month+5,day-1));
        le = query.getResultList();
        System.out.println(new Date(year+102, month+5,day-1).toString());
        return le;
    }

    public void createEvent(Event e) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }
}
