package utilities;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * @author yuanqingtao
 * @version 1.0
 * @date 2021/12/8 10:39 上午
 * @description
 */
public class ObjectsTest {
    @Test
    public void testGuavaObjectsEqual(){
        System.out.println("测试guava---Objects");
        System.out.println(Objects.equal("a", "a"));
        System.out.println(Objects.equal(null, "a"));
        System.out.println(Objects.equal("a", null));
        System.out.println(Objects.equal(null, null));
    }

//    public void testGuavaObjectsOtherMethods(){
//        Objects.toStringHelper(this).add("x", 1).toString();
//        // Returns "MyObject{x=1}"
//        Objects.toStringHelper("MyObject").add("x", 1).toString();
//
//    }

    @Test
    public void testJAVA8ObjectsEqual(){
        System.out.println("测试JAVA8---Objects");
        System.out.println(java.util.Objects.equals("a", "a"));
        System.out.println(java.util.Objects.equals(null, "a"));
        System.out.println(java.util.Objects.equals("a", null));
        System.out.println(java.util.Objects.equals(null, null));
    }

}
