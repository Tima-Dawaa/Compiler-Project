package expression;

public class ENumberNode extends ASTNode {
    private final float base;
    private final int exponent;

    public ENumberNode(float base, int exponent) {
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
    public String prettyPrint() {
        return base + "e" + exponent;
    }
}
