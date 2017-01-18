import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * desc:未完成
 * Created by huangzhe on 2017/1/16.
 */
public class SynchronizedMapDemo {
    private static ExecutorService threadPool = Executors.newFixedThreadPool(10
            , new ThreadFactoryBuilder().setNameFormat("synchronized-map-%d").build());

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Map<Integer, Integer> map = Maps.newConcurrentMap();
        for (int i = 0 ; i < 1000 ; i++) {
            map.put(i, i + 900000);
        }

        AtomicInteger counter = new AtomicInteger();

        iterateByHashMap(map, counter);

        System.out.println("共完成" + counter.intValue() + "次");
        threadPool.shutdown();
    }

    private static void iterateByHashMap (Map<Integer, Integer> map, AtomicInteger counter) throws ExecutionException, InterruptedException {
        Set<Integer> keySet = map.keySet();
        Iterator<Integer> iterator = keySet.iterator();
        List<Runnable> tasks = Lists.newArrayList();
        for (int i = 0 ; i < 10 ; i++) {
//        Future<?> future = threadPool.submit(new IterateWithMultiThread(iterator, counter));
//        Object o = future.get();
        }
        System.out.println();
    }

}

class IterateWithMultiThread implements Runnable{
    private Iterator<Integer> iterator;
    private AtomicInteger counter;

    public IterateWithMultiThread(Iterator<Integer> iterator, final AtomicInteger counter) {
        this.iterator = iterator;
        this.counter = counter;
    }

    public void run() {
        while (iterator.hasNext()) {
            System.out.println(String.format("%6d", counter.intValue()) + " -> " + iterator.next());
            counter.incrementAndGet();
        }
    }
}