package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();

    @Test
    void callingAddWithEmptyStringReturnsZero() {
        int result = stringCalculator.add("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void callingAddWithStringWithOneDigitReturnsThatDigit(){
        int result = stringCalculator.add("1");
        assertThat(result).isEqualTo(1);
    }
    
    @Test
    void callingAddWithTwoCommaSeparatedValuesReturnsTheSumOfTheValues(){
        int result = stringCalculator.add("10,20");
        assertThat(result).isEqualTo(30);
    }

    @Test
    void callingAddWithThreeCommaSeparatedValuesReturnsTheSumOfTheValues() {
        int result = stringCalculator.add("10,20,30");
        assertThat(result).isEqualTo(60);
    }

    @Test
    void callingAddWithLineBreaksReturnsTheSumTheValues(){
        int result = stringCalculator.add("10\n20,30");
        assertThat(result).isEqualTo(60);
    }

    @Test
    void callingAddWithDelimiterOptionReturnsTheCorrectSum() {
        int result = stringCalculator.add("//;\n1;2");
        assertThat(result).isEqualTo(3);

    }

}