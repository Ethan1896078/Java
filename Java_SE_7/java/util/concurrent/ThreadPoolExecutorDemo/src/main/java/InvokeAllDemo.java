import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * desc:
 * Created by huangzhe on 2017/1/16.
 */
public class InvokeAllDemo {
    private static ExecutorService threadPool = Executors.newFixedThreadPool(10
            , new ThreadFactoryBuilder().setNameFormat("invoke-all-%d").build());

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Map<Integer, Integer> map = Maps.newHashMap();
        for (int i = 0 ; i < 10000 ; i++) {
            map.put(i , i);
        }
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entrySet.iterator();

        List<Callable<Object>> taskList = Lists.newArrayList();
        AtomicInteger counter = new AtomicInteger();
        String filePath = "/Users/huangzhe/Documents/MyCode/Study/Java/Java_SE_7/java/util/concurrent/ThreadPoolExecutorDemo/test";
        FileUtils.deleteQuietly(new File(filePath));
        for (int i = 0 ; i < 10 ; i++) {
            taskList.add(new CounterTask(iterator, counter, filePath));
        }

        List<Future<Object>> futures = threadPool.invokeAll(taskList);
        for (Future<Object> future : futures) {
            Object o = future.get();
            System.out.println(o.toString());
        }
        System.out.println("total : " + counter.intValue());
        threadPool.shutdown();
    }
}

class CounterTask implements Callable {
    private Iterator<Map.Entry<Integer, Integer>> iterator;
    private AtomicInteger counter;
    private String filePath;

    public CounterTask(Iterator<Map.Entry<Integer, Integer>> iterator
            , AtomicInteger counter, String filePath) {
        this.iterator = iterator;
        this.counter = counter;
        this.filePath = filePath;
    }

    public Object call() throws Exception {
        while (true) {
            Map.Entry<Integer, Integer> entry;
            synchronized (iterator) {
                if (!iterator.hasNext()) {
                    break;
                }
                entry = iterator.next();
            }
            String outputString = "[" + Thread.currentThread().getName() + "] "
                    + String.format("%6d", counter.intValue()) + " -> " + entry.getValue();
            System.out.println(outputString);
            FileUtils.write(new File(filePath), outputString + "\n", true);
            counter.incrementAndGet();
        }
        return counter;
    }
}