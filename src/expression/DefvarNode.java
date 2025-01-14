package expression;

public class DefvarNode extends ASTNode {
    private final TupleNode tuple_without_paran;

    public DefvarNode(TupleNode tuple_without_paran) {
        this.tuple_without_paran = tuple_without_paran;
    }

    public TupleNode getTuple_without_paran() {
        return tuple_without_paran;
    }

    @Override
    public String prettyPrint() {
        return "Defvar{" +
                "tuple=" + tuple_without_paran.prettyPrint() +
                "}";
    }
}
