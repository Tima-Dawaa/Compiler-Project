import expression.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ASTBuilder extends MyParserBaseVisitor<ASTNode> {
    private List<String> vars;//store all the variable declared in the program so far
    public List<String> semanticsErrors;

    public ASTBuilder() {
        // TODO Auto-generated constructor stub
        this.vars = new ArrayList<String>();
        this.semanticsErrors = new ArrayList<String>();
    }

    @Override
    public ASTNode visitSetq_single_var(MyParser.Setq_single_varContext ctx) {
        TupleNode tupleNode = (TupleNode) visit(ctx.tuple_without_paran());
        ASTNode setqNode = (ASTNode) new SetqNode(List.of(tupleNode));
        return setqNode;
    }

    @Override
    public ASTNode visitSetq_multi_var(MyParser.Setq_multi_varContext ctx) {
        List<TupleNode> tupleNodes = ctx.tuple_without_paran()
                .stream()
                .map(node -> (TupleNode) visit(node))
                .toList();
        ASTNode setqNode = (ASTNode) new SetqNode(tupleNodes);
        return setqNode;
    }

    @Override
    public ASTNode visitDefvar(MyParser.DefvarContext ctx) {
        String defvarToken = ctx.DEFVAR().getText();
        ASTNode tupleNode = visit(ctx.tuple_without_paran());
        ASTNode defvarNode = (ASTNode) new DefvarNode((TupleNode) tupleNode);
        return defvarNode;
    }

    @Override
    public ASTNode visitDefconstant(MyParser.DefconstantContext ctx) {
        String defconstantToken = ctx.DEFCONSTANT().getText();
        ASTNode tupleNode = visit(ctx.tuple_without_paran());
        ASTNode defconstantNode = (ASTNode) new DefconstantNode((TupleNode) tupleNode);
        return defconstantNode;
    }

    @Override
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

    @Override
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

    @Override
    public ASTNode visitArithmetic_expression(MyParser.Arithmetic_expressionContext ctx) {
        StringNode operation = new StringNode(ctx.getChild(1).getText());
        List<ASTNode> operands = new ArrayList<>();
        for (int i = 2; i < ctx.children.size() - 1; i++) {
            if(ctx.getChild(i) instanceof TerminalNode) {
                if(Objects.equals(((TerminalNode) ctx.getChild(i)).getSymbol().getText(), "ATOM")) operands.add(new AtomNode(ctx.getChild(i).getText()));
                else operands.add(new IntNumberNode(Integer.parseInt(ctx.getChild(i).getText())));
            }
            operands.add(visit(ctx.getChild(i)));
        }
        return new ArithmeticOpNode(operation, operands);
    }

    @Override
    public ASTNode visitComparison_expression(MyParser.Comparison_expressionContext ctx) {
        StringNode operation = new StringNode(ctx.getChild(1).getText());
        List<expression.ASTNode> operands = new ArrayList<>();
        for (int i = 2; i < ctx.children.size() - 1; i++) {
            operands.add((expression.ASTNode) visit(ctx.getChild(i)));
        }
        return (ASTNode) new ComparisonOpNode(operation, operands);
    }

    @Override
    public ASTNode visitAnd_or_expression(MyParser.And_or_expressionContext ctx) {
        String operation = ctx.getChild(0).getText();
        List<expression.ASTNode> operands = new ArrayList<>();
        for (int i = 1; i < ctx.children.size(); i++) {
            operands.add((expression.ASTNode) visit(ctx.getChild(i)));
        }
        return (ASTNode) new LogicalOpNode(operation, operands);
    }

    @Override
    public ASTNode visitNot_expression(MyParser.Not_expressionContext ctx) {
        String operation = ctx.getChild(0).getText();
        List<ASTNode> operand = new ArrayList<>();
        operand.add(visit(ctx.getChild(1)));
        return (ASTNode) new LogicalOpNode(operation, (List<expression.ASTNode>) operand);
    }

    @Override
    public ASTNode visitBitwise_expression(MyParser.Bitwise_expressionContext ctx) {
        String operation = ctx.getChild(1).getText();
        List<expression.ASTNode> operands = new ArrayList<>();
        for (int i = 2; i < ctx.children.size() - 1; i++) {
            operands.add((expression.ASTNode) visit(ctx.getChild(i)));
        }
        return (ASTNode) new BitwiseOpNode(operation, operands);
    }

    @Override
    public ASTNode visitEq_expression(MyParser.Eq_expressionContext ctx) {
        StringNode operation = new StringNode(ctx.getChild(1).getText());
        ASTNode operand1 = visit(ctx.getChild(2));
        ASTNode operand2 = visit(ctx.getChild(3));
        return (ASTNode) new EqualityOpNode(operation, operand1, operand2);
    }

    @Override
    public ASTNode visitEql_expression(MyParser.Eql_expressionContext ctx) {
        StringNode operation = new StringNode(ctx.getChild(1).getText());
        ASTNode operand1 = visit(ctx.getChild(2));
        ASTNode operand2 = visit(ctx.getChild(3));
        return (ASTNode) new EqualityOpNode(operation, operand1, operand2);
    }

    @Override
    public ASTNode visitEqual_expression(MyParser.Equal_expressionContext ctx) {
        StringNode operation = new StringNode(ctx.getChild(1).getText());
        ASTNode operand1 = visit(ctx.getChild(2));
        ASTNode operand2 = visit(ctx.getChild(3));
        return (ASTNode) new EqualityOpNode(operation, operand1, operand2);
    }

    @Override
    public ASTNode visitNot_equal_expression(MyParser.Not_equal_expressionContext ctx) {
        StringNode operation = new StringNode(ctx.getChild(1).getText());
        ASTNode operand1 = visit(ctx.getChild(2));
        ASTNode operand2 = visit(ctx.getChild(3));
        return (ASTNode) new EqualityOpNode(operation, operand1, operand2);
    }

    @Override
    public ASTNode visitFuncall_expression(MyParser.Funcall_expressionContext ctx) {
        ASTNode funcName = visit(ctx.getChild(2));
        List<expression.ASTNode> funcParameters = new ArrayList<>();
        for (int i = 3; i < ctx.children.size() - 1; i++) {
            funcParameters.add((expression.ASTNode) visit(ctx.getChild(i)));
        }
        return (ASTNode) new FuncallNode(funcName, funcParameters);
    }

    @Override
    public ASTNode visitApply_expression(MyParser.Apply_expressionContext ctx) {
        ASTNode funcName = visit(ctx.getChild(2));
        List<expression.ASTNode> funcParameters = new ArrayList<>();
        for (int i = 3; i < ctx.children.size() - 1; i++) {
            funcParameters.add((expression.ASTNode) visit(ctx.getChild(i)));
        }
        return (ASTNode) new ApplyNode(funcName, funcParameters);
    }

    @Override
    public ASTNode visitMapcar_expression(MyParser.Mapcar_expressionContext ctx) {
        ASTNode funcName = visit(ctx.getChild(2));
        List<expression.ASTNode> funcParameters = new ArrayList<>();
        for (int i = 3; i < ctx.children.size() - 1; i++) {
            funcParameters.add((expression.ASTNode) visit(ctx.getChild(i)));
        }
        return (ASTNode) new ApplyNode(funcName, funcParameters);
    }
    @Override
    public ASTNode visitList_expression(MyParser.List_expressionContext ctx) {
        List<ASTNode> elements = new ArrayList<>();

        for (ParseTree child : ctx.children) {
            if (child instanceof MyParser.ValueContext) {
                elements.add(visit((MyParser.ValueContext) child));
            } else if (child instanceof MyParser.Operators_expressionContext) {
                elements.add(visit((MyParser.Operators_expressionContext) child));
            }
        }

        return new ListNode(elements);
    }


    @Override
    public ASTNode visitFormat_expression(MyParser.Format_expressionContext ctx) {
        ASTNode formatDestinationNode = visit(ctx.FORMAT_DESTINATION());
        BooleanNode formatDestination = (BooleanNode) formatDestinationNode;

        ASTNode formatStringNode = visit((ParseTree) ctx.FORMAT_STRING());
        StringNode formatString = (StringNode) formatStringNode;

        List<ASTNode> expressionNodes = new ArrayList<>();

        for (int i = 0; i < ctx.children.size(); i++) {
            ParseTree child = ctx.children.get(i);
            if (child instanceof MyParser.ValueContext) {
                expressionNodes.add(visit((MyParser.ValueContext) child));
            } else if (child instanceof MyParser.ExpressionContext) {
                expressionNodes.add(visit((MyParser.ExpressionContext) child));
            }
        }
        FormatNode formatNode = new FormatNode(formatDestination, formatString, expressionNodes);
        return formatNode;
    }



    @Override
    public ASTNode visitPush_expression(MyParser.Push_expressionContext ctx) {
        ASTNode valueNode = visit(ctx.value());

        List<ASTNode> listExpression = new ArrayList<>();
        if (ctx.list_expression() != null) {
            ASTNode listNode = visit(ctx.list_expression());
            listExpression.add(listNode);
        } else if (ctx.ATOM() != null) {
            listExpression.add(new AtomNode(ctx.ATOM().getText()));
        }

        return new PushNode(valueNode, listExpression);
    }

    @Override
    public ASTNode visitPop_expression(MyParser.Pop_expressionContext ctx) {
        List<ASTNode> listPop = new ArrayList<>();
        if (ctx.list_expression() != null) {
            ASTNode listNode = visit(ctx.list_expression());
            listPop.add(listNode);
        } else if (ctx.ATOM() != null) {
            listPop.add(new AtomNode(ctx.ATOM().getText()));
        }

        return new PopNode(listPop);
    }

    @Override
    public ASTNode visitMake_instance_expression(MyParser.Make_instance_expressionContext ctx) {
        ASTNode atom = new AtomNode(ctx.ATOM().getText());

        List<MakeInstanceArgumentNode> arguments = new ArrayList<>();
        for (MyParser.Initialization_argumentContext argCtx : ctx.initialization_argument()) {
            arguments.add((MakeInstanceArgumentNode) visit(argCtx));
        }

        return new MakeInstanceNode(atom, arguments);
    }

    @Override
    public ASTNode visitInitialization_argument(MyParser.Initialization_argumentContext ctx) {
        ASTNode colon = new AtomNode(ctx.COLON().getText());
        ASTNode atom = new AtomNode(ctx.ATOM().getText());
        ASTNode value = visit(ctx.value());

        return new MakeInstanceArgumentNode(atom, colon, value);
    }

    @Override
    public ASTNode visitDefun_expression(MyParser.Defun_expressionContext ctx) {
        AtomNode atom = new AtomNode(ctx.ATOM().getText());

        List<ASTNode> listParameters = new ArrayList<>();
        if (ctx.parameter_list() != null) {
            for (TerminalNode param : ctx.parameter_list().ATOM()) {
                listParameters.add(new AtomNode(param.getText()));
            }
        }

        List<ASTNode> listBody = new ArrayList<>();
        if (ctx.defun_body() != null) {
            for (MyParser.ExpressionContext exprCtx : ctx.defun_body().expression()) {
                listBody.add(visit(exprCtx));
            }
        }

        return new DefunNode(atom, listParameters, listBody);
    }

    @Override
    public ASTNode visitAref_expression(MyParser.Aref_expressionContext ctx) {
        ASTNode atomNode = visit(ctx.ATOM(0));

        List<ASTNode> parameterNodes = new ArrayList<>();

        for (int i = 1; i < ctx.children.size() - 1; i++) {
            ParseTree child = ctx.getChild(i);

            if (child instanceof MyParser.Real_numberContext) {
                parameterNodes.add(visit(child));
            } else if (child != null) {
                parameterNodes.add(new AtomNode(child.getText()));
            }
        }

        return new ArefNode((AtomNode) atomNode, parameterNodes);
    }

    @Override
    public ASTNode visitIf_expression(MyParser.If_expressionContext ctx) {
        ASTNode condition = visit(ctx.condition_clause());
        ASTNode action = visit(ctx.expression(0));
        Optional<ASTNode> elsePart = ctx.expression().size() > 1 ? Optional.of(visit(ctx.expression(1))) : Optional.empty();
        return new IfNode(condition, action, elsePart);
    }

    @Override
    public ASTNode visitWhen_expression(MyParser.When_expressionContext ctx) {
        ASTNode condition = visit(ctx.condition_clause());
        List<ASTNode> expressions = new ArrayList<>();
        for (int i = 1; i < ctx.expression().size(); i++) {
            expressions.add(visit(ctx.expression(i)));
        }
        return new WhenNode(condition, expressions);
    }

    @Override
    public ASTNode visitProgn_expression(MyParser.Progn_expressionContext ctx) {
        List<ASTNode> expressions = new ArrayList<>();
        for (int i = 0; i < ctx.expression().size()  ; i++) {
            expressions.add(visit(ctx.expression(i)));
        }
        return new PrognNode(expressions);
    }

    @Override
    public ASTNode visitUnless_expression(MyParser.Unless_expressionContext ctx) {
        ASTNode condition = visit(ctx.condition_clause());
        List<ASTNode> expressions = new ArrayList<>();
        for (int i = 1; i < ctx.expression().size(); i++) {
            expressions.add(visit(ctx.expression(i)));
        }
        return new UnlessNode(condition, expressions);
    }

    @Override
    public ASTNode visitCond_expression(MyParser.Cond_expressionContext ctx) {
        List<CondClause> clauses = new ArrayList<>();
        for (MyParser.Cond_clauseContext clauseCtx : ctx.cond_clause()) {
            clauses.add((CondClause) visit(clauseCtx));
        }
        return new CondNode(clauses);
    }

    @Override
    public ASTNode visitCond_clause(MyParser.Cond_clauseContext ctx) {
        ASTNode condition = visit(ctx.condition_clause());
        List<ASTNode> expressions = new ArrayList<>();
        for (int i = 1; i < ctx.expression().size(); i++) {
            expressions.add(visit(ctx.expression(i)));
        }
        return new CondClause(condition, expressions);
    }

    @Override
    public ASTNode visitCons_expression(MyParser.Cons_expressionContext ctx) {
        ASTNode firstExpression = visit(ctx.expression(0));
        ASTNode secondExpression = visit(ctx.expression(1));
        return new ConsNode(firstExpression, secondExpression);
    }

    @Override
    public ASTNode visitCar_expression(MyParser.Car_expressionContext ctx) {
        ConsNode consExpression = (ConsNode) visit(ctx.cons_expression());
        return new CarNode(consExpression);
    }

    @Override
    public ASTNode visitCdr_expression(MyParser.Cdr_expressionContext ctx) {
        ConsNode consExpression = (ConsNode) visit(ctx.cons_expression());
        return new CdrNode(consExpression);
    }

@Override
public ASTNode visitDefstruct_expression(MyParser.Defstruct_expressionContext ctx) {
    List<ASTNode> parameters = new ArrayList<>();
    for (ParseTree child : ctx.children) {
        if (child instanceof TerminalNode terminalNode) {
            if (terminalNode.getSymbol().getType() == MyParser.ATOM) {
                parameters.add(new AtomNode(terminalNode.getText()));
            }
        }
    }
    return new DefStructNode(parameters);
}

    @Override
    public ASTNode visitMake_hash_table_expression(MyParser.Make_hash_table_expressionContext ctx) {
        List<ASTNode> arguments = new ArrayList<>();
        for (ParseTree child : ctx.children) {
            if (child instanceof MyParser.Key_argumentContext ||
                    child instanceof MyParser.Size_functionContext ||
                    child instanceof MyParser.Test_functionContext ||
                    child instanceof MyParser.Hash_functionContext) {
                arguments.add(visit(child));
            }
        }
        return new MakeHashTableNode(arguments);
    }

    @Override
    public ASTNode visitGethash_expression(MyParser.Gethash_expressionContext ctx) {
        ASTNode key = visit(ctx.key());
        AtomNode tableName = new AtomNode(ctx.ATOM().getText());
        return new GetHashNode(key, tableName);
    }

    @Override
    public ASTNode visitRemhash_expression(MyParser.Remhash_expressionContext ctx) {
        ASTNode key = visit(ctx.key());
        AtomNode tableName = new AtomNode(ctx.ATOM().getText());
        return new RemHashNode(key, tableName);
    }

    @Override
    public ASTNode visitClrhash_expression(MyParser.Clrhash_expressionContext ctx) {
        AtomNode tableName = new AtomNode(ctx.ATOM().getText());
        return new ClrHashNode(tableName);
    }

    @Override
    public ASTNode visitMaphash_expression(MyParser.Maphash_expressionContext ctx) {
        LambdaNode function = (LambdaNode) visit(ctx.lambda_expression());
        AtomNode tableName = new AtomNode(ctx.ATOM().getText());
        return new MapHashNode(function, tableName);
    }

    @Override
    public ASTNode visitDefclass_expression(MyParser.Defclass_expressionContext ctx) {
        AtomNode className = new AtomNode(ctx.class_name().ATOM(0).getText());
        List<ASTNode> parameters = new ArrayList<>();
        for (MyParser.ParametersContext paramCtx : ctx.parameters()) {
            parameters.add(visit(paramCtx));
        }
        return new DefClassNode(className, parameters);
    }
}
