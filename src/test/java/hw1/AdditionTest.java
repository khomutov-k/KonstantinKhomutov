package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AdditionTest {

    Calculator calc = new Calculator();

    @DataProvider(name = "additionDataLong")
    public static Object[][] createLongData() {
        return new Object[][]{
                {1L, 2L, 3L},
                {2L, 4L, 6L}
        };
    }

    @DataProvider(name = "additionDataDouble")
    public static Object[][] createDoubleData() {
        return new Object[][]{
                {1.2D, 3.5D, 4.7D},
                {1D, 2D, 3D}
        };
    }

    @Test(dataProvider = "additionDataLong")
    public void longSumPositiveTest(long a, long b, long expected) {
        Long actual = calc.sum(a, b);
        assertThat(actual).as("Calculation went wrong")
                .isEqualTo(expected);
    }

    @Test(dataProvider = "additionDataDouble")
    public void doubleSumPositiveTest(double a, double b, double expected) {
        Double actual = calc.sum(a, b);
        assertThat(actual).as("Calculation went wrong")
                .isEqualTo(expected);
    }
}
