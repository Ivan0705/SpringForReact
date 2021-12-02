package spring_react.demo.SimpleUnitTest;

import org.junit.*;

public class SimpleUnitTest {
    @Test
    public void simpleTest() {
        System.out.println("This is simple test");
    }

    @Before
    public void before() {
        System.out.println("Before each test");
    }

    @Test
    public void test() {
        int firstNumber = 2;
        int secondNumber = 2;

        Assert.assertEquals(firstNumber, secondNumber);
        Assert.assertEquals(firstNumber, secondNumber * firstNumber);
    }

    @Ignore
    @Test(expected = ArithmeticException.class)
    public void error() {
        int number1 = 10;
        int number2 = 1;
        int result = number1 / number2;
        System.out.println(result);
    }

    @After
    public void after() {
        System.out.println("After each test");
    }
}
