import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * desc:
 * Created by huangzhe on 2017/1/21.
 */
public class CancelDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<?> future = executorService.submit(new Runnable() {
            public void run() {
                int i = 0;
                while (true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i++);
                }
            }
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //参数用来标识是否打断当前正在进行的任务
        future.cancel(true);
        System.out.println("future cancel:" + future.isCancelled());
    }
}

