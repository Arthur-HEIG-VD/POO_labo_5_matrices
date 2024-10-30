package operations;

/**
 * Multiplication operation.
 */
public class Multiplication extends Operation {
  @Override
  protected int calculate(int a, int b) {
    return a * b;
  }
}