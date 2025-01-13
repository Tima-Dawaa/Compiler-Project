package expression;

public class InitFormNode  extends ASTNode {
    private final String value;

    public InitFormNode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String prettyPrint() {
        return "InitFormExpression{" +
                "value='" + value + '\'' +
                '}';
    }
}
