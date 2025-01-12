package expression;

public class EqNode extends ASTNode{
    private ASTNode singleQuote1;
    private ASTNode eq1;
    private ASTNode singleQuote2;
    private ASTNode eq2;
    

    public EqNode(ASTNode singleQuote1, ASTNode eq1, ASTNode singleQuote2, ASTNode eq2) {
        this.singleQuote1 = singleQuote1;
        this.eq1 = eq1;
        this.singleQuote2 = singleQuote2;
        this.eq2 = eq2;
    }

    @Override
    public String prettyPrint(String indent) {
        return null;
    }
}
