package Controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadExe {


    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new MyThread1();
            service.execute(worker);
        }
        service.shutdown();

        Thread myThread = new Thread(new Terminator(service));
        myThread.start();
    }
}

class Terminator implements Runnable{
    ExecutorService service;

    public Terminator(ExecutorService service){
        this.service = service;
    }

    @Override
    public void run() {
        while(!service.isTerminated());
        System.out.println("task has been done and shutdown has been done.");
    }
}

class MyThread1 extends Thread{
    @Override
    public void run() {
        System.out.println("My Name is Khan " + Thread.currentThread().getName());
        System.out.println("Kabhi khushi kabhi gum " + Thread.currentThread().getName());
        System.out.println("Kuch Kuch hota hai " + Thread.currentThread().getName());
    }
}
