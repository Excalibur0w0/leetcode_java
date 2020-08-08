package leetcode.demo.multi;

public class MultiTh {
    public static void main(String[] args) throws InterruptedException {
        MultiTh multiTh = new MultiTh();
        Thread th1 = new Thread(() -> {
            multiTh.printSecond(() -> System.out.println("second"));
        });
        Thread th2 = new Thread(() -> {
            multiTh.printThird(() -> System.out.println("three"));
        });
        Thread th3 = new Thread(() -> {
            multiTh.printFirst(() -> System.out.println("first"));
        });

        th1.start();
        th2.start();
        th3.start();

        th1.join();
        th2.join();
        th3.join();
        System.out.println("completed");
    }

    private Boolean[] lockFlag = new Boolean[] { false, false, false };

    public void printFirst(Runnable runnable) {
        runnable.run();
        lockFlag[0] = true;
    }

    public void printSecond(Runnable runnable) {
        while(!lockFlag[0]);
        runnable.run();
        lockFlag[1] = true;
    }

    public void printThird(Runnable runnable) {
        while (!lockFlag[0]);
        while (!lockFlag[1]);
        runnable.run();
    }
}
