package Calculator;

public class Calculator {
    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        } else {
            return getSum(input);
        }
    }

    private int getSum(String input) {
        String[] splitNumbers = input.split("[,\n/;]");
        int sum = 0;
        for (String splitNumber : splitNumbers) {
            if (!splitNumber.isEmpty()) {
                sum = sum + Integer.parseInt(splitNumber);
            }
        }
        return sum;
    }
}
