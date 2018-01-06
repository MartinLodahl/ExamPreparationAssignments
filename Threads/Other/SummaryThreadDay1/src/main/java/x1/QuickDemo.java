/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x1;

/**
 *
 * @author MartinLodahl
 */
public class QuickDemo extends Thread{
  public static int COUNT_TIMES = 5;
  @Override
  public void run(){
    int counter = 0;
    while(counter < COUNT_TIMES){
      System.out.println("Hello Class");
      counter++;
      try {
        Thread.sleep(1000);        
      } catch (InterruptedException ex) {}
    }
  }
  public static void main(String[] args) {
    new QuickDemo().start(); //What is printed first, and what is wrong here
    System.out.println("#### Hello World ####");
  }
}
