public class Main {
    public static void main(String[] args) {
        if (args.length != 5) {
            throw new IllegalArgumentException("Wrong number of arguments. Requires : N1 M1 N2 M2 mod.");
        } else {
            int mod = Integer.valueOf(args[4]);
            Matrix m1 = new Matrix(Integer.valueOf(args[0]), Integer.valueOf(args[1]), mod);
            Matrix m2 = new Matrix(Integer.valueOf(args[2]), Integer.valueOf(args[3]), mod);
            System.out.println("The modulus is " + mod);
            System.out.println("one:");
            System.out.println(m1);
            System.out.println("two:");
            System.out.println(m2);
            System.out.println("one + two:");
            Matrix sum = Matrix.operate(m1, m2, new Addition());
            System.out.println(sum);
            System.out.println("one - two:");
            Matrix diff = Matrix.operate(m1, m2, new Subtraction());
            System.out.println(diff);
            System.out.println("one x two:");
            Matrix prod = Matrix.operate(m1, m2, new Multiplication());
            System.out.println(prod);
        }
    }
}