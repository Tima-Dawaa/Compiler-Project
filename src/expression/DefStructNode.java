package expression;
import java.util.List;

public class DefStructNode extends ASTNode {
    private final List<String> atoms;

    public DefStructNode(List<String> atoms) {
        this.atoms = atoms;
    }

    public List<String> getAtoms() {
        return atoms;
    }

    @Override
    public String prettyPrint() {
        return "DefStructExpression{" +
                "atoms=" + atoms +
                '}';
    }
}
