package expression;
import java.util.List;

public class DefStructNode extends ASTNode {
    private final List<ASTNode> parameters;

    public DefStructNode(List<ASTNode> parameters) {
        this.parameters = parameters;
    }

    public List<ASTNode> getAtoms() {
        return parameters;
    }

    @Override
    public String prettyPrint() {
        StringBuilder parametersString = new StringBuilder();
        for (ASTNode exp : parameters) {
            parametersString.append(exp.prettyPrint()).append(" ");
        }
        return "Defstruct Expression{" +
                "parameters =" + parametersString +
                '}';
    }
}
