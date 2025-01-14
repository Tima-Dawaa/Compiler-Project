package expression;


public class MakeInstanceArgumentNode extends ASTNode {
    private final ASTNode atom;
    private final ASTNode colon;
    private final ASTNode value;


    public MakeInstanceArgumentNode(ASTNode atom, ASTNode colon, ASTNode value) {
        this.atom = atom;
        this.colon = colon;
        this.value = value;
    }

    @Override
    public String prettyPrint() {


        return "MakeInstanceArgumentNode{" +
                "atom=" + atom.prettyPrint() +
                "colon=" + colon.prettyPrint() +
                "value=" + value.prettyPrint()+
                "}";

    }
}
