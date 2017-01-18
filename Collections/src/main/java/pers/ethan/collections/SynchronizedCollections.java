package pers.ethan.collections;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author ethanhuang
 *
 */
public class SynchronizedCollections 
{
    public static void main( String[] args )
    {
		synchronizedList();
    }
    
    private static void synchronizedList(){
    	final List<Integer> normalList = Lists.newArrayList();
        for (int i = 0; i < 100000; i++) {
        	normalList.add(i);
		}
        
        long beginTime = System.currentTimeMillis();
        final AtomicInteger excutorCounter = new AtomicInteger(0);
        final AtomicInteger processingThreadCounter = new AtomicInteger(0); 
       
        /*//线程不安全
        for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				
				public void run() {
					processingThreadCounter.incrementAndGet();
					while (true) {
						Integer remove = -1;
						if (normalList.size() != 0) {
							remove = normalList.remove(0);
							excutorCounter.incrementAndGet();
						} else {
							break;
						}
						if (remove != -1) {
							System.out.println(Thread.currentThread().getName() + " -> " + remove);
						}
					}
					processingThreadCounter.decrementAndGet();
				}
			}).start();
		}*/
        
        //线程安全 - 通过Collections.synchronizedList
        /*final List<Integer> synchronizedList = Collections.synchronizedList(normalList);
        for (int i = 0; i < 9; i++) {
			new Thread(new Runnable() {
				public void run() {
					processingThreadCounter.incrementAndGet();
					while (true) {
						Integer remove = -1;
						if (synchronizedList.size() != 0) {
							remove = synchronizedList.remove(0);
							excutorCounter.incrementAndGet();
						} else {
							break;
						}
						if (remove != -1) {
							System.out.println(Thread.currentThread().getName() + " -> " + remove);
						}
					}
					processingThreadCounter.decrementAndGet();
				}
			}).start();
		}*/
        
        //线程安全 - 通过上锁
        for (int i = 0; i < 9; i++) {
			new Thread(new Runnable() {
				public void run() {
					processingThreadCounter.incrementAndGet();
					while (true) {
						Integer remove = -1;
						synchronized (normalList) {
							if (normalList.size() != 0) {
								remove = normalList.remove(0);
								excutorCounter.incrementAndGet();
							} else {
								break;
							}
						}
						if (remove != -1) {
							System.out.println(Thread.currentThread().getName() + " -> " + remove);
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
    
    private static void synchronizedSet(){
    	Set<Integer> normalSet = Sets.newTreeSet();
        for (int i = 0; i < 100000; i++) {
        	normalSet.add(i);
		}
        
        long beginTime = System.currentTimeMillis();
        final AtomicInteger processingThreadCounter = new AtomicInteger();
        final AtomicInteger excutorCounter = new AtomicInteger(0);
        
        //线程不安全
        final Iterator<Integer> normalSetIterator = normalSet.iterator();
       /* for (int i = 0; i < 9; i++) {
			new Thread(new Runnable() {
				public void run() {
					while (true) {
						if (normalSetIterator.hasNext()) {
							Integer integer = (Integer) normalSetIterator.next();
							System.out.println(Thread.currentThread().getName() + " -> " + integer);
						}
					}
				}
			}).start();
		}*/
        
        //线程安全 - 通过上锁
//        final Iterator <Integer> synchronizedSetIterator = normalSet.iterator();
//        for (int i = 0; i < 10; i++) {
//			new Thread(new Runnable() {
//				public void run() {
//					processingThreadCounter.incrementAndGet();
//					while (true) {
//						Integer integer = -1;
//						synchronized (synchronizedSetIterator) {
//							if (synchronizedSetIterator.hasNext()) {
//								integer = (Integer) synchronizedSetIterator.next();
//								excutorCounter.incrementAndGet();
//							} else {
//								break;
//							}
//						}
//						if (integer != -1) {
//							System.out.println(Thread.currentThread().getName() + " -> " + integer);
//						}
//					}
//					processingThreadCounter.decrementAndGet();
//				}
//			}).start();
//		}
        
      //TODO 未完成通过Collections.synchronizedSet
      Set<Integer> synchronizedSet = Collections.synchronizedSet(normalSet);
      final Iterator <Integer> synchronizedSetIterator = synchronizedSet.iterator();
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
