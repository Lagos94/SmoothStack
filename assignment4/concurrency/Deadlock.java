package assignment4.concurrency;

public class Deadlock {

    private final Integer factor1 = 1;
    private final Integer factor2 = 0;

    private final Thread process1 = new Thread() {
        public void run() { //old method
            while (true) {
                synchronized (factor1) {
                    synchronized (factor2) {
                        System.err.println(factor1 + " " + factor2);
                    }
                }
            }
        }
    };

    private Thread process2 = new Thread(() -> { //new method with lambda expression
        while (true) {
            synchronized (factor2) {
                synchronized (factor1) {
                    System.out.println(factor2 +" "+ factor1);
                }
            }
        }
    });

    public static void main(String[] args) {
        Deadlock dl = new Deadlock();
        dl.process2.start();
        dl.process1.start();
    }
}
