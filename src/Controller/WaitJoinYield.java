package Controller;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class WaitJoinYield {

    public static void main(String[] args) {
        //runWaitNotify();
        runJoin();
    }

    public static void runJoin(){
        AtomicInteger count = new AtomicInteger(0);
        Thread thread1 = new Thread(()->{
            for(int i = 0;i<10000; i++){
                count.incrementAndGet();
            }
        });
        Thread thread2 = new Thread(()->{
            for(int i = 0;i<10000; i++){
                count.incrementAndGet();
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        System.out.println(count.get());
    }

    public static void runWaitNotify(){
        Processor processor = new Processor();
        //thread wait and notify part..
        Thread thread1 = new Thread(() -> {
            try {
                processor.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                processor.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        });

        thread1.start();
        thread2.start();
    }
}

class Processor{
    public void produce() throws InterruptedException{
        synchronized (this) {
            System.out.println("Produces is started.... ");
            wait();
            System.out.println("job is resumed");
        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(3000);
        Scanner scan = new Scanner(System.in);
        synchronized (this){
            System.out.println("please press Enter to continue..");
            scan.nextLine();
            System.out.println("notifying methods..");
            notify();
        }
    }
}
