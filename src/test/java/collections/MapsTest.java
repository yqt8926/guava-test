package collections;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author yuanqingtao
 * @version 1.0
 * @date 2021/12/14 9:47 下午
 * @description
 */
public class MapsTest {

    /**
     * 创建
     */
    @Test
    public void testNewMap(){
        List<String> valueList = Lists.newArrayList("1","2","3");
        ImmutableMap<String,String> result = Maps.uniqueIndex(valueList, value -> value + "-key");
        System.out.println(result);//{1-key=1, 2-key=2, 3-key=3}

        Map<String,String> result1 =Maps.asMap(Sets.newHashSet("1","2","3"), value -> value + "-value");
        System.out.println(result1);
    }

    /**
     * 转换
     */
    @Test
    public void testTransform(){
        Map<String,String> source =Maps.asMap(Sets.newHashSet("1","2","3"), value -> value + "-value");
        Map<String,String> result =Maps.transformValues(source,value->value+"-new");
        System.out.println(result);//{1=1-value-new, 2=2-value-new, 3=3-value-new}
    }

    /**
     * 过滤
     */
    @Test
    public void testFilterKeys(){
        List<String> list = Lists.newArrayList("1","2");
        Map<String,String> source =Maps.asMap(Sets.newHashSet("1","2","3"), value -> value + "-value");
        Map<String,String> result =Maps.filterKeys(source,key->list.contains(key));
        System.out.println(result);//{1=1-value, 2=2-value}
    }
}
