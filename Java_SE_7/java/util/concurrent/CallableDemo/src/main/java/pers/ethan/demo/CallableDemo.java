package pers.ethan.demo;

import java.util.concurrent.*;

/**
 * desc:
 * Created by huangzhe on 2017/1/13.
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> result = executorService.submit(new Calculate(1, 1));
        System.out.println(result.get());
    }
}

class Calculate implements Callable<Integer> {
    private int firstParam;
    private int secondParam;

    public Calculate (int firstParam, int secondParam) {
        this.firstParam = firstParam;
        this.secondParam = secondParam;
    }

    public Integer call() throws Exception {
        Thread.sleep(10000);
        return firstParam + secondParam;
    }
}
