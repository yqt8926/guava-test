package collections;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import org.apache.commons.collections4.MultiSet;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * @author yuanqingtao
 * @version 1.0
 * @date 2021/12/15 1:45 下午
 * @description
 */
public class MultisetTest {
    /**
     *
     */
    @Test
    public void testmMultilSet() {
        HashMultiset<String> multiSet = HashMultiset.create();
        multiSet.add("a");
        multiSet.add("b");
        multiSet.add("b");
        multiSet.add("c");
        multiSet.add("c");
        multiSet.add("c");
        multiSet.add("a");
        System.out.println(multiSet);
        System.out.println(multiSet.size());
        System.out.println(multiSet.count("a"));
    }
}
