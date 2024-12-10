// Generated from C:/Users/lenovo/IdeaProjects/CompilerProject/src/MyParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MyParser}.
 */
public interface MyParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MyParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MyParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MyParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MyParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MyParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#operators_expression}.
	 * @param ctx the parse tree
	 */
	void enterOperators_expression(MyParser.Operators_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#operators_expression}.
	 * @param ctx the parse tree
	 */
	void exitOperators_expression(MyParser.Operators_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#arithmetic_expression}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic_expression(MyParser.Arithmetic_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#arithmetic_expression}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic_expression(MyParser.Arithmetic_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#comparison_expression}.
	 * @param ctx the parse tree
	 */
	void enterComparison_expression(MyParser.Comparison_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#comparison_expression}.
	 * @param ctx the parse tree
	 */
	void exitComparison_expression(MyParser.Comparison_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#logical_expression}.
	 * @param ctx the parse tree
	 */
	void enterLogical_expression(MyParser.Logical_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#logical_expression}.
	 * @param ctx the parse tree
	 */
	void exitLogical_expression(MyParser.Logical_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#and_or_expression}.
	 * @param ctx the parse tree
	 */
	void enterAnd_or_expression(MyParser.And_or_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#and_or_expression}.
	 * @param ctx the parse tree
	 */
	void exitAnd_or_expression(MyParser.And_or_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#not_expression}.
	 * @param ctx the parse tree
	 */
	void enterNot_expression(MyParser.Not_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#not_expression}.
	 * @param ctx the parse tree
	 */
	void exitNot_expression(MyParser.Not_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#bitwise_expression}.
	 * @param ctx the parse tree
	 */
	void enterBitwise_expression(MyParser.Bitwise_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#bitwise_expression}.
	 * @param ctx the parse tree
	 */
	void exitBitwise_expression(MyParser.Bitwise_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#defining_expressions}.
	 * @param ctx the parse tree
	 */
	void enterDefining_expressions(MyParser.Defining_expressionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#defining_expressions}.
	 * @param ctx the parse tree
	 */
	void exitDefining_expressions(MyParser.Defining_expressionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#defvar}.
	 * @param ctx the parse tree
	 */
	void enterDefvar(MyParser.DefvarContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#defvar}.
	 * @param ctx the parse tree
	 */
	void exitDefvar(MyParser.DefvarContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#setq_single_var}.
	 * @param ctx the parse tree
	 */
	void enterSetq_single_var(MyParser.Setq_single_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#setq_single_var}.
	 * @param ctx the parse tree
	 */
	void exitSetq_single_var(MyParser.Setq_single_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#setq_multi_var}.
	 * @param ctx the parse tree
	 */
	void enterSetq_multi_var(MyParser.Setq_multi_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#setq_multi_var}.
	 * @param ctx the parse tree
	 */
	void exitSetq_multi_var(MyParser.Setq_multi_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(MyParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(MyParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#let}.
	 * @param ctx the parse tree
	 */
	void enterLet(MyParser.LetContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#let}.
	 * @param ctx the parse tree
	 */
	void exitLet(MyParser.LetContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#defconstant}.
	 * @param ctx the parse tree
	 */
	void enterDefconstant(MyParser.DefconstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#defconstant}.
	 * @param ctx the parse tree
	 */
	void exitDefconstant(MyParser.DefconstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#tuple_with_paran}.
	 * @param ctx the parse tree
	 */
	void enterTuple_with_paran(MyParser.Tuple_with_paranContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#tuple_with_paran}.
	 * @param ctx the parse tree
	 */
	void exitTuple_with_paran(MyParser.Tuple_with_paranContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#tuple_without_paran}.
	 * @param ctx the parse tree
	 */
	void enterTuple_without_paran(MyParser.Tuple_without_paranContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#tuple_without_paran}.
	 * @param ctx the parse tree
	 */
	void exitTuple_without_paran(MyParser.Tuple_without_paranContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#real_number}.
	 * @param ctx the parse tree
	 */
	void enterReal_number(MyParser.Real_numberContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#real_number}.
	 * @param ctx the parse tree
	 */
	void exitReal_number(MyParser.Real_numberContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#setf_expression}.
	 * @param ctx the parse tree
	 */
	void enterSetf_expression(MyParser.Setf_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#setf_expression}.
	 * @param ctx the parse tree
	 */
	void exitSetf_expression(MyParser.Setf_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#place}.
	 * @param ctx the parse tree
	 */
	void enterPlace(MyParser.PlaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#place}.
	 * @param ctx the parse tree
	 */
	void exitPlace(MyParser.PlaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(MyParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(MyParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#make_array_expression}.
	 * @param ctx the parse tree
	 */
	void enterMake_array_expression(MyParser.Make_array_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#make_array_expression}.
	 * @param ctx the parse tree
	 */
	void exitMake_array_expression(MyParser.Make_array_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#aref_expression}.
	 * @param ctx the parse tree
	 */
	void enterAref_expression(MyParser.Aref_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#aref_expression}.
	 * @param ctx the parse tree
	 */
	void exitAref_expression(MyParser.Aref_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#list_expression}.
	 * @param ctx the parse tree
	 */
	void enterList_expression(MyParser.List_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#list_expression}.
	 * @param ctx the parse tree
	 */
	void exitList_expression(MyParser.List_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#index_list}.
	 * @param ctx the parse tree
	 */
	void enterIndex_list(MyParser.Index_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#index_list}.
	 * @param ctx the parse tree
	 */
	void exitIndex_list(MyParser.Index_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#push_expression}.
	 * @param ctx the parse tree
	 */
	void enterPush_expression(MyParser.Push_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#push_expression}.
	 * @param ctx the parse tree
	 */
	void exitPush_expression(MyParser.Push_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#pop_expression}.
	 * @param ctx the parse tree
	 */
	void enterPop_expression(MyParser.Pop_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#pop_expression}.
	 * @param ctx the parse tree
	 */
	void exitPop_expression(MyParser.Pop_expressionContext ctx);
}