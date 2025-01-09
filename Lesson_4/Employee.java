public class Employee {
<<<<<<< HEAD
    public String name;
    public String job;
    public String email;
    public String phone;
    public int salary;
    public int age;
=======
    String name;
    String job;
    String email;
    String phone;
    int salary;
    int age;
>>>>>>> c06301a7a1bc55a8449e6e013e2b105ba4fc8b23

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

<<<<<<< HEAD
}
=======
    public static void main(String[] args) {
        Employee[] employeeArray = new Employee[5];
        employeeArray[0] = new Employee("Василий Петров", "Экономист", "vp@mail.ru", "+89563269874", 80000, 31);
        employeeArray[1] = new Employee("Инокентий Иванов", "Руководитель отдела продаж", "ii@mail.ru", "+375445673420", 150000, 45);
        employeeArray[2] = new Employee("Денис Граков", "уборщик", "dg@mail.ru", "+89325648965", 40000, 43);
        employeeArray[3] = new Employee("Тимофей Сердильских", "Руководитель отдела снабжения", "ts@mail.ru", "+89632147856", 160000, 35);
        employeeArray[4] = new Employee("Михаил Маслов", "Аналитик", "mm@mail.ru", "+89231475236", 90000, 42);

        for (int i = 0; i < employeeArray.length; i++)
            employeeArray[i].print();
    }

}
>>>>>>> c06301a7a1bc55a8449e6e013e2b105ba4fc8b23
