// Generated from C:/Users/lenovo/IdeaProjects/CompilerProject/src/MyParser.g4 by ANTLR 4.13.2
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
	 * Visit a parse tree produced by {@link MyParser#index_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex_list(MyParser.Index_listContext ctx);
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
}