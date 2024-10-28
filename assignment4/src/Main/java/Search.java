package Main.java;

public class Search {

    // To find if a key is present or not in the array
    public int linearSearch(int[] array, int key, int size) {
        if (array.length == 0) {
            throw new ArithmeticException("Array is Empty!Enter any valid size of array!");
        }
        // we reached the last of array and key is not found
        if (size == 0)
            return -1; // element not found

        if (array[size - 1] == key)
            return size - 1; // if key found, return the index

        return linearSearch(array, key, size - 1); // recursively call the linearSearch till key not found or reach end
                                                   // of array

    }

    // to find if a key is present or not using binary search
    public int binarySearch(int[] array, int key, int leftInd, int rightInd) {
        int length = array.length;
        if (length == 0) { // If user neter a empty array
            throw new ArithmeticException("Array is Empty!Enter any valid size of array!");
        }

        // check so that
        if (rightInd >= leftInd && leftInd < array.length - 1) {
            // finding the middle index of sorted array
            int mid = leftInd + (rightInd - leftInd) / 2;

            // if middle index array element is equal to the key
            if (array[mid] == key)
                return mid;

            // if middle element greater than the key we want to find, reduce search space
            // to left side of the array
            else if (array[mid] > key)
                return binarySearch(array, key, leftInd, mid - 1);

            // if middle element smaller than the key we want to find, reduce search space
            // to right side of the array
            else
                return binarySearch(array, key, mid + 1, rightInd);
        }
        
        //reached the end of array, still key not found
        return -1; // element not found in the array

    }
}
