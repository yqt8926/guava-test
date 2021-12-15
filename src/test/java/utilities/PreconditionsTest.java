package utilities;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.List;

/**
 * @author yuanqingtao
 * @version 1.0
 * @date 2021/12/14 5:13 下午
 * @description
 */
public class PreconditionsTest {

    /**
     * 普通的参数校验
     * @throws Exception
     */
    @Test
    public void testNormalVa() throws Exception {
        System.out.println("测试参数校验");
        getPerson(6,"cdss");

        getPerson(-9,"tumorcdss");

        getPerson(8,"");

        getPerson(8,null);
    }

    /**
     * 使用guava.Preconditions进行参数校验
     * @throws Exception
     */
    @Test
    public void Preconditions() throws Exception {

        getPersonByPrecondition(8,"cdss");

        try {
            getPersonByPrecondition(-9,"tumorcdss");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            getPersonByPrecondition(8,"");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            getPersonByPrecondition(8,null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        List<Integer> intList=Lists.newArrayList ();
        for(int i=0;i<10;i++){
            try {
                checkState(intList,9);
                intList.add(i);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

        try {
            checkPositionIndex(intList,3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            checkPositionIndex(intList,13);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            checkPositionIndexes(intList,3,7);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            checkPositionIndexes(intList,3,17);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            checkPositionIndexes(intList,13,17);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            checkElementIndex(intList,6);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            checkElementIndex(intList,16);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



    private static void getPerson(int age,String neme) {
        if (age > 0 && neme != null && neme.isEmpty() != true) {
            System.out.println("a person age:" + age + ",neme:" + neme);
        } else {
            System.out.println("参数输入有误！");
        }
    }

    private static void getPersonByPrecondition(int age,String neme)throws Exception{
        Preconditions.checkNotNull(neme, "neme为null");
        Preconditions.checkArgument(neme.length()>0, "neme为\'\'");
        Preconditions.checkArgument(age>0, "age 必须大于0");
//        Preconditions.checkState();
        System.out.println("a person age:"+age+",neme:"+neme);
    }

    public static void checkState(List<Integer> intList,int index)throws Exception{
        //表达式为true不抛异常
        Preconditions.checkState(intList.size()<index, " intList size 不能大于"+index);
    }

    public static void checkPositionIndex(List<Integer> intList,int index) throws Exception{
        Preconditions.checkPositionIndex(index, intList.size(), "index "+index+" 不在 list中， List size为："+intList.size());
    }

    public static void checkPositionIndexes(List<Integer> intList,int start,int end) throws Exception{
        Preconditions.checkPositionIndexes(start, end, intList.size());
    }

    public static void checkElementIndex(List<Integer> intList,int index) throws Exception{
        Preconditions.checkElementIndex(index, intList.size(),"index 为 "+index+" 不在 list中， List size为： "+intList.size());
    }
}
