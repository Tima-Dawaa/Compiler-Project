import expression.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ASTBuilder extends MyParserBaseVisitor<ASTNode> {
    private List<String> vars;//store all the variable declared in the program so far
    public List<String> semanticsErrors;

    public ASTBuilder() {
        // TODO Auto-generated constructor stub
        this.vars = new ArrayList<String>();
        this.semanticsErrors = new ArrayList<String>();
    }

    @Override
    public ASTNode visitProgram(MyParser.ProgramContext ctx) {
        // Create a Program node to represent the root of the AST
        Program programNode = new Program();

        // Iterate over all children of the ProgramContext
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);

            // Skip terminal nodes if they're not relevant
            if (child instanceof TerminalNode) {
                System.out.println("Skipping terminal node: " + child.getText());
                continue;
            }
            // Visit the child node and get the corresponding ASTNode
            ASTNode childNode = visit(child);
            // If the visit returns a valid ASTNode, add it to the Program node
            if (childNode != null) {
                programNode.addChild(childNode);
            } else {
                System.out.println("Null ASTNode for child: " + child.getText());
            }
        }
        // Return the constructed Program node
        return programNode;
    }

    @Override
    public ASTNode visitDefining_expressions(MyParser.Defining_expressionsContext ctx) {
        return visit(ctx.getChild(1));
    }

    @Override
    public ASTNode visitSetq_single_var(MyParser.Setq_single_varContext ctx) {
        TupleNode tupleNode = (TupleNode) visit(ctx.tuple_without_paran());
        List<TupleNode> tupleList = new ArrayList<>();
        tupleList.add(tupleNode);
        ASTNode setqNode = (ASTNode) new SetqNode(tupleList);
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
        TupleNode tupleNode = (TupleNode) visit(ctx.tuple_without_paran());
        DefvarNode defvarNode = new DefvarNode(tupleNode);
        return (ASTNode) defvarNode;
    }

    @Override
    public ASTNode visitTuple_without_paran(MyParser.Tuple_without_paranContext ctx) {
        String atomValue = ctx.getChild(0).getText();
        ASTNode expressionNode = visit(ctx.getChild(1));
        return new TupleNode(new AtomNode(atomValue), expressionNode);
    }

    @Override
    public ASTNode visitTuple_with_paran(MyParser.Tuple_with_paranContext ctx) {
        String atomValue = ctx.getChild(0).getText();
        ASTNode expressionNode = visit(ctx.getChild(1));
        return new TupleWithParanNode(new AtomNode(atomValue), expressionNode);
    }

    @Override
    public ASTNode visitDefconstant(MyParser.DefconstantContext ctx) {
        ASTNode tupleNode = visit(ctx.tuple_without_paran());
        ASTNode defconstantNode = (ASTNode) new DefconstantNode((TupleNode) tupleNode);
        return defconstantNode;
    }

    @Override
    public ASTNode visitProg(MyParser.ProgContext ctx) {
        List<AtomNode> atomNodes = ctx.atom()
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
        // Visit the tuple_with_paran elements to collect all tuples
        List<TupleWithParanNode> tupleNodes = ctx.tuple_with_paran()
                .stream()
                .map(node -> (TupleWithParanNode) visit(node))  // Visit each tuple node
                .collect(Collectors.toList());  // Collect them in a List

        // Visit the expression or atom elements, these can either be expressions or atoms
        List<ASTNode> expressionNodes = ctx.expression()
                .stream()
                .map(this::visit)  // Visit each expression node
                .collect(Collectors.toList());

        // Create the LetNode from the collected tuples and expressions
        LetNode letNode = new LetNode(tupleNodes, expressionNodes);

        return letNode;  // Return the constructed LetNode
    }

    @Override
    public ASTNode visitArithmetic_expression(MyParser.Arithmetic_expressionContext ctx) {
        StringNode operation = new StringNode(ctx.getChild(1).getText());
        List<ASTNode> operands = new ArrayList<>();
        for (int i = 2; i < ctx.children.size() - 1; i++) {
            operands.add(visit(ctx.getChild(i)));
        }
        return new ArithmeticOpNode(operation, operands);
    }

    @Override
    public ASTNode visitComparison_expression(MyParser.Comparison_expressionContext ctx) {
        StringNode operation = new StringNode(ctx.getChild(1).getText());
        List<expression.ASTNode> operands = new ArrayList<>();
        for (int i = 2; i < ctx.children.size() - 1; i++) {
            operands.add(visit(ctx.getChild(i)));
        }
        return new ComparisonOpNode(operation, operands);
    }

    @Override public ASTNode visitLogical_expression(MyParser.Logical_expressionContext ctx) {
        return visit(ctx.getChild(1));
    }

    @Override
    public ASTNode visitAnd_or_expression(MyParser.And_or_expressionContext ctx) {
        String operation = ctx.getChild(0).getText();
        List<ASTNode> operands = new ArrayList<>();
        for (int i = 1; i < ctx.children.size(); i++) {
            operands.add(visit(ctx.getChild(i)));
        }
        return new LogicalOpNode(operation, operands);
    }

    @Override
    public ASTNode visitNot_expression(MyParser.Not_expressionContext ctx) {
        String operation = ctx.getChild(0).getText();
        List<ASTNode> operand = new ArrayList<>();
        operand.add(visit(ctx.getChild(1)));
        return new LogicalOpNode(operation, (List<expression.ASTNode>) operand);
    }

    @Override
    public ASTNode visitBitwise_expression(MyParser.Bitwise_expressionContext ctx) {
        String operation = ctx.getChild(1).getText();
        List<expression.ASTNode> operands = new ArrayList<>();
        for (int i = 2; i < ctx.children.size() - 1; i++) {
            operands.add(visit(ctx.getChild(i)));
        }
        return new BitwiseOpNode(operation, operands);
    }

    @Override
    public ASTNode visitEq_expression(MyParser.Eq_expressionContext ctx) {
        StringNode operation = new StringNode(ctx.getChild(1).getText());
        ASTNode operand1 = visit(ctx.getChild(2));
        ASTNode operand2 = visit(ctx.getChild(3));
        System.out.println(operand1);
        System.out.println(operand2);
        return new EqualityOpNode(operation, operand1, operand2);
    }

    @Override
    public ASTNode visitEql_expression(MyParser.Eql_expressionContext ctx) {
        StringNode operation = new StringNode(ctx.getChild(1).getText());
        ASTNode operand1 = visit(ctx.getChild(2));
        ASTNode operand2 = visit(ctx.getChild(3));
        return new EqualityOpNode(operation, operand1, operand2);
    }

    @Override
    public ASTNode visitEqual_expression(MyParser.Equal_expressionContext ctx) {
        StringNode operation = new StringNode(ctx.getChild(1).getText());
        ASTNode operand1 = visit(ctx.getChild(2));
        ASTNode operand2 = visit(ctx.getChild(3));
        return new EqualityOpNode(operation, operand1, operand2);
    }

    @Override
    public ASTNode visitNot_equal_expression(MyParser.Not_equal_expressionContext ctx) {
        StringNode operation = new StringNode(ctx.getChild(1).getText());
        ASTNode operand1 = visit(ctx.getChild(2));
        ASTNode operand2 = visit(ctx.getChild(3));
        return new EqualityOpNode(operation, operand1, operand2);
    }

    @Override
    public ASTNode visitFuncall_expression(MyParser.Funcall_expressionContext ctx) {
        ASTNode funcName = visit(ctx.getChild(2));
        List<expression.ASTNode> funcParameters = new ArrayList<>();
        for (int i = 3; i < ctx.children.size() - 1; i++) {
            funcParameters.add((expression.ASTNode) visit(ctx.getChild(i)));
        }
        return new FuncallNode(funcName, funcParameters);
    }

    @Override
    public ASTNode visitApply_expression(MyParser.Apply_expressionContext ctx) {
        ASTNode funcName = visit(ctx.getChild(2));
        List<ASTNode> funcParameters = new ArrayList<>();
        for (int i = 3; i < ctx.children.size() - 1; i++) {
            funcParameters.add(visit(ctx.getChild(i)));
        }
        return new ApplyNode(funcName, funcParameters);
    }

    @Override
    public ASTNode visitMapcar_expression(MyParser.Mapcar_expressionContext ctx) {
        ASTNode funcName = visit(ctx.getChild(2));
        List<expression.ASTNode> funcParameters = new ArrayList<>();
        for (int i = 3; i < ctx.children.size() - 1; i++) {
            funcParameters.add((expression.ASTNode) visit(ctx.getChild(i)));
        }
        return new ApplyNode(funcName, funcParameters);
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
        BooleanNode formatDestination =  new BooleanNode(ctx.FORMAT_DESTINATION().toString());
        StringNode formatString = new StringNode(ctx.FORMAT_STRING().toString());
        List<ASTNode> expressions = new ArrayList<>();
        for (ParseTree child : ctx.children) {
            if (child instanceof MyParser.ValueContext || child instanceof MyParser.ExpressionContext) {
                ASTNode expression = visit(child);
                expressions.add(expression);
            }
        }
        return new FormatNode(formatDestination, formatString, expressions);
    }

    @Override
    public ASTNode visitPush_expression(MyParser.Push_expressionContext ctx) {
        ASTNode valueNode = visit(ctx.value());

        List<ASTNode> listExpression = new ArrayList<>();
        if (ctx.list_expression() != null) {
            ASTNode listNode = visit(ctx.list_expression());
            listExpression.add(listNode);
        } else if (ctx.atom() != null) {
            listExpression.add(new AtomNode(ctx.atom().getText()));
        }

        return new PushNode(valueNode, listExpression);
    }

    @Override
    public ASTNode visitPop_expression(MyParser.Pop_expressionContext ctx) {
        List<ASTNode> listPop = new ArrayList<>();
        if (ctx.list_expression() != null) {
            ASTNode listNode = visit(ctx.list_expression());
            listPop.add(listNode);
        } else if (ctx.atom() != null) {
            listPop.add(new AtomNode(ctx.atom().getText()));
        }

        return new PopNode(listPop);
    }

    @Override
    public ASTNode visitMake_instance_expression(MyParser.Make_instance_expressionContext ctx) {
        ASTNode atom = new AtomNode(ctx.atom().getText());

        List<MakeInstanceArgumentNode> arguments = new ArrayList<>();
        for (MyParser.Initialization_argumentContext argCtx : ctx.initialization_argument()) {
            arguments.add((MakeInstanceArgumentNode) visit(argCtx));
        }

        return new MakeInstanceNode(atom, arguments);
    }

    @Override
    public ASTNode visitInitialization_argument(MyParser.Initialization_argumentContext ctx) {
        ASTNode colon = new AtomNode(ctx.COLON().getText());
        ASTNode atom = new AtomNode(ctx.atom().getText());
        ASTNode value = visit(ctx.value());

        return new MakeInstanceArgumentNode(atom, colon, value);
    }

