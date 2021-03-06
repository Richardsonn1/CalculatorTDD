package Calculator;

import java.util.ArrayList;

public class Calculator {
    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        return getSum(input);
    }

    private int getSum(String input) {
        String[] splitNumbers = getSplitArray(input);
        checkForNegativeNumbers(splitNumbers);
        int sum = 0;
        for (String splitNumber : splitNumbers) {
            if (!splitNumber.isEmpty() && Integer.parseInt(splitNumber) < 1001) {
                sum = sum + Integer.parseInt(splitNumber);
            }
        }
        return sum;
    }

    private void checkForNegativeNumbers(String[] splitNumbers) {
        ArrayList<Integer> negativeNumbers = new ArrayList<>();
        for (String number : splitNumbers) {
            if (!number.isEmpty() && Integer.parseInt(number) < 0) {
                negativeNumbers.add(Integer.parseInt(number));
            }
        }
        if(0 < negativeNumbers.size()){
            throw new IllegalArgumentException("Negatives not allowed! Negatives used: " + negativeNumbers.toString());
        }
    }


    /***
     * Methods to handle new types of delimiters.
     * This code is not driven through TDD though.
     *
     * getSplitArray has 3 options.
     * 1. If the input string starts with "//" it handles new types of delimiters.
     * 2. If the input contains both "," and "\n" the method decides if it is a valid input.
     * 3. Else it returns one delimiter, either comma or new line. Depending on what the input contains.
     */

    private String[] getSplitArray(String input) {
        if(input.startsWith("//")){
            int endOfDelimiters = getEndOfDelimiters(input);
            String delimiters = removeBracketsFromDelimiters(input, endOfDelimiters);
            return input.substring(endOfDelimiters + 1).split("["+ delimiters +"]");
        }
        if (input.contains(",") && input.contains("\n")) {
            String[] input1 = getTerms(input);
            if (input1 != null) return input1;
        }
        return input.indexOf(",") > input.indexOf("\n") ? input.split(",") : input.split("\n");
    }

    private String[] getTerms(String input) {
        int number = 0;
        int delimiter = 0;
        for(int i = 0; i < input.length(); i++){
            if(String.valueOf(input.charAt(i)).equals(",") || String.valueOf(input.charAt(i)).equals("\n")){
                delimiter++;
            }else if(0 < Integer.parseInt(input)){
                number++;
            }
        }
        return delimiter < number ? input.split("[,\n]") : null;
    }

    private int getEndOfDelimiters(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.contains("]") && String.valueOf(input.charAt(i)).equals("\n")
                    && String.valueOf(input.charAt(i - 1)).equals("]")) {
                return i;
            }
        }
        return input.indexOf("\n");
    }

    private String removeBracketsFromDelimiters(String input, int endOfDelimiters) {
        String delimiters = input.substring(2, endOfDelimiters);
        if(delimiters.contains("[") && delimiters.contains("]")){
            delimiters = delimiters.replaceAll("\\[", "").replaceAll("]", "");
        }
        return delimiters;
    }

}
