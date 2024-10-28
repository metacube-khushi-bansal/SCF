package Main.java;

import java.util.ArrayList;
import java.util.List;

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
    public int[][] sumOfPolynomial(int[][] polynomial1, int[][] polynomial2) {
        List<int[]> result = new ArrayList<>();

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
                result.add(polynomial1[i]);
                i++;
            } else { // poly2 has a higher power term
                result.add(polynomial2[j]);
                j++;
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
    public int[][] multiplicationOfPolynomial(int[][] polynomial1, int[][] polynomial2) {
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
     * @param termsList - represent the polynomial 
     * @param coefficient- represent the coefficeint
     * @param power - represent the power
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

    public static void main(String[] args) {
        int[][] polynomial = { { 3, 0 }, { 0, 1 }, { 5, 2 } };
        Poly poly = new Poly(polynomial);
        System.out.println(poly.evaluate(1));
        System.out.println(poly.degreeOfPolynomial(polynomial));

        int[][] polynomial2 = { { 5, 0 }, { 4, 2 } };
        int[][] addition = poly.sumOfPolynomial(polynomial, polynomial2);
        int[][] multiplication = poly.multiplicationOfPolynomial(polynomial, polynomial2);
        for (int i = 0; i < addition.length; i++) {
            System.out.print(addition[i][0] + " " + addition[i][1]);
            System.out.println();
        }
        for (int i = 0; i < multiplication.length; i++) {
            System.out.print(multiplication[i][0] + " " + multiplication[i][1]);
            System.out.println();
        }
    }
}
