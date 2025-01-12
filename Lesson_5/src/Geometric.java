public interface Geometric {
     double getPerimeter();

     double getSquare();

     String getBackgroundColor();

     String getBorderColor();

    default void printCharacteristics() {
        System.out.println("Периметр: " + getPerimeter());
        System.out.println("Площадь: " + getSquare());
        System.out.println("Цвет фона: " + getBackgroundColor());
        System.out.println("Цвет границы: " + getBorderColor());
    }
}