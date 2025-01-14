package expression;

public class ClrHashNode extends ASTNode {
    private final AtomNode tableName;

    public ClrHashNode(AtomNode hashTable) {
        this.tableName = hashTable;
    }

    public ASTNode getHashTable() {
        return tableName;
    }

    @Override
    public String prettyPrint() {
        return "Clrhash Expression{" +
                "hash table =" + tableName.prettyPrint() +
                '}';
    }
}