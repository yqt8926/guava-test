package utilities;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yuanqingtao
 * @version 1.0
 * @date 2021/12/11 2:04 下午
 * @description 用分隔符连接字符串
 *
 */
public class JoinerTest {

    private final List<String> stringList = Lists.newArrayList("huimei","tumor","cdss","sentry");

    private final List<String> stringListWithNull = Lists.newArrayList("huimei","tumor","cdss","sentry",null);

    private final Map<String,String> stringMap = ImmutableMap.of("key1", "value1", "key2", "value2");

    /**
     * 使用apache的common拼接字符串
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
     * 使用Java8流式操作拼接字符串
     */
    @Test
    public void testJava8StreamJoin(){
        System.out.println("测试java8.stream---join");
        String joinStr = stringListWithNull.stream().map(str->{
            return StringUtils.isEmpty(str)?"default":str;
        }).collect(Collectors.joining("#"));
        System.out.println(joinStr);//[1, 2, 3, 4]
    }

    /**
     * 优点：不带有[]等特殊符号，分隔符可以自定义，元素可以不是string类型
     */
    @Test
    public void testGuavaJoinerJoin(){
        System.out.println("测试guava---Joiner");
        String joinResultWithoutSeparator = Joiner.on("").join(stringList);
        String joinresult = Joiner.on("#").join("huimei","tumor","cdss","sentry");
        System.out.println(joinResultWithoutSeparator);
        System.out.println(joinresult);
    }

    /**
     * 跳过null
     * ps.如果有null值未跳过会报 NPE
     *   // Bad! Do not do this!
     *   Joiner joiner = Joiner.on(',');
     *   joiner.skipNulls(); // does nothing!
     *   return joiner.join("wrong", null, "wrong");}
     */
    @Test
    public void testGuavaJoinerSkipNulls(){
        System.out.println("测试guava---Joiner");
//        String joinresult = Joiner.on("#").join("huimei",null,"cdss","sentry");
        String joinresult = Joiner.on("#").skipNulls().join(stringListWithNull);
        System.out.println(joinresult);
    }

    @Test
    public void testGuavaJoinerSkipNullsBadCase(){
        System.out.println("测试guava---Joiner");
        Joiner joiner = Joiner.on(',');
        joiner.skipNulls();
        String joinresult = joiner.join(stringListWithNull);
        System.out.println(joinresult);
    }

    /**
     * 将 null 值替换为指定的字符串
     */
    @Test
    public void testGuavaJoinerUseForNull(){
        System.out.println("测试guava---Joiner");
//        String joinresult = Joiner.on("#").join("huimei",null,"cdss","sentry");
        String joinresultUseForNull = Joiner.on("#").useForNull("null").join(stringListWithNull);
//        System.out.println(joinresult);
        System.out.println(joinresultUseForNull);
    }


    /**
     * useForNull()方法调用后无法再调用useForNull()/skipNulls()
     */
    @Test
    public void testGuavaJoinerSkipNullsYuan(){
        System.out.println("测试guava---Joiner");
//        String joinresult = Joiner.on("#").join("huimei",null,"cdss","sentry");
        String joinresult = Joiner.on("#").useForNull("null").skipNulls().join(stringListWithNull);
        System.out.println(joinresult);
    }

    @Test
    public void testGuavaJoinerAppend()  {
        final StringBuffer sb = new StringBuffer("pyramid#");
        try {
            StringBuffer result  = Joiner.on("#").useForNull("default").appendTo(sb,stringListWithNull);
            System.out.println(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 对象上使用Joiner,最终会调用对象的 toString() 方法
     */
    @Test
    public void testGuavaJoinerOnObject(){
        System.out.println("测试guava---Joiner");
//        String joinresult = Joiner.on("#").join("huimei",null,"cdss","sentry");
        String joinresultUseForNull = Joiner.on("#").useForNull("null").join(stringListWithNull);
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
        String result = Joiner.on("; ").withKeyValueSeparator("=").join(stringMap);
        System.out.println("打印map集合：" + stringMap);
        System.out.println("打印map字符串：" + result);
    }


}
