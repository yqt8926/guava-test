package utilities;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author yuanqingtao
 * @version 1.0
 * @date 2021/12/11 2:04 下午
 * @description :
 *  Splitter可以对字符串进行分割，在分割时的方式有2种，
 *
 * 　　1.按字符/字符串分割
 *
 * 　　2.按正则进行分割
 *
 *  Splitter在分割完成时可以转换成list和map
 */
public class SplitterTest {

    private final String sourceStr =  ",huimei,,cdss,";

    private final String sourceStrWithBlank =  ", huimei ,, cd ss ,";

    private final String sourceStrFull =  "huimei,cdss,tumor,drgs,sentry";

    private final String sourceStrForMap =  "com=huimei,my=tumor,biao=cdss,zen=drgs,shuai=sentry";


    /**
     * 最后一个分隔符后的null值有点不正常
     */
    @Test
    public void testGuavaStringSplit(){
        System.out.println("测试String---split");
        String[] splitArray = sourceStr.split(",");
        List<String> splitList =Lists.newArrayList(splitArray);
        System.out.println(splitList);//[, huimei, , cdss]
    }

    /**
     * 使用Splitter最后一个null是正常的
     */
    @Test
    public void testGuavaSplitterSplit(){
        System.out.println("测试guava---Splitter");
        List<String> splitList = Splitter.on(",").splitToList(sourceStr);
        System.out.println(splitList);//[, huimei, , cdss, ]
    }

    /**
     * 忽略空字符串
     */
    @Test
    public void testGuavaSplitterSplitOmitEmptyStrings(){
        System.out.println("测试Splitter---omitEmptyStrings");
        List<String> splitList = Splitter.on(",").omitEmptyStrings().splitToList(sourceStr);
        System.out.println(splitList);//[huimei, cdss]
    }

    /**
     * 去除前后空字符串
     * ps.只能去除前后的，不能去除中间的空字符串
     */
    @Test
    public void testGuavaSplitterSpliterTrimResults(){
        System.out.println("测试Splitte---TrimResults");
        List<String> splitList = Splitter.on(",").trimResults().omitEmptyStrings().splitToList(sourceStrWithBlank);
        System.out.println(splitList);//[huimei, cd ss]
    }

    /**
     * 文本按照固定长度分割
     * aaabbbcccddd
     */
    @Test
    public void testGuavaSplitterSpliterFixedLength(){
        System.out.println("测试Splitte---FixedLength");
        List<String> splitList = Splitter.fixedLength(3).splitToList("aaabbbcccddd");
        System.out.println(splitList);//[aaa, bbb, ccc, ddd]
    }

    /**
     * 测试fixedLength()这个方法能做什么
     * 先拆分，再执行trimResults()、omitEmptyStrings()，这两个方法最后执行
     */
    @Test
    public void testGuavaSplitterSpliterFixedLengthBorder(){
        System.out.println("测试Splitter---FixedLength");
        List<String> splitList = Splitter.fixedLength(3).trimResults().omitEmptyStrings().splitToList("huimei is the best");
        System.out.println(splitList);//[hui, mei, is, th, e b, est]
    }

    /**
     * limit分成n个元素
     */
    @Test
    public void testGuavaSplitterSplitLimit(){
        System.out.println("测试Splitter---Limit");
        List<String> splitList = Splitter.on(",").limit(3).splitToList(sourceStrFull);
        splitList.stream().forEach(System.out::println);//huimei cdss  tumor,drgs,sentry
    }

    /**
     * 按照正则表达式字符串分割
     */
    @Test
    public void testGuavaSplitterPatternString(){
        System.out.println("测试Splitter---PatternString");
        List<String> splitList = Splitter.onPattern("\\|").trimResults().omitEmptyStrings().splitToList("huimei| cdss|tumor ||drgs");
        splitList.stream().forEach(System.out::println);//huimei cdss  tumor drgs
    }

    /**
     * 按照正则表达式分割
     */
    @Test
    public void testGuavaSplitterPattern(){
        System.out.println("测试Splitter---Pattern");
        List<String> splitList = Splitter.on(Pattern.compile("\\|")).trimResults().omitEmptyStrings().splitToList("huimei| cdss|tumor ||drgs");
        splitList.stream().forEach(System.out::println);//huimei cdss  tumor drgs
    }

    @Test
    public void testGuavaSplitterToMap(){
        System.out.println("测试Splitter---ToMap");
        Map<String,String> splitList = Splitter.on(",").trimResults().omitEmptyStrings().withKeyValueSeparator("=").split(sourceStrForMap);
        System.out.println(splitList);//{com=huimei, my=tumor, biao=cdss, zen=drgs, shuai=sentry}
    }

}
