package expression;

public class InitArgNode extends ASTNode {
    private final String atom;

    public InitArgNode(String atom) {
        this.atom = atom;
    }

    public String getAtom() {
        return atom;
    }

    @Override
    public String prettyPrint() {
        return "InitArgExpression{" +
                "atom='" + atom + '\'' +
                '}';
    }
}
