package expression;

import java.util.List;
public class LoopForNode extends ASTNode {
    private final ASTNode variable;
    private final ASTNode fromValue;
    private final ASTNode toValue;
    private final List<ASTNode> loopBody;

    public LoopForNode(ASTNode variable, ASTNode fromValue, ASTNode toValue, List<ASTNode> loopBody) {
        this.variable = variable;
        this.fromValue = fromValue;
        this.toValue = toValue;
        this.loopBody = loopBody;
    }

    @Override
    public String prettyPrint() {
        StringBuilder body = new StringBuilder();
        for (ASTNode node : loopBody) {
            body.append(node.prettyPrint()).append(" ");
        }
        return "LoopFor{variable=" + variable.prettyPrint() +
                ", from=" + fromValue.prettyPrint() +
                ", to=" + toValue.prettyPrint() +
                ", body=[" + body.toString().trim() + "]}";
    }
}


