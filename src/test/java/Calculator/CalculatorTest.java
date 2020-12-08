package Calculator;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void EmptyLineInputReturnsZero(){
        Calculator calculator = new Calculator();
        assertEquals(0,calculator.add(""), "Sum by nothing should be 0.");
    }

    @Test
    void OneIntegerInputShouldReturnSameValue(){
        Calculator calculator = new Calculator();
        String input = "1";
        int result = calculator.add(input);
        assertEquals(1,result,"1 + nothing should return 1.");
    }
}
