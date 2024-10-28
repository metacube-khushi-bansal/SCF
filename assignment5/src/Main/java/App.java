package Main.java;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the set :");
        int size = scanner.nextInt();

        System.out.println("Enter the set elements: ");
        int[] setValues = new int[size];
        for (int i = 0; i < size; i++) {
            setValues[i] = scanner.nextInt();
        }

        IntSet set1 = new IntSet(setValues);

        int choice;
        do {
            System.out.println("Select the operation to perform on Set: ");
            System.out.println("1: To find if a given value is part of the Set");
            System.out.println("2: To find the size of the Set");
            System.out.println("3: To find if a given set is subset of the Set");
            System.out.println("4: To find Complement of two sets");
            System.out.println("5: To find Intersection of two sets");
            System.out.println("6: To find Difference of two sets");
            System.out.println("7: To find Union of two sets");
            System.out.println("8: Exit");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Enter the value you want to find out: ");
                    int key = scanner.nextInt();
                    System.out.println("If " + key + " is present or not in set: " + set1.isMemberOfSet(key));
                    break;

                case 2:
                    System.out.println("The size of the set is: " + set1.size());
                    break;

                case 3:
                    System.out.println("Enter Another set size: ");
                    int lengthOfSet = scanner.nextInt();
                    int[] valOfSet = new int[lengthOfSet];
                    System.out.println("Enter set elements");
                    for (int i = 0; i < lengthOfSet; i++) {
                        valOfSet[i] = scanner.nextInt();
                    }
                    IntSet set2 = new IntSet(valOfSet);
                    System.out.println("If Set 1 and set2 subset or not: " + set1.isSubSet(set2));
                    break;

                case 4:
                    System.out.println("Enter Another set size: ");
                    int lengthOfSet3 = scanner.nextInt();
                    int[] valOfSet3 = new int[lengthOfSet3];
                    System.out.println("Enter set elements: ");
                    for (int i = 0; i < lengthOfSet3; i++) {
                        valOfSet3[i] = scanner.nextInt();
                    }
                    IntSet set3 = new IntSet(valOfSet3);
                    int[] setAns = set1.getComplement(set1, set3).getSetElements();
                    System.out.println("Complement of set1 and Set2 :  ");
                    for (int i = 0; i < setAns.length; i++) {
                        if (setAns[i] != 0)
                        System.out.print(setAns[i] + " ");
                    }
                    System.out.println();
                    break;

                case 5:
                    System.out.println("Enter Another set size: ");
                    int lengthOfSet4 = scanner.nextInt();
                    int[] valOfSet4 = new int[lengthOfSet4];
                    System.out.println("Enter set elements: ");
                    for (int i = 0; i < lengthOfSet4; i++) {
                        valOfSet4[i] = scanner.nextInt();
                    }
                    IntSet set4 = new IntSet(valOfSet4);
                    int[] setAns4 = set1.getIntersection(set1, set4).getSetElements();
                    System.out.println("Intersection of set1 and Set2 :  ");
                    for (int i = 0; i < setAns4.length; i++) {
                        if (setAns4[i] != 0)
                        System.out.print(setAns4[i] + " ");
                    }
                    System.out.println();
                    break;

                case 6:
                    System.out.println("Enter Another set size: ");
                    int lengthOfSet5 = scanner.nextInt();
                    int[] valOfSet5 = new int[lengthOfSet5];
                    System.out.println("Enter set elements: ");
                    for (int i = 0; i < lengthOfSet5; i++) {
                        valOfSet5[i] = scanner.nextInt();
                    }
                    IntSet set5 = new IntSet(valOfSet5);
                    int[] setAns5 = set1.getDifference(set1, set5).getSetElements();
                    System.out.println("Difference of set1 and Set2 :  ");
                    for (int i = 0; i < setAns5.length; i++) {
                        if (setAns5[i] != 0)
                        System.out.print(setAns5[i] + " ");
                    }

                    System.out.println();
                    break;

                case 7:
                    System.out.println("Enter Another set size: ");
                    int lengthOfSet6 = scanner.nextInt();
                    int[] valOfSet6 = new int[lengthOfSet6];
                    System.out.println("Enter set elements: ");
                    for (int i = 0; i < lengthOfSet6; i++) {
                        valOfSet6[i] = scanner.nextInt();
                    }
                    IntSet set6 = new IntSet(valOfSet6);
                    int[] setAns6 = set1.getUnion(set1, set6).getSetElements();
                    System.out.println("Union of set1 and Set2 :  ");
                    for (int i = 0; i < setAns6.length; i++) {

                        if (setAns6[i] != 0)
                            System.out.print(setAns6[i] + " ");
                    }
                    System.out.println();
                    break;

                default:
                    break;
            }

            
        } while (choice != 8);
        scanner.close();


    }
}
