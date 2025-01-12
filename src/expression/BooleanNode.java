package expression;

public class BooleanNode extends ASTNode {
    private boolean value;

    public BooleanNode(boolean value) {
        this.value = value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public String prettyPrint() {
        return "";
    }
}
