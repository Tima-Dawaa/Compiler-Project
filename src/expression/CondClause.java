package expression;

import java.util.List;

public class CondClause extends ASTNode {
    private final ASTNode condition;
    private final List<ASTNode> expressions;

    public CondClause(ASTNode condition, List<ASTNode> expressions) {
        this.condition = condition;
        this.expressions = expressions;
    }

    public ASTNode getCondition() {
        return condition;
    }

    public List<ASTNode> getExpressions() {
        return expressions;
    }

    @Override
    public String prettyPrint() {
        StringBuilder expressionsString = new StringBuilder();
        for (ASTNode exp : expressions) {
            expressionsString.append(exp.prettyPrint()).append(" ");
        }
        return "Cond Clause{" +
                "condition =" + condition.prettyPrint() +
                ", expressions =" + expressionsString +
                '}';
    }
}
