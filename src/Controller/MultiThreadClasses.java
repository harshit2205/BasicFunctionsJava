package Controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadClasses {

    Thread t = new Thread( ()-> {
        try {
            System.out.println("Thread is running" + this.getClass().getName());
            Thread.sleep(5000);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }, "Thread 1");


    public static void main(String[] args) {
//        MultiThreadClasses myClass = new MultiThreadClasses();
//        myClass.t.start();
//        System.out.println(myClass.t.getName());

        //Java thread pool example....
        //using executor framework....

        ExecutorService executor = Executors.newFixedThreadPool(5);//creating a pool of 5 threads
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);//calling execute method of ExecutorService
        }
        executor.shutdown();
        TerminatorThread thread = new TerminatorThread(executor);
        thread.start();
    }
}

class TerminatorThread extends Thread {
    ExecutorService service;

    public TerminatorThread(ExecutorService service){
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        while(!service.isTerminated());
        System.out.println("service terminated");
        System.out.println("Finished all threads");
    }
}
