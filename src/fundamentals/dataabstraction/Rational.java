package fundamentals.dataabstraction;

public class Rational {

    private int numerator;
    private int denominator;

    private final static String ASSERT_MESSAGE = "Operation would cause overflow";

    public Rational(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("denominator can't be zero!");

        this.numerator = numerator;
        this.denominator = denominator;
        int maxCommonDivisor = gcd(numerator, denominator);
        this.numerator /= maxCommonDivisor;
        this.denominator /= maxCommonDivisor;
        if (this.denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }
    }

    private int gcd(int p, int q) {
        if (q == 0) return p;
        return gcd(q, p % q);
    }

    private void checkPlusMinusOverFlow(Rational b) {
        assert (this.numerator < Integer.MAX_VALUE / b.denominator) ||
                (this.numerator > Integer.MIN_VALUE / b.denominator) : ASSERT_MESSAGE;
        assert (b.numerator < Integer.MAX_VALUE / this.denominator) ||
                (b.numerator > Integer.MIN_VALUE / this.denominator) : ASSERT_MESSAGE;
        assert (this.denominator < Integer.MAX_VALUE / b.denominator) ||
                (this.denominator > Integer.MIN_VALUE / b.denominator) : ASSERT_MESSAGE;
        int x = this.numerator * b.denominator;
        int y = b.numerator * this.denominator;
        if (x / y > 0)
            assert !(x > Integer.MAX_VALUE - y || x < Integer.MIN_VALUE - y) : ASSERT_MESSAGE;
        else if (x > 0 && y < 0)
            assert x < Integer.MAX_VALUE + y : ASSERT_MESSAGE;
        else assert x >= 0 || y <= 0 || x > Integer.MIN_VALUE + y : ASSERT_MESSAGE;
    }

    private void checkTimesOverFlow(Rational b) {
        assert (this.numerator < Integer.MAX_VALUE / b.numerator) ||
                (this.numerator > Integer.MIN_VALUE / b.numerator) : ASSERT_MESSAGE;
        assert (this.denominator < Integer.MAX_VALUE / b.denominator) ||
                (this.denominator > Integer.MIN_VALUE / b.denominator) : ASSERT_MESSAGE;
    }

    private void checkDividesOverFlow(Rational b) {
        assert (this.numerator < Integer.MAX_VALUE / b.denominator) ||
                (this.numerator > Integer.MIN_VALUE / b.denominator) : ASSERT_MESSAGE;
        assert (this.denominator < Integer.MAX_VALUE / b.numerator) ||
                (this.denominator > Integer.MIN_VALUE / b.numerator) : ASSERT_MESSAGE;
    }

    public Rational plus(Rational b) {
        checkPlusMinusOverFlow(b);
        int numerator = this.numerator * b.denominator + b.numerator * this.denominator;
        int denominator = this.denominator * b.denominator;
        return new Rational(numerator, denominator);
    }

    public Rational minus(Rational b) {
        checkPlusMinusOverFlow(b);
        int numerator = this.numerator * b.denominator - b.numerator * this.denominator;
        int denominator = this.denominator * b.denominator;
        return new Rational(numerator, denominator);
    }

    public Rational times(Rational b) {
        checkTimesOverFlow(b);
        int numerator = this.numerator * b.numerator;
        int denominator = this.denominator * b.denominator;
        return new Rational(numerator, denominator);
    }

    public Rational divides(Rational b) {
        checkDividesOverFlow(b);
        if (b.numerator == 0) throw new ArithmeticException("0 can'be divided!");
        int numerator = this.numerator * b.denominator;
        int denominator = this.denominator * b.numerator;
        return new Rational(numerator, denominator);
    }

    public boolean equals(Rational that) {
        if (this == that) return true;
        if (that == null) return false;
        if (this.numerator == 0 && that.numerator == 0) return true;
        return this.numerator == that.numerator && this.denominator == that.denominator;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }
}
