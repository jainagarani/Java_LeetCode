package threadsbasic.threadCommuni;

public class OddEvenPrinter {
    public static void main(String[] args) {
        SharedResource oddPrinter = new SharedResource(5,1);
        SharedResource evenPrinter = new SharedResource(5,0);
        new Thread(oddPrinter, "oddNumber").start();
        new Thread(evenPrinter, "EvenNumber").start();


    }
}
