package expression;

public class MapHashNode extends ASTNode {
    private final LambdaNode function;
    private final ASTNode hashTable;

    public MapHashNode(LambdaNode function, ASTNode hashTable) {
        this.function = function;
        this.hashTable = hashTable;
    }

    public LambdaNode getFunction() {
        return function;
    }

    public ASTNode getHashTable() {
        return hashTable;
    }

    @Override
    public String prettyPrint() {
        return "MapHashExpression{" +
                "function=" + function +
                ", hashTable=" + hashTable +
                '}';
    }
}
