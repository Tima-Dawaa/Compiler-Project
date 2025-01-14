package expression;

public class MapHashNode extends ASTNode {
    private final LambdaNode function;
    private final AtomNode tableName;

    public MapHashNode(LambdaNode function, AtomNode tableName) {
        this.function = function;
        this.tableName = tableName;
    }

    public LambdaNode getFunction() {
        return function;
    }

    public AtomNode getHashTable() {
        return tableName;
    }

    @Override
    public String prettyPrint() {
        return "Maphash Expression{" +
                "function =" + function.prettyPrint() +
                ", hash table =" + tableName.prettyPrint() +
                '}';
    }
}
