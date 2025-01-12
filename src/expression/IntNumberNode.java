package expression;

public class IntNumberNode extends ASTNode {
    private final int value;

    public IntNumberNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String prettyPrint() {
        return String.valueOf(value);
    }
}
