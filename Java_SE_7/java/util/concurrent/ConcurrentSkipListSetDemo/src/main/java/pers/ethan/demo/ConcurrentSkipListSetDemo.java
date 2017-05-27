package pers.ethan.demo;

import java.util.HashSet;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * desc:
 * Created by huangzhe on 2017/2/27.
 */
public class ConcurrentSkipListSetDemo {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentSkipListSet<Integer> concurrentSkipListSet = new ConcurrentSkipListSet<>();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0 ; i < 5 ; i++) {
            new Thread(new AutoIncrementTask(concurrentSkipListSet, hashSet)).start();
        }

        Thread.sleep(1000 * 3);
        System.out.println(concurrentSkipListSet);
    }

}

class AutoIncrementTask implements Runnable{
    private ConcurrentSkipListSet<Integer> concurrentSkipListSet;
    private HashSet<Integer> hashSet;

    public AutoIncrementTask(ConcurrentSkipListSet<Integer> concurrentSkipListSet, HashSet<Integer> hashSet) {
        this.concurrentSkipListSet = concurrentSkipListSet;
        this.hashSet = hashSet;
    }

    @Override
    public void run() {
        for (int i = 0 ; i < 10 ; i++) {
            concurrentSkipListSet.add(i);
        }
    }
}
