package operations;

/**
 * Subtraction operation.
 */
public class Subtraction extends Operation {
  @Override
  protected int calculate(int a, int b) {
    return a - b;
  }
}