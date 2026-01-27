package threadsbasic.creation;

public class HelloThread extends  Thread{
    private String name;
    public HelloThread(String  name){
        this.name = name;
    }

    public void run(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("In Interrupted exception");
        }
        System.out.println("in HelloThread "+this.name);
    }

    public static void main(String[] args) {
        HelloThread helloThread = new HelloThread("ByThread");
        helloThread.start();
    }
}
