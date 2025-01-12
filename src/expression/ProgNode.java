package expression;

import java.util.List;

public class ProgNode extends ASTNode {
    private final ASTNode tuple;
    private final List<ASTNode> expression;  // expression | ATOM

    public ProgNode(ASTNode tuple, List<ASTNode> expression) {
        this.tuple = tuple;
        this.expression = expression;
    }

    public ASTNode getTuple() {
        return tuple;
    }

    public List<ASTNode> getExpression() {
        return expression;
    }

    @Override
    public String prettyPrint() {
        return "";
    }
}

