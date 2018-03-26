package com.kalicut.sort;

public class BubbleSort implements Sort {

    public int[] sort(int[] input) {
    	
        for(int i=0; i < input.length-1; i++) {
        	boolean noSwaps = true;
            for (int j=0; j < input.length-i-1; j++) {
                if (input[j] > input[j+1]) {
                    int _tmp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = _tmp;
                    noSwaps = false;
                }
            }
            
            if(noSwaps) { break; }
        }

        return input;
    }


}