package org.workshop;

import org.testng.annotations.Test;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.testng.Assert.assertEquals;

public class SumTest {

    private Sum sum = new Sum();

    @Test
    public void sum1() throws Exception{
        assertEquals(1, sum.sumFrom1To(1));
    }

    @Test
    public void sum2() throws Exception{
        assertEquals(3, sum.sumFrom1To(2));
    }

    @Test
    public void sum10() throws Exception{
        assertEquals(55, sum.sumFrom1To(10));
    }

    @Test(expectedExceptions = OperationNotSupportedException.class)
    public void sumFailed() throws Exception{
        sum.sumFrom1To(-1);
    }

    @Test
    public void sumEmptyList() throws Exception{
        assertEquals(0, sum.sumAList(new ArrayList<>()));
    }

    @Test
    public void sumOneElementList() throws Exception{
        assertEquals(1, sum.sumAList(Collections.singletonList(1)));
    }

    @Test
    public void sum10elementsList() throws Exception{
        List<Integer> toSum = IntStream.range(1, 11).boxed().collect(Collectors.toList());
        assertEquals(55, sum.sumAList(toSum));
    }

    @Test(expectedExceptions = OperationNotSupportedException.class)
    public void sumAListFailed() throws Exception{
        sum.sumAList(null);
    }


}
