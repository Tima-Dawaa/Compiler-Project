package expression;

public class FloatNumberNode extends ASTNode {
    private final float value;

    public FloatNumberNode(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    @Override
    public String prettyPrint() {
        return String.valueOf(value);
    }
}
