package expression;

public class TupleNode extends ASTNode{
    private final Atom atom;
    private final ASTNode expression;

    public TupleNode(Atom atom, ASTNode expression) {
        this.atom = atom;
        this.expression = expression;
    }

    public Atom getAtom() {
        return atom;
    }

    public ASTNode getExpression() {
        return expression;
    }

    @Override
    public String prettyPrint(String indent) {
        return "";
    }
}
