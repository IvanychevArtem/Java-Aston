public class Employee {
    public String name;
    public String job;
    public String email;
    public String phone;
    public int salary;
    public int age;

    public Employee(String name, String job, String email, String phone, int salary, int age) {
        this.name = name;
        this.job = job;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public String toString() {
        return String.format("Name: %s \tJob: %s \nEmail: %s \tPhone: %s \nSalary: %d \tAge: %d \n", name, job, email, phone, salary, age);
    }

    public void print() {
        System.out.println(this);
    }

}