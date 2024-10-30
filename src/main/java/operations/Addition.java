package operations;

public class Addition extends Operation {
  @Override
  public int apply(int a, int b, int mod) {
    return Math.floorMod((a + b), mod);
  }
}