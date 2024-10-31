package operations;

/**
 * Addition operation.
 *
 * @author: Aude Laydu
 * @author: Arthur Jacobs
 */
public class Addition extends Operation {
  @Override
  protected int calculate(int a, int b) {
    return a + b;
  }
}