import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * desc:
 * Created by huangzhe on 2017/1/11.
 */
public class BlockingQueueDemoMain {
    public static void main(String[] args) {
        BlockingQueue<Toy> blockingQueue = new ArrayBlockingQueue<Toy>(100);
        new Thread(new Producer(blockingQueue)).start();
        new Thread(new Consumer(blockingQueue)).start();
    }
}

class Producer implements Runnable {

    private BlockingQueue<Toy> blockingQueue;

    private static int id_index = 0;

    public Producer (BlockingQueue<Toy> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run() {
        while (true) {
            try {
                blockingQueue.put(produce());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Toy produce(){
        Toy toy = new Toy(++id_index);
        System.out.println("生成玩具(编号" + toy.getId() + ")。");
        try {
//            Thread.sleep(10);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return toy;
    }
}

class Consumer implements Runnable{

    private BlockingQueue<Toy> blockingQueue;

    public Consumer(BlockingQueue<Toy> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run() {
        while (true) {
            Toy toy = null;
            try {
                toy = blockingQueue.take();
                consumer(toy);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void consumer(Toy toy) {
        System.out.println("--------------消费玩具(编号" + toy.getId() + ")");
        try {
//            Thread.sleep(1000);
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Toy{
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Toy (int id) {
        this.id = id;
    }
}

