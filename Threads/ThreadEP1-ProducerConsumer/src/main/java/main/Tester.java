/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author MartinLodahl
 */
public class Tester {

    public static void main(String[] args) throws InterruptedException {

        ArrayBlockingQueue<Long> s1 = new ArrayBlockingQueue(40);
        ArrayBlockingQueue<Long> s2 = new ArrayBlockingQueue(40);

//        for (long i = 0; i < 30; i++) {
//            s1.add(i);
//        }
        s1.add(4l);
        s1.add(5l);
        s1.add(8l);
        s1.add(12l);
        s1.add(21l);
        s1.add(22l);
        s1.add(34l);
        s1.add(35l);
        Counter counter = new Counter(s1.size());

        ExecutorService es = Executors.newCachedThreadPool();
        //Create and start the four Producers (P1-P4)
        createProducers(4, es, s1, s2);

        //Create and start the single Consumer Thead (P1)
        es.execute(new Consumer(s2, counter));

        es.shutdown();
        es.awaitTermination(5, TimeUnit.SECONDS);

    }

    static private void createProducers(int numberOfProducers, ExecutorService es, ArrayBlockingQueue s1, ArrayBlockingQueue s2) {
        for (int i = 0; i < numberOfProducers; i++) {
            es.execute(new Producer(s1, s2));
        }
    }

}
