package expression;

import java.util.List;

public class PopNode extends ASTNode {
    private final List<ASTNode> listPop;

    public PopNode(List<ASTNode> list) {
        this.listPop = list;
    }

    @Override
    public String prettyPrint() {
        StringBuilder parameters = new StringBuilder();
        for (ASTNode param : listPop) {
            parameters.append(param.prettyPrint()).append(" ");
        }


        return "Push{" +
                ", parameters=[" + parameters.toString().trim() + "]" +
                "}";
    }
}
