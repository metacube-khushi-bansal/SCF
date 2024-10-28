package Main.java;

public class NQueenProblem {

    // printing the solution 
    private void printSolution(int [][] board,int dimensionOfMatrix){
        System.out.println(dimensionOfMatrix+ " queens can be placed as: ");
        for(int i = 0; i< dimensionOfMatrix;i++){
            for(int j = 0;j< dimensionOfMatrix; j++){
                System.out.print(board[i][j] + " " );
            }
            System.out.println();
        }
    } 

    // to check if we can place the Queen at the (row,col)without any other queen attacking
    private boolean isSafe(int board[][], int row, int col, int dimensionOfMatrix) {
        int dupRow = row;
        int dupCol = col;

        // checking the upper left diagonal
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 1)
                return false;
            row--;
            col--;
        }

        col = dupCol;
        row = dupRow;
       
        // checking left diagonal
        while (col >= 0) {
            if (board[row][col] == 1)
                return false;
            col--;
        }

        col = dupCol;
        row = dupRow;


        //checking lower left digonal
        while (row < dimensionOfMatrix && col >= 0) {
            if (board[row][col] == 1)
                return false;
            row++;
            col--;
        }

        return true;
    }

    private boolean solveNQ(int[][] board, int col, int dimensionOfMatrix) {
        // If reached at the point more than the size of matrix
        if (col >= dimensionOfMatrix)
            return true;

            // looping through each row and checking if we can place the Queen at the particular (row,col)
        for (int row = 0; row < dimensionOfMatrix; row++) {

            if (isSafe(board, row, col, dimensionOfMatrix)) {
                board[row][col] = 1;    // if queen can be placed 

                if (solveNQ(board, col + 1, dimensionOfMatrix) == true) // recursively calling the solve for next column
                    return true;

                board[row][col] = 0;  // backtrack to cover the next case
            }

        }

        return false;

    }

    public boolean solveNQueen(int startRow, int dimensionOfMatrix) {
        
        int board[][] = new int[dimensionOfMatrix][dimensionOfMatrix];
        // setting the board values to zero initially
        for (int i = 0; i < dimensionOfMatrix; i++) {
            for (int j = 0; j < dimensionOfMatrix; j++) {
                board[i][j] = 0;
            }
        }
        
        // calling the utility method solveNQ to find if solution exist , 
        if (solveNQ(board, 0, dimensionOfMatrix) == false) {
            System.out.println("Solution does not exist");
            return false;
        }


        //printing the solution obtained
        printSolution(board,dimensionOfMatrix);
        return true;

    }

}
