package pers.ethan.thread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class ThreadWithIO {
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	public static void main(String[] args) throws IOException {
//		printBySerial();
		printByMultiThread();
	}
	
	private static void printBySerial() throws IOException {
		long beginTime = System.currentTimeMillis();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("E:\\公司资料\\项目\\No.1 同步全量伴奏数据\\开发\\获取全量音频组与作者的关系格式.txt")));
		String line = null;
		int counter = 0;
		Map<String, Object> responseMap = null;
		while ((line = bufferedReader.readLine()) != null ) {
			if (!line.contains("\"sn\"") && !line.contains("\"mtime\"")) {
				continue;
			}
			counter++;
			responseMap = OBJECT_MAPPER.readValue(line, Map.class);
			System.out.println(counter + " -> " + Thread.currentThread().getName() + " -> " + line);
		}
		System.out.println("完成，数量:" + counter + "，耗时：" + (System.currentTimeMillis() - beginTime) + "，sn=" + responseMap.get("sn"));
	}

	private static void printByMultiThread() throws FileNotFoundException{
		long beginTime = System.currentTimeMillis();
		final BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("E:\\公司资料\\项目\\No.1 同步全量伴奏数据\\开发\\获取全量音频组与作者的关系格式.txt")));
		final AtomicInteger counter = new AtomicInteger(0);
		final AtomicInteger processingThreadCounter = new AtomicInteger(0);
		final List<Integer> snList = Lists.newArrayList();
		final AtomicInteger maxSn = new AtomicInteger(0);
		for (int i = 0; i < 1000; i++) {
			new Thread(new Runnable() {
				public void run() {
					processingThreadCounter.incrementAndGet();
					Map<String, Object> responseMap = null;
					while (true) {
						String line;
						try {
							synchronized (bufferedReader) {
								line = bufferedReader.readLine();
								if (line == null) {
									break;
								}
								if (!line.contains("\"sn\"") && !line.contains("\"mtime\"")) {
									continue;
								}
								counter.incrementAndGet();
							}
							responseMap = OBJECT_MAPPER.readValue(line, Map.class);
							Integer sn = Integer.parseInt(responseMap.get("sn").toString());
							synchronized (maxSn) {
								if (sn > maxSn.intValue()) {
									maxSn.set(sn);
								}
							}
							System.out.println(counter.intValue() + " -> " + Thread.currentThread().getName() + " -> " + snList.size() + " -> " + line);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					processingThreadCounter.decrementAndGet();
				}
			}).start();
		}
		while (processingThreadCounter.intValue() != 0) {
		}
		System.out.println("完成，数量:" + counter.intValue() + "，耗时：" + (System.currentTimeMillis() - beginTime) + "，sn=" + maxSn.intValue());
	}
}
