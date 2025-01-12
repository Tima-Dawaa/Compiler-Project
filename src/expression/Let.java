package expression;

import java.util.List;

public class Let extends ASTNode {
    private final ASTNode tuple;
    private final List<ASTNode> expression;  // expression | ATOM

    public Let(ASTNode tuple, ASTNode expression, List<ASTNode> expression1) {
        this.tuple = tuple;
        this.expression = expression1;
    }

    public ASTNode getTuple() {
        return tuple;
    }

    public List<ASTNode> getExpression() {
        return expression;
    }

    @Override
    public String prettyPrint(String indent) {
        return "";
    }
}
