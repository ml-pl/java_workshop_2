package org.workshop;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.naming.OperationNotSupportedException;
import java.util.List;

public class Sum {

    /**
     * It should sum elements starting with 1 up to rangeMax (included).
     * Consider using the for loop to accomplish this.
     * @param rangeMax max range of numbers to sum
     * @return result of summing
     * @throws OperationNotSupportedException when rangeMax is lower than 1
     */
    public int sumFrom1To(int rangeMax) throws OperationNotSupportedException {
        if(rangeMax <= 0) throw new OperationNotSupportedException();
        int sum = 0;
        for(int i = 0; i <= rangeMax; i++){
            sum += i;
        }
        return sum;
    }

    /**
     * Method should sum all integers in a list.
     * Consider using foreach loop.
     * @param toSum list of integers to be summed up.
     * @return result of summing
     * @throws OperationNotSupportedException when list is null
     */
    public int sumAList(List<Integer> toSum) throws OperationNotSupportedException {
        if(toSum == null) throw new OperationNotSupportedException();
        int sum = 0;
        for(int e : toSum){
            sum += e;
        }
        return sum;
    }
}
