package expression;

import java.util.List;

public class DoExpressionNode extends ASTNode {
    private final List<VariableDefinitionNode> variableDefinitions;
    private final ASTNode condition;
    private final List<ASTNode> loopBody;

    public DoExpressionNode(List<VariableDefinitionNode> variableDefinitions, ASTNode condition, List<ASTNode> loopBody) {
        this.variableDefinitions = variableDefinitions;
        this.condition = condition;
        this.loopBody = loopBody;
    }

    @Override
    public String prettyPrint() {
        StringBuilder vars = new StringBuilder();
        for (VariableDefinitionNode varDef : variableDefinitions) {
            vars.append(varDef.prettyPrint()).append(" ");
        }
        StringBuilder body = new StringBuilder();
        for (ASTNode node : loopBody) {
            body.append(node.prettyPrint()).append(" ");
        }
        return "DoExpression{variables=[" + vars.toString().trim() + "], condition=" +
                condition.prettyPrint() + ", body=[" + body.toString().trim() + "]}";
    }
}
