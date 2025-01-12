package expression;

import expression.ASTNode;

import java.util.List;

public class BitwiseOpNode extends ASTNode {
    private String operator;
    private List<ASTNode> operands;

    public BitwiseOpNode(String operator, List<ASTNode> operands) {
        this.operator = operator;
        this.operands = operands;
    }

    public String getOperator() {
        return operator;
    }

    public List<ASTNode> getOperands() {
        return operands;
    }

//    @Override
//    public <T> T accept(MyParserListener<T> visitor) {
//        return visitor.visitOperationsdNode(this);
//    }

    @Override
    public String toString() {
        return "(" + operator + " " + operands.stream()
                .map(ASTNode::toString)
                .reduce((a, b) -> a + " " + b)
                .orElse("") + ")";
    }

    @Override
    public String prettyPrint() {
        StringBuilder operandsString = new StringBuilder();
        for (ASTNode operand : operands) {
            operandsString.append(operand.prettyPrint()).append(", ");
        }
        return "BitwiseOpNode{ " +
                "operator = " + operator +
                "operands = " + operandsString +
                "}";
    }
}
