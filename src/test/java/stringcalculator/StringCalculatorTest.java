package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();

    @Test
    void whenCallingAddWithEmptyStringReturnsZero() {
        int result = stringCalculator.add("");
        assertThat(result).isEqualTo(0);
    }

}