package expression;

public class StringNode extends ASTNode {
    private final String value;

    public StringNode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String prettyPrint(String indent) {
        return "StringNode{" +
                "value='" + value + '\'' +
                '}';
    }
}
