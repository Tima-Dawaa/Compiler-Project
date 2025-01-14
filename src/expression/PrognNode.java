package expression;

import java.util.List;

public class PrognNode extends ASTNode {
    private final List<ASTNode> expressions;

    public PrognNode(List<ASTNode> expressions) {
        this.expressions = expressions;
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
        return "Progn Expression{" +
                "expressions =" + expressionsString +
                '}';
    }
}
