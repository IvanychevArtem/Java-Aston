package org.example;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class FactorialTest {

    @DataProvider(name = "factorialData")
    public Object[][] factorialData() {
        return new Object[][]{
                {0, 1},
                {1, 1},
        };
    }

    @Test(dataProvider = "factorialData")
    public void testFactorial(int input, int expected) {
        assertEquals(Factorial.factorial(input), expected);
    }
    @Test
    public void testFactorialNumber(){
        assertEquals(Factorial.factorial(-1), 0, "Факториал не определен для отрицательных чисел");
    }
    @Test(groups = "Major")
    public void testFactorialFive(){
        assertEquals(Factorial.factorial(5), 120, "Факториал 5 должен быть 120");
    }
    @Test(groups = "Major")
    public void testFactorialTen(){
        assertEquals(Factorial.factorial(10), 3628800, "Факториал 10 должен быть 3628800");
    }
}