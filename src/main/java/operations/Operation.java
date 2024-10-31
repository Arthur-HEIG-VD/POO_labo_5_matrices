package operations;

/**
 * @author: Aude Laydu
 * @author: Arthur Jacobs
 */
public abstract class Operation {
  /**
   * Calculate the result of the operation on two integers.
   * To be overridden by subclasses to implement the various operations.
   *
   * @param a The first integer.
   * @param b The second integer.
   * @return The result of the operation.
   */
  protected abstract int calculate(int a, int b);

  /**
   * Apply the operation to two integers, taking the modulus into account.
   *
   * @param a The first integer.
   * @param b The second integer.
   * @param mod The modulus to apply to the result.
   * @return The result of the operation, taken modulo mod.
   */
  public int apply(int a, int b, int mod) {
    return Math.floorMod(calculate(a, b), mod);
  }
}