package Producer_Consumer_problem;

import java.util.ArrayList;

public class PCProblem {
    public static void main(String[] args) {
        ArrayList<Integer> B = new ArrayList<Integer>();
        Thread p = new Thread(new Producer(B));
        Thread c = new Thread(new Consumer(B));
        p.start();
        c.start();
    }
}
