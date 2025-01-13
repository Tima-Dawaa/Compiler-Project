package expression;

public class RemHashNode extends ASTNode {
    private final ASTNode key;
    private final ASTNode hashTable;

    public RemHashNode(ASTNode key, ASTNode hashTable) {
        this.key = key;
        this.hashTable = hashTable;
    }

    public ASTNode getKey() {
        return key;
    }

    public ASTNode getHashTable() {
        return hashTable;
    }

    @Override
    public String prettyPrint() {
        return "RemHashExpression{" +
                "key=" + key +
                ", hashTable=" + hashTable +
                '}';
    }
}
