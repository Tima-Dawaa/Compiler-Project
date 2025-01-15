package expression;

import java.util.List;

public class DefunNode extends ASTNode {
    private final AtomNode functionName;
    private final ParameterListNode parameterList;
    private final StringNode documentation;
    private final List<ASTNode> body;

    public DefunNode(AtomNode functionName, ParameterListNode parameterList, StringNode documentation, List<ASTNode> body) {
        this.functionName = functionName;
        this.parameterList = parameterList;
        this.documentation = documentation;
        this.body = body;
    }

    @Override
    public String prettyPrint() {
        StringBuilder bodyStr = new StringBuilder();
        for (ASTNode expr : body) {
            bodyStr.append(expr.prettyPrint()).append(" ");
        }
        String toPrint = null;
        if (documentation != null) {
            toPrint = documentation.prettyPrint();
        }

        return "Defun{" +
                "functionName=" + functionName.prettyPrint() +
                ", parameters=" + parameterList.prettyPrint() +
                ", documentation=" + toPrint +
                ", body=[" + bodyStr.toString().trim() + "]" +
                "}";
    }
}
