package expression;

import java.util.List;

public class DotimesNode extends ASTNode {
    private final ASTNode variable;
    private final ASTNode limitValue;
    private final List<ASTNode> loopBody;

    public DotimesNode(ASTNode variable, ASTNode limitValue, List<ASTNode> loopBody) {
        this.variable = variable;
        this.limitValue = limitValue;
        this.loopBody = loopBody;
    }

    @Override
    public String prettyPrint() {
        StringBuilder body = new StringBuilder();
        for (ASTNode node : loopBody) {
            body.append(node.prettyPrint()).append(" ");
        }
        return "Dotimes{variable=" + variable.prettyPrint() +
                ", limitValue=" + limitValue.prettyPrint() +
                ", body=[" + body.toString().trim() + "]}";
    }
}
