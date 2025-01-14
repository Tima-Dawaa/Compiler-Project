package expression;

import java.util.List;

public class ProgNode extends ASTNode {
    private final List<AtomNode> atoms;
    private final List<ASTNode> expressions;  // expression | ATOM

    public ProgNode(List<AtomNode> atoms, List<ASTNode> expressions) {
        this.atoms = atoms;
        this.expressions = expressions;
    }

    public List<AtomNode> getAtoms() {
        return atoms;
    }

    public List<ASTNode> getExpression() {
        return expressions;
    }

    @Override
    public String prettyPrint() {
        StringBuilder atomsString = new StringBuilder();
        for (ASTNode param : atoms) {
            atomsString.append(param.prettyPrint()).append(" ");
        }

        StringBuilder body = new StringBuilder();
        for (ASTNode expr : expressions) {
            body.append(expr.prettyPrint()).append(" ");
        }

        return "Prog{" +
                "atoms=" + atoms.toString().trim() +
                ", body=[" + body.toString().trim() + "]" +
                "}";
    }
}

