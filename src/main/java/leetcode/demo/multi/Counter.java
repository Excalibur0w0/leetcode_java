package leetcode.demo.multi;

public class Counter {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread();
        t.start();
        t.interrupt();
        Thread.sleep(10);
        t.join();
        System.out.println(t);
    }
}
