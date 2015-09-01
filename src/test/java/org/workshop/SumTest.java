package org.workshop;

import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class SumTest {

    private Sum sum = new Sum();

    @Test
    public void sum1() throws Exception {
        assertEquals(1, sum.sumFrom1To(1));
    }

    @Test
    public void sum2() throws Exception {
        assertEquals(3, sum.sumFrom1To(2));
    }

    @Test
    public void sum10() throws Exception {
        assertEquals(55, sum.sumFrom1To(10));
    }

    @Test(expectedExceptions = OperationNotSupportedException.class)
    public void sumFailed() throws Exception {
        sum.sumFrom1To(-1);
    }

    @Test(expectedExceptions = OperationNotSupportedException.class)
    public void sumAListFailed() throws Exception {
        sum.sumAList(null);
    }

    @Test(dataProvider = "sumData")
    public void sumTest(int limit, int expected) throws OperationNotSupportedException {
        assertThat(sum.sumFrom1To(limit), equalTo(expected));
    }

    @DataProvider(name = "sumData")
    public Object[][] sumDataProvider() {
        return new Object[][]{
                {1, 1},
                {2, 3},
                {3, 6}
        };
    }

    @Test(dataProvider = "listSum")
    public void sumAListTest(List<Integer> listToSum, int expected) throws OperationNotSupportedException {
        assertThat(sum.sumAList(listToSum), equalTo(expected));
    }

    @DataProvider(name = "listSum")
    public Object[][] sumAListDataProvider() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(7);
        return new Object[][]{
                {new ArrayList<Integer>(), 0},
                {list, 8},
                {IntStream.range(1, 11).boxed().collect(Collectors.toList()), 55}
        };
    }

}
