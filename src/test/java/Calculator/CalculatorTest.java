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
    void UnknownAmountOfIntegerShouldReturnCorrectValue(){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int rng = random.nextInt(10);
        int expected = 0;
        for(int i = 0; i < rng; i++){
            sb.append(i).append(",");
            expected = expected + i;
        }
        String numbers = String.valueOf(sb);
        int result = calculator.add(numbers);
        assertEquals(expected, result, "Sum of String numbers & expected should be the same.");
    }
}
