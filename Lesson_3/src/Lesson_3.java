public class Lesson_3 {
    public static void main(String[] args) {
        writeThreeWords();
        checkSum();
        printColor();
        compareNumbers();
        System.out.println(twoNumbers(1, 133) + "\n");
        positiveNegativeNumber(-5);
        System.out.println(checkPositiveNegative(-9) + "\n");
        wordNumber("ker", 8);
        System.out.println(checkLeapYear(1508) + "\n");
        int[] mass = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        integerArray(mass);
        emptyInteger(100);
        int[] mas = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        arrayCycle(mas);
        int k = 11;
        int[][] twomas = new int[k][k];
        twoDimensionalArray(twomas);
        twoArgument(5, 2);
    }

    static void writeThreeWords() {
        System.out.println("Orange \nBanana \nApple" + "\n");
    }

    static void checkSum() {
        int a = 2;
        int b = -3;
        if (a + b >= 0) {
            System.out.println("Сумма положительная" + "\n");
        }
        if (a + b < 0) {
            System.out.println("Сумма отрицательная" + "\n");
        }
    }

    static void printColor() {
        int value = 101;
        if (value <= 0) {
            System.out.println("Красный" + "\n");
        }
        if (value > 0 & value <= 100) {
            System.out.println("желтый" + "\n");
        }
        if (value > 100) {
            System.out.println("зеленый" + "\n");
        }
    }

    static void compareNumbers() {
        int a = 12;
        int b = 9;
        if (a >= b) {
            System.out.println("a>=b" + "\n");
        } else {
            System.out.println("a<b" + "\n");
        }
    }

    public static boolean twoNumbers(int a, int b) {
        return (a + b) >= 10 & (a + b) <= 20;
    }

    public static void positiveNegativeNumber(int a) {
        if (a >= 0) {
            System.out.println("Положительное" + "\n");
        } else {
            System.out.println("Отрицательное" + "\n");
        }
    }

    public static boolean checkPositiveNegative(int a) {
        return a < 0;
    }

    public static void wordNumber(String a, int b) {
        for (int i = 1; i <= b; i++) {
            System.out.println(i + ")" + a);
        }
        System.out.print("\n");
    }

    public static boolean checkLeapYear(int a) {
        if (a % 400 == 0) {
            return true;
        } else if (a % 100 == 0) {
            return false;
        } else {
            return a % 4 == 0;
        }
    }

    public static void integerArray(int[] mass) {
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] == 0) {
                mass[i] = 1;
            } else {
                mass[i] = 0;
            }
            System.out.print(mass[i]);
        }
        System.out.print("\n" + "\n");
    }

    public static void emptyInteger(int size) {
        int[] p = new int[size];
        for (int i = 0; i < p.length; i++) {
            p[i] = i + 1;
            System.out.print(p[i] + " ");
        }
        System.out.print("\n" + "\n");
    }

    public static void arrayCycle(int[] mas) {
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < 6) {
                mas[i] = mas[i] * 2;
            }
            System.out.print(mas[i]);
        }
        System.out.print("\n" + "\n");
    }

    public static void twoDimensionalArray(int[][] twomas) {
        int k = 11;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (i == j) {
                    twomas[i][j] = 1;
                } else {
                    twomas[i][j] = 0;
                }
                if (i + j == k - 1) {
                    twomas[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(twomas[i][j] + "  ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public static void twoArgument(int len, int initialValue) {
        int[] r = new int[len];
        for (int i = 0; i < len; i++) {
            r[i] = initialValue;
            System.out.println(i + ")" + r[i]);
        }
    }
}