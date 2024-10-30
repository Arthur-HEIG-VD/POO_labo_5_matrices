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
   * @param mod The modulus to related to the matrix.
   */
  public Matrix(int[][] values, int mod) {
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

  public Matrix(int rows, int cols, int mod) {
    if (rows <= 0 || cols <= 0 || mod <= 0) {
      throw new RuntimeException("Invalid parameters to create java.Matrix");
    }
    this.rows = rows;
    this.cols = cols;
    this.mod = mod;
    this.coefficients = new int[rows][cols];
    Random rand = new Random();
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        this.coefficients[i][j] = rand.nextInt(mod);
      }
    }
  }

  public String toString() {
    String str = "";
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        str += (coefficients[i][j] + " ").toString();
      }
      str += "\n";
    }
    return str;
  }

  public static Matrix operate(Matrix A, Matrix B, Operation op) {
    if (A.mod != B.mod)
      throw new RuntimeException("The two matrices have different modulus.");
    int maxRows = Math.max(A.rows, B.rows);
    int maxCols = Math.max(A.cols, B.cols);
    int[][] result = new int[maxRows][maxCols];
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