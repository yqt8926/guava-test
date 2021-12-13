package TestClass;

/**
 * @author yuanqingtao
 * @version 1.0
 * @date 2021/12/13 5:20 下午
 * @description
 */
public class User {
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return address != null ? address.equals(user.address) : user.address == null;
    }

    @Override
    public int hashCode() {
        return address != null ? address.hashCode() : 0;
    }
}
