package edu.indwes.cis330.arrays;

public class ArraysAPI implements INumArrayUtils {
	
	public void addItem(int number, int[] array, int position) {
		for (int i = array.length-1; i > position; i--) {
			array[i] = array[i-1];
		}
		array[position] = number;
	}
	
	public void removeItem(int number, int[] array) {
        int[] tempArray = new int[array.length];
        int j = 0;
        for(int i = 0; i < array.length; i++) {
        	if(array[i] != number) {
        		tempArray[j] = array[i];
            	j++;
            }
        }
        for(int i = j; i< array.length; i++) {
            tempArray[i] = 0;
        }
        for (int i = 0; i < tempArray.length;i++)
        {
            array[i] = tempArray[i];
        }
	}
}
