package threadsbasic.producerconsumer;

public class ProducerConsumerExample {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource(3);
        Thread producer = new Thread(new Producer(sharedResource));
        Thread consumer = new Thread(new Consumer(sharedResource));
        producer.start();
        consumer.start();
    }
}
