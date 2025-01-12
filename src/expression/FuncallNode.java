package expression;

import java.util.List;

public class FuncallNode extends ASTNode{

    private final ASTNode funcName;
    private final List<ASTNode> funcParameters;

    public FuncallNode(ASTNode funcName, List<ASTNode> funcParameters) {
        this.funcName = funcName;
        this.funcParameters = funcParameters;
    }

    @Override
    public String prettyPrint() {
        StringBuilder funcParametersString = new StringBuilder();
        for (ASTNode param : funcParameters) {
            funcParametersString.append(param.prettyPrint()).append(" ");
        }
        return "Funcall{" +
                "Func name = " + funcName.prettyPrint() +
                "Func parameters = " + funcParametersString +
                "}";
    }
}
