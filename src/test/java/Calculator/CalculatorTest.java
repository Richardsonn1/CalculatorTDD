package Calculator;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void EmptyLineInputReturnsZero(){
        Calculator calculator = new Calculator();
        String input = "";
        int result = calculator.add(input);
        assertEquals(0,result, "Sum by nothing should be 0.");
    }
}
