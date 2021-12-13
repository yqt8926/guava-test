package utilities;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author yuanqingtao
 * @version 1.0
 * @date 2021/12/11 2:04 下午
 * @description 用分隔符连接字符串
 *
 */
public class JoinerTest {

    /**
     * 缺点:带有特殊符号
     */
    @Test
    public void testStringUtilsJoin(){
        System.out.println("测试apache.common3.lang.StringUtils---join");
        List<Integer> numlist = Lists.newArrayList(1,2,3,4);
        String joinStr = StringUtils.join(numlist);
        System.out.println(joinStr);//[1, 2, 3, 4]
    }

    /**
     * 优点：不带有[]等特殊符号，分隔符可以自定义，元素可以不是string类型
     */
    @Test
    public void testGuavaObjectsEqual(){
        System.out.println("测试guava---Joiner");
        String joinResultWithoutSeparator = Joiner.on("").join("huimei","tumor","cdss","sentry");
        String joinresult = Joiner.on("#").join("huimei","tumor","cdss","sentry");
        System.out.println(joinResultWithoutSeparator);
        System.out.println(joinresult);

    }

    /**
     * 跳过null
     * ps.如果有null值未跳过会报 NPE
     */
    @Test
    public void testGuavaJoinerSkipNulls(){
        System.out.println("测试guava---Joiner");
//        String joinresult = Joiner.on("#").join("huimei",null,"cdss","sentry");
        String joinresult = Joiner.on("#").skipNulls().join("huimei",null,"cdss","sentry");
        System.out.println(joinresult);
    }

    /**
     * 将 null 值替换为指定的字符串
     */
    @Test
    public void testGuavaJoinerUseForNull(){
        System.out.println("测试guava---Joiner");
//        String joinresult = Joiner.on("#").join("huimei",null,"cdss","sentry");
        String joinresultUseForNull = Joiner.on("#").useForNull("null").join("huimei",null,"cdss","sentry");
//        System.out.println(joinresult);
        System.out.println(joinresultUseForNull);
    }

    /**
     * 对象上使用Joiner,最终会调用对象的 toString() 方法
     */
    @Test
    public void testGuavaJoinerOnObject(){
        System.out.println("测试guava---Joiner");
//        String joinresult = Joiner.on("#").join("huimei",null,"cdss","sentry");
        String joinresultUseForNull = Joiner.on("#").useForNull("null").join("huimei",null,"cdss","sentry");
//        System.out.println(joinresult);
        System.out.println(joinresultUseForNull);
    }

    /**
     * 将Map中数据按照指定字符拼接
     */
    @Test
    public void testGuavaJoinerOnMap() {
        System.out.println("测试guava---Joiner");
        /// MapJoiner 的使用，将 map 转换为字符串
        Map map = ImmutableMap.of("k1", "v1", "k2", "v2");
        String result = Joiner.on("; ").withKeyValueSeparator("=").join(map);
        System.out.println("打印map集合：" + map);
        System.out.println("打印map字符串：" + result);
    }
}
