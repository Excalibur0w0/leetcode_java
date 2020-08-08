package leetcode.demo.multi;

public class ThreadGroupTest {
    public static void main(String[] args) {
        Thread testThread = new Thread(() -> {
            System.out.println("testThread当前线程组名字: " + Thread.currentThread().getThreadGroup().getName());
            System.out.println("testThread线程名字: " + Thread.currentThread().getName());
        });
        testThread.start();
    }
}
