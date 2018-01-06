/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sharecounter;

/**
 *
 * @author MartinLodahl
 */
public class LarsTester {

    public static void main(String[] args) throws InterruptedException {
        int max = 10000;
        Counter shared = new Counter();
        
        Thread t1 = new Thread(new CountUser(shared, max));
        Thread t2 = new Thread(new CountUser(shared, max));
        Thread t3 = new Thread(new CountUser(shared, max));
        Thread t4 = new Thread(new CountUser(shared, max));
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("Result:" + shared.getValue());
    }

}
