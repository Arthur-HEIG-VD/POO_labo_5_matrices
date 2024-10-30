package operations;

public class Addition extends Operation {
  @Override
  protected int calculate(int a, int b) {
    return a + b;
  }
}