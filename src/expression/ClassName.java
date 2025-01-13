package expression;
import java.util.List;
public class ClassName extends ASTNode {
    private final String name;
    private final List<String> atoms;

    public ClassName(String name, List<String> atoms) {
        this.name = name;
        this.atoms = atoms;
    }

    public String getName() {
        return name;
    }

    public List<String> getAtoms() {
        return atoms;
    }

    @Override
    public String prettyPrint() {
        return "ClassName{" +
                "name='" + name + '\'' +
                ", atoms=" + atoms +
                '}';
    }
}
