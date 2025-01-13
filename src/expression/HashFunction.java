package expression;

public class HashFunction extends ASTNode {
    private final ASTNode hashFunction;

    public HashFunction(ASTNode hashFunction) {
        this.hashFunction = hashFunction;
    }

    public ASTNode getHashFunction() {
        return hashFunction;
    }

    @Override
    public String prettyPrint() {
        return "HashFunction{" +
                "hashFunction=" + hashFunction +
                '}';
    }
}