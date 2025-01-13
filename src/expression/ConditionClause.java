package expression;

public class ConditionClause extends ASTNode {
    private final ASTNode clause;

    public ConditionClause(ASTNode clause) {
        this.clause = clause;
    }

    public ASTNode getClause() {
        return clause;
    }

    @Override
    public String prettyPrint() {
        return "ConditionClause{" +
                "clause=" + clause +
                '}';
    }
}
