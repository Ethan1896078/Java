package pers.ethan.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * desc:
 * Created by huangzhe on 2017/4/23.
 */
public class TestFuture {

    // https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Executor.html
    static ExecutorService executor = Executors.newCachedThreadPool();

    public void testTaskRunning(String name, Integer t) {
        System.out.println("Prepare for execution：" + name);
        long startTime = System.currentTimeMillis(); //获取开始时间

        // using lambda may cause 10X time then Callable
//        Future<String> fa = executor.submit(
//                new Callable<String>() {
//                    @Override
//                    public String call() throws Exception {
//                        try {
//                            Thread.sleep(t);
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                        return String.format("service exec time: %d", t);
//                    }
//                }
//        );

        Future<String> fa =  executor.submit(
                () -> {
                    try {
                        Thread.sleep(t);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return String.format("service exec time: %d", t);
                });

        long endTime = System.currentTimeMillis();
        System.out.println("Start execute： " + (endTime - startTime) + "ms");

        try {
            String s = fa.get(); //Future to Blocked
            System.out.println(s);
        } catch (
                Exception e)
        {
            e.printStackTrace();
        }

        endTime = System.currentTimeMillis(); //
        System.out.println("End execute： " + (endTime - startTime) + "ms");

    }

    /*public void testAsyncTaskRunning() {
        System.out.println("Prepare for execution： composite task" );
        long startTime = System.currentTimeMillis(); //获取开始时间

        Future<String> fa = executor.submit(new TimeConsumingService("fa",200,new String[]{}));
        Future<String> fb = executor.submit(new TimeConsumingService("fb",400,new String[]{}));

        System.out.println("Start execute： " + (System.currentTimeMillis() - startTime) + "ms");

        try {
            // What will happen when change line fc and fd ?
            Future<String> fc = executor.submit(new TimeConsumingService("fc",400,new String[]{fa.get()}));
            Future<String> fd = executor.submit(new TimeConsumingService("fd",200,new String[]{fb.get()}));
            Future<String> fe = executor.submit(new TimeConsumingService("fe",200,new String[]{fb.get()}));
            fc.get(); fd.get(); fe.get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("End execute： " + (System.currentTimeMillis() - startTime) + "ms");
    }
*/
    public static void main(String[] args) {
        TestFuture test = new TestFuture();
        test.testTaskRunning("fa", 3000);
        //test.testAsyncTaskRunning();
        System.out.println("sssssssssssssssssss");
    }
}
