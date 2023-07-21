// Generated from isilang.g4 by ANTLR 4.7.1
package src.core;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link isilangParser}.
 */
public interface isilangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link isilangParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(isilangParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link isilangParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(isilangParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link isilangParser#declare}.
	 * @param ctx the parse tree
	 */
	void enterDeclare(isilangParser.DeclareContext ctx);
	/**
	 * Exit a parse tree produced by {@link isilangParser#declare}.
	 * @param ctx the parse tree
	 */
	void exitDeclare(isilangParser.DeclareContext ctx);
	/**
	 * Enter a parse tree produced by {@link isilangParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(isilangParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link isilangParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(isilangParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link isilangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(isilangParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link isilangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(isilangParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link isilangParser#lista_var}.
	 * @param ctx the parse tree
	 */
	void enterLista_var(isilangParser.Lista_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link isilangParser#lista_var}.
	 * @param ctx the parse tree
	 */
	void exitLista_var(isilangParser.Lista_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link isilangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(isilangParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link isilangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(isilangParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link isilangParser#cmdRead}.
	 * @param ctx the parse tree
	 */
	void enterCmdRead(isilangParser.CmdReadContext ctx);
	/**
	 * Exit a parse tree produced by {@link isilangParser#cmdRead}.
	 * @param ctx the parse tree
	 */
	void exitCmdRead(isilangParser.CmdReadContext ctx);
	/**
	 * Enter a parse tree produced by {@link isilangParser#cmdWrite}.
	 * @param ctx the parse tree
	 */
	void enterCmdWrite(isilangParser.CmdWriteContext ctx);
	/**
	 * Exit a parse tree produced by {@link isilangParser#cmdWrite}.
	 * @param ctx the parse tree
	 */
	void exitCmdWrite(isilangParser.CmdWriteContext ctx);
	/**
	 * Enter a parse tree produced by {@link isilangParser#cmdIf}.
	 * @param ctx the parse tree
	 */
	void enterCmdIf(isilangParser.CmdIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link isilangParser#cmdIf}.
	 * @param ctx the parse tree
	 */
	void exitCmdIf(isilangParser.CmdIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link isilangParser#cmdAttr}.
	 * @param ctx the parse tree
	 */
	void enterCmdAttr(isilangParser.CmdAttrContext ctx);
	/**
	 * Exit a parse tree produced by {@link isilangParser#cmdAttr}.
	 * @param ctx the parse tree
	 */
	void exitCmdAttr(isilangParser.CmdAttrContext ctx);
	/**
	 * Enter a parse tree produced by {@link isilangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(isilangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link isilangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(isilangParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link isilangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(isilangParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link isilangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(isilangParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link isilangParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(isilangParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link isilangParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(isilangParser.FactorContext ctx);
}