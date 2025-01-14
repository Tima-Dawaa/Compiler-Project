package expression;

public class DefconstantNode extends ASTNode {
    private final TupleNode tuple_without_paran;

    public DefconstantNode(TupleNode tuple_without_paran) {
        this.tuple_without_paran = tuple_without_paran;
    }

    public TupleNode getTuple_without_paran() {
        return tuple_without_paran;
    }

    @Override
    public String prettyPrint() {
        return "Defconstant{" +
                "tuple=" + tuple_without_paran.prettyPrint() +
                "}";
    }
}
