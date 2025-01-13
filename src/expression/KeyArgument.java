package expression;

public class KeyArgument extends ASTNode {
    private final ASTNode key;
    private final ASTNode value;

    public KeyArgument(ASTNode key, ASTNode value) {
        this.key = key;
        this.value = value;
    }

    public ASTNode getKey() {
        return key;
    }

    public ASTNode getValue() {
        return value;
    }

    @Override
    public String prettyPrint() {
        return "KeyArgument{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
