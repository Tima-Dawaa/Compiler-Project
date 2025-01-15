package expression;

public class SingleQuoteNode extends ASTNode {
    private ASTNode value;

    public SingleQuoteNode(ASTNode value){
        this.value = value;
    }

    @Override
    public String prettyPrint() {
        return "SingleQuoteNode{ " + "\'" + value.prettyPrint() + "}" ;
    }
}
