package expression;

public class RealNumberNode extends ASTNode{
    private final String number;

    public RealNumberNode(String number) {
        this.number = number;
    }

    @Override
    public String prettyPrint() {
        return number;
    }
}
