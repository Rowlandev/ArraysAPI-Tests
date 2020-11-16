import static org.junit.Assert.assertTrue;
import org.junit.Test;

// Corresponding Spreadsheet for all information:
// https://docs.google.com/spreadsheets/d/1Zl5Qw1WaQ451E9IOaJXr3sv01GcbX73Ne5VUveSeL9k/edit?usp=sharing

public class RACC {
		
	@Test
	public void testInsertItem() {
		// Create needed testing items
		ArraysAPI arrayAPI = new ArraysAPI();
		int[] arr;
		int[] expectedArr;
		boolean areEqualArrays;
		
//		Test 1 (i > position = true) 
//		*i > position until i iterates down to 4.
		arr = new int[] {1, 2, 3, 4, 5};
		expectedArr = new int[] {1, 2, 3, 4, 1};
		arrayAPI.addItem(1, arr, 4);
		areEqualArrays = arrayAPI.arraysAreEqual(arr, expectedArr);
		assertTrue("Insert: Test 1/2 Passes", areEqualArrays);
		
		//Test 2 (i > position = false) 
//		*i can not be greater than position, as i's maximum value is arr.length and position is greater than arr.length
		arr = new int[] {1, 2, 3, 4, 5};
		expectedArr = new int[] {1, 2, 3, 4, 5};
		
		try{
			arrayAPI.addItem(1, arr, 5);
					}
		catch(Exception e){
			areEqualArrays = arrayAPI.arraysAreEqual(arr, expectedArr);
			assertTrue("Insert: Test 2/2 Passes", areEqualArrays);
		}
		
	}
	

	@Test
	public void testRemoveItem() {
		// Create needed testing items
		ArraysAPI arrayAPI = new ArraysAPI();
		int[] arr;
		int[] expectedArr;
		boolean areEqualArrays;
		
		//Test 1 (i<array.length = true and array[i] != number = true)
		//array[i] will always be not equal to number, as number does not exist in the arr.
		arr = new int[] {1, 2, 3, 4, 5};
		expectedArr = new int[] {1, 2, 3, 4, 5};
		arrayAPI.removeItem(6, arr);
		areEqualArrays = arrayAPI.arraysAreEqual(arr, expectedArr);
		assertTrue("Remove: Test 1/2 Passes", areEqualArrays);
		
		//Test 2 (i<array.length = true and array[i] != number = false)
		//array[i] will never be not equal to number, as arr only contains number.
		arr = new int[] {2, 2, 2, 2, 2};
		expectedArr = new int[] {0, 0, 0, 0, 0};
		arrayAPI.removeItem(2, arr);
		areEqualArrays = arrayAPI.arraysAreEqual(arr, expectedArr);
		assertTrue("Remove: Test 2/2 Passes", areEqualArrays);
	}

}
