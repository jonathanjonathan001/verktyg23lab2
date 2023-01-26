package stringcalculator;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.equals(""))
            return 0;
        else if (numbers.length() == 1)
            return Integer.parseInt(numbers);
        else {
            int result = 0;
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < numbers.length(); i++) {
                if (numbers.charAt(i) != ',' && numbers.charAt(i) != '\n') {
                        stringBuilder.append(numbers.charAt(i));
                }

                else {
                    if (!stringBuilder.isEmpty()) {
                        result += Integer.parseInt(stringBuilder.toString());
                        stringBuilder.delete(0, stringBuilder.length());
                    }
                }

            }
            result += Integer.parseInt(stringBuilder.toString());
            return result;
        }


    }
}
