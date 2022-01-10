/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS G731G
 */
class CalculatorMatrix {

    void displayMenu() {
        System.out.println("========Caculator program==========");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
    }

    void AdditionMatrix() {
        System.out.println("-------- Addition ----------");
        //input matrix 1
        System.out.print("Enter Row Matrix 1:");
        int row1 = Inputter.InputIntNumber();
        System.out.print("Enter Column Matrix 1:");
        int col1 = Inputter.InputIntNumber();
        int[][] matrix1 = Inputter.EnterMatrix(1, row1, col1);
        //input matrix 2
        System.out.print("Enter Row Matrix 2:");
        int row2 = Inputter.EnterRowOrColMatrix2(row1, "Please enter row to equal row of matrix1: ");
        System.out.print("Enter Column Matrix 2:");
        int col2 = Inputter.EnterRowOrColMatrix2(col1, "Please enter coloumn to equal coloumn of matrix1: ");
        int[][] matrix2 = Inputter.EnterMatrix(2, row2, col2);
        System.out.println("-------- Result ----------");
        displayMatrix(matrix1);
        System.out.println("+");
        displayMatrix(matrix2);
        System.out.println("=");
        //loop traversal all row of matrix 1
        for (int i = 1; i <= row1; i++) {
            // loop traversal all column of matrix 1
            for (int j = 1; j <= col1; j++) {
                System.out.print("[" + (matrix1[i][j] + matrix2[i][j]) + "]");
            }
            System.out.println("");
        }
    }

    void SubtractionMatrix() {
        System.out.println("-------- Subtraction ----------");
        //input matrix 1
        System.out.print("Enter Row Matrix 1:");
        int row1 = Inputter.InputIntNumber();
        System.out.print("Enter Column Matrix 1:");
        int col1 = Inputter.InputIntNumber();
        int[][] matrix1 = Inputter.EnterMatrix(1, row1, col1);
        //input matrix 2
        System.out.print("Enter Row Matrix 2:");
        int row2 = Inputter.EnterRowOrColMatrix2(row1, "Please enter row to equal row of matrix1: ");
        System.out.print("Enter Column Matrix 2:");
        int col2 = Inputter.EnterRowOrColMatrix2(col1, "Please enter coloumn to equal coloumn of matrix1: ");
        int[][] matrix2 = Inputter.EnterMatrix(2, row2, col2);
        System.out.println("-------- Result ----------");
        displayMatrix(matrix1);
        System.out.println("-");
        displayMatrix(matrix2);
        System.out.println("=");
        // loop traversal all row of matrix 1
        for (int i = 1; i <= row1; i++) {
            // loop traversal all column of matrix 1
            for (int j = 1; j <= col1; j++) {
                System.out.print("[" + (matrix1[i][j] - matrix2[i][j]) + "]");
            }
            System.out.println();
        }
    }

    void MultiplicationMatrix() {
        System.out.println("-------- Multiplication ----------");
        //input matrix 1
        System.out.print("Enter Row Matrix 1:");
        int row1 = Inputter.InputIntNumber();
        System.out.print("Enter Column Matrix 1:");
        int col1 = Inputter.InputIntNumber();
        int[][] matrix1 = Inputter.EnterMatrix(1, row1, col1);
        //input matrix 2
        System.out.print("Enter Row Matrix 2:");
        int row2 = Inputter.EnterRowOrColMatrix2(col1, "Please enter row to equal coloumn of matrix1: ");
        System.out.print("Enter Column Matrix 2:");
        int col2 = Inputter.InputIntNumber();
        int[][] matrix2 = Inputter.EnterMatrix(2, row2, col2);

        //create a matrix result have row is row of matrix 1 and column is column of matrix 2
        int[][] MatrixResult = new int[row1+1][col2+1];

        // loop traversal all row of matrix 1 
        for (int i = 1; i <= row1; i++) {
            // loop traversal all column of matrix 2 
            for (int j = 1; j <= col2; j++) {
                // loop traversal from index first to the last index of column 1
                for (int k = 1; k <= col1; k++) {
                    MatrixResult[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        System.out.println("-------- Result ----------");
        displayMatrix(matrix1);
        System.out.println("*");
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(MatrixResult);

    }

    //display matrix
    public void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[1].length;
        // loop from first index to second last index of row
        for (int i = 1; i < row; i++) {
            // loop from first index to second last index of col
            for (int j = 1; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }
}
