package operations;

/**
 * Subtraction operation.
 *
 * @author: Aude Laydu
 * @author: Arthur Jacobs
 */
public class Subtraction extends Operation {
  @Override
  protected int calculate(int a, int b) {
    return a - b;
  }
}