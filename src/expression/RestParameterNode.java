package expression;

public class RestParameterNode extends ASTNode {
    private final AtomNode atom;

    public RestParameterNode(AtomNode atom) {
        this.atom = atom;
    }

    public AtomNode getAtom() {
        return atom;
    }

    @Override
    public String prettyPrint() {
        return atom.prettyPrint();
    }
}
