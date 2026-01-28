package threadsbasic.threadCommuni;

public class SharedResource implements  Runnable{
     static int num;
    int limit;
    int reminder;


    static Object lock = new Object();

    SharedResource( int limit, int reminder){
        this.num = 1;
        this.limit = limit;
        this.reminder = reminder;
    }

    public void print(){
        System.out.println(Thread.currentThread().getName()+" Num is "+num++);
    }

    @Override
    public void run() {
        synchronized (lock){
            for(int i =1; i< limit; i++){
                if(num %2 != reminder) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }


                }
                print();
                lock.notifyAll();
            }

        }

    }
}
