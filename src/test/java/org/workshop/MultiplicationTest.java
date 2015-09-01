package org.workshop;

import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class MultiplicationTest {

    public int multiply(int param1, int param2){
        return param1 * param2;
    }

    @Test(dataProvider = "multiplyProvider")
    public void testMultiplication(int param1, int param2, int expected){
        assertThat(multiply(param1, param2), Matchers.equalTo(expected));
    }

    @DataProvider(name = "multiplyProvider")
    public Object[][] data(){

        Object[][] tab = new Object[100][3];
        int idx = 0;
        for(int p1 = 0; p1 < 10; p1++){
            for(int p2 = 0; p2 < 10; p2++){
                tab[idx] = new Object[]{p1+1, p2+1, (p1+1)*(p2+1)};
                idx ++;
            }
        }

        return tab;
    }


//    { p1, p2, expected},
//    { p1, p2, expected}
}
