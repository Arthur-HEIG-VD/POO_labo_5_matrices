public class Addition extends Operation {
    @Override
    protected int apply(int a, int b, int mod) {
        return (a + b)%mod;
    }
}