package com.kalicut.sort;

public class ReplacementSort implements Sort {

	@Override
	public int[] sort(int[] input) {
		for (int i=0; i<input.length-1; i++) {
			for (int j=i+1; j<input.length; j++) {
				if(input[j]<input[i]) {
					int _tmp = input[i];
					input[i] = input[j];
					input[j] = _tmp;
				}
			}
		}
		
		return input;
	}

}
