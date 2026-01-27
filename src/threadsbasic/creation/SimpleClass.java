package threadsbasic.creation;

public class SimpleClass {
    public static void main(String[] args) throws InterruptedException {
        for(int i =1; i<100; i++){
            NumberPrinter numberPrinter = new NumberPrinter(i);
            Thread t = new Thread(numberPrinter);
            t.start();
            t.join();
        }
    }
}
