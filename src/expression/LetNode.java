package expression;

import java.util.List;

public class LetNode extends ASTNode {
    private final List<TupleWithParanNode> tuples;
    private final List<ASTNode> expressions;  // expression | ATOM

    public LetNode(List<TupleWithParanNode> tuples, List<ASTNode> expressions) {
        this.tuples = tuples;
        this.expressions = expressions;
    }

    public List<TupleWithParanNode> getTuple() {
        return tuples;
    }

    public List<ASTNode> getExpression() {
        return expressions;
    }

    @Override
    public String prettyPrint() {
        StringBuilder tuplesString = new StringBuilder();
        for (ASTNode param : tuples) {
            tuplesString.append(param.prettyPrint()).append(" ");
        }

        StringBuilder body = new StringBuilder();
        for (ASTNode expr : expressions) {
            body.append(expr.prettyPrint()).append(" ");
        }

        return "Let{" +
                "tuples=" + tuplesString.toString().trim() +
                ", body=[" + body.toString().trim() + "]" +
                "}";
    }
}
