package expression;

import java.util.List;

public class CondNode extends ASTNode {
    private final List<CondClause> clauses;

    public CondNode(List<CondClause> clauses) {
        this.clauses = clauses;
    }

    public List<CondClause> getClauses() {
        return clauses;
    }

    @Override
    public String prettyPrint() {
        StringBuilder clausesString = new StringBuilder();
        for (CondClause exp : clauses) {
            clausesString.append(exp.prettyPrint()).append(" ");
        }
        return "Cond Expression{" +
                "clauses =" + clausesString +
                '}';
    }
}
