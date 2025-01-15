package expression;

public class VariableDefinitionNode extends ASTNode {
    private final ASTNode variable;
    private final ASTNode initValue;
    private final ASTNode stepValue;

    public VariableDefinitionNode(ASTNode variable, ASTNode initValue, ASTNode stepValue) {
        this.variable = variable;
        this.initValue = initValue;
        this.stepValue = stepValue;
    }

    @Override
    public String prettyPrint() {
        return "VariableDefinition{variable=" + variable.prettyPrint() +
                ", initValue=" + (initValue != null ? initValue.prettyPrint() : "null") +
                ", stepValue=" + (stepValue != null ? stepValue.prettyPrint() : "null") + "}";
    }
}
