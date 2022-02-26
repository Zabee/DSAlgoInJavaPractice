public class ThreadCreationSimpleDemo{
  
  //Runnable thread cannot run by itslef. Wrap it inside a Thread before calling start() method    
  private static class MyThreadRunnable implements Runnable{
    @Override
    public void run(){
      System.out.println("MyThreadRunnable doing some work here!!");
    }
  }
  
  private static class MyThread extends Thread{
    @Override
    public void run(){
      System.out.println("MyThread doing some work here!!");
    }
  }
  
  public static void main(String []args){
    MyThreadRunnable mrt = new MyThreadRunnable();
    Thread t1 = new Thread(mrt);
    t1.start();
    
    MyThread mt = new MyThread();
    mt.start();
    
    Runnable r = () -> System.out.println("Lambda thread doing some work here!");
    Thread t2 = new Thread(r);
    t2.start();
    
    Thread t3 = new Thread(() -> System.out.println("Another ananymous thread doing some work here!"));
    t3.start();
  }
}

/** Output
    MyThreadRunnable doing some work here!!
    MyThread doing some work here!!
    Lambda thread doing some work here!
    Another ananymous thread doing some work here!
**/
