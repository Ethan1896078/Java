package pers.ethan.anytest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysDemo {
	public static void main(String[] args) {
		final int length = 2000000;
		List<Integer> list = new ArrayList<Integer>(); 
		for (int i = 0; i < length; i++) {
			list.add(i);
		}
		
		long begin = System.currentTimeMillis();
		int target = 1888888;
		for (int i = 0; i < length; i++) {
			if (list.get(i) == target) {
				break;
			}
		}
		System.out.println("顺序查找耗时：" + (System.currentTimeMillis() - begin));
		
		Object[] array = list.toArray();
		begin = System.currentTimeMillis();
		Arrays.binarySearch(array, target);
		System.out.println("二分查找耗时：" + (System.currentTimeMillis() - begin));
	}
}
