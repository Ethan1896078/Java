import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * desc:
 * Created by huangzhe on 2017/1/11.
 */
public class Consumer implements Runnable{

    private BlockingQueue<Toy> blockingQueue;
    private String type;

    public Consumer(BlockingQueue<Toy> blockingQueue, String type) {
        this.blockingQueue = blockingQueue;
        this.type = type;
    }

    public void run() {
        while (true) {
            Toy toy = null;
            try {
                if ("Throws exception".equals(type)) {
                    toy =  blockingQueue.remove();
                } else if ("Special value".equals(type)) {
                    toy =  blockingQueue.poll();
                } else if ("Blocks".equals(type)) {
                    toy =  blockingQueue.take();
                } else if ("Times out".equals(type)) {
                    toy =  blockingQueue.poll(100, TimeUnit.MICROSECONDS);
                }
                consumer(toy);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void consumer(Toy toy) {
        try {
            System.out.println("消费玩具：" + toy);
//            Thread.sleep(100);
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
