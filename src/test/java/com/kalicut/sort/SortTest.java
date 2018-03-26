package com.kalicut.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SortTest {
    int[] input = null;
    int[] inputSortedAsc = null;
    int[] inputSortedDesc = null;
    
    @Before
    public void runBeforeTestMethod() {
        Random random = new Random();
		input = random.ints(-1000,1000).limit(10).toArray();
		
		inputSortedAsc = IntStream.of(input)
		        .boxed()
		        .sorted()
		        .mapToInt(i -> i)
		        .toArray();

		inputSortedDesc = IntStream.of(input)
		        .boxed()
		        .sorted(Comparator.reverseOrder())
		        .mapToInt(i -> i)
		        .toArray();
    }
    
    @Test
    public void testBubbleSort() {
    	System.out.println("\n===== BUBBLE SORT =====");
    	System.out.println("INPUT " + Arrays.toString(input));
        Sort _sort = new BubbleSort();
        int[] output = _sort.sort(input);
        System.out.println("OUTPUT " + Arrays.toString(output));
        assertArrayEquals(inputSortedAsc, output);
    }

    @Test
    public void testBubbleSortWithSortedAscInput() {
    	System.out.println("\n===== BUBBLE SORT [SORTED ASC INPUT] =====");
    	System.out.println("INPUT " + Arrays.toString(inputSortedAsc));
        Sort _sort = new BubbleSort();
        int[] output = _sort.sort(inputSortedAsc);
        System.out.println("OUTPUT " + Arrays.toString(output));
        assertArrayEquals(inputSortedAsc, output);
    }
    
    @Test
    public void testBubbleSortWithSortedDescInput() {
    	System.out.println("\n===== BUBBLE SORT [SORTED DESC INPUT] =====");
    	System.out.println("INPUT " + Arrays.toString(inputSortedDesc));
        Sort _sort = new BubbleSort();
        int[] output = _sort.sort(inputSortedDesc);
        System.out.println("OUTPUT " + Arrays.toString(output));
        assertArrayEquals(inputSortedAsc, output);
    }
    

    @Test
    public void testReplacementSort() {
    	System.out.println("\n===== REPLACEMENT/SELECTION SORT =====");
    	System.out.println("INPUT " + Arrays.toString(input));
        Sort _sort = new ReplacementSort();
        int[] output = _sort.sort(input);
        System.out.println("OUTPUT " + Arrays.toString(output));
        assertArrayEquals(inputSortedAsc, output);        
    }

    @Test
    public void testReplacementSortWithSortedAscInput() {
    	System.out.println("\n===== REPLACEMENT/SELECTION SORT [SORTED ASC INPUT] =====");
    	System.out.println("INPUT " + Arrays.toString(inputSortedAsc));
        Sort _sort = new ReplacementSort();
        int[] output = _sort.sort(inputSortedAsc);
        System.out.println("OUTPUT " + Arrays.toString(output));
        assertArrayEquals(inputSortedAsc, output);        
    }
    
    @Test
    public void testReplacementSortWithSortedDescInput() {
    	System.out.println("\n===== REPLACEMENT/SELECTION SORT [SORTED DESC INPUT] =====");
    	System.out.println("INPUT " + Arrays.toString(inputSortedDesc));
        Sort _sort = new ReplacementSort();
        int[] output = _sort.sort(inputSortedDesc);
        System.out.println("OUTPUT " + Arrays.toString(output));
        assertArrayEquals(inputSortedAsc, output);        
    }

    @Test
    public void testMergeSort() {
    	System.out.println("\n===== MERGE SORT =====");
    	System.out.println("INPUT " + Arrays.toString(input));
        Sort _sort = new MergeSort();
        int[] output = _sort.sort(input);
        System.out.println("OUTPUT " + Arrays.toString(output));
        assertArrayEquals(inputSortedAsc, output);
    }

    @Test
    public void testMergeSortWithSortedAscInput() {
    	System.out.println("\n===== MERGE SORT [SORTED ASC INPUT] =====");
    	System.out.println("INPUT " + Arrays.toString(inputSortedAsc));
        Sort _sort = new MergeSort();
        int[] output = _sort.sort(inputSortedAsc);
        System.out.println("OUTPUT " + Arrays.toString(output));
        assertArrayEquals(inputSortedAsc, output);        
    }
    
    @Test
    public void testMergeSortWithSortedDescInput() {
    	System.out.println("\n===== MERGE SORT [SORTED DESC INPUT] =====");
    	System.out.println("INPUT " + Arrays.toString(inputSortedDesc));
        Sort _sort = new MergeSort();
        int[] output = _sort.sort(inputSortedDesc);
        System.out.println("OUTPUT " + Arrays.toString(output));
        assertArrayEquals(inputSortedAsc, output);        
    }
    
    @Test
    public void testQuickSort() {
    	System.out.println("\n===== QUICK SORT =====");
    	System.out.println("INPUT " + Arrays.toString(input));
        Sort _sort = new QuickSort();
        int[] output = _sort.sort(input);
        System.out.println("OUTPUT " + Arrays.toString(output));
        assertArrayEquals(inputSortedAsc, output);
    }

    @Test
    public void testQuickSortWithSortedAscInput() {
    	System.out.println("\n===== QUICK SORT [SORTED ASC INPUT] =====");
    	System.out.println("INPUT " + Arrays.toString(inputSortedAsc));
        Sort _sort = new QuickSort();
        int[] output = _sort.sort(inputSortedAsc);
        System.out.println("OUTPUT " + Arrays.toString(output));
        assertArrayEquals(inputSortedAsc, output);
    }

    @Test
    public void testQuickSortWithSortedDescInput() {
    	System.out.println("\n===== QUICK SORT [SORTED DESC INPUT] =====");
    	System.out.println("INPUT " + Arrays.toString(inputSortedDesc));
        Sort _sort = new QuickSort();
        int[] output = _sort.sort(inputSortedDesc);
        System.out.println("OUTPUT " + Arrays.toString(output));
        assertArrayEquals(inputSortedAsc, output);
    }

}