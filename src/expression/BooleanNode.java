package expression;

public class BooleanNode extends ASTNode {
    private String value;

    public BooleanNode(String value) {
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String prettyPrint() {
        return value;
    }
}
