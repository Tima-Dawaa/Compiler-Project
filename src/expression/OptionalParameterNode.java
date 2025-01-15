package expression;

public class OptionalParameterNode extends ASTNode {
    private final AtomNode atom;
    private final ASTNode defaultValue;

    public OptionalParameterNode(AtomNode atom, ASTNode defaultValue) {
        this.atom = atom;
        this.defaultValue = defaultValue;
    }

    public AtomNode getAtom() {
        return atom;
    }

    @Override
    public String prettyPrint() {
        if (defaultValue != null) {
            return "Optional(" + atom.prettyPrint() + " " + defaultValue.prettyPrint() + ")";
        }
        return "Optional(" + atom.prettyPrint() + ")";
    }
}
