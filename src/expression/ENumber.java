package expression;

public class ENumber extends ASTNode {
    private final float base;
    private final int exponent;

    public ENumber(float base, int exponent) {
        this.base = base;
        this.exponent = exponent;
    }

    public float getBase() {
        return base;
    }

    public int getExponent() {
        return exponent;
    }

    @Override
    public String prettyPrint(String indent) {
        return "ENumber{" +
                "base=" + base +
                ", exponent=" + exponent +
                '}';
    }
}
