package expression;

public class ConsNode extends ASTNode {
    private final ASTNode firstExpression;
    private final ASTNode secondExpression;

    public ConsNode(ASTNode firstExpression, ASTNode secondExpression) {
        this.firstExpression = firstExpression;
        this.secondExpression = secondExpression;
    }

    public ASTNode getFirstExpression() {
        return firstExpression;
    }

    public ASTNode getSecondExpression() {
        return secondExpression;
    }

    @Override
    public String prettyPrint() {
        return "ConsExpression{" +
                "firstExpression=" + firstExpression +
                ", secondExpression=" + secondExpression +
                '}';
    }
}
