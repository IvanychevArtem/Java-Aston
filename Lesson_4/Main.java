public class Main {
    public static void main(String[] args) {
        Employee[] employeeArray = new Employee[5];
        employeeArray[0] = new Employee("Василий Петров", "Экономист", "vp@mail.ru", "+89563269874", 80000, 31);
        employeeArray[1] = new Employee("Инокентий Иванов", "Руководитель отдела продаж", "ii@mail.ru", "+375445673420", 150000, 45);
        employeeArray[2] = new Employee("Денис Граков", "уборщик", "dg@mail.ru", "+89325648965", 40000, 43);
        employeeArray[3] = new Employee("Тимофей Сердильских", "Руководитель отдела снабжения", "ts@mail.ru", "+89632147856", 160000, 35);
        employeeArray[4] = new Employee("Михаил Маслов", "Аналитик", "mm@mail.ru", "+89231475236", 90000, 42);

        for (Employee employee : employeeArray) employee.print();


        Park.Attraction theTrain = new Park.Attraction("Паровозик", "10:00 - 8:00", 350);
        Park.Attraction ferrisWheel = new Park.Attraction("Колесо обозрения", "9:00 - 10:00", 600);
        Park.Attraction golf = new Park.Attraction("Гольф", "12:00 - 12:00", 2200);

        theTrain.print();
        ferrisWheel.print();
        golf.print();
    }

}

