public abstract class Animal {
    protected String name;
    protected static int animalCount = 0;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public abstract void run(int runDistance);

    public abstract void swim(int swimDistance);

    public static int getAnimalCount() {
        return animalCount;
    }
    public String getName() {
        return name;
    }
}
