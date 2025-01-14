package expression;

import java.util.List;

public class ArefNode extends ASTNode {
    private final AtomNode atom;
    private final List<ASTNode> list;

    public ArefNode(AtomNode atom, List<ASTNode> list) {
        this.atom = atom;
        this.list = list;
    }

    @Override
    public String prettyPrint() {
        StringBuilder parameters = new StringBuilder();
        for (ASTNode param : list) {
            parameters.append(param.prettyPrint()).append(" ");
        }


        return "ArefNode{" +
                "atom =" + atom.prettyPrint() +
                ", parameters=[" + parameters.toString().trim() + "]" +
                "}";
    }
}
