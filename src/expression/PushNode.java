package expression;

import java.util.List;

public class PushNode extends  ASTNode{
private final ASTNode value;
private final List<ASTNode> listexpression;

    public PushNode(ASTNode value, List<ASTNode> listexpression) {
        this.value = value;
        this.listexpression = listexpression;
    }

    @Override
    public String prettyPrint() {
        StringBuilder parameters = new StringBuilder();
        for (ASTNode param : listexpression) {
            parameters.append(param.prettyPrint()).append(" ");
        }

        return "Push{" +
                "value=" + value.prettyPrint() +
                ", parameters=[" + parameters.toString().trim() + "]" +
                "}";
    }
}
