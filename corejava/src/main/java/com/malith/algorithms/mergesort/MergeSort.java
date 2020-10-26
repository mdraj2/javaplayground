package com.malith.algorithms.mergesort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
	// you need a splitting algorithm

	public static void main(String[] args) {
		ArrayList<Integer> sample = new ArrayList<>();
		sample.add(8);
		sample.add(3);
		sample.add(5);
		sample.add(4);
		sample.add(7);
		sample.add(6);
		sample.add(1);
		sample.add(2);
		List<Integer> sorted = MergeSort.split(sample);
		System.out.println(sorted);
	}

	public static List<Integer> split(List<Integer> array) {

		// the base case is when the you only have one array
		//note that this program will not work if the array does not have any value
		if (array.size() == 1) {
			// this is where you will need to write your merge function
			// it will need to the
			return array;
		}

		// you need to split this array by getting the midpoint and splitting it again
		double midpointD = array.size() / 2;
		int midpoint = (int) midpointD;

		List<Integer> leftHandArray = array.subList(0, midpoint);
		List<Integer> rightHandArray = array.subList(midpoint, array.size());
		// you need to run this split function on both the left and the righthand side
		// it should return a sorted array
		List<Integer> sortLeftHandArray = MergeSort.split(leftHandArray);
		List<Integer> sortRightHandArray = MergeSort.split(rightHandArray);
		// merge the lefthandsort and the righthand sorted

		List<Integer> combinedArray = MergeSort.mergeTwoSortedArray(sortLeftHandArray, sortRightHandArray);

		return combinedArray;
	}

	public static List<Integer> mergeTwoSortedArray(List<Integer> array1, List<Integer> array2) {
		// this is where you will need to write the comparison functions

		// you will need three counters
		int i = 0;
		int j = 0;

		// size of the new array is equal to the size of array1 and array2
		int size = array1.size() + array2.size();
		List<Integer> sortedArray = new ArrayList<>(size);

		while (i < array1.size() && j < array2.size()) {
			int curArray1Value = array1.get(i);
			int curArray2Value = array2.get(j);
			if (curArray1Value < curArray2Value) {
				sortedArray.add(curArray1Value);
				i++;
			} else {
				sortedArray.add(curArray2Value);
				j++;
			}
		}
		
		//You could have done this logic in a while loop aswell
		if (i < array1.size()) {
			// this means that array1 is still bigger
			// you want to loop of the remaining of array1 and insert it
			for (int z = i; z < array1.size(); z++) {
				int curValue = array1.get(z);
				sortedArray.add(curValue);
			}
		} else if (j < array2.size()) {
			for (int z = j; z < array2.size(); z++) {
				int curValue = array2.get(z);
				sortedArray.add(curValue);
			}

		}
		return sortedArray;
	}

}
