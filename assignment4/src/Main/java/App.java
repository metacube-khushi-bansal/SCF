package Main.java;

import java.util.Scanner;

public class App {

    static public boolean isSorted(int[] array) {
        int len = array.length;

        if (array[0] <= array[1]) {

            for (int i = 1; i < len; i++) {
                if (array[i] < array[i - 1])
                    return false;
            }
        } else {
            for (int i = 1; i < len; i++) {
                if (array[i] > array[i - 1])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        MathOperations mathOperations = new MathOperations();
        Search search = new Search();
        NQueenProblem nQueenProblem = new NQueenProblem();

        Scanner scanner = new Scanner(System.in);
        System.out.println("");

        int choice;

        do {
            System.out.println("Enter a choice from the following: ");
            System.out.println("1: To Find the HCF of Two Positive integers");
            System.out.println("2: To Find the LCM of Two Positive integers");
            System.out.println("3: To Find if an element is present or not in Array: Linear Search");
            System.out.println("4: To Find if an element is present or not in Array: Binary Search");
            System.out.println("5: To Position 'N' Number of Queens in a N x N Chess Board");
            System.out.println("6:Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    try {
                        System.out.println("For HCF, Enter the first Number: ");
                        int number1 = scanner.nextInt();

                        System.out.println("For HCF, Enter the second Number: ");
                        int number2 = scanner.nextInt();

                        System.out.println("HCF is: " + mathOperations.calculateHcfOfTwoNumbers(number1, number2));
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                case 2:
                    try {
                        System.out.println("For LCM, Enter the first Number: ");
                        int num1 = scanner.nextInt();

                        System.out.println("For LCM, Enter the second Number: ");
                        int num2 = scanner.nextInt();

                        System.out.println("HCF is: " + mathOperations.calculateLCMOfTwoNumbers(num1, num2));
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                case 3:
                    try {
                        System.out.println("Enter the size of array ");
                        int size = scanner.nextInt();

                        int[] array = new int[size];
                        System.out.println("Enter the array elements: ");
                        for (int i = 0; i < size; i++) {
                            array[i] = scanner.nextInt();
                        }

                        System.out.println("Enter the key to be searched in the array if that's present or not: ");
                        int key = scanner.nextInt();

                        int ans = search.linearSearch(array, key, size);
                        if (ans == -1)
                            System.out.println("Key is not present in the array!");
                        else
                            System.out.println("Key is present at index: " + ans);
                        break;
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                    }

                case 4:
                    try {
                        System.out.println("Enter the size of array ");
                        int length = scanner.nextInt();

                        int[] arr = new int[length];
                        System.out.println("Enter the array elements: ");
                        for (int i = 0; i < length; i++) {
                            arr[i] = scanner.nextInt();
                        }
                        if (!isSorted(arr)) {
                            System.out.println("Enter sorted array! ");
                            break;
                        }

                        System.out.println("Enter the key to be searched in the array if that's present or not: ");
                        int keyy = scanner.nextInt();
                        
                        int answer = search.binarySearch(arr, keyy, 0, length - 1);
                        if (answer == -1)
                            System.out.println("Key is not present in the array!");
                        else
                            System.out.println("Key is present at index: " + answer);
                        break;

                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                    }
                case 5:
                    System.out.println("Enter the size of the chessboard: ");
                    int N = scanner.nextInt();
                    nQueenProblem.solveNQueen(0, N);

                default:
                    break;
            }
        } while (choice != 6);
        scanner.close();

    }
}
