public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Тузик");
        Dog dog2 = new Dog("Доен");
        Cat cat1 = new Cat("Лор");
        Cat cat2 = new Cat("Рома");
        Cat cat3 = new Cat("Доген");
        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Всего собак: " + Dog.getDogCount());
        System.out.println("Всего кошек: " + Cat.getCatCount());
        dog1.run(300);
        dog1.swim(5);

        dog2.run(600);
        dog2.swim(15);

        cat1.run(150);
        cat1.swim(0);

        Dish dish = new Dish(30);
        Cat[] cats = {cat1, cat2, cat3};

        for (Cat cat : cats) {
            cat.eat(dish, 10);
            System.out.println(cat.getName() + " сыт: " + cat.isFull());
        }
        System.out.println("Осталось еды в миске: " + dish.getFood() + " ед.");

        dish.addFood(25);
        System.out.println("Наполнили миску, теперь в ней: " + dish.getFood() + " ед.");

        for (
                Cat cat : cats) {
            if (!cat.isFull()) {
                cat.eat(dish, 10);
                System.out.println(cat.getName() + " сыт: " + cat.isFull());
            }
        }
        System.out.println("Осталось еды в миске: " + dish.getFood() + " ед.");

        Geometric circle = new Circle(10, "Желтый", "Красный");
        Geometric triangle = new Triangle(10,5,7, "Синий", "Фиолетовый");
        Geometric rectangle = new Rectangle(10,15,"Зеленый", "Голубой");
        System.out.println("Круг:");
        circle.printCharacteristics();
        System.out.println("Треугольник:");
        triangle.printCharacteristics();
        System.out.println("Прямоугольник:");
        rectangle.printCharacteristics();
    }
}