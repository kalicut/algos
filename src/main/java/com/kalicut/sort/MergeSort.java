package com.kalicut.sort;

import java.util.Arrays;

public class MergeSort implements Sort {

	@Override
	public int[] sort(int[] input) {
		int len = input.length;		
		if(len == 1) {
			return input;
		}
		
		int[] _left = sort(Arrays.copyOfRange(input, 0, len/2));
		int[] _right = sort(Arrays.copyOfRange(input, len/2, len));
		
		int[] c = merge(_left, _right);
		return c;
	}
	
	private int[] merge(int[] leftArry, int[] rightArry) {
		int[] combinedSortedArry = new int[leftArry.length+rightArry.length];
		
		int i=0, j=0, k=0;
		while ( i < leftArry.length && j < rightArry.length ) {
			if(leftArry[i] < rightArry[j]) {
				combinedSortedArry[k++] = leftArry[i++];
			} 
			else if (leftArry[i] > rightArry[j]) {
				combinedSortedArry[k++] = rightArry[j++];
			}
			else {
				combinedSortedArry[k++] = leftArry[i++];
				combinedSortedArry[k++] = rightArry[j++];
			}
		}
		
		while (i < leftArry.length) {
			combinedSortedArry[k++] = leftArry[i++];
		} 
		while (j < rightArry.length) {
			combinedSortedArry[k++] = rightArry[j++];
		}
		
		return combinedSortedArry;
	}
	
}
