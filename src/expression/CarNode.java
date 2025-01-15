package expression;

public class CarNode extends ASTNode {
    private final ASTNode consExpression;

    public CarNode(ASTNode consExpression) {
        this.consExpression = consExpression;
    }

    public ASTNode getConsExpression() {
        return consExpression;
    }

    @Override
    public String prettyPrint() {
        return "Car Expression{" +
                consExpression.prettyPrint() +
                '}';
    }
}
