package expression;

public class CarNode extends ASTNode {
    private final ConsNode consExpression;

    public CarNode(ConsNode consExpression) {
        this.consExpression = consExpression;
    }

    public ConsNode getConsExpression() {
        return consExpression;
    }

    @Override
    public String prettyPrint() {
        return "Car Expression{" +
                consExpression.prettyPrint() +
                '}';
    }
}
