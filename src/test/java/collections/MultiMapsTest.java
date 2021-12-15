package collections;

import com.google.common.collect.*;
import org.junit.Test;

import java.util.*;


/**
 * @author yuanqingtao
 * @version 1.0
 * @date 2021/12/14 10:04 下午
 * @description
 */
public class MultiMapsTest {

    @Test
    public void testNormalMap() {
        String wordId = "12334";
        List<Date> recordDateList = Lists.newArrayList(new Date(), new Date());
        Map<String, List<Date>> recordDateMap = Maps.newHashMap();
        recordDateList.forEach(recordDate -> {
            if (!recordDateMap.containsKey(wordId)) {
                recordDateMap.put(wordId, Lists.newArrayList(recordDate));
            } else {
                recordDateMap.get(wordId).add(recordDate);
            }
        });
    }

    @Test
    public void testmMultilMap() {
        String wordId = "12334";
        List<Date> recordDateList = Lists.newArrayList(new Date(), new Date());
        Multimap<String, Date> multimap = ArrayListMultimap.create();
        recordDateList.forEach(recordDate -> {
            multimap.put(wordId, recordDate);
        });
    }

    /**
     * 对比普通map和multimap
     */
    @Test
    public void testNewMap() {
        Multimap<String, String> multimap = ArrayListMultimap.create();
        Map<String, String> hashMap = Maps.newHashMap();
        Map<String, List<String>> combMap = Maps.newHashMap();
        hashMap.put("1", "1");
        hashMap.put("1", "2");
        hashMap.put("A", "huimei");
        hashMap.put("A", "cdss");
        System.out.println(hashMap);
        combMap.put("1",Lists.newArrayList("1","2"));
        combMap.put("A",Lists.newArrayList("huimei","cdss"));
        System.out.println(combMap);
        multimap.put("1", "1");
        multimap.put("1", "2");
        multimap.put("A", "huimei");
        multimap.put("A", "cdss");
        System.out.println(multimap);
        Collection<String> values= multimap.get("A");
        System.out.println(values);
    }
}
