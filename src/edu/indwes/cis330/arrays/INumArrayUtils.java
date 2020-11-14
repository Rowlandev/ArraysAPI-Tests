package edu.indwes.cis330.arrays;

public interface INumArrayUtils {

	/**
	 * Adds a number into the array at the position desired.
	 * Any numbers existing after the position are shifted 
	 * to the next index in order to create room for the new
	 * number. For example, adding 1 in position 2 to the array
	 * [2, 4, 5, 6, 0] would result in [2, 4, 1, 5, 6]. Note
	 * that the number at the last position is discarded.
	 * 
	 * @param number - number to be added
	 * @param array - array where the number is added
	 * @param position - position where the number is added
	 */
	public void addItem(int number, int[] array, int position);
	
	/**
	 * Removes a number from the array. Any numbers existing
	 * after the position of the number are shifted one position
	 * back. For example, removing 4 from the array [3, 4, 2, 0]
	 * should result in [3, 2, 0, 0]. Note that the new slot opened
	 * in the last position of the array should be filled with a 0.
	 * 
	 * All the occurrences of the number must be removed. For 
	 * example, removing 2 from the array [2, 3, 5, 2] results 
	 * in [3, 5, 0, 0].
	 * 
	 * If the number does not exist in the array, nothing happens. 
	 * 
	 * @param number - number to be removed
	 * @param array - array from which the number is removed
	 */
	public void removeItem(int number, int[] array);
	
}
