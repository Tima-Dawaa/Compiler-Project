// Generated from C:/Users/VISION/IdeaProjects/Compiler-Project/src/MyParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MyParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MyParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MyParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MyParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MyParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#operators_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperators_expression(MyParser.Operators_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#arithmetic_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmetic_expression(MyParser.Arithmetic_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#comparison_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison_expression(MyParser.Comparison_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#logical_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical_expression(MyParser.Logical_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#and_or_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd_or_expression(MyParser.And_or_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#not_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot_expression(MyParser.Not_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#bitwise_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwise_expression(MyParser.Bitwise_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#equality_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality_expression(MyParser.Equality_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#eq_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEq_expression(MyParser.Eq_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#eql_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEql_expression(MyParser.Eql_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#equal_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqual_expression(MyParser.Equal_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#not_equal_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot_equal_expression(MyParser.Not_equal_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#defining_expressions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefining_expressions(MyParser.Defining_expressionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#defvar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefvar(MyParser.DefvarContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#setq_single_var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetq_single_var(MyParser.Setq_single_varContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#setq_multi_var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetq_multi_var(MyParser.Setq_multi_varContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(MyParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#let}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet(MyParser.LetContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#defconstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefconstant(MyParser.DefconstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#tuple_with_paran}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTuple_with_paran(MyParser.Tuple_with_paranContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#tuple_without_paran}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTuple_without_paran(MyParser.Tuple_without_paranContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#real_number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReal_number(MyParser.Real_numberContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#setf_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetf_expression(MyParser.Setf_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#place}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlace(MyParser.PlaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(MyParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#make_array_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMake_array_expression(MyParser.Make_array_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#index_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex_list(MyParser.Index_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#aref_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAref_expression(MyParser.Aref_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#list_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_expression(MyParser.List_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#push_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPush_expression(MyParser.Push_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#pop_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPop_expression(MyParser.Pop_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#condition_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition_expression(MyParser.Condition_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#condition_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition_clause(MyParser.Condition_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#if_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_expression(MyParser.If_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#when_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhen_expression(MyParser.When_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#cond_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond_expression(MyParser.Cond_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#cond_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond_clause(MyParser.Cond_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#progn_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgn_expression(MyParser.Progn_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#otherwise_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOtherwise_expression(MyParser.Otherwise_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#unless_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnless_expression(MyParser.Unless_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#conses_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConses_expression(MyParser.Conses_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#cons_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCons_expression(MyParser.Cons_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#car_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCar_expression(MyParser.Car_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#cdr_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCdr_expression(MyParser.Cdr_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#special_form_expressions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecial_form_expressions(MyParser.Special_form_expressionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#quote_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuote_expression(MyParser.Quote_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#single_quote_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingle_quote_expression(MyParser.Single_quote_expressionContext ctx);
}