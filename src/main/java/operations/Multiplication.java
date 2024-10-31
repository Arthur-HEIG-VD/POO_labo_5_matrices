package operations;

/**
 * Multiplication operation.
 *
 * @author: Aude Laydu
 * @author: Arthur Jacobs
 */
public class Multiplication extends Operation {
  @Override
  protected int calculate(int a, int b) {
    return a * b;
  }
}