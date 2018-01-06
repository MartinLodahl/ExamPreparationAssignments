/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sharecounter;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author MartinLodahl
 */
public class Counter {
    private int value;
    
    ReentrantLock lock = new ReentrantLock();
    //public synchronized void inc(){
    public void inc(){
        lock.lock();
        value++;
        lock.unlock();
//        int temp = value;
//        temp++;
//        value = temp;
    }

    public int getValue() {
        return value;
    }
    
}
