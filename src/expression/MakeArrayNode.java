package expression;

public class MakeArrayNode extends  ASTNode{
    private final RealNumberNode realNumber;

    public MakeArrayNode(RealNumberNode realNumber) {
        this.realNumber = realNumber;
    }

    @Override
    public String prettyPrint() {
        return "MakeArrayNode{" +
                "realNumber=" + realNumber.prettyPrint() +
                "}";
    }
}
