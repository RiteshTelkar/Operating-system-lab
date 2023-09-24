package Producer_Consumer_problem;

import java.util.List;

public class Consumer implements Runnable{
    List<Integer> Buffer = null;
    private int i=0;
    final int max = 10;
    Consumer(List<Integer> Buffer){
        this.Buffer = Buffer;
    }
    public void consume(int i)throws InterruptedException{
        synchronized (Buffer){
            while (Buffer.isEmpty()){
                System.out.println("Consumer is waiting due to buffer is full");
                Buffer.wait();
            }
        }
        Buffer.remove(i);
        System.out.println("Consumer consuming");
        Thread.sleep(350);
        synchronized (Buffer){
            Buffer.notify();

        }
    }
    @Override
    public void run() {
        try {
            while (true){
                i++;
                consume(i);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
