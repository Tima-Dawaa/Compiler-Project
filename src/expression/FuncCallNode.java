package expression;

public class FuncCallNode extends ASTNode{
    private final AtomNode atom;
    private final ASTNode expression;

    public FuncCallNode(AtomNode atom, ASTNode expression) {
        this.atom = atom;
        this.expression = expression;
    }

    @Override
    public String prettyPrint() {
        return "FuncCallNode{" +
                "atom=[" + atom.prettyPrint() + "]" +
                "body=[" + expression.prettyPrint() + "]" +
                "}";
    }
}
