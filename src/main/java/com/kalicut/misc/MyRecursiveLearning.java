package com.kalicut.misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MyRecursiveLearning {

    static void printArray(int[] arry) {
        //base case
        if (arry == null || arry.length == 0) {
            System.out.println();
            return;
        }

        System.out.print(arry[0] + ",");
        printArray(Arrays.copyOfRange(arry, 1, arry.length));
    }

    static int factorial(int n) {
        // base case
        if (n < 2) {
            return 1;
        }

        // recursive case
        return n * factorial(n - 1);
    }

    static String reverse(String s) {
        // base case
        if (s == null || s.length() < 2) {
            return s;
        }

        // recursive case
        return reverse(s.substring(1)) + s.charAt(0);
    }

    static boolean palindrome(String s) {
        // base case
        if (s == null || s.length() < 2) {
            return true;
        }

        // recursive case
        int len = s.length();
        if (s.charAt(0) != s.charAt(len - 1)) {
            return false;
        }

        if (len - 2 > 0) {
            palindrome(s.substring(1, len - 2));
        }

        return true;
    }

    static int power(int a, int b) {
        // base case
        if (b == 0)
            return 1;

        // recursive case
        return a * power(a, b - 1);
    }

    static Map<Integer, Integer> myMap = new HashMap<>();
    static Map<Integer, Integer> map(int[] val) {
        // base case
        if (val.length == 1) {
            myMap.put(val[0], val[0]*2);
            return myMap;
        }

        // recursive case
        int _mid = val.length / 2;
        int[] _left = Arrays.copyOfRange(val, 0, _mid);
        int[] _right = Arrays.copyOfRange(val, _mid, val.length);
        map(_left);
        map(_right);
        
        return myMap;
    }

    public static void main(String[] args) {

        System.out.println("++++++++ PRINT ARRAY ++++++++");
        int[] arry = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        printArray(arry);

        System.out.println("\n++++++++ FACTORIAL ++++++++");
        int n = 10;
        System.out.println(n + "! = " + factorial(n));

        System.out.println("\n++++++++ REVERSE A STRING ++++++++");
        String s = "Hello World!!!";
        System.out.println(s + " -> " + reverse(s));

        System.out.println("\n++++++++ PALINDROME ++++++++");
        s = "Hello World!!!";
        System.out.println(s + " -> " + palindrome(s));
        s = "malayalam";
        System.out.println(s + " -> " + palindrome(s));
        s = "civic";
        System.out.println(s + " -> " + palindrome(s));
        s = "peep";
        System.out.println(s + " -> " + palindrome(s));

        System.out.println("\n++++++++ A POWER B ++++++++");
        int a = 2, b = 5;
        System.out.println(a + "^" + b + " = " + power(a, b));
        a = 3;
        b = 12;
        System.out.println(a + "^" + b + " = " + power(a, b));

        System.out.println("\n++++++++ ARRAY-2-MAP ++++++++");
        Map<Integer, Integer> m = map(arry);
        m.forEach((k,v)->System.out.println(k + " -> " + v));

    }
}
