package expression;

import java.util.List;

public class ParameterListNode extends ASTNode {
    private final List<ASTNode> parameters; // Can contain AtomNode or specialized parameter types

    public ParameterListNode(List<ASTNode> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String prettyPrint() {
        StringBuilder paramStr = new StringBuilder();
        for (ASTNode param : parameters) {
            paramStr.append(param.prettyPrint()).append(" ");
        }
        return "(" + paramStr.toString().trim() + ")";
    }
}

