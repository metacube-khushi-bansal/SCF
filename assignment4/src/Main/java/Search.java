package Main.java;

public class Search {

    /**
     * To find if a key is present or not in the array using linear Search
     * 
     * @param array - Input array from which the element is to be searched
     * @param key   - Element which is to be founf
     * @param size  - Size of the input array
     * @return int- Returns the index if element is found, otherwise -1
     */
    public int linearSearch(int[] array, int key, int size) {
        if (array.length == 0) {
            throw new ArithmeticException("Array is Empty!Enter any valid size of array!");
        }
        // we reached the last of array and key is not found
        if (size == 0)
            return -1; // element not found

        if (array[size - 1] == key)
            return size - 1; // if key found, return the index

        return linearSearch(array, key, size - 1);

    }

    /**
     * To find if a key is present or not in the array using binary Search
     * 
     * @param array    - Input array from which the element is to be searched
     * @param key      - Element which is to be founf
     * @param leftInd  - Represents the left end of the input array
     * @param rightInd - Represents the right end of the input array
     * @return int- Returns the index if element is found, otherwise -1
     */
    public int binarySearch(int[] array, int key, int leftInd, int rightInd) {
        int length = array.length;
        if (length == 0) {
            throw new ArithmeticException("Array is Empty!Enter any valid size of array!");
        }

        if (rightInd >= leftInd && leftInd < array.length - 1) {

            int mid = leftInd + (rightInd - leftInd) / 2;

            if (array[mid] == key)
                return mid;

            else if (array[mid] > key)
                return binarySearch(array, key, leftInd, mid - 1);

            else
                return binarySearch(array, key, mid + 1, rightInd);
        }

        return -1; // element not found in the array

    }
}
