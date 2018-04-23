package com.kalicut.datastructure.arrays;

import java.util.ArrayList;
import java.util.List;

import com.kalicut.misc.MyRecursiveLearning;

public class FindUnique {

    private static int findUniqueValueUsingBrutForce(int[] arry) {
        int nonRecurringNumber = 0;

        for (int i = 0; i < arry.length; i++) {
            boolean matchFound = false;
            for (int j = 0; j < arry.length; j++) {
                if (arry[i] == arry[j] && i != j) {
                    matchFound = true;
                    break;
                }
            }
            if (!matchFound) {
                nonRecurringNumber = arry[i];
                break;
            }
        }

        return nonRecurringNumber;
    }

    private static int findXOR(int[] arry) {
        int x = arry[0];
        for (int i = 1; i < arry.length; i++) {
            x = x ^ arry[i];
        }
        return x;
    }

    private static int findOneNonRepeating(int[] arry) {
        return findXOR(arry);
    }

    private static String findTwoNonRepeating(int[] arry) {
        int x = findXOR(arry);

        int pos = findRightMostSetBitIndex(x);
        int posVal = (int) Math.pow(2, pos);

        List<Integer> g1 = new ArrayList<Integer>();
        List<Integer> g2 = new ArrayList<Integer>();
        for (int i = 0; i < arry.length; i++) {
            if ((arry[i] & posVal) == 0) {
                g1.add(arry[i]);
            } else {
                g2.add(arry[i]);
            }
        }

        int v1 = findXOR(g1.stream().mapToInt(i->i).toArray());
        int v2 = findXOR(g2.stream().mapToInt(i->i).toArray());
        return v1 + "," + v2;
    }

    private static int findRightMostSetBitIndex(int val) {
        for (int i = 0; val != 0; i++, val >>= 1) {
            if ((val & 1) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arry = new int[] { 1, 4, 2, 3, 1, 4, 3 };
        MyRecursiveLearning.printArray(arry); 
        System.out.println("Using Brute Force = " + findUniqueValueUsingBrutForce(arry));
        System.out.println("Using XOR = " + findOneNonRepeating(arry));

        // System.out.println("+++++ RIGHT MOST SET BIT POSITION +++++");
        // for (int val : arry) {
        //     System.out.println(val + " [" + Integer.toString(val, 2) + "] --> " + findRightMostSetBitIndex(val)); 
        // }

        arry = new int[] { 1, 4, 2, 3, 5, 1, 4, 3 };
        MyRecursiveLearning.printArray(arry); 
        System.out.println("Using XOR = " + findTwoNonRepeating(arry));
    }

}