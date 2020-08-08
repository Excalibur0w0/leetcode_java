package leetcode.demo.multi;

public class MyThread extends Thread {
    @Override
    public void run() {
        int count = 0;
        while(isInterrupted()) {
            System.out.println("block" + ++count);
        }
        System.out.println("end");
    }
}
