package expression;
import java.util.List;
public class ClassParameters extends ASTNode {
    private final List<ParametersOptions> options;

    public ClassParameters(List<ParametersOptions> options) {
        this.options = options;
    }

    public List<ParametersOptions> getOptions() {
        return options;
    }

    @Override
    public String prettyPrint() {
        return "Parameters{" +
                "options=" + options +
                '}';
    }
}