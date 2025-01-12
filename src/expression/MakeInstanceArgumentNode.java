package expression;


public class MakeInstanceArgumentNode extends ASTNode{
private final ASTNode atom;
private  final ASTNode colon;
private  final ASTNode listValue;

    public MakeInstanceArgumentNode(ASTNode atom, ASTNode colon, ASTNode listValue) {
        this.atom = atom;
        this.colon = colon;
        this.listValue = listValue;
    }

    @Override
    public String prettyPrint() {
        return null;
    }
}
