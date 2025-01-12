public class Cat extends Animal {
   private int maxRun = 200;
   private int maxSwim = 0;
   private boolean isFull;
   private static int catCount = 0;

    public Cat(String name) {
        super(name);
        catCount++;
    }

    public void run(int distance) {
        if (distance <= maxRun) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не смог пробежать " + distance + " м.");
        }
    }

    public void swim(int distance) {

        System.out.println(name + " не умеет плавать ");

    }

    public static int getCatCount() {
        return catCount;
    }

    public void eat(Dish dish, int amount) {
        if (dish.decreaseFood(amount)) {
            this.isFull = true;
            System.out.println(name + " поел и сыт");
        } else {
            System.out.println(name + " не смог поесть. Еды в миске мало");
        }
    }

    public boolean isFull() {
        return isFull;
    }
}