package expression;
import java.util.List;

public class DefClassNode extends ASTNode {
    private final AtomNode className;
    private final List<ASTNode> parameters;

    public DefClassNode(AtomNode className, List<ASTNode> parameters) {
        this.className = className;
        this.parameters = parameters;
    }

    public AtomNode getClassName() {
        return className;
    }

    public List<ASTNode> getParameters() {
        return parameters;
    }

    @Override
    public String prettyPrint() {
        StringBuilder parametersString = new StringBuilder();
        for (ASTNode exp : parameters) {
            parametersString.append(exp.prettyPrint()).append(" ");
        }
        return "Defclass Expression{" +
                "class name =" + className.prettyPrint() +
                ", parameters =" + parametersString +
                '}';
    }
}
