package expression;

import expression.ASTNode;

public class TNode extends ASTNode {
    private final String value;

    public TNode(String value) {
        this.value = value;
    }

    @Override
    public String prettyPrint() {
        return value;
    }
}