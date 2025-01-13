package expression;

public class ClrHashNode extends ASTNode {
    private final ASTNode hashTable;

    public ClrHashNode(ASTNode hashTable) {
        this.hashTable = hashTable;
    }

    public ASTNode getHashTable() {
        return hashTable;
    }

    @Override
    public String prettyPrint() {
        return "ClrHashExpression{" +
                "hashTable=" + hashTable +
                '}';
    }
}