package expression;

public class SetFNode extends  ASTNode{
    private final ASTNode place;
    private  final ASTNode value;

    public SetFNode(ASTNode place, ASTNode value) {
        this.place = place;
        this.value = value;
    }

    @Override
    public String prettyPrint() {
        return "Setf{" +
                "place=" + place.prettyPrint() +
                "value=" +value.prettyPrint()+
                "}";
    }
}
