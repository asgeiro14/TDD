package is.ru.stringcalculator;

public class Calculator{

    public static int add(String text){
        if(text.startsWith("//")){
            String newString = text.substring(4);
            text = newString.replaceAll(Character.toString(text.charAt(2)), ",");
        }
        text = text.replaceAll("\n", ",");
        if(text.equals("")){
            return 0;            }
        else {
            if(text.contains(",")){
                String numbers[] = text.split(",");
                return sum(numbers);
            }
            return toInt(text);
        }
    }

    private static int toInt(String number){
        return Integer.parseInt(number);
    }

    private static int sum(String[] numbers){
        boolean flag = false;
        String negNum = "";
        int total = 0;
        
        for(String number : numbers){
            if(number.contains("-")){
                negNum = negNum + number + ","; 
                flag = true;
            }else{
                int toAdd = toInt(number);
                if(toAdd <= 1000){
                    total += toAdd;
                }
            }
        }
        if(flag == true){
            String negativeNumbers = negNum.substring(0, negNum.length() - 1);
            throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbers);
        }
        else { 
            return total;
        }
    }
}