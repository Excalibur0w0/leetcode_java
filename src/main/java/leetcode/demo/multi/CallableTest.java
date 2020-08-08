package leetcode.demo.multi;

import java.util.concurrent.*;

public class CallableTest implements Callable<Integer> {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        CallableTest task = new CallableTest();
        Future<Integer> result = service.submit(task);
        result.cancel(true);
        System.out.println(result.get());
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return 2;
    }
}
