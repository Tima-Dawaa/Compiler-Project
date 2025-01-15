package expression;

public class AtomNode extends ASTNode {
    private final String value;

    public AtomNode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String prettyPrint() {
        return value.toString();
    }
}
