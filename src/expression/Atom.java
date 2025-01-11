package expression;

public class Atom extends ASTNode {
    private final String value;

    public Atom(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String prettyPrint(String indent) {
        return "Atom{" +
                "value='" + value + '\'' +
                '}';
    }
}
