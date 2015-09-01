package org.workshop;

import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test(dataProvider = "calc")
    public void calculatorTest(ArithmeticOperation operation, int left, int right, int expected){
        assertThat(calculator.calculate(operation, left, right), Matchers.equalTo(expected));
    }

    @DataProvider(name = "calc")
    public Object[][] params(){
        return new Object[][]{
                { ArithmeticOperation.ADDITION, 1, 2, 3 }
        };
    }
}
