package expression;

import java.util.List;

public class SetqNode extends ASTNode{
    private final List<TupleNode> tuple_without_paran;

    public SetqNode(List<TupleNode> tupleWithoutParan) {
        tuple_without_paran = tupleWithoutParan;
    }

    public List<TupleNode> getTuple_without_paran() {
        return tuple_without_paran;
    }

    @Override
    public String prettyPrint() {
        StringBuilder tuplesString = new StringBuilder();
        for (ASTNode param : tuple_without_paran) {
            tuplesString.append(param.prettyPrint()).append(", ");
        }

        return "Setq{" +
                "tuples=" + tuplesString.toString().trim() +
                "}";
    }
}
