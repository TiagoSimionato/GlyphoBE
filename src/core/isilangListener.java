// Generated from isilang.g4 by ANTLR 4.7.1
package src.core;

  import src.ast.Program;
  import src.ast.AbstractCommand;
  import src.symbols.DataType;

  import src.symbols.identifiers.AbstractIdentifier;
  import src.symbols.identifiers.IntegerId;
  import src.symbols.identifiers.RealId;
  import src.symbols.identifiers.BooleanId;

  import src.symbols.IdTable;
  
  import src.exceptions.semanticException;

  import java.util.ArrayList;
  import java.util.List;

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
	 * Enter a parse tree produced by {@link isilangParser#codeblock}.
	 * @param ctx the parse tree
	 */
	void enterCodeblock(isilangParser.CodeblockContext ctx);
	/**
	 * Exit a parse tree produced by {@link isilangParser#codeblock}.
	 * @param ctx the parse tree
	 */
	void exitCodeblock(isilangParser.CodeblockContext ctx);
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
	 * Enter a parse tree produced by {@link isilangParser#cmdDeclare}.
	 * @param ctx the parse tree
	 */
	void enterCmdDeclare(isilangParser.CmdDeclareContext ctx);
	/**
	 * Exit a parse tree produced by {@link isilangParser#cmdDeclare}.
	 * @param ctx the parse tree
	 */
	void exitCmdDeclare(isilangParser.CmdDeclareContext ctx);
	/**
	 * Enter a parse tree produced by {@link isilangParser#cmdDeclare2}.
	 * @param ctx the parse tree
	 */
	void enterCmdDeclare2(isilangParser.CmdDeclare2Context ctx);
	/**
	 * Exit a parse tree produced by {@link isilangParser#cmdDeclare2}.
	 * @param ctx the parse tree
	 */
	void exitCmdDeclare2(isilangParser.CmdDeclare2Context ctx);
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
	 * Enter a parse tree produced by {@link isilangParser#cmdAttr2}.
	 * @param ctx the parse tree
	 */
	void enterCmdAttr2(isilangParser.CmdAttr2Context ctx);
	/**
	 * Exit a parse tree produced by {@link isilangParser#cmdAttr2}.
	 * @param ctx the parse tree
	 */
	void exitCmdAttr2(isilangParser.CmdAttr2Context ctx);
	/**
	 * Enter a parse tree produced by {@link isilangParser#cmdWhile}.
	 * @param ctx the parse tree
	 */
	void enterCmdWhile(isilangParser.CmdWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link isilangParser#cmdWhile}.
	 * @param ctx the parse tree
	 */
	void exitCmdWhile(isilangParser.CmdWhileContext ctx);
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
	 * Enter a parse tree produced by {@link isilangParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(isilangParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link isilangParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(isilangParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link isilangParser#numberExpr}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpr(isilangParser.NumberExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link isilangParser#numberExpr}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpr(isilangParser.NumberExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link isilangParser#numberTerm}.
	 * @param ctx the parse tree
	 */
	void enterNumberTerm(isilangParser.NumberTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link isilangParser#numberTerm}.
	 * @param ctx the parse tree
	 */
	void exitNumberTerm(isilangParser.NumberTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link isilangParser#numberFactor}.
	 * @param ctx the parse tree
	 */
	void enterNumberFactor(isilangParser.NumberFactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link isilangParser#numberFactor}.
	 * @param ctx the parse tree
	 */
	void exitNumberFactor(isilangParser.NumberFactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link isilangParser#realExpr}.
	 * @param ctx the parse tree
	 */
	void enterRealExpr(isilangParser.RealExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link isilangParser#realExpr}.
	 * @param ctx the parse tree
	 */
	void exitRealExpr(isilangParser.RealExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link isilangParser#realTerm}.
	 * @param ctx the parse tree
	 */
	void enterRealTerm(isilangParser.RealTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link isilangParser#realTerm}.
	 * @param ctx the parse tree
	 */
	void exitRealTerm(isilangParser.RealTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link isilangParser#realFactor}.
	 * @param ctx the parse tree
	 */
	void enterRealFactor(isilangParser.RealFactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link isilangParser#realFactor}.
	 * @param ctx the parse tree
	 */
	void exitRealFactor(isilangParser.RealFactorContext ctx);
}