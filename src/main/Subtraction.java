public class Subtraction extends Operation {
    @Override
    protected int apply(int a, int b, int mod) {
        int r = (a - b) % mod;
        return r < 0 ? r + mod : r ;
    }
}