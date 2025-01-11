package expression;

public class FloatNumber extends ASTNode {
    private final float value;

    public FloatNumber(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    @Override
    public String prettyPrint(String indent) {
        return "FloatNumber{" +
                "value=" + value +
                '}';
    }
}
