package expression;

import java.util.List;

public class DefunNode extends ASTNode {
    private final AtomNode functionName;
    private final ParameterListNode parameterList;
    private final List<ASTNode> body;

    public DefunNode(AtomNode functionName, ParameterListNode parameterList, List<ASTNode> body) {
        this.functionName = functionName;
        this.parameterList = parameterList;
        this.body = body;
    }

    @Override
    public String prettyPrint() {
        StringBuilder bodyStr = new StringBuilder();
        for (ASTNode expr : body) {
            bodyStr.append(expr.prettyPrint()).append(" ");
        }

        return "Defun{" +
                "functionName=" + functionName.prettyPrint() +
                ", parameters=" + parameterList.prettyPrint() +
                ", body=[" + bodyStr.toString().trim() + "]" +
                "}";
    }
}
