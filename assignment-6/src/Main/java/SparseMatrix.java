package Main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class SparseMatrix {
    public final int rows;
    public final int cols;
    public final int[][] elements;

    // Time Complexity : O(N)
    public SparseMatrix(int rows, int cols, int[][] elements) {
        this.rows = rows;
        this.cols = cols;

        List<int[]> nonZeroElements = new ArrayList<>();
        for (int[] element : elements) {
            if (element[2] != 0) {
                nonZeroElements.add(new int[] { element[0], element[1], element[2] });
            }
        }

        this.elements = nonZeroElements.toArray(new int[0][3]);
    }
 
   /**
    * To convert the input matrix by user into a sparse matrix
    * @param fullMatrix - Input entered by the user
    */
    public SparseMatrix(int[][] fullMatrix) {
        this.rows = fullMatrix.length;
        this.cols = fullMatrix[0].length;

        List<int[]> nonZeroElements = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (fullMatrix[i][j] != 0) {
                    nonZeroElements.add(new int[]{i, j, fullMatrix[i][j]});
                }
            }
        }
        
        this.elements = nonZeroElements.toArray(new int[0][3]);
    }

    public SparseMatrix transpose() {
        int[][] transposedElements = new int[elements.length][3];
        for (int i = 0; i < elements.length; i++) {
            transposedElements[i][0] = elements[i][1];
            transposedElements[i][1] = elements[i][0];
            transposedElements[i][2] = elements[i][2];
        }
        return new SparseMatrix(cols, rows, transposedElements);
    }

    /**
     * To find if the matrix is symmetrical or not- If a matrix is equal to its
     * transpose
     * 
     * @return boolea - true if matrix symmetrical otherwise false
     */
    public boolean isSymmetrical() {
        if (rows != cols)
            return false;

        SparseMatrix transposed = this.transpose();
        for (int[] element : elements) {
            boolean found = false;
            for (int[] transposedElement : transposed.elements) {
                if (element[0] == transposedElement[0] && element[1] == transposedElement[1]
                        && element[2] == transposedElement[2]) {
                    found = true;
                    break;
                }
            }
            if (!found)
                return false;
        }
        return true;
    }

    /**
     * To Add two matrices
     * 
     * @param other - Matrix which is to be added
     * @return Matrix which is resultant addition
     */
    public SparseMatrix add(SparseMatrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Matrices dimensions must match for addition.");
        }

        List<int[]> resultElements = new ArrayList<>();
        int i = 0, j = 0;

        while (i < this.elements.length && j < other.elements.length) {
            int[] a = this.elements[i];
            int[] b = other.elements[j];

            if (a[0] == b[0] && a[1] == b[1]) {
                int sum = a[2] + b[2];
                if (sum != 0)
                    resultElements.add(new int[] { a[0], a[1], sum });
                i++;
                j++;
            } else if (a[0] < b[0] || (a[0] == b[0] && a[1] < b[1])) {
                resultElements.add(a);
                i++;
            } else {
                resultElements.add(b);
                j++;
            }
        }

        while (i < this.elements.length) {
            resultElements.add(this.elements[i++]);
        }
        while (j < other.elements.length) {
            resultElements.add(other.elements[j++]);
        }

        int[][] resultArray = resultElements.toArray(new int[0][3]);
        return new SparseMatrix(rows, cols, resultArray);
    }

    /**
     * To Multiply two matrices
     * 
     * @param other - Matrix which is to be multiplied
     * @return Matrix which is resultant multiplication
     */
    public SparseMatrix multiply(SparseMatrix other) {
        if (this.cols != other.rows) {
            throw new IllegalArgumentException("Matrix multiplication not possible with given dimensions.");
        }

        List<int[]> resultElements = new ArrayList<>();
        SparseMatrix transposedOther = other.transpose();

        for (int[] a : this.elements) {
            for (int[] b : transposedOther.elements) {
                if (a[1] == b[1]) {
                    int row = a[0];
                    int col = b[0];
                    int value = a[2] * b[2];

                    boolean found = false;
                    for (int[] resultElement : resultElements) {
                        if (resultElement[0] == row && resultElement[1] == col) {
                            resultElement[2] += value;
                            found = true;
                            break;
                        }
                    }

                    if (!found && value != 0)
                        resultElements.add(new int[] { row, col, value });
                }
            }
        }

        int[][] resultArray = resultElements.toArray(new int[0][3]);
        return new SparseMatrix(this.rows, other.cols, resultArray);
    }

    /**
     * To print the matrix
     */
    public void printMatrix() {
        int[][] fullMatrix = new int[rows][cols];
        for (int[] element : elements) {
            fullMatrix[element[0]][element[1]] = element[2];
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(fullMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter rows and columns of Matrix A:");
        int rowsA = scanner.nextInt();
        int colsA = scanner.nextInt();
        
        int[][] fullMatrixA = new int[rowsA][colsA];
        System.out.println("Enter elements of Matrix A:");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                fullMatrixA[i][j] = scanner.nextInt();
            }
        }
        
        SparseMatrix matrixA = new SparseMatrix(fullMatrixA);

        System.out.println("Enter rows and columns of Matrix B:");
        int rowsB = scanner.nextInt();
        int colsB = scanner.nextInt();
        
        int[][] fullMatrixB = new int[rowsB][colsB];
        System.out.println("Enter elements of Matrix B:");
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                fullMatrixB[i][j] = scanner.nextInt();
            }
        }
        
        SparseMatrix matrixB = new SparseMatrix(fullMatrixB);

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Transpose Matrix A");
            System.out.println("2. Check if Matrix A is Symmetrical");
            System.out.println("3. Add Matrix A and Matrix B");
            System.out.println("4. Multiply Matrix A and Matrix B");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Transpose of Matrix A:");
                    SparseMatrix transposeA = matrixA.transpose();
                    transposeA.printMatrix();
                    break;

                case 2:
                    System.out.println("Is Matrix A Symmetrical? " + matrixA.isSymmetrical());
                    break;

                case 3:
                    try {
                        System.out.println("A + B:");
                        SparseMatrix sum = matrixA.add(matrixB);
                        sum.printMatrix();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        System.out.println("A * B:");
                        SparseMatrix product = matrixA.multiply(matrixB);
                        product.printMatrix();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
}
