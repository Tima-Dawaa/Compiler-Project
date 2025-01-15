package expression;

import java.util.List;

public class DolistNode extends ASTNode {
    private final ASTNode variable;
    private final ASTNode listExpression;
    private final List<ASTNode> loopBody;

    public DolistNode(ASTNode variable, ASTNode listExpression, List<ASTNode> loopBody) {
        this.variable = variable;
        this.listExpression = listExpression;
        this.loopBody = loopBody;
    }

    @Override
    public String prettyPrint() {
        StringBuilder body = new StringBuilder();
        for (ASTNode node : loopBody) {
            body.append(node.prettyPrint()).append(" ");
        }
        return "Dolist{variable=" + variable.prettyPrint() +
                ", listExpression=" + listExpression.prettyPrint() +
                ", body=[" + body.toString().trim() + "]}";
    }
}
