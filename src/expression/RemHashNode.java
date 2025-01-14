package expression;

public class RemHashNode extends ASTNode {
    private final ASTNode key;
    private final AtomNode tableName;

    public RemHashNode(ASTNode key, AtomNode tableName) {
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
        return "Remhash Expression{" +
                "key =" + key.prettyPrint() +
                ", hash table =" + tableName.prettyPrint() +
                '}';
    }
}
