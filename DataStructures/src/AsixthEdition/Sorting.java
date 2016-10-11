package AsixthEdition;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Sorting {

	/*
	 * This both are In place sorting O(1) memory
	 */
	
	// Compare every element if its smaller then swap to the left.
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length - i; j++) {
				if (arr[j - 1] > arr[j]) {
					// swap values
					int tmp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}
	
	 //Find smallest element using a linear scan and move it to front, find
	// second smallest.
	public static void selectionSort(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			int sIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[sIndex]) {
					sIndex = j;
				}
			}
			// swap
			if (sIndex != i) {
				int tmp = arr[i];
				arr[i] = arr[sIndex];
				arr[sIndex] = tmp;
			}
		}
	}
	
	/*
	 * LEGENDARY BINARY SEARCH ! ! ! ! !
	 */
	
	public static int binarySearch(int[] arr, int x){
		int low = 0;
		int high = arr.length - 1;
		int mid;
		
		while (low <= high){
			mid = (low + high) /2;
			
			if(arr[mid] < x){ // look right;
				low = mid + 1;
			}else if(arr[mid] > x){ // look left;
				high = mid - 1;
			}else{
				return mid;
			}
		}
		
		return -1;
	}
	
	public static int binarySearchRec(int[] arr, int x, int low, int high){
		if(low > high) return -1;
		
		int mid = (low + high) /2;
		
		if(arr[mid] > x){ // looks left
			binarySearchRec(arr, x, low, mid - 1);
		}else if(arr[mid] < x){ // looks right
			binarySearchRec(arr, x, mid + 1 , high );
		}
		return mid;
	}
	
	// 10.1 Sorted Merged, merge two sorted arrays into arr #1
	
	public static void sortedMerge(int[] arr1, int[] arr2, int lastA, int lastB){
		int aIndex = lastA -1 ;
		int bIndex = lastB -1;
		int mIndex = lastA + lastB - 1;
		
		// We start from the last element
		while(bIndex >= 0){
			// A element is bigger
			if(aIndex >= 0 && arr1[aIndex] > arr2[bIndex]){
				arr1[mIndex] = arr1[aIndex];
				aIndex--;
			}else{
				arr1[mIndex] = arr1[bIndex]; //Copy b elements
				bIndex--;
			}
			mIndex--;
		}
	}
	
	// 10.2 Group Anagrams, given a array of String put all anagrams together.
	// Modification of bucket sort
	
	public static void sortAnagram(String[] string){
		HashMap<String,String> map = new HashMap<>();
		
		// Group by anagram
		for(String s: string){
			String key = sortChar(s);
			map.put(key, s);
		}
		
		// convert hashmap to array;
		int index = 0;
		for(String key : map.keySet()){
			ArrayList<String> list = map.get(key);
			for(String t: list){
				string[index] = t; // overrides the current string array
				index++;
			}
		}
	}
	
	// Sort the Strings by char
	public static String sortChar(String s){
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
	
	// 10.3 Search in a Rotated Array
	public static int searchInArr(int[] arr, int x, int low, int high){
		Arrays.sort(arr);
		if(low > high) return - 1;
		
		int mid = (low + high) / 2;
		
		if(arr[mid] > x){
			searchInArr(arr, x, low, mid - 1);
		}else if(arr[mid] < x){
			searchInArr(arr, x, mid + 1, high);
		}
		
		return mid;
	}
	
	// 10.4 Sorted Search, No size
	
	public static int search(Listy list, int value){
		int index = 1;
		// we go by multiple of to to get a O(log(n)) run time.
		while(list.elementAt(index) != -1 && list.elementAt(index) < value){
			index *= 2;
		}
		return binarySearchListy(list, value, index/2, index);
	}
	
	public static int binarySearchListy(Listy list, int value, int low, int high){
		while( low <= high){
			int mid = (low + high) /2;
			
			if(list.elementAt(mid) > value){ // goes left;
				high = mid - 1;
			}else if(list.elementAt(mid) < value){ // goes right
				low = mid + 1;
			}else{
				return mid;
			}
		}
		return -1;
	}
	
	// 10.5 Sorted Array of Strings, interspersed with empty strings. find the index of a given string.
}











