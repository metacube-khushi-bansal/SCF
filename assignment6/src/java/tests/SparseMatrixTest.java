package java.tests;

import Main.java.SparseMatrix;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class SparseMatrixTest {
@Test
    public void testTranspose() {
        //Given
        int[][] elements = {{0, 1, 5}, {1, 0, 5}};
        int[][] expectedTransposedElements = {{1, 0, 5}, {0, 1, 5}};
        
        //When
        SparseMatrix mat= new SparseMatrix(2, 2, elements);
        SparseMatrix transposed = mat.transpose();
        
        //Then
        assertArrayEquals(expectedTransposedElements, transposed.elements);
    }

    @Test
    public void testTransposeNegative() {
        //Given
        int[][] elements = {{0, 1, 5}, {1, 0, 5}};
        int[][] expectedTransposedElements = {{1, 0, 5}, {0, 1, 5}};
        
        //When
        SparseMatrix mat= new SparseMatrix(2, 2, elements);
        SparseMatrix transposed = mat.transpose();
        
        //Then
        assertNotEquals(expectedTransposedElements, transposed.elements);
    }

    @Test
    public void testIsSymmetricalTrue() {
        //Given
        int[][] elements = {{0, 1, 5}, {1, 0, 5}};

        //When
        SparseMatrix matrix = new SparseMatrix(2, 2, elements);
        boolean ans = matrix.isSymmetrical();

        //then
        assertTrue(ans);
    }

    @Test
    public void testIsSymmetricalFalse() {
        //Given
        int[][] elements = {{0, 1, 5}, {1, 0, 6}};

        //When
        SparseMatrix matrix = new SparseMatrix(2, 2, elements);
        boolean ans = matrix.isSymmetrical();

        //Then
        assertFalse(ans);
    }

    @Test
    public void testAdditionPositive() {
        //Given
        int[][] elementsA = {{0, 1, 5}, {1, 1, 3}};
        int[][] elementsB = {{0, 1, 2}, {1, 1, -3}};
        int[][] expectedElements = {{0, 1, 7}};
        
        //When
        SparseMatrix matrixA = new SparseMatrix(2, 2, elementsA);
        SparseMatrix matrixB = new SparseMatrix(2, 2, elementsB);
        SparseMatrix result = matrixA.add(matrixB);
        
        //Then
        assertArrayEquals(expectedElements, result.elements);
    }

    @Test
    public void testAdditionNegative() {
        //Given
        int[][] elementsA = {{0, 1, 5}, {1, 1, 3}};
        int[][] elementsB = {{0, 1, 2}, {1, 1, -3}};
        int[][] expectedElements = {{0, 1, 7}};
        
        //When
        SparseMatrix matrixA = new SparseMatrix(2, 2, elementsA);
        SparseMatrix matrixB = new SparseMatrix(2, 2, elementsB);
        SparseMatrix result = matrixA.add(matrixB);
        
        //Then
        assertNotEquals(expectedElements, result.elements);
    }

    @Test
    public void testMultiplicationPositive() {
        //Given
        int[][] elementsA = {{0, 1, 3}, {1, 0, 4}};
        int[][] elementsB = {{0, 0, 1}, {1, 1, 2}};
        int[][] expectedElements = {{0, 1, 6},{1, 0, 4}};

        //When
        SparseMatrix matrixA = new SparseMatrix(2, 2, elementsA);
        SparseMatrix matrixB = new SparseMatrix(2, 2, elementsB);
        SparseMatrix result = matrixA.multiply(matrixB);

        //Then
        assertArrayEquals(expectedElements, result.elements);
    }

    @Test
    public void testMultiplicationNegative() {
        //Given
        int[][] elementsA = {{0, 1, 3}, {1, 0, 4}};
        int[][] elementsB = {{0, 0, 1}, {1, 1, 2}};
        int[][] expectedElements = {{0, 1, 6}};

        //When
        SparseMatrix matrixA = new SparseMatrix(2, 2, elementsA);
        SparseMatrix matrixB = new SparseMatrix(2, 2, elementsB);
        SparseMatrix result = matrixA.multiply(matrixB);

        //Then
        assertNotEquals(expectedElements, result.elements);

    }
}
