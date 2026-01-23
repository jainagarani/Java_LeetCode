package threadsbasic;

public class DeadLockExample {
    public static void main(String[] args) throws InterruptedException {
        Object resource1 = new Object();
        Object resource2 = new Object();

        Thread t1 = new Thread(()-> {
            synchronized (resource1){
                System.out.println("Thread1 locking resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (resource2){
                    System.out.println("Thread1 locking resource2");


                }

            }

        });

        Thread t2 = new Thread(()-> {
            synchronized (resource2){
                System.out.println("Thread2 locking resource2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (resource1){
                    System.out.println("Thread2 locking resource1");


                }

            }

        });

        t1.start();
        t2.start();
        t1.join();

        System.out.println("End of main");
    }
}
