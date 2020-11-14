package edu.indwes.cis330.arrays;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class MutationCoverage {
	
	// MARK: -> Insert Items
	
	/* Create mutations for insertItem function */
	public void mutateInsertItem(int number, int[] array, int position, int mutantDecision) {
		// Mutant #0 -> run normal code without any mutants
		// Mutant #1 -> array[i - 1] -> array[i + 1];
		// Mutant #2 -> array[i - 1] -> array[i * 1];
		// Mutant #3 -> array[i - 1] -> array[i / 1];
		
		for (int i = array.length - 1; i > position; i--) {
			if (mutantDecision == 0) { array[i] = array[i - 1]; }
			if (mutantDecision == 1) { array[i] = array[i + 1]; }
			if (mutantDecision == 2) { array[i] = array[i * 1]; }
			if (mutantDecision == 3) { array[i] = array[i / 1]; }
		}
		array[position] = number;
	}
	
	@Test
	public void testInsertItem() {
		// Create needed testing items
		ArraysAPI arrayAPI = new ArraysAPI();
		int[] arr;
		int[] expectedArr;
		boolean areEqualArrays;
		
		// Test (1/4) : Ensure code without any mutants is successful
		arr = new int[] {1, 2, 3};
		expectedArr = new int[] {1, 4, 2};
		mutateInsertItem(4, arr, 1, 0);
		areEqualArrays = arrayAPI.arraysAreEqual(arr, expectedArr);
		assertTrue("Insert: Test 1/4 Passes", areEqualArrays);
		
		// Test (2/4) : Strongly kill mutant #1 - CAUSES INDEX OUT OF BOUNDS EXCEPTION
		arr = new int[] {1, 2, 3};
		expectedArr = new int[] {1, 4, 2};
		try {
			mutateInsertItem(4, arr, 1, 1);
		} catch(Exception e) {
			areEqualArrays = arrayAPI.arraysAreEqual(arr, expectedArr);
			assertTrue("Insert: Test 2/4 Passes", !areEqualArrays);
		}
		
		// Test (3/4) : Strongly kill mutant #2
		arr = new int[] {1, 2, 3};
		expectedArr = new int[] {1, 4, 2};
		try {
			mutateInsertItem(4, arr, 1, 2);
		} catch(Exception e) {
			areEqualArrays = arrayAPI.arraysAreEqual(arr, expectedArr);
			assertTrue("Insert: Test 3/4 Passes", !areEqualArrays);
		}
		
		// Test (4/4) : Strongly kill mutant #3
		arr = new int[] {1, 2, 3};
		expectedArr = new int[] {1, 4, 2};
		try {
			mutateInsertItem(4, arr, 1, 3);
		} catch(Exception e) {
			areEqualArrays = arrayAPI.arraysAreEqual(arr, expectedArr);
			assertTrue("Insert: Test 4/4 Passes", !areEqualArrays);
		}
	}
	
	// MARK: -> Remove Items
	
	/* Create mutations for removeItem function */
	public void mutateRemoveItem(int number, int[] array, int mutantDecision) {
		// Mutant #0 -> run normal code without any mutants
		// Mutant #1 -> array[i] = tempArray[i] -> array[i] = Math.abs(tempArray[i])
		// Mutant #2 -> array[i] = tempArray[i] -> array[Math.abs(i)] = tempArray[i]
		
        int[] tempArray = new int[array.length];
        int j = 0;
        for(int i = 0; i < array.length; i++) {
        	if(array[i] != number) {
        		tempArray[j] = array[i];
            	j++;
            }
        }
        for(int i = j; i < array.length; i++) {
        	tempArray[i] = 0;
        }
        for (int i = 0; i < tempArray.length;i++)
        {
        	if (mutantDecision == 0) { array[i] = tempArray[i]; }
        	if (mutantDecision == 1) { array[i] = Math.abs(tempArray[i]); }
        	if (mutantDecision == 2) { array[Math.abs(i)] = tempArray[i]; }
        }
	}

	@Test
	public void testRemoveItem() {
		// Create needed testing items
		ArraysAPI arrayAPI = new ArraysAPI();
		int[] arr;
		int[] expectedArr;
		boolean areEqualArrays;
		
		// Test (1/3) : Ensure code without any mutants is successful
		arr = new int[] {1, 2, 3};
		expectedArr = new int[] {1, 2, 0};
		mutateRemoveItem(3, arr, 0);
		areEqualArrays = arrayAPI.arraysAreEqual(arr, expectedArr);
		assertTrue("Remove: Test 1/3 Passes", areEqualArrays);
		
		
		// Test (2/3) : Weakly kill mutant #1
		arr = new int[] {1, 2, 3};
		expectedArr = new int[] {1, 2, 0};
		mutateRemoveItem(3, arr, 1);
		areEqualArrays = arrayAPI.arraysAreEqual(arr, expectedArr);
		assertTrue("Remove: Test 2/3 Passes", areEqualArrays);
		
		// Test (3/3) : Weakly kill mutant #2
		arr = new int[] {1, 2, 3};
		expectedArr = new int[] {1, 2, 0};
		mutateRemoveItem(3, arr, 2);
		areEqualArrays = arrayAPI.arraysAreEqual(arr, expectedArr);
		assertTrue("Remove: Test 2/3 Passes", areEqualArrays);
	}
}
