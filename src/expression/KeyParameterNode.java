package expression;

public class KeyParameterNode extends ASTNode {
    private final AtomNode atom;

    public KeyParameterNode(AtomNode atom) {
        this.atom = atom;
    }

    public AtomNode getAtom() {
        return atom;
    }

    @Override
    public String prettyPrint() {
        return "(" + atom.prettyPrint() + ")";
    }
}
