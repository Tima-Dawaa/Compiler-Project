package expression;

public class EqualityOpNode extends ASTNode {
    private StringNode operation;
    private ASTNode operand1;
    private ASTNode operand2;

    public EqualityOpNode(StringNode operation, ASTNode operand1, ASTNode operand2) {
        this.operation = operation;
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    @Override
    public String prettyPrint() {
        return operation + "{" +
                 "operands = ["+ operand1.prettyPrint() + ',' + operand1.prettyPrint() + "]";
    }
}
