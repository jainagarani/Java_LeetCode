package threadsbasic.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
    int capacity;

    private final Queue<Integer> buffer = new LinkedList<>();

    public SharedResource(int capacity){
        this.capacity = capacity;
    }

    public synchronized void produce(int value) throws InterruptedException {
        if(buffer.size() == capacity)
            wait();
        buffer.add(value);
        System.out.println("Produced "+value);
        notify();

    }

    public synchronized void consume() throws InterruptedException {
        if(buffer.isEmpty())
            wait();
        int value = buffer.poll();
        System.out.println("consumed "+value);
        notify();

    }

}

class Producer implements  Runnable{
    SharedResource sharedResource;

    public Producer(SharedResource sharedResource){
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        try{
            for(int i =1; i<=5; i++){
                sharedResource.produce(i);
                Thread.sleep(1000);
            }
        }catch(InterruptedException ie){
            System.out.println("InterruptedException");
        }

    }
}

class Consumer implements Runnable{
    SharedResource sharedResource;

    public Consumer(SharedResource sharedResource){
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        try{
            for(int i =1; i<=5; i++){
                sharedResource.consume();
                 Thread.sleep(1000);
            }
        }catch(InterruptedException ie){
            System.out.println("InterruptedException");
        }

    }
}
