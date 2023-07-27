public class Customer {
    private String fullName;
    private int age;
    private String phone;

    public Customer(String fullName, int age, String phone) {
        this.fullName = fullName;
        this.age = age;
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }
}
