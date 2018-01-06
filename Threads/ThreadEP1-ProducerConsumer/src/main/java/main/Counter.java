/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author MartinLodahl
 */
public class Counter {
    
    private int counter;
    
    Counter(int counter){
        this.counter = counter;
    }
    
    public synchronized void decrease(){
        counter--;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
    
    
}
