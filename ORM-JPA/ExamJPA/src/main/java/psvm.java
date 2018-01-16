
import EXAMJPA.FacadeJPA;
import entities.Booking;
import entities.Image;
import entities.Kayak;
import entities.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MartinLodahl
 */
public class psvm {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
        
        FacadeJPA f = new FacadeJPA(emf);
        
      //  User user = new User("Per", "1123234"); f.createUser(user);
      
      //  Kayak kayak = new Kayak("Den Sorte Ulv", "12ss31211d", "Den er sort, og den er farlig", 1979, "Sort", 30.2);f.createKayak(kayak);
        
      //  Kayak kayak2 = f.getKayakById(2); Image image = new Image("www.w3.com/kayak.jpg", kayak2);f.createImage(image);
        
       // User user = f.getUserByID(51);Kayak kayak = f.getKayakById(2);
       // Booking booking = new Booking(user, kayak, new Date(1522216091974l)); f.createBooking(booking);
       
        /*System.out.println(f.getAUserByName("Per").toString());
        System.out.println(f.getUserByID(1).getName());
        List<User> lu = f.getUsers();
        for (int i = 0; i < lu.size(); i++) {
            System.out.println(lu.get(i).getName());
        }
        System.out.println(f.getKayakById(52).getColor());
        List<Image> li = f.getAllKayaksWithImages();
        for (int i = 0; i < li.size(); i++) {
            System.out.println(li.get(i).getKayak().getId());
            
        }
      List<Booking> lb = f.getAllBookings();
        for (int i = 0; i < lb.size(); i++) {
            System.out.println(lb.get(i).getUser().getName());
            System.out.println(lb.get(i).getKayak().getYear());
            
        }*/
      List<Booking> lba = f.getAllBookingsPerUserId(1);
        for (int i = 0; i < lba.size(); i++) {
            System.out.println(lba.get(i).getUser().getName());
            System.out.println(lba.get(i).getKayak().getId());
            
        }
    }
}
