package stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.equals(""))
            return 0;
        else if (numbers.length() == 1)
            return Integer.parseInt(numbers);
        else {
            int result = 0;
            boolean hasNegatives = false;

            StringBuilder delimiterChars = new StringBuilder();
            delimiterChars.append(",");
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder negativesStringBuilder = new StringBuilder();

            for (int i = 0; i < numbers.length(); i++) {
                if (numbers.length() >= 3 && numbers.charAt(0) == '/'
                        && numbers.charAt(1) == '/') {

                    if (numbers.charAt(2) != '[') {
                        delimiterChars.append(numbers.charAt(i + 2));
                        numbers = numbers.substring(3);
                        i = 0;
                        continue;
                    } else if (numbers.charAt(i + 2) != '[' && numbers.charAt(i + 2) != ']') {
                        delimiterChars.append(numbers.charAt(i + 2));
                        continue;
                    } else if (numbers.charAt(i + 2) != ']') {
                        delimiterChars.append(numbers.charAt(i + 3));
                        continue;
                    } else {
                        numbers = numbers.substring(i+3);
                        i = 0;
                        continue;
                    }

                }


                if (!delimiterChars.toString().contains("" + numbers.charAt(i)) && numbers.charAt(i) != '\n') {

                    stringBuilder.append(numbers.charAt(i));

                } else {

                    if (!stringBuilder.isEmpty()) {
                        int numberToAdd = Integer.parseInt(stringBuilder.toString());
                        if (numberToAdd < 0) {
                            hasNegatives = true;
                            negativesStringBuilder.append("").append(numberToAdd).append(", ");

                        }
                        if (numberToAdd <= 1000) {
                            result += numberToAdd;

                        }

                    }

                    stringBuilder.delete(0, stringBuilder.length());
                }


            }
            int numberToAdd = Integer.parseInt(stringBuilder.toString());
            if (numberToAdd <= 1000)
                result += numberToAdd;
            if (numberToAdd < 0) {
                hasNegatives = true;
                negativesStringBuilder.append("").append(numberToAdd);
            }
            if (hasNegatives)
                throw new IllegalArgumentException("negatives not allowed: " + negativesStringBuilder.toString());

            return result;
        }


    }
}
