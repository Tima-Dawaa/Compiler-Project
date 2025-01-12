package expression;

import java.util.List;

public class MakeInstanceNode extends ASTNode{
    private final ASTNode atome;
    private  final List<MakeInstanceArgumentNode> argument;


    public MakeInstanceNode(ASTNode atome, List<MakeInstanceArgumentNode> argument) {
        this.atome = atome;
        this.argument = argument;
    }

    @Override
    public String prettyPrint() {
        return null;
    }
}
