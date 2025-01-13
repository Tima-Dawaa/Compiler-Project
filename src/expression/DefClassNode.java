package expression;
import java.util.List;

public class DefClassNode extends ASTNode {
    private final ClassName className;
    private final List<ParametersOptions> parameters;

    public DefClassNode(ClassName className, List<ParametersOptions> parameters) {
        this.className = className;
        this.parameters = parameters;
    }

    public ClassName getClassName() {
        return className;
    }

    public List<ParametersOptions> getParameters() {
        return parameters;
    }

    @Override
    public String prettyPrint() {
        return "DefClassExpression{" +
                "className=" + className +
                ", parameters=" + parameters +
                '}';
    }
}
