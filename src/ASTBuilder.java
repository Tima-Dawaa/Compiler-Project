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
    @Override public ASTNode visitArithmetic_expression(MyParser.Arithmetic_expressionContext ctx) {
        StringNode operation = new StringNode(ctx.getChild(1).getText());
        List<expression.ASTNode> operands = new ArrayList<>();
        for(int i = 2; i<ctx.children.size() - 1; i++){
            operands.add((expression.ASTNode) visit(ctx.getChild(i)));
        }
        return (ASTNode) new ArithmeticOpNode(operation, operands);
    }


    @Override public ASTNode visitComparison_expression(MyParser.Comparison_expressionContext ctx) {
        StringNode operation = new StringNode(ctx.getChild(1).getText());
        List<expression.ASTNode> operands = new ArrayList<>();
        for(int i = 2; i<ctx.children.size() - 1; i++){
            operands.add((expression.ASTNode) visit(ctx.getChild(i)));
        }
        return (ASTNode) new ComparisonOpNode(operation, operands);
    }
    @Override public ASTNode visitAnd_or_expression(MyParser.And_or_expressionContext ctx) {
        String operation = ctx.getChild(0).getText();
        List<expression.ASTNode> operands = new ArrayList<>();
        for(int i = 1; i<ctx.children.size(); i++){
            operands.add((expression.ASTNode) visit(ctx.getChild(i)));
        }
        return (ASTNode) new LogicalOpNode(operation, operands);
    }
    @Override public ASTNode visitNot_expression(MyParser.Not_expressionContext ctx) {
        String operation = ctx.getChild(0).getText();
        List<ASTNode> operand =  new ArrayList<>();
        operand.add(visit(ctx.getChild(1)));
        return (ASTNode) new LogicalOpNode(operation, (List<expression.ASTNode>) operand);
    }
    @Override public ASTNode visitBitwise_expression(MyParser.Bitwise_expressionContext ctx) {
        String operation = ctx.getChild(1).getText();
        List<expression.ASTNode> operands = new ArrayList<>();
        for(int i = 2; i<ctx.children.size() - 1; i++){
            operands.add((expression.ASTNode) visit(ctx.getChild(i)));
        }
        return (ASTNode) new BitwiseOpNode(operation, operands);
    }
    @Override public ASTNode visitEq_expression(MyParser.Eq_expressionContext ctx) {
        StringNode operation = new StringNode(ctx.getChild(1).getText());
        ASTNode operand1 = visit(ctx.getChild(2));
        ASTNode operand2 = visit(ctx.getChild(3));
        return (ASTNode) new EqualityOpNode(operation, operand1, operand2);
    }
    @Override public ASTNode visitEql_expression(MyParser.Eql_expressionContext ctx) {
        StringNode operation = new StringNode(ctx.getChild(1).getText());
        ASTNode operand1 = visit(ctx.getChild(2));
        ASTNode operand2 = visit(ctx.getChild(3));
        return (ASTNode) new EqualityOpNode(operation, operand1, operand2);
    }
    @Override public ASTNode visitEqual_expression(MyParser.Equal_expressionContext ctx) {
        StringNode operation = new StringNode(ctx.getChild(1).getText());
        ASTNode operand1 = visit(ctx.getChild(2));
        ASTNode operand2 = visit(ctx.getChild(3));
        return (ASTNode) new EqualityOpNode(operation, operand1, operand2);
    }
    @Override public ASTNode visitNot_equal_expression(MyParser.Not_equal_expressionContext ctx) {
        StringNode operation = new StringNode(ctx.getChild(1).getText());
        ASTNode operand1 = visit(ctx.getChild(2));
        ASTNode operand2 = visit(ctx.getChild(3));
        return (ASTNode) new EqualityOpNode(operation, operand1, operand2);
    }
    @Override public ASTNode visitFuncall_expression(MyParser.Funcall_expressionContext ctx) {
        ASTNode funcName = visit(ctx.getChild(2));
        List<expression.ASTNode> funcParameters = new ArrayList<>();
        for(int i = 3; i < ctx.children.size() - 1; i++){
            funcParameters.add((expression.ASTNode) visit(ctx.getChild(i)));
        }
        return (ASTNode) new FuncallNode(funcName, funcParameters);
    }
    @Override public ASTNode visitApply_expression(MyParser.Apply_expressionContext ctx) {
        ASTNode funcName = visit(ctx.getChild(2));
        List<expression.ASTNode> funcParameters = new ArrayList<>();
        for(int i = 3; i < ctx.children.size() - 1; i++){
            funcParameters.add((expression.ASTNode) visit(ctx.getChild(i)));
        }
        return (ASTNode) new ApplyNode(funcName, funcParameters);
    }
    @Override public ASTNode visitMapcar_expression(MyParser.Mapcar_expressionContext ctx) {
        ASTNode funcName = visit(ctx.getChild(2));
        List<expression.ASTNode> funcParameters = new ArrayList<>();
        for(int i = 3; i < ctx.children.size() - 1; i++){
            funcParameters.add((expression.ASTNode) visit(ctx.getChild(i)));
        }
        return (ASTNode) new ApplyNode(funcName, funcParameters);
    }
}
