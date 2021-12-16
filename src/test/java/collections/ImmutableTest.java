package collections;

import com.google.common.collect.*;
import org.junit.Test;

import java.awt.*;
import java.util.List;

/**
 * @author yuanqingtao
 * @version 1.0
 * @date 2021/12/15 3:14 下午
 * @description
 */
public class ImmutableTest {
    /**
     * 测试不可变
     */
    @Test
    public void testGuavaImmutable1(){
        ImmutableList<String> imOflist=ImmutableList.of("peida","jerry","harry");
        imOflist.add("demo");
        System.out.println("imlist："+imOflist);
    }

    /**
     * 内部元素可变
     */
    @Test
    public void testGuavaImmutableCannotDo(){
        ImmutableList<List<String>> imOflist2= ImmutableList.of(Lists.newArrayList("peida","jerry","harry"));
        imOflist2.get(0).add("demo");
        System.out.println(imOflist2);
    }

    /**
     * 　　一个immutable集合可以有以下几种方式来创建：
     * 　　1.用copyOf方法, 譬如, ImmutableSet.copyOf(set)
     * 　　2.使用of方法，譬如，ImmutableSet.of("a", "b", "c")或者ImmutableMap.of("a", 1, "b", 2)
     * 　　3.使用Builder类
     */
    @Test
    public void testGuavaImmutableCreate(){

        List<String> list= Lists.newArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("list："+list);

        ImmutableList<String> imlist=ImmutableList.copyOf(list);
        System.out.println("imlist："+imlist);

        ImmutableList<String> imOflist=ImmutableList.of("peida","jerry","harry");
        System.out.println("imOflist："+imOflist);

        ImmutableSortedSet<String> imSortList=ImmutableSortedSet.of("a", "b", "c", "a", "d", "b");
        System.out.println("imSortList："+imSortList);

        list.add("baby");
        System.out.println("list add a item after list:"+list);
        System.out.println("list add a item after imlist:"+imlist);

        ImmutableSet<Color> imColorSet =
                ImmutableSet.<Color>builder()
                        .add(new Color(0, 255, 255))
                        .add(new Color(0, 191, 255))
                        .build();

        System.out.println("imColorSet:"+imColorSet);
    }
}
