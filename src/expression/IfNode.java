package expression;

import java.util.Optional;

public class IfNode extends ASTNode {
    private final ASTNode condition;
    private final ASTNode action;
    private final Optional<ASTNode> elsePart;

    public IfNode(ASTNode condition, ASTNode action, Optional<ASTNode> elsePart) {
        this.condition = condition;
        this.action = action;
        this.elsePart = elsePart;
    }

    public ASTNode getCondition() {
        return condition;
    }

    public ASTNode getThenPart() {
        return action;
    }

    public Optional<ASTNode> getElsePart() {
        return elsePart;
    }

    @Override
    public String prettyPrint() {
        String elseSection = "None";
        if(elsePart.isPresent())
            elseSection=elsePart.get().prettyPrint();
        return "If Expression{" +
                "condition =" + condition.prettyPrint() +
                ", action =" + action.prettyPrint() +
                ", else =" + elseSection +
                '}';
    }
}
