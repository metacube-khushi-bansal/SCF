package Main.java;

import java.util.ArrayList;

public class ArrOperations {

    /**
     * To find the Max mirror in Array- The maximum continuous part of array having
     * mirror/reverse elements
     * 
     * @param array
     * @return int - the size of the maximum mirror present in the array
     * @throws AssertionError- If the size of array is empty
     */
    public int calculateMaxMirrorInArray(int[] array) {
        // { 1,1, 2, 3, 2, 1 }
        if (array.length == 0)
            throw new AssertionError("Cant perform the array operation! Array is empty");
        int maximum = 0;
        int length = array.length;
        // 1, 2, 3, 8, 9, 3, 2, 1
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int curr = i;
            int cnt = 0;
            for (int j = length - 1; (curr + cnt) < length && j > -1; j--) {
                if (array[curr + cnt] == array[j]) {
                    cnt++;
                } else {
                    if (cnt > 0) // 1 2 3 4
                    {
                        maximum = Math.max(maximum, cnt);
                        ans.clear();
                        cnt = 0;
                    }
                }
            }
            maximum = Math.max(maximum, cnt);
            if (maximum == 1)
                maximum = 0;
        }

        return maximum;

    }

    /**
     * To find the No. of clumps present in an array- Clump- series of 2 or more
     * adjacent elements of the same value
     * 
     * @param array
     * @return The no. of clumps present in the array
     * @throws AssertionError- If the size of array is empty
     */
    public int calculateNoOfClumps(int[] array) {
        if (array.length == 0)
            throw new AssertionError("Cant perform the array operation! Array is empty");
        int ans = 0;
        int len = array.length;

        for (int i = 0; i < len - 1; i++) {
            boolean check = false;
            while (i < len - 1 && array[i] == array[i + 1]) {
                check = true;
                i++;
            }

            if (check == true)
                ans++;
        }
        return ans;
    }

    /**
     * To return the array in such a way that every X is followed by Y , with
     * condition X's original position not changes, but another elements position
     * can be changed.
     * 
     * @param nums - The input array on which operation to be performed
     * @param X    - Number that's position should not changed
     * @param Y    - Number that should be after every X
     * @return int[]- The new array after the operation is performed
     * @throws AssertionError - If size of input array is zero or Number
     *                        of X
     *                        and Y are not equal or Two adjacent X are
     *                        present
     *                        or If X occurs at the last index of array
     */
    public int[] solveFixXYProblem(int[] nums, int X, int Y) {

        if (nums.length == 0)
            throw new AssertionError("Cant perform the array operation! Array is empty");
        int length = nums.length;
        int[] ans = new int[length];

        int countOfX = 0;
        int countOfY = 0;

        for (int i = 0; i < length; i++) {
            if (i == length - 1 && nums[i] == X)
                throw new AssertionError("Cant perform the array operation! X is present in the end");

            if (nums[i] == X && nums[i + 1] == X)
                throw new AssertionError(
                        "Cant perform the array operation! Two adjacent X present in the array");
            if (nums[i] == X)
                countOfX++;
            else if (nums[i] == Y)
                countOfY++;
        }
        if (countOfX != countOfY)
            throw new AssertionError("Cant perform the array operation! No of X and Y are not equal!");

        for (int i = 0; i < length; i++) {

            if (nums[i] == X) {
                ans[i] = X;
                ans[i + 1] = Y;
            }                       
        }

        int numsInd = 0;
        int ansInd = 0;

        while (ansInd < length) {
            if (ans[ansInd] == X) {
                ansInd += 2;
            }

            else if (nums[numsInd] == X || nums[numsInd] == Y) {
                numsInd++;
            }

            else {                                
                ans[ansInd] = nums[numsInd];
                ansInd++;
                numsInd++;
            }
        }

        return ans;
    }

    /**
     * To split the array in such a way that sum of the numbers on one side is equal
     * to the sum of the numbers on the other side
     * 
     * @param nums - The input array on which operation is to be performed
     * @return int - The index of the array from which we can split the array
     * @throws AssertionError - If the size of input array is zero
     * 
     */
    public int splitArray(int[] nums) {
        if (nums.length == 0)
            throw new AssertionError("Cant perform the array operation! Array is empty");
        int sum = 0;
        for (int val : nums) {
            sum += val;
        }
        int currSum = 0;
        int i = 0;

        while (i < nums.length) {
            currSum += nums[i];

            if (currSum == sum - currSum) {
                return i + 1; // one based indexing
            } else {
                i++;
            }
        }

        return -1;
    }

}
