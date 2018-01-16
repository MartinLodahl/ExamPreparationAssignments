package EXAMJPA;

import entities.Booking;
import entities.Image;
import entities.Kayak;
import entities.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author MartinLodahl
 */
public class FacadeJPA {
     EntityManagerFactory emf;

    EntityManager em;

    public FacadeJPA(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    //User
    //Create a user
    public void createUser(User user) {
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    
    //Find a user by name .. totally useless.
    public User getAUserByName(String name) {
        List<User> users = getUsers();
        User user = null;
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getName().equals(name)){
                user = users.get(i);
                break;
            }      
        }
        return user;
    }
    //Find a user by id - Actually using identificator.
    public User getUserByID(int id){
        em = getEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, id);
        em.getTransaction().commit();
        em.close();
        return user;
    }

    //Get all users
    public List<User> getUsers() {
        EntityManager em = emf.createEntityManager();
        List<User> users = null;
        try {
            em.getTransaction().begin();
            users = em.createQuery("Select u from User u").getResultList();
            em.getTransaction().commit();
            return users;
        } finally {
            em.close();
        }
    }

   //Kayak
    //Create a kayak
    public void createKayak(Kayak kayak) {
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(kayak);
        em.getTransaction().commit();
        em.close();
    }
    
    //Find a Kayak .. by id I assume.
    public Kayak getKayakById(int id){
        em = getEntityManager();
        em.getTransaction().begin();
        Kayak kayak = em.find(Kayak.class, id);
        em.getTransaction().commit();
        em.close();
        return kayak;
    }
    
    //Create a booking
    public void createBooking(Booking book){
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
        em.close();
    }
    //Get all Kayaks with images
    public List<Image> getAllKayaksWithImages(){
          EntityManager em = emf.createEntityManager();
        List<Image> images = null;
        //List<Kayak> kayaks = null;
        try {
            em.getTransaction().begin();
            images = em.createQuery("Select i from Image i").getResultList();
            em.getTransaction().commit();
        /*  for (int i = 0; i < images.size(); i++) {
                Kayak k = images.get(i).getKayak();
                kayaks.add(k);
            }*/
            return images;
        } finally {
            em.close();
        }
    }
    //Get all bookings
    public List<Booking> getAllBookings(){
          EntityManager em = emf.createEntityManager();
        List<Booking> bookings = null;
        try {
            em.getTransaction().begin();
            bookings = em.createQuery("Select b from Booking b").getResultList();
            em.getTransaction().commit();
            return bookings;
        } finally {
            em.close();
        }
    }
    //Get all bookings with userId
    public List<Booking> getAllBookingsPerUserId(int id){
          EntityManager em = emf.createEntityManager();
        List<Booking> bookings = null;
        try {
            em.getTransaction().begin();       
            TypedQuery<Booking> query = em.createQuery("Select b from Booking b where b.user.id = :id", Booking.class);
            query.setParameter("id", id);  
            bookings =  query.getResultList();
            em.getTransaction().commit();
            return bookings;
        } finally {
            em.close();
        }
    }
    //Create image for Kayak
    public void createImage(Image i){
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(i);
        em.getTransaction().commit();
        em.close();
    }
    
}
