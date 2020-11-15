

public class ArraysAPI implements INumArrayUtils {
	
	/* Add item to array at specified position */
	public void addItem(int number, int[] array, int position) {
		for (int i = array.length - 1; i > position; i--) {
			array[i] = array[i - 1];
		}
		array[position] = number;
	}
	
	/* Remove item from array at specified position */
	public void removeItem(int number, int[] array) {
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
            array[i] = tempArray[i];
        }
	}
	
	/* Returns true if arrays passed in are equal in value & order */
	public boolean arraysAreEqual(int[] arr1, int[] arr2) {
		if (arr1.length != arr2.length) { return false; }
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}
}
