import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * desc:
 * Created by huangzhe on 2017/1/11.
 */
public class BlockingQueueDemoMain {
    public static void main(String[] args) {
        BlockingQueue<Toy> blockingQueue = new ArrayBlockingQueue<Toy>(100);
        String type = "Special value";
        new Thread(new Producer(blockingQueue, type)).start();
        new Thread(new Consumer(blockingQueue, type)).start();
    }
}



