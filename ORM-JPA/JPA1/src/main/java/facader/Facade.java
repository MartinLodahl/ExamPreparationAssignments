package facader;

import entity.Customer;
import entity.ItemType;
import entity.Orderline;
import entity.Ordero;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author MartinLodahl
 */
public class Facade {

    EntityManagerFactory emf;

    EntityManager em;

    public Facade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    //Customer
    public void createCustomer(Customer cust) {
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(cust);
        em.getTransaction().commit();
        em.close();
    }

    public Customer getCustomer(long id) {
        em = getEntityManager();
        em.getTransaction().begin();
        Customer cus = em.find(Customer.class, id);
        em.getTransaction().commit();
        em.close();

        return cus;
    }

    public List<Customer> getCustomers() {

        EntityManager em = emf.createEntityManager();

        List<Customer> users = null;

        try {
            em.getTransaction().begin();
            users = em.createQuery("Select u from User u").getResultList();
            em.getTransaction().commit();
            return users;
        } finally {
            em.close();
        }

////        long i = 1;
////        List<Customer> returnList = new ArrayList();
////        while (true) {
////            Customer cus = getCustomer(i);
////            if (cus != null) {
////                returnList.add(cus);
////            } else {
////                break;
////            }
////            i++;
////        }
////        return returnList;
    }

    public void deleteCustomer(long id) {
        em = getEntityManager();
        em.getTransaction().begin();
        Customer cus = em.find(Customer.class, id);
        em.remove(cus);
        em.getTransaction().commit();
        em.close();
    }

    public void editCustomer(Customer dust) {
        em = getEntityManager();
        em.getTransaction().begin();
        em.merge(dust);
        em.getTransaction().commit();
        em.close();
    }

    //Order
    public void createOrder(Ordero order) {
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(order);
        em.getTransaction().commit();
        em.close();
    }

    public void setOrderToCus(Ordero ord, long cus_ID) {
        Customer cus = new Customer();
        cus.setId(cus_ID);
        cus.addOrder(ord);
        editCustomer(cus);
    }

    public Ordero findOrder(long id) {
        em = getEntityManager();
        em.getTransaction().begin();
        Ordero ord = em.find(Ordero.class, id);
        em.getTransaction().commit();
        em.close();

        return ord;
    }

    //ItemType
    public void createItemType(ItemType item) {
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(item);
        em.getTransaction().commit();
        em.close();
    }

    //OrderLine
    public void createOrderline(Orderline ol) {
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(ol);
        em.getTransaction().commit();
        em.close();
    }

    //TotalPrice Calc //Find the total price of an order
    public double calcPrice(long ordero_ID) {
        double price = 0;

        Ordero or = findOrder(ordero_ID);
        price+=calcOrderPrice(or, price);
        return price;
    }

    public double calcPriceFromCus(long cusID) {
        double price = 0;
        Customer cus = getCustomer(cusID);
        List<Ordero> list = cus.getOrderList();
        for (int i = 0; i < list.size(); i++) {
            price+=calcOrderPrice(list.get(i), price);
        }
        return price;
    }
    
    public double calcOrderPrice(Ordero or, double price){
        List<Orderline> ol = or.getOrderList();
        for (int i = 0; i < ol.size(); i++) {
            price += ol.get(i).getCost();
        }
        return price;
    }

}
