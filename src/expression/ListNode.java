package expression;

import java.util.List;

public class ListNode extends ASTNode {
    private final List<ASTNode> list;

    public ListNode(List<ASTNode> list) {
        this.list = list;
    }

    @Override
    public String prettyPrint() {
        StringBuilder parameters = new StringBuilder();
        for (ASTNode param : list) {
            parameters.append(param.prettyPrint()).append(" ");
        }


        return "ListNode{" +
                ", list parameters=[" + parameters.toString().trim() + "]" +
                "}";
    }
}
