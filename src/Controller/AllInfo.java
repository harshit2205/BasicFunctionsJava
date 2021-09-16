package Controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class AllInfo {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);

        service.execute(new Thread(() -> {System.out.println("Employee id is : 1000");}));
        service.execute(new Thread(() -> {System.out.println("Name of the Employee is Harshit Srivastava");}));
        service.execute(new Thread(() -> {System.out.println("Employee Address is Hanumat Nagar, Bhagwanpur, Varanasi");}));
        service.shutdown();

    }
}

class Worker extends Thread{

    Semaphore sem = new Semaphore(0);

    @Override
    public void run() {
        fetchEmpId();
        fetchName();
        fetchAddress();
    }

    public void fetchEmpId(){
        System.out.println("Employee id is : 1000");
//        sem.release();
    }

    public void fetchAddress(){
//        try{
//            sem.acquire();
            System.out.println("Employee Address is Hanumat Nagar, Bhagwanpur, Varanasi");
//            sem.release();
//        }catch (InterruptedException e){
//            Thread.currentThread().interrupt();
//        }

    }

    public void fetchName(){
//        try{
//            sem.acquire();
            System.out.println("Name of the Employee is Harshit Srivastava");
//            sem.release();
//        }catch (InterruptedException e){
//            Thread.currentThread().interrupt();
//        }
    }


}

