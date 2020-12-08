package Calculator;

import java.util.ArrayList;

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
        ArrayList<Integer> negativeNumbers = new ArrayList<>();
        for (int i = 0; i < splitNumbers.length; i++) {
            String number = splitNumbers[i];
            if (!number.isEmpty() && Integer.parseInt(number) < 0) {
                negativeNumbers.add(Integer.parseInt(number));
            }
        }
        if(0 < negativeNumbers.size()){
            throw new IllegalArgumentException("Negatives not allowed! Negatives used: " + negativeNumbers.toString());
        }
        int sum = 0;
        for (String splitNumber : splitNumbers) {
            if (!splitNumber.isEmpty()) {
                sum = sum + Integer.parseInt(splitNumber);
            }
        }
        return sum;
    }
}
