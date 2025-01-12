package expression;

public class RealNumberNode extends ASTNode{
    private final ASTNode number;

    public RealNumberNode(ASTNode number) {
        this.number = number;
    }

    @Override
    public String prettyPrint() {
        return String.valueOf(number);
    }
}
