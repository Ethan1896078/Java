import com.google.common.collect.Sets;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * desc:未完成
 * Created by huangzhe on 2017/1/16.
 */
public class SynchronizedSetDemo {
    public static void main(String[] args) {
        Set<Integer> normalSet = Sets.newTreeSet();
        for (int i = 0; i < 100000; i++) {
            normalSet.add(i);
        }

        long beginTime = System.currentTimeMillis();
        final AtomicInteger processingThreadCounter = new AtomicInteger();
        final AtomicInteger excutorCounter = new AtomicInteger(0);

        Set<Integer> synchronizedSet = Collections.synchronizedSet(normalSet);
        final Iterator<Integer> synchronizedSetIterator = synchronizedSet.iterator();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    processingThreadCounter.incrementAndGet();
                    while (true) {
                        Integer integer = -1;
                        synchronized (synchronizedSetIterator) {
                            if (synchronizedSetIterator.hasNext()) {
                                integer = (Integer) synchronizedSetIterator.next();
                                excutorCounter.incrementAndGet();
                            } else {
                                break;
                            }
                        }
                        if (integer != -1) {
                            System.out.println(Thread.currentThread().getName() + " -> " + integer);
                        }
                    }
                    processingThreadCounter.decrementAndGet();
                }
            }).start();
        }

        while (processingThreadCounter.intValue() != 0) {
        }

        System.out.println("处理" + excutorCounter.intValue() + "条数据，共耗时" + (System.currentTimeMillis() - beginTime) + "毫秒");
    }
}
