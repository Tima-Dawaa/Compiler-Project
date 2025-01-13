package expression;

import java.util.List;

public class MakeHashTableNode extends ASTNode {
    private final List<ASTNode> arguments;

    public MakeHashTableNode(List<ASTNode> arguments) {
        this.arguments = arguments;
    }

    public List<ASTNode> getArguments() {
        return arguments;
    }

    @Override
    public String prettyPrint() {
        return "MakeHashTableExpression{" +
                "arguments=" + arguments +
                '}';
    }
}
