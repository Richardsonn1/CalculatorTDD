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
            int sum = 0;
            for(int i = 0; i < splitNumbers.length; i++){
                sum = sum + Integer.parseInt(splitNumbers[i]);
            }
            return sum;
        }
    }
}
