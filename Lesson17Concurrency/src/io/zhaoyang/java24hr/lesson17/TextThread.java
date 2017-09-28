package io.zhaoyang.java24hr.lesson17;

public class TextThread {

public static void main(String[] args) { 
   TxtThread tt = new TxtThread(); 
   new Thread(tt).start(); 
   new Thread(tt).start(); 
   new Thread(tt).start(); 
   new Thread(tt).start(); 
} 
}

class TxtThread implements Runnable { 
int num = 10; 
String str = new String();

public void run() { 
   synchronized (str) { 
    while (num > 0) {

     try { 
      Thread.sleep(1); 
     } catch (Exception e) { 
      e.getMessage(); 
     } 
     System.out.println(Thread.currentThread().getName() 
       + "this is " + num--); 
    } 
   } 
} 
}