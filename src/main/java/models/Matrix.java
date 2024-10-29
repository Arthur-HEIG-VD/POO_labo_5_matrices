package models;

import java.util.Random;
import operations.Operation;

public class Matrix {
  private int[][] coefficients;
  private int rows;
  private int cols;
  private int mod;

  // TODO : Are values int[][] or int[] and it's taking rows + cols as parameters too for this constructor ??
  // TODO : Handle exception once this question is answered.
  public Matrix(int[][] values, int mod) {
    rows = values.length;
    cols = values[0].length;
    this.mod = mod;
    coefficients = new int[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        //TODO : Are we applying mod to the values, or are we throwing an error if they aren't already to mod n ??
        coefficients[i][j] = values[i][j] % mod;
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