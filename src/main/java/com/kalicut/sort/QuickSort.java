package com.kalicut.sort;

import java.util.Arrays;

public class QuickSort implements Sort {

	@Override
	public int[] sort(int[] input) {
		int len = input.length;
		if(len <= 1) {
			return input;
		}

		int pivotIndex = partition(input);
		int[] _left = sort(Arrays.copyOfRange(input, 0, pivotIndex));
		int[] _right = sort(Arrays.copyOfRange(input, pivotIndex+1, len));
		
		for(int i=0; i<_left.length; i++) {
			input[i] = _left[i];
		}
		for(int j=0; j<_right.length; j++) {
			input[pivotIndex+1+j] = _right[j];
		}
		
		return input;
	}

	public int partition(int[] input) {
		//assume pivot is last element
		int pIndex = -1;
		int pivot = input[input.length - 1];
		
		for(int i=0; i<input.length-1; i++) {
			int _tmp = input[i];
			//System.out.println("pivot=" + pivot + ",pIndex="+ pIndex + ",nextVal=" + _tmp);
			
			if (_tmp > pivot) {
				if(pIndex == -1) {
					pIndex = i;
				}
			} else if (pIndex > -1) {
				input[i] = input[pIndex];
				input[pIndex] = _tmp;
				pIndex++;
			}
		}
		
		if(pIndex == -1) {
			pIndex = input.length - 1;
		}
		else {
			input[input.length-1] = input[pIndex];
			input[pIndex] = pivot;
		}
		
		return pIndex;
	}
	
}
