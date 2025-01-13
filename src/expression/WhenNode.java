package expression;

import java.util.List;

public class WhenNode extends ASTNode {
    private final ConditionClause condition;
    private final List<ASTNode> expressions;

    public WhenNode(ConditionClause condition, List<ASTNode> expressions) {
        this.condition = condition;
        this.expressions = expressions;
    }

    public ConditionClause getCondition() {
        return condition;
    }

    public List<ASTNode> getExpressions() {
        return expressions;
    }

    @Override
    public String prettyPrint() {
        return "WhenExpression{" +
                "condition=" + condition +
                ", expressions=" + expressions +
                '}';
    }
}
