import models.Matrix;
import operations.Addition;
import operations.Multiplication;
import operations.Subtraction;

public class RandomMatrix {
  public static void main(String[] args) {
    // Handle improper argument count
    if (args.length != 5) {
      System.out.println("Error: Wrong number of arguments. Requires : M1 N1 M2 N2 mod.");
      return;
    }

    // Parse the arguments and create the matrices
    int mod;
    Matrix m1, m2;
    try {
      mod = Integer.parseInt(args[4]);
      m1 = new Matrix(Integer.parseInt(args[0]), Integer.parseInt(args[1]), mod);
      m2 = new Matrix(Integer.parseInt(args[2]), Integer.parseInt(args[3]), mod);
    } catch (RuntimeException e) {
      System.out.println("Error: " + e.getMessage());
      return;
    }

    // Display modulus
    System.out.println("The modulus is " + mod);

    // Display the two matrices
    System.out.println("one:");
    System.out.println(m1);

    System.out.println("two:");
    System.out.println(m2);

    // Addition
    System.out.println("one + two:");
    Matrix sum = Matrix.operate(m1, m2, new Addition());
    System.out.println(sum);

    // Subtraction
    System.out.println("one - two:");
    Matrix diff = Matrix.operate(m1, m2, new Subtraction());
    System.out.println(diff);

    // Multiplication
    System.out.println("one x two:");
    Matrix prod = Matrix.operate(m1, m2, new Multiplication());
    System.out.println(prod);

  }
}