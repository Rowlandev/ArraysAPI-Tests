package edu.indwes.cis330.arrays;

public class Main {
	public static void main(String[] args) {
		ArraysAPI arrAPI = new ArraysAPI();
		int arr[] = new int[]{1,2,3,4,5};
		arrAPI.addItem(2, arr, 1);
		
		arrAPI.removeItem(2, arr);
		for (int i = 0; i < arr.length;i++)
        {
            System.out.println(arr[i]);
        }
	}
}
