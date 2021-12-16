package collections;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * @author yuanqingtao
 * @version 1.0
 * @date 2021/12/15 10:55 上午
 * @description
 */
public class BiMapTest {

    /**
     * 测试基本特性
     * 最终维护一组一对一的映射关系
     */
    @Test
    public void testBiMapBasic(){
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("com", "huimei");
        System.out.println(biMap);
        //普通的put方法value不允许重复
//        biMap.put("company", "huimei");
        //key可以重复put
//        biMap.put("com", "alibaba");
        //forcePut 可以让value重复put
        biMap.forcePut("company", "huimei");
//        biMap.forcePut("com", "alibaba");
        System.out.println(biMap);
    }

    /**
     * inverse
     */
    @Test
    public void testBiMapInverse() {
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("1", "2");
        biMap.put("2", "3");
        biMap.put("3", "4");
        System.out.println(biMap);
        System.out.println(biMap.inverse());
    }


    /**
     * 可以用于一对一的映射查询
     */
    @Test
    public void testBiMapUse() {
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("肺癌", "123");
        biMap.put("肿瘤", "234");
        biMap.put("脑梗死", "456");
        System.out.println(biMap.get("肺癌"));
        System.out.println(biMap.inverse().get("123"));
    }

}
