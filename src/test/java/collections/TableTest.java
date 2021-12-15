package collections;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Sets;
import com.google.common.collect.Table;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

/**
 * @author yuanqingtao
 * @version 1.0
 * @date 2021/12/15 11:32 上午
 * @description
 */
public class TableTest {
    //ArraysTable

    /**
     * 测试重复性
     * 结论：rowkey可以重复  columnkey和value重复会合并
     */
    @Test
    public void tesBasic(){
        Table<String,String,String> hashTable = HashBasedTable.create();
        hashTable.put("language","java","17");
        hashTable.put("language","java","17");
        hashTable.put("language","java","17");
        System.out.println(hashTable);
    }

    @Test
    public void tesContains(){
        Table<String,String,String> hashTable = HashBasedTable.create();
        hashTable.put("language","java","17");
        hashTable.put("language","python","unkown");
        hashTable.put("language","plsql","13");
        System.out.println(hashTable);
        Boolean contains = hashTable.contains("language","java");
        System.out.println(contains);
        Boolean containsRow = hashTable.containsRow("version");
        System.out.println(containsRow);
        Boolean containsColumn = hashTable.containsColumn("java");
        System.out.println(containsColumn);
        Boolean containsValue =hashTable.containsValue("17");
        System.out.println(containsValue);
    }


    /**
     * 演示
     */
    @Test
    public void tesCreate(){
        Table<String,String,String> hashTable = HashBasedTable.create();
        hashTable.put("language","java","17");
        hashTable.put("language","python","unkown");
        hashTable.put("language","plsql","13");
        System.out.println(hashTable);
        Map<String,String> produt = hashTable.row("language");
        System.out.println(produt);
        Map<String,String> column = hashTable.column("version");
        System.out.println(column);
    }

    @Test
    public void tesCell(){
        Table<String,String,String> hashTable = HashBasedTable.create();
        hashTable.put("language","java","17");
        hashTable.put("language","python","unkown");
        hashTable.put("language","plsql","13");
        Set<Table.Cell<String, String, String>> column = hashTable.cellSet();
        System.out.println(column);
        column.forEach(System.out::println);
    }
}
