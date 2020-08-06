package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DivideTest {

    Calculator calc = new Calculator();

    @DataProvider(name = "divisionDataLong")
    public static Object[][] createLongData() {
        return new Object[][]{
                {4L, 2L, 2L},
                {7L, 4L, 1L}
        };
    }

    @DataProvider(name = "divisionDataDouble")
    public static Object[][] createDoubleData() {
        return new Object[][]{
                {7D, 4D, 1.75D},
                {4D, 2D, 2D}
        };
    }

    @Test(dataProvider = "divisionDataLong")
    public void longDivPositiveTest(long a, long b, long expected) {
        Long actual = calc.div(a, b);
        assertThat(actual).as("Calculation went wrong")
                .isEqualTo(expected);
    }

    @Test(dataProvider = "divisionDataDouble")
    public void doubleDivPositiveTest(double a, double b, double expected) {
        Double actual = calc.div(a, b);
        assertThat(actual).as("Calculation went wrong")
                .isEqualTo(expected);
    }
}
