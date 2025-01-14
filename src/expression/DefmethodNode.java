package expression;

import java.util.List;

public class DefmethodNode extends ASTNode{

    private final AtomNode funcName;
    private final List<ASTNode> funcParameters;
    private final List<ASTNode> funcBody;

    public DefmethodNode(AtomNode funcName, List<ASTNode> funcParameters, List<ASTNode> funcBody) {
        this.funcName = funcName;
        this.funcParameters = funcParameters;
        this.funcBody = funcBody;
    }

    @Override
    public String prettyPrint() {
        StringBuilder funcParametersString = new StringBuilder();
        for (ASTNode param : funcParameters) {
            funcParametersString.append(param.prettyPrint()).append(" ");
        }
        StringBuilder body = new StringBuilder();
        for (ASTNode expr : funcBody) {
            body.append(expr.prettyPrint()).append(" ");
        }
        return "Defmethod{" +
                "Func name = " + funcName.prettyPrint() +
                "Func parameters = " + funcParametersString +
                "Func body = " + body +
                "}";
    }
}
