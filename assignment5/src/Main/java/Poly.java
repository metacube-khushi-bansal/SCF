package Main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public final class Poly {
    private final int[][] polynomial;

    public Poly(int[][] terms) {
        int nonZeroCount = 0; // only store terms with non-zero coefficients

        for (int[] term : terms) {
            if (term[0] != 0) // term[0] is the coefficient of the row
                nonZeroCount++;
        }

        this.polynomial = new int[nonZeroCount][2];
        int ind = 0;
        for (int i = 0; i < terms.length; i++) {
            if (terms[i][0] != 0) {
                polynomial[ind][0] = terms[i][0];
                polynomial[ind][1] = terms[i][1];
                ind++;
            }
            //
        }
    }

    /**
     * To calculate the value of polynomial on a value X
     * 
     * @param x int - The value for which to calculate the polynomial
     * @return float - the value obtained after evaluation
     */
    public float evaluate(float x) {
        float valueOfPolynomial = 0;
        for (int i = 0; i < polynomial.length; i++) {
            valueOfPolynomial += polynomial[i][0] * Math.pow(x, polynomial[i][1]);
        }
        return valueOfPolynomial;
    }

    /**
     * To calculate the degree of the polynomial
     * 
     * @param polynomial - the input polynomial
     * @return int - the highest power present in the polynomial
     */
    public int degreeOfPolynomial(int[][] polynomial) {
        int degree = 0;
        for (int i = 0; i < polynomial.length; i++) {
            degree = Math.max(degree, polynomial[i][1]);

        }
        return degree;
    }

    /**
     * To calculate sum of two polynomials
     * 
     * @param polynomial1 - the first input polynomial
     * @param polynomial2 - the second input polynomial
     * @return int[][]- the resultant polynomial array after addition
     */
    public int[][] sumOfPolynomial(Poly poly1, Poly poly2) {
        List<int[]> result = new ArrayList<>();

        int[][] polynomial1 = poly1.polynomial;
        Arrays.sort(polynomial1, Comparator.comparingInt(a -> a[1])); // sorting on the basis of power

        int[][] polynomial2 = poly2.polynomial;
        Arrays.sort(polynomial2, Comparator.comparingInt(a -> a[1])); // sorting on the basis of power

        int i = 0, j = 0;
        while (i < polynomial1.length && j < polynomial2.length) {
            if (polynomial1[i][1] == polynomial2[j][1]) { // Same power
                int sumCoefficient = polynomial1[i][0] + polynomial2[j][0];
                if (sumCoefficient != 0) {
                    result.add(new int[] { sumCoefficient, polynomial1[i][1] });
                }
                i++;
                j++;
            } else if (polynomial1[i][1] > polynomial2[j][1]) { // poly1 has a higher power term
                result.add(polynomial2[j]);
                j++;
            } else { // poly2 has a higher power term
                result.add(polynomial1[i]);
                i++;
            }
        }

        // Add remaining terms from poly1 or poly2
        while (i < polynomial1.length) {
            result.add(polynomial1[i]);
            i++;
        }
        while (j < polynomial2.length) {
            result.add(polynomial2[j]);
            j++;
        }

        // Convert list to 2D array
        return result.toArray(new int[result.size()][]);
    }

    /**
     * To calculate multiplication of two polynomials
     * 
     * @param polynomial1 - the first input polynomial
     * @param polynomial2 - the second input polynomial
     * @return int[][]- the resultant polynomial array after multiplication
     */
    public int[][] multiplicationOfPolynomial(Poly poly1, Poly poly2) {
        int[][] polynomial1 = poly1.polynomial;
        int[][] polynomial2 = poly2.polynomial;

        List<int[]> termsList = new ArrayList<>();
        // Multiply each term in poly1 with each term in poly2 
        for (int[] term1 : polynomial1) {
            for (int[] term2 : polynomial2) {
                int coefficient = term1[0] * term2[0];
                int power = term1[1] +
                        term2[1];
                addTerm(termsList, coefficient, power);
            }
        }

        // Convert the list of terms to a 2D array
        return termsList.toArray(new int[termsList.size()][]);

    }

    //
    /**
     * Helper method to add terms and combine like terms
     * 
     * @param termsList    - represent the polynomial
     * @param coefficient- represent the coefficeint
     * @param power        - represent the power
     */
    private static void addTerm(List<int[]> termsList, int coefficient, int power) {
        for (int[] term : termsList) {
            if (term[1] == power) { // Combine like terms with the same power
                term[0] += coefficient;
                return;
            }
        }
        // If there's no existing term with the same power, add a new term
        if (coefficient != 0) {
            termsList.add(new int[] { coefficient, power });
        }
    }

    /**
     * Helper method to input polynomial from user
     * 
     * @return int[][]- return the input polynomial
     */
    public static int[][] inputPolynomial() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms: ");
        int numTerms = scanner.nextInt();
        int[][] terms = new int[numTerms][2];

        for (int i = 0; i < numTerms; i++) {
            System.out.print("Enter coefficient for term " + (i + 1) + ": ");
            terms[i][0] = scanner.nextInt();
            System.out.print("Enter exponent for term " + (i + 1) + ": ");
            terms[i][1] = scanner.nextInt();
        }

        return terms;
    }

    /**
     * Helper method to print polynomial
     * 
     * @param polynomial - Polynomial array to be printed
     */
    public static void printPolynomial(int[][] polynomial) {
        for (int i = 0; i < polynomial.length; i++) {
            if (i > 0 && polynomial[i][0] > 0) {
                System.out.print("+");
            }
            System.out.print(polynomial[i][0] + "x^" + polynomial[i][1]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first polynomial");
        int[][] polynomial = inputPolynomial();
        Poly poly1 = new Poly(polynomial);

        System.out.println("Enter the second polynomial");
        int[][] polynomial2 = inputPolynomial();
        Poly poly2 = new Poly(polynomial2);

        System.out.println("User entered following polynomials:");
        System.out.println("Polynomial1: ");
        printPolynomial(polynomial);
        System.out.println("Polynomial2: ");
        printPolynomial(polynomial2);
        System.out.println("Enter a value at which to evaluate polynomials:");
        int x = scanner.nextInt();
        System.out.println("The value of polynomial1 at " + x + " is " + poly1.evaluate(x));
        System.out.println("The value of polynomial2 at " + x + " is " + poly2.evaluate(x));

        System.out.println("The degree of polynomial1 is " + poly1.degreeOfPolynomial(polynomial));
        System.out.println("The degree of polynomial2 is " + poly2.degreeOfPolynomial(polynomial2));
        int[][] addition = poly1.sumOfPolynomial(poly1, poly2);
        int[][] multiplication = poly1.multiplicationOfPolynomial(poly1, poly2);

        System.out.println("The addition of Polynomial1 and Polynomial 2 is: ");
        printPolynomial(addition);

        System.out.println("The multiplication of Polynomial1 and Polynomial 2 is: ");
        printPolynomial(multiplication);
        scanner.close();
    }
}
