import models.Matrix;
import operations.Addition;
import operations.Multiplication;
import operations.Subtraction;

/**
 * EdgeCases class to test Matrix with edge cases.
 */
public class EdgeCases {

  /**
   * Main method to test the Matrix class with edge cases.
   *
   * @param args No args needed, we used static values from Cyberlearn's example
   */
  public static void main(String[] args) {
    testNullMatrixInitialization();
    testDifferentModulusOperations();
    testInvalidMatrixSize();
    testBiggerSizeIsKept();
  }

  /**
   * Test null matrix initialization raises exception.
   */
  private static void testNullMatrixInitialization() {
    try {
      Matrix nullMatrix = new Matrix(0, 0, 5);
      System.out.println("[FAILED] Test null matrix 1");
    } catch (RuntimeException e) {
      System.out.println("[PASSED] Test null matrix 1");
    }

    try {
      Matrix nullMatrix = new Matrix(0, 3, 5);
      System.out.println("[FAILED] Test null matrix 2");
    } catch (RuntimeException e) {
      System.out.println("[PASSED] Test null matrix 2");
    }

    try {
      Matrix nullMatrix = new Matrix(3, 0, 5);
      System.out.println("[FAILED] Test null matrix 3");
    } catch (RuntimeException e) {
      System.out.println("[PASSED] Test null matrix 3");
    }

    try {
      Matrix nullMatrix = new Matrix(new int[][]{}, 5);
      System.out.println("[FAILED] Test null matrix 4");
    } catch (RuntimeException e) {
      System.out.println("[PASSED] Test null matrix 4");
    }
  }

  /**
   * Test operations with different modulus raises exception.
   */
  private static void testDifferentModulusOperations() {
    int mod = 5;
    Matrix m1 = new Matrix(new int[][]{{1, 3, 1, 1}, {3, 2, 4, 2}, {1, 0, 1, 0}}, mod);
    Matrix m2 = new Matrix(new int[][]{{1, 3, 1, 1}, {3, 2, 4, 2}, {1, 0, 1, 0}}, mod + 1);

    try {
      Matrix result = Matrix.operate(m1, m2, new Addition());
      System.out.println("[FAILED] Test different modulus 1");
    } catch (RuntimeException e) {
      System.out.println("[PASSED] Test different modulus 1");
    }

    Matrix m3 = new Matrix(new int[][]{{1, 3, 1, 1}, {3, 2, 4, 2}, {1, 0, 1, 0}}, 2 * mod);
    try {
      Matrix result = Matrix.operate(m1, m3, new Multiplication());
      System.out.println("[FAILED] Test different modulus 2");
    } catch (RuntimeException e) {
      System.out.println("[PASSED] Test different modulus 2");
    }
  }

  /**
   * Test invalid matrix size raises exception at initialization.
   */
  private static void testInvalidMatrixSize() {
    int mod = 5;

    try {
      Matrix m1 = new Matrix(-3, 3, mod);
      System.out.println("[FAILED] Test invalid matrix size 1");
    } catch (RuntimeException e) {
      System.out.println("[PASSED] Test invalid matrix size 1");
    }

    try {
      Matrix m2 = new Matrix(3, -3, mod);
      System.out.println("[FAILED] Test invalid matrix size 2");
    } catch (RuntimeException e) {
      System.out.println("[PASSED] Test invalid matrix size 2");
    }

    try {
      Matrix m3 = new Matrix(new int[][]{{1, 3, 1}, {3, 2}}, mod);
      System.out.println("[FAILED] Test invalid matrix size 3");
    } catch (RuntimeException e) {
      System.out.println("[PASSED] Test invalid matrix size 3");
    }
  }

  /**
   * Test matrix size with different sizes keep the bigger size.
   */
  private static void testBiggerSizeIsKept() {
    int mod = 5;
    Matrix m1 = new Matrix(3, 10, mod);
    Matrix result;

    Matrix m2 = new Matrix(3, 3, mod);
    result = Matrix.operate(m1, m2, new Addition());
    if (result.getCols() != 10) {
      System.out.println("[FAILED] Test bigger size is kept 1");
    } else {
      System.out.println("[PASSED] Test bigger size is kept 1");
    }

    Matrix m4 = new Matrix(4, 3, mod);
    result = Matrix.operate(m1, m4, new Subtraction());
    if (result.getRows() != 4) {
      System.out.println("[FAILED] Test bigger size is kept 2");
    } else {
      System.out.println("[PASSED] Test bigger size is kept 2");
    }

    Matrix m5 = new Matrix(2, 11, mod);
    result = Matrix.operate(m1, m5, new Multiplication());
    if (result.getRows() != 2 || result.getCols() != 11) {
      System.out.println("[FAILED] Test bigger size is kept 3");
    } else {
      System.out.println("[PASSED] Test bigger size is kept 3");
    }
  }
}