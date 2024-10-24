package Main.java;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // int[] arrray = { 1, 1, 3, 4, 4, 4 };

        ArrOperations arrOperations = new ArrOperations();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {

            System.out.println("Select from the below operation : ");
            System.out.println("1: To find the max Size of Mirror present in array");
            System.out.println("2: To find the No. of Clumps present in the array");    
            System.out.println("3: To Fix the XY problem in the array");
            System.out.println("4: To Split the array such that sum of First half = Sum of Second Half ");
            System.out.println("5: To Exit");

            choice = scanner.nextInt();

            if (choice >= 5) {
                System.out.println("Exited");
                scanner.close();
                return;
            }
            System.out.println("Enter the size of Array you want to enter: ");
            int n = scanner.nextInt();
            int[] array = new int[n];
            System.out.println("Enter the array elements: ");
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.println("The size of max mirror present in the array is: "
                                + arrOperations.calculateMaxMirrorInArray(array));
                    } catch (AssertionError e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        System.out.println("The number of clumps present in array is: "
                                + arrOperations.calculateNoOfClumps(array));
                    } catch (AssertionError e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        System.out.println("Enter the value of X: ");
                        int X = scanner.nextInt();
                        System.out.println("Enter the value of Y: ");
                        int Y = scanner.nextInt();
                        int []ans = arrOperations.solveFixXYProblem(array, X, Y);
                        System.out.println("The array after Fixing XY problem is: ");
                        for(int val : ans){
                            System.out.println(val);
                        }

                    } catch (AssertionError e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        System.out.println(
                                "The index of the array at which we can divide in two halves such that Sum Of First Half = Sum of Second Half "
                                        + arrOperations.splitArray(array));

                    } catch (AssertionError e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                default:
                    break;
            }

        } while (choice < 5);

        scanner.close();
    }
}
