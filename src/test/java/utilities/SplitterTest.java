package utilities;

import TestClass.Address;
import TestClass.Country;
import TestClass.User;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
    /**
     * 最后一个分隔符后的null值
     */
    @Test
    public void testGuavaObjectsEqual(){
        System.out.println("测试String---split");
        String sourceStr = ",a,,b,";
        String[] splitArray = sourceStr.split(",");
        System.out.println(Arrays.toString(splitArray));//"", "a", "", "b"
    }


    /**
     * 最后一个分隔符后的null值
     */
    @Test
    public void testGuavaSplitterSplit(){
        System.out.println("测试guava---Splitter");
        List<String> splitList = Splitter.on(",").trimResults().omitEmptyStrings().splitToList("huimei,cdss,tumor,drgs");
        System.out.println(splitList);//[huimei, cdss, tumor, drgs]
    }


    /**
     * 最后一个分隔符后的null值
     */
    @Test
    public void testGuavaSplitterFatoryMethod(){
        System.out.println("测试guava---Splitter");

        List<String> splitList = Splitter.on(",").trimResults().omitEmptyStrings().splitToList("huimei,cdss,tumor,drgs");
        System.out.println(splitList);//[huimei, cdss, tumor, drgs]
    }


}
