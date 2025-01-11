package expression;

public class IntNumber extends ASTNode {
    private final int value;

    public IntNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String prettyPrint(String indent) {
        return "IntNumber{" +
                "value=" + value +
                '}';
    }
}
