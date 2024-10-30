package operations;

public abstract class Operation {
  protected abstract int calculate(int a, int b);

  public int apply(int a, int b, int mod) {
    int result = calculate(a, b);
    return Math.floorMod(result, mod);
  }
}