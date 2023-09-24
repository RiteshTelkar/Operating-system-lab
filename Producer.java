package Producer_Consumer_problem;

import java.util.List;

public class Producer implements  Runnable{
    List<Integer> Buffer = null;
    private int i=0;
    final int max = 10;
    Producer(List<Integer> Buffer){
        this.Buffer = Buffer;
    }
    public void produce(int i)throws InterruptedException{
        synchronized (Buffer){
            while (Buffer.size()==max){
                System.out.println("producer is waiting due to buffer is full");
                Buffer.wait();
            }
        }
        Buffer.add(i);
        System.out.println("producer producing");
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
               produce(i);
           }
       }
       catch (Exception e){
           System.out.println(e);
       }
    }
}
