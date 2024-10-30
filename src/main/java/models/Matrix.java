package models;

import operations.Operation;

import java.util.Random;

public class Matrix {
  private final int[][] coefficients;
  private final int rows;
  private final int cols;
  private final int mod;

  /**
   * Create a matrix from a 2D array of values.
   *
   * @param values The values to insert into the matrix. If they are not between
   * 0 and mod - 1, they are taken modulo mod.
   * @param mod The modulus related to the matrix.
   */
  public Matrix(int[][] values, int mod) {
    // Check if the parameters are valid
    if (values.length == 0 || values[0].length == 0 || mod <= 0) {
      throw new RuntimeException("Invalid parameters to create Matrix");
    }

    // Initialize the matrix
    this.rows = values.length;
    this.cols = values[0].length;
    this.mod = mod;
    this.coefficients = new int[rows][cols];

    // Copy the values into the matrix, taking the modulus if necessary
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        coefficients[i][j] = Math.floorMod(values[i][j], mod);
      }
    }
  }

  /**
   * Create a matrix with random values between 0 and mod - 1.
   *
   * @param rows The number of rows in the matrix.
   * @param cols The number of columns in the matrix.
   * @param mod  The modulus related to the matrix.
   */
  public Matrix(int rows, int cols, int mod) {
    // Check if the parameters are valid
    if (rows <= 0 || cols <= 0 || mod <= 0) {
      throw new RuntimeException("Invalid parameters to create Matrix");
    }

    // Initialize the matrix
    this.rows = rows;
    this.cols = cols;
    this.mod = mod;
    this.coefficients = new int[rows][cols];

    // Fill the matrix with random values
    Random rand = new Random();
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        this.coefficients[i][j] = rand.nextInt(mod);
      }
    }
  }

  /**
   * Convert the matrix to a string representation.
   *
   * @return The string representation of the matrix.
   */
  public String toString() {
    String str = "";

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        str += coefficients[i][j] + " ";
      }
      str += "\n";
    }

    return str;
  }

  /**
   * Apply an operation to two matrices.
   *
   * @param A The first matrix.
   * @param B The second matrix.
   * @param op The operation to apply.
   * @return The result of the operation.
   */
  public static Matrix operate(Matrix A, Matrix B, Operation op) {
    // Check if the matrices have the same modulus
    if (A.mod != B.mod) {
      throw new RuntimeException("The two matrices have different modulus, cannot operate.");
    }

    // Initialize the result matrix
    int maxRows = Math.max(A.rows, B.rows);
    int maxCols = Math.max(A.cols, B.cols);
    int[][] result = new int[maxRows][maxCols];

    // Apply the operation to the matrices
    for (int i = 0; i < maxRows; i++) {
      for (int j = 0; j < maxCols; j++) {
        int aValue = (i < A.rows && j < A.cols) ? A.coefficients[i][j] : 0;
        int bValue = (i < B.rows && j < B.cols) ? B.coefficients[i][j] : 0;
        result[i][j] = op.apply(aValue, bValue, A.mod);
      }
    }

    return new Matrix(result, A.mod);
  }
}