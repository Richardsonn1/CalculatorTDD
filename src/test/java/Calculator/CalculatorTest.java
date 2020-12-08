package Calculator;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

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
}
