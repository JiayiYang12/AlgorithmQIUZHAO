import java.util.Random;
import java.util.PriorityQueue;


public class TopK_Test {
    private PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
    private int K = 10;

    public void add(int i) {
        if (queue.size() < K) {
            queue.add(i);
        } else {
            // Min heap
            int min = queue.peek();
            if (i > min) {
                queue.poll();
                queue.add(i);
            }
        }
    }

    public void print() {
        while (!queue.isEmpty()) {
            Integer i = queue.poll();
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Random r = new Random();
        TopK_Test t = new TopK_Test();

        for (int i = 0; i < 100; i++) {
            t.add(r.nextInt(100));
        }

        t.print();
    }
}