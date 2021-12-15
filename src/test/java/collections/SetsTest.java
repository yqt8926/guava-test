package collections;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * @author yuanqingtao
 * @version 1.0
 * @date 2021/12/14 9:32 下午
 * @description
 */
public class SetsTest {

    /**
     * 创建
     */
    @Test
    public void testNewSet(){
        Set<String> set0 = Sets.newHashSet();
        Set<String> set1 = Sets.newHashSet("1","2");
        Set<String> set2 = Sets.newTreeSet();
        Set<String> set3 = Sets.newLinkedHashSet();
        Set<String> set4 = Sets.newConcurrentHashSet();
        Set<String> set5 = Sets.newHashSetWithExpectedSize(10);
        Set<String> set6 = Sets.newLinkedHashSetWithExpectedSize(10);
    }

    /**
     * 两个集合的笛卡尔积
     */
    @Test
    public void testCartesianProduct(){
        Set<String> numStr = Sets.newHashSet("1","2");
        Set<String> engStr = Sets.newHashSet("A","B");
        Set<String> chinsesStr = Sets.newHashSet("你","我");
        Set<List<String>> result = Sets.cartesianProduct(numStr, engStr,chinsesStr);
        System.out.println(result);//[[1, A, 你], [1, A, 我], [1, B, 你], [1, B, 我], [2, A, 你], [2, A, 我], [2, B, 你], [2, B, 我]]
    }

    /**
     * 所有子集
     */
    @Test
    public void testcombinations(){
        Set<Integer> num = Sets.newHashSet(1,2,3,4);
        Set<Set<Integer>> combinationSets = Sets.combinations(num, 2);
        combinationSets.forEach(System.out::println);
    }

    /**
     * 差集
     */
    @Test
    public void testdifference(){
        Set<Integer> num1 = Sets.newHashSet(1,2,3,4);
        Set<Integer> num2 = Sets.newHashSet(2,3,5,6);
        Sets.SetView difference = Sets.difference(num1, num2);
        difference.forEach(System.out::println);//1 4
    }

    /**
     * 差集
     */
    @Test
    public void testintersection(){
        Set<Integer> num1 = Sets.newHashSet(1,2,3,4);
        Set<Integer> num2 = Sets.newHashSet(2,3,5,6);
        Sets.SetView intersection = Sets.intersection(num1, num2);
        intersection.forEach(System.out::println);//2 3
    }

    /**
     * 并集
     */
    @Test
    public void testunion(){
        Set<Integer> num1 = Sets.newHashSet(1,2,3,4);
        Set<Integer> num2 = Sets.newHashSet(2,3,5,6);
        Sets.SetView union = Sets.union(num1, num2);
        union.forEach(System.out::println);//1 2 3 4 5 6
    }
}
