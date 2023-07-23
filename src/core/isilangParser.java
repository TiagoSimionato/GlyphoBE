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
  import java.util.HashMap;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class isilangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, TYPE=11, NUMBER=12, REAL=13, BOOLEAN=14, TEXT=15, ATTR=16, SUM=17, 
		SUB=18, MUL=19, DIV=20, RELOP=21, ID=22, COMMA=23, FP=24, OP=25, CP=26, 
		OB=27, CB=28, BLANK=29;
	public static final int
		RULE_program = 0, RULE_block = 1, RULE_codeblock = 2, RULE_cmd = 3, RULE_cmdDeclare = 4, 
		RULE_cmdDeclare2 = 5, RULE_cmdRead = 6, RULE_cmdWrite = 7, RULE_cmdIf = 8, 
		RULE_cmdAttr = 9, RULE_cmdAttr2 = 10, RULE_cmdWhile = 11, RULE_expr = 12, 
		RULE_term = 13, RULE_factor = 14, RULE_boolExpr = 15;
	public static final String[] ruleNames = {
		"program", "block", "codeblock", "cmd", "cmdDeclare", "cmdDeclare2", "cmdRead", 
		"cmdWrite", "cmdIf", "cmdAttr", "cmdAttr2", "cmdWhile", "expr", "term", 
		"factor", "boolExpr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programa'", "'fimprog'", "'declare'", "'leia'", "'escreva'", "'se'", 
		"'entao'", "'ou se'", "'senao'", "'enquanto'", null, null, null, null, 
		null, "':='", "'+'", "'-'", "'*'", "'/'", null, null, "','", "'.'", "'('", 
		"')'", "'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "TYPE", 
		"NUMBER", "REAL", "BOOLEAN", "TEXT", "ATTR", "SUM", "SUB", "MUL", "DIV", 
		"RELOP", "ID", "COMMA", "FP", "OP", "CP", "OB", "CB", "BLANK"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "isilang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	  //Geração codigo
	  private Program program = new Program();
	  private List<AbstractCommand> mainThread = new ArrayList<AbstractCommand>();

	  //Analise semantica
	  private IdTable st = new IdTable();
	  private HashMap<String,Token> declaredOnly = new HashMap<String,Token>();
	  public static DataType currentType;
	  public static DataType currentExprType;
	  private AbstractIdentifier currentId;
	  private String idName;
	  private boolean isExprEvaluating = false;

	  public void isIdDeclared(String idName, int line) {
	    if (!st.exists(idName)) {
	      throw new semanticException("At line " + line + ", identifier [" + idName + "] not declared");
	    }
	  }

	  public void idHaveValue(String idName, int line) {
	    if (st.get(idName).getValue() == null) {
	      throw new semanticException("At line " + line + ", identifier [" + idName + "] value was used but never assigned");
	    }
	  }

	  public void exprTypeCheck(DataType type, int line) {
	    if (!isExprEvaluating) {
	      isExprEvaluating = true;
	      currentExprType = type;
	    } else {
	      if (type != currentExprType) {
	        throw new semanticException("At line " + line + ", expression type missmatch. Expecting " + currentExprType + " but found " + type);
	      }
	    }
	  }

	  public void endExprEval(DataType expectedType, int line) {
	    if (currentExprType != expectedType) {
	      throw new semanticException("At line " + line + ", expression type should be " + expectedType + " but found " + currentExprType);
	    }
	    isExprEvaluating = false;
	  }

	public isilangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode FP() { return getToken(isilangParser.FP, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(T__0);
			setState(33);
			block();
			setState(34);
			match(T__1);
			setState(35);
			match(FP);

			    if (declaredOnly.size() > 0) {
			      throw new semanticException("There are identifiers declared but not used starting at line " + declaredOnly.entrySet().iterator().next().getValue().getLine());
			    }
			  
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CodeblockContext codeblock() {
			return getRuleContext(CodeblockContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			setState(45);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__9) | (1L << ID) | (1L << FP))) != 0)) {
					{
					{
					setState(38);
					cmd();
					}
					}
					setState(43);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				codeblock();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CodeblockContext extends ParserRuleContext {
		public TerminalNode OB() { return getToken(isilangParser.OB, 0); }
		public TerminalNode CB() { return getToken(isilangParser.CB, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CodeblockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_codeblock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).enterCodeblock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).exitCodeblock(this);
		}
	}

	public final CodeblockContext codeblock() throws RecognitionException {
		CodeblockContext _localctx = new CodeblockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_codeblock);
		int _la;
		try {
			setState(56);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OB:
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				match(OB);
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__9) | (1L << ID) | (1L << FP))) != 0)) {
					{
					{
					setState(48);
					cmd();
					}
					}
					setState(53);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(54);
				match(CB);
				}
				break;
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case T__9:
			case ID:
			case FP:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				cmd();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdContext extends ParserRuleContext {
		public CmdDeclareContext cmdDeclare() {
			return getRuleContext(CmdDeclareContext.class,0);
		}
		public TerminalNode FP() { return getToken(isilangParser.FP, 0); }
		public CmdReadContext cmdRead() {
			return getRuleContext(CmdReadContext.class,0);
		}
		public CmdWriteContext cmdWrite() {
			return getRuleContext(CmdWriteContext.class,0);
		}
		public CmdAttrContext cmdAttr() {
			return getRuleContext(CmdAttrContext.class,0);
		}
		public CmdIfContext cmdIf() {
			return getRuleContext(CmdIfContext.class,0);
		}
		public CmdWhileContext cmdWhile() {
			return getRuleContext(CmdWhileContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_cmd);
		try {
			setState(73);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				cmdDeclare();
				setState(59);
				match(FP);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				cmdRead();
				setState(62);
				match(FP);
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
				cmdWrite();
				setState(65);
				match(FP);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(67);
				cmdAttr();
				setState(68);
				match(FP);
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 5);
				{
				setState(70);
				cmdIf();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 6);
				{
				setState(71);
				cmdWhile();
				}
				break;
			case FP:
				enterOuterAlt(_localctx, 7);
				{
				setState(72);
				match(FP);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdDeclareContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(isilangParser.TYPE, 0); }
		public List<CmdDeclare2Context> cmdDeclare2() {
			return getRuleContexts(CmdDeclare2Context.class);
		}
		public CmdDeclare2Context cmdDeclare2(int i) {
			return getRuleContext(CmdDeclare2Context.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(isilangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(isilangParser.COMMA, i);
		}
		public CmdDeclareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdDeclare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).enterCmdDeclare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).exitCmdDeclare(this);
		}
	}

	public final CmdDeclareContext cmdDeclare() throws RecognitionException {
		CmdDeclareContext _localctx = new CmdDeclareContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_cmdDeclare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(T__2);
			setState(76);
			match(TYPE);
			setState(77);
			cmdDeclare2();
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(78);
				match(COMMA);
				setState(79);
				cmdDeclare2();
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdDeclare2Context extends ParserRuleContext {
		public TerminalNode ID() { return getToken(isilangParser.ID, 0); }
		public CmdAttr2Context cmdAttr2() {
			return getRuleContext(CmdAttr2Context.class,0);
		}
		public CmdDeclare2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdDeclare2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).enterCmdDeclare2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).exitCmdDeclare2(this);
		}
	}

	public final CmdDeclare2Context cmdDeclare2() throws RecognitionException {
		CmdDeclare2Context _localctx = new CmdDeclare2Context(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmdDeclare2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(ID);

			    idName = _input.LT(-1).getText();
			    if (!st.exists(idName)) {
			      if (currentType == DataType.INTEGER) {
			        st.add(idName, new IntegerId(idName));
			        declaredOnly.put(idName,_input.LT(-1));
			      }
			      else if (currentType == DataType.BOOLEAN) {
			        st.add(idName, new BooleanId(idName));
			        declaredOnly.put(idName,_input.LT(-1));
			      }
			      else if (currentType == DataType.REAL) {
			        st.add(idName, new RealId(idName));
			        declaredOnly.put(idName,_input.LT(-1));
			      }
			      else {
			        throw new semanticException("At line " + _ctx.getStart().getLine() + ", unexpected Type Declared");
			      }
			    } else {
			      throw new semanticException("At line " + _ctx.getStart().getLine() + ", identifier " + idName + " already declared");
			    }
			    currentId = st.get(idName);
			  
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ATTR) {
				{
				setState(87);
				cmdAttr2();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdReadContext extends ParserRuleContext {
		public TerminalNode OP() { return getToken(isilangParser.OP, 0); }
		public TerminalNode ID() { return getToken(isilangParser.ID, 0); }
		public TerminalNode CP() { return getToken(isilangParser.CP, 0); }
		public CmdReadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdRead; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).enterCmdRead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).exitCmdRead(this);
		}
	}

	public final CmdReadContext cmdRead() throws RecognitionException {
		CmdReadContext _localctx = new CmdReadContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdRead);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(T__3);
			setState(91);
			match(OP);
			setState(92);
			match(ID);

			    idName = _input.LT(-1).getText();
			    isIdDeclared(idName, _input.LT(-1).getLine());
			    idHaveValue(idName, _input.LT(-1).getLine());
			    declaredOnly.remove(idName);
			  
			setState(94);
			match(CP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdWriteContext extends ParserRuleContext {
		public TerminalNode OP() { return getToken(isilangParser.OP, 0); }
		public TerminalNode CP() { return getToken(isilangParser.CP, 0); }
		public TerminalNode TEXT() { return getToken(isilangParser.TEXT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CmdWriteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdWrite; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).enterCmdWrite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).exitCmdWrite(this);
		}
	}

	public final CmdWriteContext cmdWrite() throws RecognitionException {
		CmdWriteContext _localctx = new CmdWriteContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdWrite);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(T__4);
			setState(97);
			match(OP);
			setState(102);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEXT:
				{
				setState(98);
				match(TEXT);
				}
				break;
			case NUMBER:
			case REAL:
			case BOOLEAN:
			case ID:
			case OP:
				{
				setState(99);
				expr();

				    endExprEval(currentExprType, _ctx.getStart().getLine());
				  
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(104);
			match(CP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdIfContext extends ParserRuleContext {
		public List<TerminalNode> OP() { return getTokens(isilangParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(isilangParser.OP, i);
		}
		public List<BoolExprContext> boolExpr() {
			return getRuleContexts(BoolExprContext.class);
		}
		public BoolExprContext boolExpr(int i) {
			return getRuleContext(BoolExprContext.class,i);
		}
		public List<TerminalNode> CP() { return getTokens(isilangParser.CP); }
		public TerminalNode CP(int i) {
			return getToken(isilangParser.CP, i);
		}
		public List<CodeblockContext> codeblock() {
			return getRuleContexts(CodeblockContext.class);
		}
		public CodeblockContext codeblock(int i) {
			return getRuleContext(CodeblockContext.class,i);
		}
		public CmdIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).enterCmdIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).exitCmdIf(this);
		}
	}

	public final CmdIfContext cmdIf() throws RecognitionException {
		CmdIfContext _localctx = new CmdIfContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdIf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(T__5);
			setState(107);
			match(OP);
			setState(108);
			boolExpr();
			setState(109);
			match(CP);
			setState(110);
			match(T__6);
			setState(111);
			codeblock();
			setState(119);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(112);
				match(T__7);
				setState(113);
				match(OP);
				setState(114);
				boolExpr();
				setState(115);
				match(CP);
				setState(116);
				match(T__6);
				setState(117);
				codeblock();
				}
				break;
			}
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(121);
				match(T__8);
				setState(122);
				codeblock();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdAttrContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(isilangParser.ID, 0); }
		public CmdAttr2Context cmdAttr2() {
			return getRuleContext(CmdAttr2Context.class,0);
		}
		public CmdAttrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdAttr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).enterCmdAttr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).exitCmdAttr(this);
		}
	}

	public final CmdAttrContext cmdAttr() throws RecognitionException {
		CmdAttrContext _localctx = new CmdAttrContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdAttr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(ID);

			    idName = _input.LT(-1).getText();
			    isIdDeclared(idName, _input.LT(-1).getLine());
			    currentId = st.get(idName);
			  
			setState(127);
			cmdAttr2();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdAttr2Context extends ParserRuleContext {
		public TerminalNode ATTR() { return getToken(isilangParser.ATTR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CmdAttr2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdAttr2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).enterCmdAttr2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).exitCmdAttr2(this);
		}
	}

	public final CmdAttr2Context cmdAttr2() throws RecognitionException {
		CmdAttr2Context _localctx = new CmdAttr2Context(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmdAttr2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(ATTR);
			setState(130);
			expr();

			    endExprEval(currentId.getType(), _ctx.getStart().getLine());
			    declaredOnly.remove(currentId.getName());
			    if (currentId.getType() == DataType.INTEGER) {
			      currentId.setValue(1);
			    } else if (currentId.getType() == DataType.BOOLEAN) {
			      currentId.setValue(true);
			    } else {
			      currentId.setValue(1.0d);
			    }
			  
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdWhileContext extends ParserRuleContext {
		public TerminalNode OP() { return getToken(isilangParser.OP, 0); }
		public BoolExprContext boolExpr() {
			return getRuleContext(BoolExprContext.class,0);
		}
		public TerminalNode CP() { return getToken(isilangParser.CP, 0); }
		public CodeblockContext codeblock() {
			return getRuleContext(CodeblockContext.class,0);
		}
		public CmdWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdWhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).enterCmdWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).exitCmdWhile(this);
		}
	}

	public final CmdWhileContext cmdWhile() throws RecognitionException {
		CmdWhileContext _localctx = new CmdWhileContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cmdWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(T__9);
			setState(134);
			match(OP);
			setState(135);
			boolExpr();
			setState(136);
			match(CP);
			setState(137);
			codeblock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode SUM() { return getToken(isilangParser.SUM, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SUB() { return getToken(isilangParser.SUB, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expr);
		try {
			setState(148);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(139);
				term();
				setState(140);
				match(SUM);
				setState(141);
				expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(143);
				term();
				setState(144);
				match(SUB);
				setState(145);
				expr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(147);
				term();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode MUL() { return getToken(isilangParser.MUL, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode DIV() { return getToken(isilangParser.DIV, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_term);
		try {
			setState(159);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				factor();
				setState(151);
				match(MUL);
				setState(152);
				term();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
				factor();
				setState(155);
				match(DIV);
				setState(156);
				term();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(158);
				factor();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(isilangParser.NUMBER, 0); }
		public TerminalNode REAL() { return getToken(isilangParser.REAL, 0); }
		public TerminalNode BOOLEAN() { return getToken(isilangParser.BOOLEAN, 0); }
		public TerminalNode ID() { return getToken(isilangParser.ID, 0); }
		public TerminalNode OP() { return getToken(isilangParser.OP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CP() { return getToken(isilangParser.CP, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_factor);
		try {
			setState(173);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(161);
				match(NUMBER);

				    exprTypeCheck(DataType.INTEGER, _ctx.getStart().getLine());
				  
				}
				break;
			case REAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				match(REAL);

				    exprTypeCheck(DataType.REAL, _ctx.getStart().getLine());
				  
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 3);
				{
				setState(165);
				match(BOOLEAN);

				    exprTypeCheck(DataType.BOOLEAN, _ctx.getStart().getLine());
				  
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(167);
				match(ID);

				    idName = _input.LT(-1).getText();
				    isIdDeclared(idName, _input.LT(-1).getLine());
				    idHaveValue(idName, _input.LT(-1).getLine());
				    declaredOnly.remove(idName);
				    exprTypeCheck(st.get(idName).getType(), _ctx.getStart().getLine());
				  
				}
				break;
			case OP:
				enterOuterAlt(_localctx, 5);
				{
				setState(169);
				match(OP);
				setState(170);
				expr();
				setState(171);
				match(CP);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolExprContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(isilangParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RELOP() { return getToken(isilangParser.RELOP, 0); }
		public BoolExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).enterBoolExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).exitBoolExpr(this);
		}
	}

	public final BoolExprContext boolExpr() throws RecognitionException {
		BoolExprContext _localctx = new BoolExprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_boolExpr);
		try {
			setState(182);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				match(ID);

				    idName = _input.LT(-1).getText();
				    isIdDeclared(idName, _input.LT(-1).getLine());
				    idHaveValue(idName, _input.LT(-1).getLine());
				    if (st.get(idName).getType() != DataType.BOOLEAN) {
				      throw new semanticException("Identifier should have BOOLEAN type");
				    }
				    declaredOnly.remove(idName);
				  
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				expr();
				setState(178);
				match(RELOP);
				setState(179);
				expr();

				    endExprEval(currentExprType, _ctx.getStart().getLine());
				  
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\37\u00bb\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\3\7\3*\n\3\f\3\16\3-\13\3\3\3\5\3\60\n\3\3\4\3\4\7"+
		"\4\64\n\4\f\4\16\4\67\13\4\3\4\3\4\5\4;\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5L\n\5\3\6\3\6\3\6\3\6\3\6\7\6S\n"+
		"\6\f\6\16\6V\13\6\3\7\3\7\3\7\5\7[\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\5\ti\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\5\nz\n\n\3\n\3\n\5\n~\n\n\3\13\3\13\3\13\3\13\3\f\3\f"+
		"\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\5\16\u0097\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\5\17\u00a2\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\5\20\u00b0\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00b9\n"+
		"\21\3\21\2\2\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\2\2\u00c2\2"+
		"\"\3\2\2\2\4/\3\2\2\2\6:\3\2\2\2\bK\3\2\2\2\nM\3\2\2\2\fW\3\2\2\2\16\\"+
		"\3\2\2\2\20b\3\2\2\2\22l\3\2\2\2\24\177\3\2\2\2\26\u0083\3\2\2\2\30\u0087"+
		"\3\2\2\2\32\u0096\3\2\2\2\34\u00a1\3\2\2\2\36\u00af\3\2\2\2 \u00b8\3\2"+
		"\2\2\"#\7\3\2\2#$\5\4\3\2$%\7\4\2\2%&\7\32\2\2&\'\b\2\1\2\'\3\3\2\2\2"+
		"(*\5\b\5\2)(\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\60\3\2\2\2-+\3\2\2"+
		"\2.\60\5\6\4\2/+\3\2\2\2/.\3\2\2\2\60\5\3\2\2\2\61\65\7\35\2\2\62\64\5"+
		"\b\5\2\63\62\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\668\3\2"+
		"\2\2\67\65\3\2\2\28;\7\36\2\29;\5\b\5\2:\61\3\2\2\2:9\3\2\2\2;\7\3\2\2"+
		"\2<=\5\n\6\2=>\7\32\2\2>L\3\2\2\2?@\5\16\b\2@A\7\32\2\2AL\3\2\2\2BC\5"+
		"\20\t\2CD\7\32\2\2DL\3\2\2\2EF\5\24\13\2FG\7\32\2\2GL\3\2\2\2HL\5\22\n"+
		"\2IL\5\30\r\2JL\7\32\2\2K<\3\2\2\2K?\3\2\2\2KB\3\2\2\2KE\3\2\2\2KH\3\2"+
		"\2\2KI\3\2\2\2KJ\3\2\2\2L\t\3\2\2\2MN\7\5\2\2NO\7\r\2\2OT\5\f\7\2PQ\7"+
		"\31\2\2QS\5\f\7\2RP\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2U\13\3\2\2\2"+
		"VT\3\2\2\2WX\7\30\2\2XZ\b\7\1\2Y[\5\26\f\2ZY\3\2\2\2Z[\3\2\2\2[\r\3\2"+
		"\2\2\\]\7\6\2\2]^\7\33\2\2^_\7\30\2\2_`\b\b\1\2`a\7\34\2\2a\17\3\2\2\2"+
		"bc\7\7\2\2ch\7\33\2\2di\7\21\2\2ef\5\32\16\2fg\b\t\1\2gi\3\2\2\2hd\3\2"+
		"\2\2he\3\2\2\2ij\3\2\2\2jk\7\34\2\2k\21\3\2\2\2lm\7\b\2\2mn\7\33\2\2n"+
		"o\5 \21\2op\7\34\2\2pq\7\t\2\2qy\5\6\4\2rs\7\n\2\2st\7\33\2\2tu\5 \21"+
		"\2uv\7\34\2\2vw\7\t\2\2wx\5\6\4\2xz\3\2\2\2yr\3\2\2\2yz\3\2\2\2z}\3\2"+
		"\2\2{|\7\13\2\2|~\5\6\4\2}{\3\2\2\2}~\3\2\2\2~\23\3\2\2\2\177\u0080\7"+
		"\30\2\2\u0080\u0081\b\13\1\2\u0081\u0082\5\26\f\2\u0082\25\3\2\2\2\u0083"+
		"\u0084\7\22\2\2\u0084\u0085\5\32\16\2\u0085\u0086\b\f\1\2\u0086\27\3\2"+
		"\2\2\u0087\u0088\7\f\2\2\u0088\u0089\7\33\2\2\u0089\u008a\5 \21\2\u008a"+
		"\u008b\7\34\2\2\u008b\u008c\5\6\4\2\u008c\31\3\2\2\2\u008d\u008e\5\34"+
		"\17\2\u008e\u008f\7\23\2\2\u008f\u0090\5\32\16\2\u0090\u0097\3\2\2\2\u0091"+
		"\u0092\5\34\17\2\u0092\u0093\7\24\2\2\u0093\u0094\5\32\16\2\u0094\u0097"+
		"\3\2\2\2\u0095\u0097\5\34\17\2\u0096\u008d\3\2\2\2\u0096\u0091\3\2\2\2"+
		"\u0096\u0095\3\2\2\2\u0097\33\3\2\2\2\u0098\u0099\5\36\20\2\u0099\u009a"+
		"\7\25\2\2\u009a\u009b\5\34\17\2\u009b\u00a2\3\2\2\2\u009c\u009d\5\36\20"+
		"\2\u009d\u009e\7\26\2\2\u009e\u009f\5\34\17\2\u009f\u00a2\3\2\2\2\u00a0"+
		"\u00a2\5\36\20\2\u00a1\u0098\3\2\2\2\u00a1\u009c\3\2\2\2\u00a1\u00a0\3"+
		"\2\2\2\u00a2\35\3\2\2\2\u00a3\u00a4\7\16\2\2\u00a4\u00b0\b\20\1\2\u00a5"+
		"\u00a6\7\17\2\2\u00a6\u00b0\b\20\1\2\u00a7\u00a8\7\20\2\2\u00a8\u00b0"+
		"\b\20\1\2\u00a9\u00aa\7\30\2\2\u00aa\u00b0\b\20\1\2\u00ab\u00ac\7\33\2"+
		"\2\u00ac\u00ad\5\32\16\2\u00ad\u00ae\7\34\2\2\u00ae\u00b0\3\2\2\2\u00af"+
		"\u00a3\3\2\2\2\u00af\u00a5\3\2\2\2\u00af\u00a7\3\2\2\2\u00af\u00a9\3\2"+
		"\2\2\u00af\u00ab\3\2\2\2\u00b0\37\3\2\2\2\u00b1\u00b2\7\30\2\2\u00b2\u00b9"+
		"\b\21\1\2\u00b3\u00b4\5\32\16\2\u00b4\u00b5\7\27\2\2\u00b5\u00b6\5\32"+
		"\16\2\u00b6\u00b7\b\21\1\2\u00b7\u00b9\3\2\2\2\u00b8\u00b1\3\2\2\2\u00b8"+
		"\u00b3\3\2\2\2\u00b9!\3\2\2\2\20+/\65:KTZhy}\u0096\u00a1\u00af\u00b8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}