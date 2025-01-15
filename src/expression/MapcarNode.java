package expression;

import java.util.List;

public class MapcarNode extends ASTNode{
    private final ASTNode funcName;
    private final List<ASTNode> funcParameters;

    public MapcarNode(ASTNode funcName, List<ASTNode> funcParameters) {
        this.funcName = funcName;
        this.funcParameters = funcParameters;
    }

    @Override
    public String prettyPrint() {
        StringBuilder funcParametersString = new StringBuilder();
        for (ASTNode param : funcParameters) {
            funcParametersString.append(param.prettyPrint()).append(" ,");
        }
        return "Mapcar{" +
                "Func name = " + funcName.prettyPrint() +
                "\t,Func parameters =[" + funcParametersString + "]" +
                "}";
    }
}
