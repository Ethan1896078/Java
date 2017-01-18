package pers.ethan.demo;

import java.util.concurrent.*;

/**
 * desc:
 * Created by huangzhe on 2017/1/18.
 */
public class ThrowExceptionFromCallableTask {
    public static void main(String[] args) {
        CustomThreadPoolExecutor executorService = new CustomThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1000));
        try {
            Future<Object> future = executorService.submit(new ThrowExceptionTask(true));
        } catch (Exception e) {
            System.out.println("catch exception in main method");
        }
    }
}

class CustomThreadPoolExecutor extends ThreadPoolExecutor {

    public CustomThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    //重写该方法来捕获异常
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        printException(r, t);
    }

    private static void printException(Runnable r, Throwable t) {
        if (t == null && r instanceof Future<?>) {
            try {
                Future<?> future = (Future<?>) r;
                if (future.isDone())
                    future.get();
            } catch (CancellationException ce) {
                t = ce;
            } catch (ExecutionException ee) {
                t = ee.getCause();
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt(); // ignore/reset
            }
        }
        if (t != null)
            System.out.println("catch exception in override afterExecute, exception:" + t.getMessage());
    }
}

class ThrowExceptionTask implements Callable<Object> {
    private boolean flag;

    public ThrowExceptionTask(boolean flag) {
        this.flag = flag;
    }

    public Object call() throws Exception {
        if (flag) {
            System.out.println("throw Exception");
            throw new RuntimeException("throw from callable task.");
        }
        return null;
    }
}