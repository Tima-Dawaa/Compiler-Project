package expression;

import java.util.List;

public class FormatNode extends ASTNode{
    // (value | expression)*
    private final BooleanNode format_destination;
    private final StringNode format_string;
    private final List<ASTNode> expressions;

    public FormatNode(BooleanNode format_destination, StringNode format_string, List<ASTNode> expressions) {
        this.format_destination = format_destination;
        this.format_string = format_string;
        this.expressions = expressions;
    }

    @Override
    public String prettyPrint() {
        StringBuilder body = new StringBuilder();
        for (ASTNode expr : expressions) {
            body.append(expr.prettyPrint()).append("\n");
        }

        return "FormatNode{" +
                "format_destination=" + format_destination.prettyPrint() +
                ", format_string=" + format_string.prettyPrint() +
                ", expressions=" + expressions.toString().trim() +
                "}";
    }
}
