package expression;

import java.util.List;

public class LambdaNode extends ASTNode{
    private final List<ASTNode> parameters;
    private final List<ASTNode> body;


    public LambdaNode(List<ASTNode> parameters, List<ASTNode> body) {
        this.parameters = parameters;
        this.body = body;
    }

    @Override
    public String prettyPrint() {
        StringBuilder parameters = new StringBuilder();
        for (ASTNode param : this.parameters) {
            parameters.append(param.prettyPrint()).append(" ");
        }

        StringBuilder body = new StringBuilder();
        for (ASTNode expr : this.body) {
            body.append(expr.prettyPrint()).append(" ");
        }

        return "Lambda{" +
                "parameters=[" + parameters.toString().trim() + "]" +
                "body=[" + body.toString().trim() + "]" +
                "}";
    }
}
