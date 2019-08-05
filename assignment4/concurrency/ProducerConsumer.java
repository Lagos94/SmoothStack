package assignment4.concurrency;

import java.util.ArrayList;

public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        final ProduceConsume pc = new ProduceConsume();
        Thread producer = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        producer.start();
        consumer.start();
    }

    public static class ProduceConsume {
        ArrayList<Integer> list = new ArrayList<>();
        int capacity = 3;

        public void produce() throws InterruptedException {
            int gain = 1;
            while (true) {
                synchronized (this) {
                    while (list.size() == capacity)
                        wait();
                    System.out.println("Producer made-" + gain);
                    list.add(gain++);
                    //notify() method can be called to see beyond the limited 3 spots.
                    //Thread.sleep(60);
                }
            }
        }

        public void consume() throws InterruptedException {
            while (true) {
                synchronized (this) {
                    while (list.size() == 0)
                        wait();
                    int loss = list.remove(0);
                    System.out.println("Consumer took-" + loss);
                    //notify() must be called here too.
                    //Thread.sleep(60);
                }
            }
        }
    }
}
