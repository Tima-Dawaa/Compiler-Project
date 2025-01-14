package expression;

import java.util.List;

public class MakeInstanceNode extends ASTNode{
    private final ASTNode atom;
    private  final List<MakeInstanceArgumentNode> argument;


    public MakeInstanceNode(ASTNode atom, List<MakeInstanceArgumentNode> argument) {
        this.atom = atom;
        this.argument = argument;
    }

    @Override
    public String prettyPrint() {
        StringBuilder parameters = new StringBuilder();
        for (ASTNode param : argument) {
            parameters.append(param.prettyPrint()).append(" ");
        }


        return "MakeInstanceNode{" +
                ", parameters=[" + parameters.toString().trim() + "]" +
                "}";
    }
}
