package utilities;

import TestClass.Address;
import TestClass.Country;
import TestClass.User;
import org.junit.Test;

import java.util.Optional;

/**
 * @author yuanqingtao
 * @version 1.0
 * @date 2021/12/13 5:28 下午
 * @description
 */
public class OptionalTest {
    @Test
    public void noUseOptional() {
        System.out.println("测试guava---Splitter");
        User user = new User();
        //Java代码中最常见的链式调用
        String 链式调用 = user.getAddress().getCountry().getIsocode().toUpperCase();
        //针对链式调用的判空
        if (user != null) {
            Address address = user.getAddress();
            if (address != null) {
                Country country = address.getCountry();
                if (country != null) {
                    String isocode = country.getIsocode();
                    if (isocode != null) {
                        isocode = isocode.toUpperCase();
                        System.out.println(isocode);
                    }
                }
            }
        }
        //或者合在一起
        if (user != null && user.getAddress() != null && user.getAddress().getCountry() != null && user.getAddress().getCountry().getIsocode() != null) {
            String 链式调用2 = user.getAddress().getCountry().getIsocode().toUpperCase();
            System.out.println(链式调用2);
        }

    }

    @Test
    public void useJava8Optional() {
        User user = null;
        String result = Optional.ofNullable(user)
                .map(User::getAddress)
                .map(Address::getCountry)
                .map(Country::getIsocode)
                .orElse("default");
        System.out.println(result);
    }


}
