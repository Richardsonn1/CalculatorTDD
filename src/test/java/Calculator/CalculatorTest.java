package Calculator;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void EmptyLineInputReturnsZero(){
        assertEquals(0,calculator.add(""), "Sum by nothing should be 0.");
    }

    @Test
    void OneIntegerInputShouldReturnSameValue(){
        assertEquals(1,calculator.add("1"),"1 + nothing should return 1.");
    }

    @Test
    void TwoIntegersInputWithDelimiterShouldReturnSum(){
        assertEquals(3, calculator.add("1,2"), "Sum by 1 + 2 should be 3.");
    }

    @Test
    void UnknownAmountOfIntegerShouldReturnCorrectSum(){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int rng = random.nextInt(10);
        int expected = 0;
        for(int i = 0; i < rng; i++){
            sb.append(i).append(",");
            expected = expected + i;
        }
        assertEquals(expected, calculator.add(String.valueOf(sb)), "Sum of String numbers & expected should be the same.");
    }

    @Test
    void NewLineDelimiterBetweenNumbers(){
        assertEquals(3, calculator.add("1\n2"), "Sum by 1 + 2 should be 3.");
    }

    @Test
    void DifferentDelimiterSupportBetweenNumbers(){
        assertEquals(3, calculator.add("//;\n1;2"), "Sum by 1 + 2 should be 3.");
    }

    @Test
    void ThrowNegativeNumbersNotAllowed(){
        assertThrows(IllegalArgumentException.class, () -> calculator.add("-1,-2\n3"));
    }

    @Test
    void NumbersBiggerThenThousandShouldBeRemoved(){
        assertEquals(1,calculator.add("1,10001"), "1 + nothing should be 1.");
    }
    @Test
    void MoreTypesOfDelimitersSupportBetweenNumbers(){
        String numbers = "//[***]\n1***2***3";
        int result = calculator.add(numbers);
        assertEquals(6, result, "Sum by 1 + 2 + 3 should be 6.");
    }
}
