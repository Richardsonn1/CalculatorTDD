package Calculator;

public class Calculator {
    public int add(String input) {
        if(input.isEmpty()) {
            return 0;
        }
        if(input.length() == 1){
            return Integer.parseInt(input);
        }else{
            String[] splitNumbers = input.split(",");
            return Integer.parseInt(splitNumbers[0]) + Integer.parseInt(splitNumbers[1]);
        }
    }
}
