package utilities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Date;
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

    @Test
    public void testJAVA8ObjectsEqual(){
        System.out.println("测试Java8---Objects");
        System.out.println(java.util.Objects.equals("a", "a"));
        System.out.println(java.util.Objects.equals(null, "a"));
        System.out.println(java.util.Objects.equals("a", null));
        System.out.println(java.util.Objects.equals(null, null));
    }


    //    public void testGuavaObjectsOtherMethods(){
//        Objects.toStringHelper(this).add("x", 1).toString();
//        // Returns "MyObject{x=1}"
//        Objects.toStringHelper("MyObject").add("x", 1).toString();
//
//    }


    class Guava{
        private String version;
        private String manufacure;
        private Date releaseDate;

        public Guava(String version, String manufacure, Date releaseDate) {
            this.version = version;
            this.manufacure = manufacure;
            this.releaseDate = releaseDate;
        }

//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//
//            Guava guava = (Guava) o;
//
//            return Objects.equal(this.manufacure,guava.manufacure)
//                    &&Objects.equal(this.version,guava.version)
//                    &&Objects.equal(this.releaseDate,guava.releaseDate);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hashCode(this.manufacure,this.version,this.releaseDate);
//        }
//
//        @Override
//        public String toString() {
//            return MoreObjects.toStringHelper(this).omitNullValues()
//                    .add("manufacure",this.manufacure)
//                    .add("version",this.version)
//                    .add("releaseDate",this.releaseDate).toString();
//        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Guava guava = (Guava) o;

            if (version != null ? !version.equals(guava.version) : guava.version != null) return false;
            if (manufacure != null ? !manufacure.equals(guava.manufacure) : guava.manufacure != null) return false;
            return releaseDate != null ? releaseDate.equals(guava.releaseDate) : guava.releaseDate == null;
        }

        @Override
        public int hashCode() {
            int result = version != null ? version.hashCode() : 0;
            result = 31 * result + (manufacure != null ? manufacure.hashCode() : 0);
            result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
            return result;
        }
    }


}
