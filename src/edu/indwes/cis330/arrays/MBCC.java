package edu.indwes.cis330.arrays;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

// Corresponding Spreadsheet for all information:
// https://docs.google.com/spreadsheets/d/1Zl5Qw1WaQ451E9IOaJXr3sv01GcbX73Ne5VUveSeL9k/edit?usp=sharing

public class MBCC {
	
	// MARK: -> Insert Items
	
	@Test
	public void testInsertItem() {
		// Create needed testing items
		ArraysAPI arrayAPI = new ArraysAPI();
		int[] arr;
		int[] expectedArr;
		boolean areEqualArrays;
		
		// Test 1/3 (b3, b2, b2) : (Size of list > 1, Value of position = 1, List not null)
		arr = new int[] {1, 2, 3};
		expectedArr = new int[] {1, 1, 2};
		arrayAPI.addItem(1, arr, 1);
		areEqualArrays = arrayAPI.arraysAreEqual(arr, expectedArr);
		assertTrue("Insert: Test 1/3 Passes", areEqualArrays);
		
		// Test 2/3 (b2, b1, b2) : (Size of list = 1, Value of position = 0, List not null)
		arr = new int[] {1};
		expectedArr = new int[] {1};
		arrayAPI.addItem(1, arr, 0);
		areEqualArrays = arrayAPI.arraysAreEqual(arr, expectedArr);
		assertTrue("Insert: Test 2/3 Passes", areEqualArrays);
		
		// Test 3/3 (b3, b2, b2) : (Size of list > 1, Value of position = 1, List not null)
		arr = new int[] {1, 2};
		expectedArr = new int[] {1, 1};
		arrayAPI.addItem(1, arr, 1);
		areEqualArrays = arrayAPI.arraysAreEqual(arr, expectedArr);
		assertTrue("Insert: Test 3/3 Passes", areEqualArrays);
		
	}
	
	// MARK: -> Remove Items

	@Test
	public void testRemoveItem() {
		// Create needed testing items
		ArraysAPI arrayAPI = new ArraysAPI();
		int[] arr;
		int[] expectedArr;
		boolean areEqualArrays;
		
		// Test 1/3 (b2, b1, b2) : (Size of list = 1, # of occurrences of element = 0, List not null)
		arr = new int[] {2};
		expectedArr = new int[] {2};
		arrayAPI.removeItem(1, expectedArr);
		areEqualArrays = arrayAPI.arraysAreEqual(arr, expectedArr);
		assertTrue("Remove: Test 1/3 Passes", areEqualArrays);
		
		// Test 2/3 (b2, b2, b2) : (Size of list = 1, #  of occurrences of element = 1, List not null)
		arr = new int[] {1};
		expectedArr = new int[] {0};
		arrayAPI.removeItem(1, arr);
		areEqualArrays = arrayAPI.arraysAreEqual(arr, expectedArr);
		assertTrue("Remove: Test 2/3 Passes", areEqualArrays);
		
		// Test 3/3 (b3, b2, b2) : (Size of list > 1, # of occurrences of element = 1, List not null)
		arr = new int[] {1, 2};
		expectedArr = new int[] {2, 0};
		arrayAPI.removeItem(1, arr);
		areEqualArrays = arrayAPI.arraysAreEqual(arr, expectedArr);
		assertTrue("Remove: Test 3/3 Passes", areEqualArrays);
	}

}
