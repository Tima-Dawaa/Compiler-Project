package expression;

public class CdrNode extends ASTNode {
    private final ConsNode consExpression;

    public CdrNode(ConsNode consExpression) {
        this.consExpression = consExpression;
    }

    public ConsNode getConsExpression() {
        return consExpression;
    }

    @Override
    public String prettyPrint() {
        return "CdrExpression{" +
                "consExpression=" + consExpression +
                '}';
    }
}
