package expression;

import java.util.List;

public class LambdaNode extends ASTNode{
    private final ParameterListNode parameters;
    private final List<ASTNode> body;

    public LambdaNode(ParameterListNode parameters, List<ASTNode> body) {
        this.parameters = parameters;
        this.body = body;
    }

    @Override
    public String prettyPrint() {
        StringBuilder body = new StringBuilder();
        for (ASTNode expr : this.body) {
            body.append(expr.prettyPrint()).append(" ");
        }

        return "Lambda{" +
                "parameters=[" + parameters.prettyPrint() + "]" +
                "body=[" + body.toString().trim() + "]" +
                "}";
    }
}
