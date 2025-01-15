package expression;

import expression.ASTNode;

public class NILNode extends ASTNode {
    private final String value;

    public NILNode(String value) {
        this.value = value;
    }

    @Override
    public String prettyPrint() {
        return value;
    }
}