package expression;

public class CdrNode extends ASTNode {
    private final ASTNode consExpression;

    public CdrNode(ASTNode consExpression) {
        this.consExpression = consExpression;
    }

    public ASTNode getConsExpression() {
        return consExpression;
    }

    @Override
    public String prettyPrint() {
        return "Cdr Expression{" +
                consExpression.prettyPrint() +
                '}';
    }
}
