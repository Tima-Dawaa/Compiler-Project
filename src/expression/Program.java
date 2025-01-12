package expression;

import java.util.*;

public class Program extends ASTNode {
    private List<ASTNode> children = new ArrayList<>();

    public void addChild(ASTNode node) {
        children.add(node);
    }

    @Override
    public String prettyPrint() {
        // TODO Auto-generated method stub
        StringBuilder sb = new StringBuilder();
        sb.append("Program:\n");
        for (ASTNode child : children) {
            sb.append(child.prettyPrint()).append("\n");
        }
        return sb.toString().trim();
    }
}
