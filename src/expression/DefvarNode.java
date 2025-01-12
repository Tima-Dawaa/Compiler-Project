package expression;

public class DefvarNode extends ASTNode {
    private final ASTNode tuple_without_paran;

    public DefvarNode(ASTNode tuple_without_paran) {
        this.tuple_without_paran = tuple_without_paran;
    }

    public ASTNode getTuple_without_paran() {
        return tuple_without_paran;
    }

    @Override
    public String prettyPrint() {
        return "defvar " + tuple_without_paran.prettyPrint();
    }
}
