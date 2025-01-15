package expression;

public class MapHashNode extends ASTNode {
    private final ASTNode function;
    private final AtomNode tableName;

    public MapHashNode(ASTNode function, AtomNode tableName) {
        this.function = function;
        this.tableName = tableName;
    }

    public ASTNode getFunction() {
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
