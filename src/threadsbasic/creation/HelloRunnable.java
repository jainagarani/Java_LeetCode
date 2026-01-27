package threadsbasic.creation;

public class HelloRunnable implements Runnable{
    String name;

    public HelloRunnable(String name){
        this.name = name;

    }
    @Override
    public void run() {
        System.out.println("In HelloRunnable "+this.name);
    }

    public static void main(String[] args) {
        HelloRunnable runnable = new HelloRunnable("ByRunnable");
        new Thread(runnable).start();
    }
}
