package utilities;

import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.primitives.Chars;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author yuanqingtao
 * @version 1.0
 * @date 2021/12/14 7:16 下午
 * @description
 */
public class StringsTest {
    @Test
    public void testStringsnullToEmpty(){
        String emptyStr = Strings.nullToEmpty(null);
        System.out.println(emptyStr);//
    }

    @Test
    public void testStringsemptyToNull(){
        String nullStr = Strings.emptyToNull("");
        System.out.println(nullStr);//
    }

    @Test
    public void testStringscommonPrefix(){
        String commonPrefix = Strings.commonPrefix("huimei@first","huimei@second");
        System.out.println(commonPrefix);//
    }

    @Test
    public void testStringscommonSuffix(){
        String commonPrefix = Strings.commonSuffix("first.huimei","second.huimei");
        System.out.println(commonPrefix);//
    }

    @Test
    public void testStringsrepeat(){
        String repeat = Strings.repeat("huimei",3);
        System.out.println(repeat);//
    }

    @Test
    public void testStringspadEnd(){
        String padEnd = Strings.padEnd("huimei",10,'@');
        System.out.println(padEnd);//
    }

    @Test
    public void testStringspadStart(){
        String padStart = Strings.padStart("huimei",10,'@');
        System.out.println(padStart);//
    }

    @Test
    public void testCharset(){
        Charset charsetForName = Charset.forName("UTF-8");
        Charset charset = Charsets.UTF_8;
        assertThat(charsetForName,equalTo(charset));
    }

    @Test
    public void testCharMatcher(){
        Boolean isnum1 = CharMatcher.javaDigit().matches('5');
        Boolean isnum2 = CharMatcher.javaDigit().matches('w');
        System.out.println(isnum1);
        System.out.println(isnum2);
    }


}
