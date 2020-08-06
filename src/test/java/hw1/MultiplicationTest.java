package hw1;


import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MultiplicationTest {

    Calculator calc;

    @BeforeMethod
    public void setUp() {
        calc = new Calculator();
    }

    @DataProvider(name = "multiplicationDataLong")
    public static Object[][] createLongData() {
        return new Object[][]{
                {1L, 2L, 2L},
                {2L, 4L, 8L}
        };
    }

    @DataProvider(name = "multiplicationDataDouble")
    public static Object[][] createDoubleData() {
        return new Object[][]{
                {1D, 3D, 3D},
                {1D, 2D, 2D}
        };
    }

    @Test(dataProvider = "multiplicationDataLong")
    public void longMultPositiveTest(long a, long b, long expected) {
        Long actual = calc.mult(a, b);
        assertThat(actual).as("Calculation went wrong")
                .isEqualTo(expected);
    }

    @Test(dataProvider = "multiplicationDataDouble")
    public void doubleMultPositiveTest(double a, double b, double expected) {
        Double actual = calc.mult(a, b);
        assertThat(actual).as("Calculation went wrong")
                .isEqualTo(expected);
    }


}
