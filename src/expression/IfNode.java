package expression;

import java.util.Optional;

public class IfNode extends ASTNode {
    private final ConditionClause condition;
    private final ASTNode thenPart;
    private final Optional<ASTNode> elsePart;

    public IfNode(ConditionClause condition, ASTNode thenPart, Optional<ASTNode> elsePart) {
        this.condition = condition;
        this.thenPart = thenPart;
        this.elsePart = elsePart;
    }

    public ConditionClause getCondition() {
        return condition;
    }

    public ASTNode getThenPart() {
        return thenPart;
    }

    public Optional<ASTNode> getElsePart() {
        return elsePart;
    }

    @Override
    public String prettyPrint() {
        return "IfExpression{" +
                "condition=" + condition +
                ", thenPart=" + thenPart +
                ", elsePart=" + elsePart +
                '}';
    }
}
