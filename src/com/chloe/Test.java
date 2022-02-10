package com.chloe;

import java.util.List;

/**
 * Created by Chloe on 2020-06-16
 */
public class Test {

    public static void main(String[] args) {

    }

    // 3,4,5,5,4,16

    //3
    //null
    //1,2,2
    //2,2,2,2,2,2,2
    // 3,4,5,5,4,16
    // -3,-4,5,5,-4,16
    public int countPythagoras(List<Integer> numbers) {
        int[] numberArr = new int[numbers.size()];
        for (int i = 0; i <numbers.size(); i++) {
            numberArr[i] = numbers.get(i) * numbers.get(i);
        }

        if (numbers.size()<3) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < numberArr.length-2; i++) {
            for (int j = i+1; j < numberArr.length-1; j++) {
                for (int k = j+1; k < numberArr.length; k++) {
                    if (numberArr[i] + numberArr[j] == numberArr[k]) {
                        count ++;
                    }
                }
            }
        }

        return count;
    }
}
