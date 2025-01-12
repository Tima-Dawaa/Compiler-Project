package expression;

import java.util.List;

public class Setq extends ASTNode{
    private final List<ASTNode> tuple_without_paran;

    public Setq(List<ASTNode> tupleWithoutParan) {
        tuple_without_paran = tupleWithoutParan;
    }

    public List<ASTNode> getTuple_without_paran() {
        return tuple_without_paran;
    }

    @Override
    public String prettyPrint(String indent) {
        return "";
    }
}