//    @Override
//    public ASTNode visitDefun_expression(MyParser.Defun_expressionContext ctx) {
//        AtomNode atom = new AtomNode(ctx.atom().getText());
//
//        List<ASTNode> listParameters = new ArrayList<>();
//        if (ctx.parameter_list() != null) {
//            for (TerminalNode param : ctx.parameter_list().atom()) {
//                listParameters.add(new AtomNode(param.getText()));
//            }
//        }
//
//        List<ASTNode> listBody = new ArrayList<>();
//        if (ctx.defun_body() != null) {
//            for (MyParser.ExpressionContext exprCtx : ctx.defun_body().expression()) {
//                listBody.add(visit(exprCtx));
//            }
//        }
//
//        return new DefunNode(atom, listParameters, listBody);
//    }

    @Override
    public ASTNode visitAref_expression(MyParser.Aref_expressionContext ctx) {
        ASTNode atomNode = visit(ctx.atom(0));

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
        AtomNode tableName = new AtomNode(ctx.atom().getText());
        return new GetHashNode(key, tableName);
    }

    @Override
    public ASTNode visitRemhash_expression(MyParser.Remhash_expressionContext ctx) {
        ASTNode key = visit(ctx.key());
        AtomNode tableName = new AtomNode(ctx.atom().getText());
        return new RemHashNode(key, tableName);
    }

    @Override
    public ASTNode visitClrhash_expression(MyParser.Clrhash_expressionContext ctx) {
        AtomNode tableName = new AtomNode(ctx.atom().getText());
        return new ClrHashNode(tableName);
    }

    @Override
    public ASTNode visitMaphash_expression(MyParser.Maphash_expressionContext ctx) {
        LambdaNode function = (LambdaNode) visit(ctx.lambda_expression());
        AtomNode tableName = new AtomNode(ctx.atom().getText());
        return new MapHashNode(function, tableName);
    }

    @Override
    public ASTNode visitDefclass_expression(MyParser.Defclass_expressionContext ctx) {
        AtomNode className = new AtomNode(ctx.class_name().atom(0).getText());
        List<ASTNode> parameters = new ArrayList<>();
        for (MyParser.ParametersContext paramCtx : ctx.parameters()) {
            parameters.add(visit(paramCtx));
        }
        return new DefClassNode(className, parameters);
    }

   @Override
   public ASTNode visitLoop_simple(MyParser.Loop_simpleContext ctx) {
       List<ASTNode> loopBody = new ArrayList<>();

       if (ctx.loop_body() != null) {
           for (int i = 0; i < ctx.loop_body().expression().size(); i++) {
               ASTNode node = visit(ctx.loop_body().expression(i));
               loopBody.add(node);
           }
       }
       return new LoopSimpleNode(loopBody);
   }

    @Override
    public ASTNode visitLoop_for(MyParser.Loop_forContext ctx) {
        ASTNode variable = visit(ctx.variable());
        ASTNode initValue = visit(ctx.from_to_clause().init_value());
        ASTNode limitValue = visit(ctx.from_to_clause().limit_value());

        List<ASTNode> loopBody = new ArrayList<>();

        if (ctx.loop_body() != null) {
            for (int i = 0; i < ctx.loop_body().expression().size(); i++) {
                ASTNode node = visit(ctx.loop_body().expression(i));
                loopBody.add(node);
            }
        }
        return new LoopForNode(variable, initValue, limitValue, loopBody);
    }


    @Override
    public ASTNode visitDo_expression(MyParser.Do_expressionContext ctx) {
        List<VariableDefinitionNode> variableDefinitions = new ArrayList<>();
        for (int i = 0; i < ctx.variable_definitions().getChildCount(); i++) {
            MyParser.Variable_definitionsContext varDefCtx = ctx.variable_definitions();

            ASTNode variable = visit((ParseTree) varDefCtx.variable());

            ASTNode initValue = null;
            if (varDefCtx.init_value() != null) {
                initValue = visit((ParseTree) varDefCtx.init_value());
            }

            ASTNode stepValue = null;
            if (varDefCtx.step_value() != null) {
                stepValue = visit((ParseTree) varDefCtx.step_value());
            }

            VariableDefinitionNode varDefNode = new VariableDefinitionNode(variable, initValue, stepValue);
            variableDefinitions.add(varDefNode);
        }

        ASTNode condition = visit(ctx.condition_clause());

        List<ASTNode> loopBody = new ArrayList<>();
        if (ctx.loop_body() != null) {
            for (int i = 0; i < ctx.loop_body().expression().size(); i++) {
                ASTNode bodyNode = visit(ctx.loop_body().expression(i));
                loopBody.add(bodyNode);
            }
        }

        return new DoExpressionNode(variableDefinitions, condition, loopBody);
    }

    @Override
    public ASTNode visitDotimes_expression(MyParser.Dotimes_expressionContext ctx) {
        ASTNode variable = visit(ctx.variable());

        ASTNode loopCount = visit(ctx.real_number());

        List<ASTNode> loopBody = new ArrayList<>();
        if (ctx.loop_body() != null) {
            for (int i = 0; i < ctx.loop_body().expression().size(); i++) {
                ASTNode bodyNode = visit(ctx.loop_body().expression(i));
                loopBody.add(bodyNode);
            }
        }
        return new DotimesNode(variable, loopCount, loopBody);
    }

    @Override
    public ASTNode visitDolist_expression(MyParser.Dolist_expressionContext ctx) {
        ASTNode variable = visit(ctx.variable());

        ASTNode listExpression = visit(ctx.list_expression());

        List<ASTNode> loopBody = new ArrayList<>();
        if (ctx.loop_body() != null) {
            // Visit each expression in the loop body
            for (int i = 0; i < ctx.loop_body().expression().size(); i++) {
                ASTNode bodyNode = visit(ctx.loop_body().expression(i));
                loopBody.add(bodyNode);
            }
        }
        return new DolistNode(variable, listExpression, loopBody);
    }

    @Override public ASTNode visitReal_number(MyParser.Real_numberContext ctx) {
        return new RealNumberNode(ctx.getChild(0).getText());
    }

    @Override public ASTNode visitAtom(MyParser.AtomContext ctx) {
        return new AtomNode(ctx.ATOM().getText());
    }

    @Override public ASTNode visitString(MyParser.StringContext ctx) {
        return new StringNode(ctx.STRING().getText());
    }

    @Override public ASTNode visitInt_number(MyParser.Int_numberContext ctx) {
        return new IntNumberNode(Integer.parseInt(ctx.INT_NUMBER().getText()));
    }

    @Override public ASTNode visitFloat_number(MyParser.Float_numberContext ctx) {
        return new FloatNumberNode(Float.parseFloat(ctx.FLOAT_NUMBER().getText()));
    }

    @Override public ASTNode visitE_number(MyParser.E_numberContext ctx) {
        return new ENumberNode(ctx.E_NUMBER().getText());
    }

    @Override public ASTNode visitT(MyParser.TContext ctx) {
        return new TNode(ctx.T().getText());
    }

    @Override public ASTNode visitNil(MyParser.NilContext ctx) {
        return new NILNode(ctx.NIL().getText());
    }

    @Override public ASTNode visitSingle_quote_expression(MyParser.Single_quote_expressionContext ctx) {
        ASTNode value = visit(ctx.getChild(1));
        return new SingleQuoteNode(value);
    }
}
