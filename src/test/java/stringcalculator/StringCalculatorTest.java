package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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

    @Test
    void callingAddWithNegativeNumbersResultsInAnExceptionThrown() {

        assertThatThrownBy(() -> stringCalculator.add("-1,-2")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("negatives not allowed: -1, -2");

    }

    @Test
    void callingAddWithNumberGreaterThan1000ShouldIgnoreThatNumber() {
        int result = stringCalculator.add("2,1001");
        assertThat(result).isEqualTo(2);
    }

    @Test
    void callindAddWithDelimiterOfAnyLengthReturnsCorrectResult() {
        int result = stringCalculator.add("//[***]\n1***2***3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void callingAddWithMultipleDelimitersReturnsCorrectResult() {
        int result = stringCalculator.add("//[*][%]\n1*2%3");
    }

}