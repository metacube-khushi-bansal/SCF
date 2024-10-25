package Main.java;

public class Search {

    public int linearSearch(int[] array, int key, int size) {
        if (array.length == 0) {
            throw new ArithmeticException("Array is Empty!Enter any valid size of array!");
        }
        if (size == 0)
            return -1; // element not found
        if (array[size - 1] == key)
            return size - 1; // if key found, return the index
        return linearSearch(array, key, size - 1);

    }

    public int binarySearch(int[] array, int key, int lo, int hi) {
        int length = array.length;
        if (length == 0) {
            throw new ArithmeticException("Array is Empty!Enter any valid size of array!");
        }
            
            if (hi >= lo && lo < array.length - 1) {
                int mid = lo + (hi - lo) / 2;
                if (array[mid] == key)
                    return mid;
    
                else if (array[mid] > key)
                    return binarySearch(array, key, lo, mid - 1);
    
                else
                    return binarySearch(array, key, mid + 1, hi);
            }
        

       

        return -1; // element not found in the array

    }
}
