package expression;

public class EqlNode extends ASTNode{
    private ASTNode singleQuote1;
    private ASTNode eq1;
    private ASTNode singleQuote2;
    private ASTNode eq2;


    public EqlNode(ASTNode singleQuote1, ASTNode eq1, ASTNode singleQuote2, ASTNode eq2) {
        this.singleQuote1 = singleQuote1;
        this.eq1 = eq1;
        this.singleQuote2 = singleQuote2;
        this.eq2 = eq2;
    }

    @Override
    public String prettyPrint() {
        StringBuilder singleQuoteString1 = new StringBuilder();
        StringBuilder singleQuoteString2 = new StringBuilder();
        singleQuoteString1.append(singleQuote1 == null ? " " : "'");
        singleQuoteString2.append(singleQuote2 == null ? " " : "'");
        return "EqlNode{ " +
                "eq1 = " + singleQuoteString1 + eq1.prettyPrint() +
                "eq2 = " + singleQuoteString2 + eq2.prettyPrint() +
                "}";
    }
}
