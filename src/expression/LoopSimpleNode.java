package expression;

import java.util.List;

public class LoopSimpleNode extends ASTNode {
    private final List<ASTNode> loopBody;

    public LoopSimpleNode(List<ASTNode> loopBody) {
        this.loopBody = loopBody;
    }

    @Override
    public String prettyPrint() {
        StringBuilder body = new StringBuilder();
        for (ASTNode node : loopBody) {
            body.append(node.prettyPrint()).append(" ");
        }
        return "LoopSimple{body=[" + body.toString().trim() + "]}";
    }
}

