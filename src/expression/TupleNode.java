package expression;

public class TupleNode extends ASTNode{
    private final AtomNode atomNode;
    private final ASTNode expression;

    public TupleNode(AtomNode atomNode, ASTNode expression) {
        this.atomNode = atomNode;
        this.expression = expression;
    }

    public AtomNode getAtom() {
        return atomNode;
    }

    public ASTNode getExpression() {
        return expression;
    }

    @Override
    public String prettyPrint() {
        return atomNode.prettyPrint() + " " + expression.prettyPrint();
    }
}
