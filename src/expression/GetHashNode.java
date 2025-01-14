package expression;

public class GetHashNode extends ASTNode {
    private final ASTNode key;
    private final AtomNode tableName;

    public GetHashNode(ASTNode key, AtomNode tableName) {
        this.key = key;
        this.tableName = tableName;
    }

    public ASTNode getKey() {
        return key;
    }

    public AtomNode getHashTable() {
        return tableName;
    }

    @Override
    public String prettyPrint() {
        return "Gethash Expression{" +
                "key =" + key.prettyPrint() +
                ", hash table =" + tableName.prettyPrint() +
                '}';
    }
}