import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * desc:
 * Created by huangzhe on 2017/1/11.
 */
public class Producer implements Runnable {

    private BlockingQueue<Toy> blockingQueue;
    private String type;

    private static int id_index = 0;

    public Producer(BlockingQueue<Toy> blockingQueue, String type) {
        this.blockingQueue = blockingQueue;
        this.type = type;
    }

    public void run() {
        while (true) {
            try {
                Toy toy = produce();
                System.out.println("生成玩具(编号" + toy.getId() + ")");
                if ("Throws exception".equals(type)) {
                    blockingQueue.add(toy);
                } else if ("Special value".equals(type)) {
                    boolean offer = blockingQueue.offer(toy);
                    System.out.println("加入队列是否成功：" + offer);
                } else if ("Blocks".equals(type)) {
                    blockingQueue.put(toy);
                } else if ("Times out".equals(type)) {
                    blockingQueue.offer(toy, 100, TimeUnit.MICROSECONDS);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Toy produce(){
        Toy toy = new Toy(++id_index);
        //虽然BlockingQueue是线程安全的，但是blockingQueue.put(produce())和blockingQueue.size()两个操作之间是可能插入其它操作的
        try {
//            Thread.sleep(10);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return toy;
    }
}
