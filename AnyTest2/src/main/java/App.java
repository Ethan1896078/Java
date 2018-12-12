import com.google.common.collect.Lists;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;

/**
 * desc:
 * Created by huangzhe on 2017/3/21.
 */
public class App {
    public static void main(String[] args) throws ParseException, IOException, InterruptedException {
        /*Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = simpleDateFormat.parse("2017-03-01");
        calendar.setTime(beginDate);

        while (calendar.get(Calendar.DAY_OF_MONTH) < 22) {
            Date time = calendar.getTime();
            String todayStr = simpleDateFormat.format(time);
            System.out.println(todayStr);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }*/
/*        List<String> lines = FileUtils.readLines(new File("/Users/huangzhe/Documents/lbs"));
        List<String> matchList = Lists.newArrayList();
        List<String> matchListIn_18_45 = Lists.newArrayList();
        int ms_in_18_45 = 0;
        for (String line : lines) {
            int ms = Integer.parseInt(line.split("get top 10 of nearby opus from lbs, spending ")[1].split(" ms")[0]);
            if (ms > 1000) {
                matchList.add(line);
//                if (line.startsWith("18:45:")) {
//                    matchListIn_18_45.add(line);
//                    ms_in_18_45 += ms;
//                }
            }

        }
        FileUtils.writeLines(new File("/Users/huangzhe/Documents/lbs_1000"), matchList);
//        FileUtils.writeLines(new File("/Users/huangzhe/Documents/2_filter_1000_in_18_45"), matchListIn_18_45);

        System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2017-02-28 18:00:00").getTime());
        System.out.println(ms_in_18_45);*/

       /* Map<String, Integer> map = Maps.newHashMap();

        List<String> lines = FileUtils.readLines(new File("/Users/huangzhe/Documents/lbsTimeOut"));
        for (String line : lines) {
            String hourMinute = line.substring(0, 5);
            int count = map.get(hourMinute) == null ? 1 : map.get(hourMinute) + 1;
            map.put(hourMinute, count);
        }

        int max = 0;
        int countAbove10 = 0, countAbove50 = 0, countAbove100 = 0, countAbove150 = 0, countAbove200 = 0;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-04-02 00:00:00"));
        List<String> outputList = Lists.newArrayList();
        while (calendar.get(Calendar.DAY_OF_MONTH) == 2) {
            String hourMinute = new SimpleDateFormat("HH:mm").format(calendar.getTime());
            int count = map.get(hourMinute) == null ? 0 : map.get(hourMinute);
            outputList.add(hourMinute + " -> " + count);

            if (count > max) {
                max = count;
            }

            if (count >= 200) {
                countAbove200++;
            }

            if (count >= 150) {
                countAbove150++;
            }

            if (count >= 100) {
                countAbove100++;
            }

            if (count >= 50) {
                countAbove50++;
            }

            if (count >= 10) {
                countAbove10++;
            }

            calendar.add(Calendar.MINUTE, 1);
        }

        outputList.add("一分钟内发生lbs超时最多的次数 : " + max);
        outputList.add("一分钟内发生lbs超时200次以上的分钟次数 : " + countAbove200);
        outputList.add("一分钟内发生lbs超时150次以上的分钟次数 : " + countAbove150);
        outputList.add("一分钟内发生lbs超时100次以上的分钟次数 : " + countAbove100);
        outputList.add("一分钟内发生lbs超时50次以上的分钟次数 : " + countAbove50);
        outputList.add("一分钟内发生lbs超时10次以上的分钟次数 : " + countAbove10);

        File outputFile = new File("/Users/huangzhe/Documents/lbsTimeOutAnalysis");
        FileUtils.writeLines(outputFile, outputList);*/

     /*   Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-03-31 18:00:00"));
        System.out.println(calendar.getTimeInMillis());*/

//        Date date = new Date(1493813103000L);
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
//        Date beginTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-03-31 18:00:00");
//        System.out.println(beginTime.getTime());
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-05-03 18:00:00"));
//
//        String data = "ODQzMTg2Mjc5XzMzMzcwNw%3D%3D";
//        String replace = data.replace("%3D", "=").replace(" ", "+");
//        System.out.println(data);
//        System.out.println(replace);

/*        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DATE));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        System.out.println(Integer.MAX_VALUE);*/

        /*new Thread(new Runnable() {
            public void run() {
                while (true) {
                    System.out.println(System.currentTimeMillis());
                }
            }
        }).start();*/

//        try {
//            System.out.println(1);
//            throw new Exception();
//        } catch (Exception e) {
//            System.out.println(2);
//        } finally {
//            System.out.println(3);
//        }
//
//        System.out.println("投票+2".split("投票\\+")[1]);
//
//        Random random = new Random();
//        for (int i = 0 ; i < 1000 ; i++){
//            int i1 = random.nextInt(1);
//                System.out.println(i1);
//        }

//        Map<Integer, List<Customer>> map = Maps.newHashMap();
//        for (int i = 0 ; i < 10 ; i++) {
//            List<Customer> list = Lists.newArrayList();
//            list.add(new Customer(i, "name" + i));
//            list.add(new Customer(i + 1, "name" + i + 1));
//            list.add(new Customer(i + 2, "name" + i + 2));
//            System.out.println(JSON.toJSONString(list));
//            map.put(i, list);
//        }

//        System.out.println(JSON.toJSONString(map));
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = simpleDateFormat.parse("2017-05-31 18:00:00");
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        System.out.println(calendar.get(Calendar.MONTH));
//        System.out.println(calendar.get(Calendar.DATE));
////        calendar.add(Calendar.MONTH, -1);
////        System.out.println(calendar.get(Calendar.MONTH));
////        System.out.println(calendar.get(Calendar.DATE));
//        calendar.add(Calendar.MONTH, -2);
//        System.out.println(calendar.get(Calendar.MONTH));
//        System.out.println(calendar.get(Calendar.DATE));

//        System.out.println(new Date().after(null));


//        Calendar cal = Calendar.getInstance();
//        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
//        cal.set(Calendar.HOUR_OF_DAY, 18);
//        cal.set(Calendar.MINUTE, 0);
//        cal.set(Calendar.SECOND, 0);
//        String lastDayStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());
//        System.out.println(lastDayStr);
//
//        long beginTime = System.currentTimeMillis();
//        System.out.println(beginTime);
//        Thread.sleep(9000);
//        long endTime = System.currentTimeMillis();
//        System.out.println(endTime);
//        System.out.println(endTime - beginTime);

//        Calendar cal = Calendar.getInstance();
//        cal.set(Calendar.DATE, 1);
//        cal.set(Calendar.HOUR_OF_DAY, 18);
//        cal.set(Calendar.MINUTE, 0);
//        cal.set(Calendar.SECOND, 0);
//        System.out.println(cal.getTime().getTime());
//
//        Map<String, Integer> map = Maps.newHashMap();
//        map.put("b", 2);
//        map.put("a", 1);
//        map.put("c", 3);
//        System.out.println("map:" + map);
//
//        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
//        System.out.println("set:" + entrySet);
//
//        List<Map.Entry<String, Integer>> list = Lists.newArrayList(entrySet);
//        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
//            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                return o2.getValue().compareTo(o1.getValue());
//            }
//        });
//        for (Map.Entry<String, Integer> entry : list) {
//            System.out.println(entry);
//        }

//        System.out.println(System.currentTimeMillis());
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-06-30 18:00:00").getTime());
//        System.out.println(System.currentTimeMillis() - new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-06-29 15:40:48").getTime() > 10 * 60 * 1000l);
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(1498665600000l)));
//
//        long time1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-06-29 00:00:00").getTime();
//        long time2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-06-30 00:00:00").getTime();
//        System.out.println((time2 - time1) / 1000 / 60 / 60 / 24);
//        DecimalFormat decimalFormat = new DecimalFormat("##0.00");
//        System.out.println((decimalFormat.format(((float)632) / 300)));

        List<Integer> list = Lists.newArrayList();
        Collections.shuffle(list);

        list.add(1);
        list.add(2);
        list.add(3);
        Collections.shuffle(list);

        System.out.println(list.subList(0, 0));
        System.out.println(list.subList(0, 1));
    }


}

class Customer {
    private int id;
    private String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}