package collections;

import com.google.common.collect.*;
import com.google.common.primitives.Ints;
import org.junit.Test;

import java.util.Set;

/**
 * @author yuanqingtao
 * @version 1.0
 * @date 2021/12/15 11:54 上午
 * @description
 */
public class RangeTest {
    @Test
    public void testClosed(){
        Range<Integer> closer =  Range.closed(0, 9);
        System.out.println(closer);
    }

    @Test
    public void testRange(){
        System.out.println("open:"+Range.open(1, 10));
        System.out.println("closed:"+ Range.closed(1, 10));
        System.out.println("closedOpen:"+ Range.closedOpen(1, 10));
        System.out.println("openClosed:"+ Range.openClosed(1, 10));
        System.out.println("greaterThan:"+ Range.greaterThan(10));
        System.out.println("atLeast:"+ Range.atLeast(10));
        System.out.println("lessThan:"+ Range.lessThan(10));
        System.out.println("atMost:"+ Range.atMost(10));
        System.out.println("all:"+ Range.all());
        System.out.println("closed:"+Range.closed(10, 10));
        System.out.println("closedOpen:"+Range.closedOpen(10, 10));
        //会抛出异常
//        System.out.println("open:"+Range.open(10, 10));
    }

    /**
     * 构造实例通过绑定类型显式
     */
    @Test
    public void testRange2(){
        System.out.println("downTo:"+Range.downTo(4, BoundType.OPEN));
        System.out.println("upTo:"+Range.upTo(4, BoundType.CLOSED));
        System.out.println("range:"+Range.range(1, BoundType.CLOSED, 4, BoundType.OPEN));
    }

    /**
     * 判断值是否在当前Range内
     */
    @Test
    public void testContains(){
        System.out.println(Range.closed(1, 3).contains(2));
        System.out.println(Range.closed(1, 3).contains(4));
        System.out.println(Range.lessThan(5).contains(5));
        System.out.println(Range.closed(1, 4).containsAll(Ints.asList(1, 2, 3)));
    }

    /**
     * Endpoint相关查询方法
     */
    @Test
    public void testQuery(){
        System.out.println("hasLowerBound:"+Range.closedOpen(4, 4).hasLowerBound());
        System.out.println("hasUpperBound:"+Range.closedOpen(4, 4).hasUpperBound());
        System.out.println(Range.closedOpen(4, 4).isEmpty());
        System.out.println(Range.openClosed(4, 4).isEmpty());
        System.out.println(Range.closed(4, 4).isEmpty());
        // Range.open throws IllegalArgumentException
        //System.out.println(Range.open(4, 4).isEmpty());

        System.out.println(Range.closed(3, 10).lowerEndpoint());
        System.out.println(Range.open(3, 10).lowerEndpoint());
        System.out.println(Range.closed(3, 10).upperEndpoint());
        System.out.println(Range.open(3, 10).upperEndpoint());
        System.out.println(Range.closed(3, 10).lowerBoundType());
        System.out.println(Range.open(3, 10).upperBoundType());
    }

    /**
     * encloses(Range range)中的range是否包含在需要比较的range中
     */
    @Test
    public void testEncloses(){
        Range<Integer> rangeBase=Range.open(1, 4);
        Range<Integer> rangeClose=Range.closed(2, 3);
        Range<Integer> rangeCloseOpen=Range.closedOpen(2, 4);
        Range<Integer> rangeCloseOther=Range.closedOpen(2, 5);
        System.out.println("rangeBase: "+rangeBase+" Enclose:"+rangeBase.encloses(rangeClose)+" rangeClose:"+rangeClose);
        System.out.println("rangeBase: "+rangeBase+" Enclose:"+rangeBase.encloses(rangeCloseOpen)+" rangeClose:"+rangeCloseOpen);
        System.out.println("rangeBase: "+rangeBase+" Enclose:"+rangeBase.encloses(rangeCloseOther)+" rangeClose:"+rangeCloseOther);
    }

    /**
     * range是否可连接上
     */
    @Test
    public void testConnected(){
        System.out.println(Range.closed(3, 5).isConnected(Range.open(5, 10)));
        System.out.println(Range.closed(0, 9).isConnected(Range.closed(3, 4)));
        System.out.println(Range.closed(0, 5).isConnected(Range.closed(3, 9)));
        System.out.println(Range.open(3, 5).isConnected(Range.open(5, 10)));
        System.out.println(Range.closed(1, 5).isConnected(Range.closed(6, 10)));
    }


    /**
     * intersection：如果两个range相连时，返回最大交集，如果不相连时，直接抛出异常
     */
    @Test
    public void testIntersection(){
        System.out.println(Range.closed(3, 5).intersection(Range.open(5, 10)));
        System.out.println(Range.closed(0, 9).intersection(Range.closed(3, 4)));
        System.out.println(Range.closed(0, 5).intersection(Range.closed(3, 9)));
        System.out.println(Range.open(3, 5).intersection(Range.open(5, 10)));
        System.out.println(Range.closed(1, 5).intersection(Range.closed(6, 10)));
    }

    /**
     * span：获取两个range的并集，如果两个range是两连的，则是其最小range
     */
    @Test
    public void testSpan(){
        System.out.println(Range.closed(3, 5).span(Range.open(5, 10)));
        System.out.println(Range.closed(0, 9).span(Range.closed(3, 4)));
        System.out.println(Range.closed(0, 5).span(Range.closed(3, 9)));
        System.out.println(Range.open(3, 5).span(Range.open(5, 10)));
        System.out.println(Range.closed(1, 5).span(Range.closed(6, 10)));
        System.out.println(Range.closed(1, 5).span(Range.closed(7, 10)));
    }

    /**
     * 模拟评估表风险等级
     */
    @Test
    public void testRangeMap(){
        RangeMap<Integer,String> rangeMap = TreeRangeMap.create();
        rangeMap.put(Range.closed(1,2),"低危");
        rangeMap.put(Range.closed(3,4),"中危");
        rangeMap.put(Range.closed(5,6),"高危");
        rangeMap.put(Range.closed(7,8),"极高危");
        System.out.println(rangeMap.get(5));
    }
}
