package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SubtractionTest {

    Calculator calc = new Calculator();

    @DataProvider(name = "subtractionDataLong")
    public static Object[][] createLongData() {
        return new Object[][]{
                {2L, 1L, 1L},
                {4L, 2L, 2L}
        };
    }

    @DataProvider(name = "subtractionDataDouble")
    public static Object[][] createDoubleData() {
        return new Object[][]{
                {4.7D, 1.2D, 3.5D},
                {4D, 4D, 0D}
        };
    }

    @Test(dataProvider = "subtractionDataLong")
    public void longSubPositiveTest(long a, long b, long expected) {
        Long actual = calc.sub(a, b);
        assertThat(actual).as("Calculation went wrong")
                .isEqualTo(expected);
    }

    @Test(dataProvider = "subtractionDataDouble")
    public void doubleSubPositiveTest(double a, double b, double expected) {
        Double actual = calc.sub(a, b);
        assertThat(actual).as("Calculation went wrong")
                .isEqualTo(expected);
    }
}
