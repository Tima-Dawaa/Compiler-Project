package expression;

import java.util.List;

public class DefunNode extends ASTNode{
    private  final AtomNode atom;
    private  final List<ASTNode> listparameters;
    private  final List<ASTNode> listbody;


    public DefunNode(AtomNode atom, List<ASTNode> listparameters, List<ASTNode> listbody) {
        this.atom = atom;
        this.listparameters = listparameters;
        this.listbody = listbody;
    }

    @Override
    public String prettyPrint() {
        StringBuilder parameters = new StringBuilder();
        for (ASTNode param : listparameters) {
            parameters.append(param.prettyPrint()).append(" ");
        }

        StringBuilder body = new StringBuilder();
        for (ASTNode expr : listbody) {
            body.append(expr.prettyPrint()).append(" ");
        }

        return "Defun{" +
                "atom=" + atom.prettyPrint() +
                ", parameters=[" + parameters.toString().trim() + "]" +
                ", body=[" + body.toString().trim() + "]" +
                "}";
    }
}
