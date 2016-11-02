import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Sets;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * desc:
 * Created by huangzhe on 2016/9/30.
 */
public class FastJsonDemo {
    public static void main(String[] args) {
        Set<Long> longSet = Sets.newHashSet();
        longSet.add(1L);
        longSet.add(2L);
        JSONObject json = new JSONObject();
        json.put("haha", "haha~");
        json.put("longSet", longSet);
        System.out.println(json.get("haha"));
        System.out.println(json.get("longSet"));
        Set<Long> longSet1 = (Set<Long>)json.get("longSet");
        System.out.println("longSet1.size() = " + longSet1.size());
        Iterator<Long> iterator = longSet1.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        String s = JSON.toJSONString(longSet);
        System.out.println(s);
        json.put("s", s);
        List<String> list = JSON.parseArray(json.getString("s"), String.class);
        System.out.println(Sets.newHashSet(list));
    }
}
