package pers.ethan.demo;

import java.util.concurrent.*;

/**
 * desc:
 * Created by huangzhe on 2017/1/13.
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        System.out.println("main thread : " + Thread.currentThread().getName());
        Future<Integer> result1 = executorService.submit(new Calculate(1, 1));
        Future<Integer> result2 = executorService.submit(new Calculate(2, 2));
        Future<Integer> result3 = executorService.submit(new Calculate(3, 3));
        System.out.println(result1.get());
        System.out.println(result2.get());
        System.out.println(result3.get());

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
        Thread.sleep(5000);
        System.out.println("callable thread : " + Thread.currentThread().getName());
        return firstParam + secondParam;
    }
}
