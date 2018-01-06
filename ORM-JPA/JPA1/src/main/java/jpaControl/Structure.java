/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaControl;

import entity.Customer;
import entity.ItemType;
import entity.Ordero;
import entity.Orderline;
import facader.Facade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MartinLodahl
 */
public class Structure {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPU");
        Facade f = new Facade(emf);

        f.createCustomer(new Customer());

        Ordero or = new Ordero();
        Orderline orderline = new Orderline();
        orderline.setQuantity(2);
        orderline.setItem(new ItemType("Test1", "Test1", 23));
        or.addOrderList(orderline);
        f.setOrderToCus(or, 0);
        
        f.createOrder(new Ordero());
        
        f.createItemType(new ItemType());
        
        f.createOrderline(new Orderline());

        System.out.println(f.calcPrice(4));
    }

}
