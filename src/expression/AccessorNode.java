package expression;

public class AccessorNode extends ASTNode {
    private final String atom;

    public AccessorNode(String atom) {
        this.atom = atom;
    }

    public String getAtom() {
        return atom;
    }

    @Override
    public String prettyPrint() {
        return "AccessorExpression{" +
                "atom='" + atom + '\'' +
                '}';
    }
}
