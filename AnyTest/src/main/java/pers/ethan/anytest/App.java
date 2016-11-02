package pers.ethan.anytest;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
/*    	List<String> list1 = new ArrayList<String>();
    	List<String> list2 = new ArrayList<String>();
    	System.out.println(list1.equals(list2));
    	list1.add("1");
    	list2.add("1");
    	System.out.println(list1.equals(list2));
    	
    	int [] intArray1 = new int[5];
    	int [] intArray2 = new int[5];
    	System.out.println(intArray1.equals(intArray2));
    	System.out.println(Arrays.equals(intArray1, intArray2));*/
    	
    	/*Integer[] i = {2, 1, 5, 3, 4};
    	print(i);
    	Arrays.sort(i);
    	print(i);
    	Arrays.sort(i, Collections.reverseOrder());
    	print(i);
    	
    	System.out.println(new Integer(1).equals(new Integer(1)));*/
    	
		/*Map<String, Object> singerInfo = Maps.newHashMap(); 
		Map<String, Object> SINGER_TYPE_MAPPING = Maps.newHashMap();
		Map<String, Object> SINGER_REGION_MAPPING = Maps.newHashMap();
		SINGER_REGION_MAPPING.put("area_id", "");
		String singerName = String.valueOf(singerInfo.get("author_name"));
		Object typeObj = singerInfo.get("type");
		Integer singerTypeFromKugou = typeObj != null && StringUtils.isNotBlank(typeObj.toString()) ? Integer.valueOf(typeObj.toString()) : null;
		Object areaId = singerInfo.get("area_id");
		Integer singerRegionFromKugou = areaId != null && StringUtils.isNotBlank(areaId.toString()) ? Integer.valueOf(areaId.toString()) : null;*/
    	
    	/*long begin = System.currentTimeMillis();
        byte[] buffer = new byte[8192];
        int len = 0;
        try {
        	FileInputStream fileInputStream = new FileInputStream(new File("E:\\公司资料\\项目\\No.1 同步全量伴奏数据\\开发\\获取全量音频接口数据格式 - 全量.txt"));
        	String string = IOUtils.toString(fileInputStream);
        	
        	FileOutputStream fileOutputStream2Disk = new FileOutputStream(new File("E:\\公司资料\\项目\\No.1 同步全量伴奏数据\\开发\\output.txt"));
        	IOUtils.write(string, fileOutputStream2Disk);
//        	BufferedInputStream bufferedInputStreamFromSocket = new BufferedInputStream(new FileInputStream(new File("E:\\公司资料\\项目\\No.1 同步全量伴奏数据\\开发\\获取全量音频接口数据格式 - 全量.txt")));
//        	StringWriter stringWriter = new StringWriter();
//        	FileOutputStream fileOutputStream2Disk = new FileOutputStream(new File("E:\\公司资料\\项目\\No.1 同步全量伴奏数据\\开发\\output.txt"));
//        	while ((len = bufferedInputStreamFromSocket.read(buffer)) != -1) {
////        		fileOutputStream2Disk.write(buffer, 0, len);
//        		stringWriter.write
//        	}
//        	
//        	bufferedInputStreamFromSocket = new BufferedInputStream(new FileInputStream(new File("E:\\公司资料\\项目\\No.1 同步全量伴奏数据\\开发\\获取全量音频组与作者的关系格式 - 测试环境全量 - 副本.txt")));
		} catch (Exception e) {
		}
        System.out.println(System.currentTimeMillis() - begin);*/
    	
//    	String songName = "袁哲 - 袁哲 - 女主角 - KTV版伴奏";
//    	if (StringUtils.isNotBlank(songName)) {
//			String[] split = songName.split("-");
//			if (split.length > 1) {
//				songName = StringUtils.trim(split[1]);
//			}
//			if(songName != null && songName.length() > 256){
//				songName = songName.substring(0, 256);
//			}
//		}
//    	System.out.println(songName);
//    	
//    	System.out.println(StringEscapeUtils.unescapeJava("\u5cf6\u8c37\u3072\u3068\u307f - Destiny -\u592a\u967d\u306e\u82b1- - \u539f\u7248\u4f34\u594f"));
    	
    	File target = new File("E:\\公司资料\\项目\\No.1 同步全量伴奏数据\\开发\\获取全量音频接口数据格式.txt");
    	List<String> resultList = Lists.newArrayList();
    	List<String> readLines = FileUtils.readLines(new File("E:\\公司资料\\项目\\No.1 同步全量伴奏数据\\开发\\accompany.2016-08-26"), "UTF-8");
    	for (String line : readLines) {
    		if (line.contains("\"audio_type\":\"4\"") || line.contains("\"audio_type\":\"13\"")) {
    			resultList.add(line);
    		}
		}
    	readLines = FileUtils.readLines(new File("E:\\公司资料\\项目\\No.1 同步全量伴奏数据\\开发\\accompany.2016-08-27"), "UTF-8");
    	for (String line : readLines) {
    		if (line.contains("\"audio_type\":\"4\"") || line.contains("\"audio_type\":\"13\"")) {
    			resultList.add(line);
    		}
		}
    	readLines = FileUtils.readLines(new File("E:\\公司资料\\项目\\No.1 同步全量伴奏数据\\开发\\accompany.2016-08-28"), "UTF-8");
    	for (String line : readLines) {
    		if (line.contains("\"audio_type\":\"4\"") || line.contains("\"audio_type\":\"13\"")) {
    			resultList.add(line);
    		}
		}
    	readLines = FileUtils.readLines(new File("E:\\公司资料\\项目\\No.1 同步全量伴奏数据\\开发\\accompany.2016-08-29"), "UTF-8");
    	for (String line : readLines) {
    		if (line.contains("\"audio_type\":\"4\"") || line.contains("\"audio_type\":\"13\"")) {
    			resultList.add(line);
    		}
		}
    	FileUtils.writeLines(target, resultList);
    }
    
    public static void print(Integer[] args){
    	for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
    	System.out.println("-------------！！！！");
    }
}

class A{
	
}