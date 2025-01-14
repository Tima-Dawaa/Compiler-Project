import expression.*;

import java.util.ArrayList;
import java.util.List;

public class ASTBuilder extends MyParserBaseVisitor<ASTNode> {
    private List<String> vars;//store all the variable declared in the program so far
    public List<String> semanticsErrors;

    public ASTBuilder() {
        // TODO Auto-generated constructor stub
        this.vars = new ArrayList<String>();
        this.semanticsErrors = new ArrayList<String>();
    }

    public ASTNode visitSetq_single_var(MyParser.Setq_single_varContext ctx) {
        TupleNode tupleNode = (TupleNode) visit(ctx.tuple_without_paran());
        ASTNode setqNode = (ASTNode) new SetqNode(List.of(tupleNode));
        return setqNode;
    }

    public ASTNode visitSetq_multi_var(MyParser.Setq_multi_varContext ctx) {
        List<TupleNode> tupleNodes = ctx.tuple_without_paran()
                .stream()
                .map(node -> (TupleNode) visit(node))
                .toList();
        ASTNode setqNode = (ASTNode) new SetqNode(tupleNodes);
        return setqNode;
    }

    public ASTNode visitDefvar(MyParser.DefvarContext ctx) {
        String defvarToken = ctx.DEFVAR().getText();
        ASTNode tupleNode = visit(ctx.tuple_without_paran());
        ASTNode defvarNode = (ASTNode) new DefvarNode((TupleNode) tupleNode);
        return defvarNode;
    }

    public ASTNode visitDefconstant(MyParser.DefconstantContext ctx) {
        String defconstantToken = ctx.DEFCONSTANT().getText();
        ASTNode tupleNode = visit(ctx.tuple_without_paran());
        ASTNode defconstantNode = (ASTNode) new DefconstantNode((TupleNode) tupleNode);
        return defconstantNode;
    }

    public ASTNode visitProg(MyParser.ProgContext ctx) {
        List<AtomNode> atomNodes = ctx.ATOM()
                .stream()
                .map(atom -> new AtomNode(atom.getText()))
                .toList();
        List<ASTNode> expressionNodes = ctx.expression()
                .stream()
                .map(this::visit)
                .toList();
        ASTNode progNode = new ProgNode(atomNodes, expressionNodes);
        return progNode;
    }

    public ASTNode visitLet(MyParser.LetContext ctx) {
        List<TupleWithParanNode> tupleNodes = ctx.tuple_with_paran()
                .stream()
                .map(node -> (TupleWithParanNode) visit(node)) // Visit each tuple node
                .toList();
        List<ASTNode> expressionNodes = ctx.expression()
                .stream()
                .map(this::visit) // Visit each expression node
                .toList();
        ASTNode letNode = new LetNode(tupleNodes, expressionNodes);
        return letNode;
    }
}
