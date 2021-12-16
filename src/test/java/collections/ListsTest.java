package collections;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * @author yuanqingtao
 * @version 1.0
 * @date 2021/12/14 9:02 下午
 * @description
 */
public class ListsTest {

    /**
     * 创建
     */
    @Test
    public void testNewList(){
        List<String> list0 = Lists.newArrayList();
        List<String> list1 = Lists.newArrayList("1","2");
        List<String> list2 = Lists.newLinkedList();
        //初始化容量
        List<String> list3 = Lists.newArrayListWithCapacity(10);
        //估算容量
        List<String> list4 = Lists.newArrayListWithExpectedSize(10);
        List<String> list5 = Lists.newCopyOnWriteArrayList();
    }

    /**
     * 两个集合的笛卡尔积
     */
    @Test
    public void testCartesianProduct(){
        List<String> numStr = Lists.newArrayList("1","2");
        List<String> engStr = Lists.newArrayList("A","b");
        List<List<String>> result = Lists.cartesianProduct(numStr, engStr);
        System.out.println(result);//[[1, A], [1, b], [2, A], [2, b]]
    }

    /**
     * 转换list
     */
    @Test
    public void testTransform(){
        List<String> sourceList = Lists.newArrayList("huimei","tumorcdss","cdss");
        Lists.transform(sourceList,e->e.toUpperCase()).forEach(System.out::println);
    }

    /**
     * 转换成不可变Character集合
     */
    @Test
    public void testCharactersOf(){
        ImmutableList<Character> result =  Lists.charactersOf("我们");
        result.forEach(System.out::println);
    }

    /**
     * 翻转list
     */
    @Test
    public void testReverse(){
        List<String> source =  Lists.newArrayList("1","2","3");
        List<String> result =  Lists.reverse(source);
        System.out.println(result);
    }

    /**
     * 分组,size是一个组内几个元素
     */
    @Test
    public void testPartition(){
        List<String> source =  Lists.newArrayList("1","2","3","4","5","6");
        List<List<String>> result =  Lists.partition(source,3);
        result.forEach(System.out::println);
    }
}
