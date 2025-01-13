package expression;

public class GetHashNode extends ASTNode {
    private final ASTNode key;
    private final ASTNode hashTable;

    public GetHashNode(ASTNode key, ASTNode hashTable) {
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
        return "GetHashExpression{" +
                "key=" + key +
                ", hashTable=" + hashTable +
                '}';
    }
}