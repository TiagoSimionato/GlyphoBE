// Generated from d:\ESTUDO\repositorios\GlyphoBE\src\isilang.g4 by ANTLR 4.9.2

  import br.edu.ufabc.glyphobe.ast.Program;
  import br.edu.ufabc.glyphobe.ast.AbstractCommand;
  import br.edu.ufabc.glyphobe.ast.CmdDeclare;
  import br.edu.ufabc.glyphobe.ast.CmdRead;
  import br.edu.ufabc.glyphobe.ast.CmdWrite;
  import br.edu.ufabc.glyphobe.ast.CmdAttr;
  import br.edu.ufabc.glyphobe.ast.CmdIf;
  import br.edu.ufabc.glyphobe.ast.CmdWhile;
  import br.edu.ufabc.glyphobe.ast.CmdToken;

  import br.edu.ufabc.glyphobe.symbols.identifiers.AbstractIdentifier;
  import br.edu.ufabc.glyphobe.symbols.identifiers.IntegerId;
  import br.edu.ufabc.glyphobe.symbols.identifiers.RealId;
  import br.edu.ufabc.glyphobe.symbols.identifiers.BooleanId;
  import br.edu.ufabc.glyphobe.symbols.DataType;
  import br.edu.ufabc.glyphobe.symbols.IdTable;

  import br.edu.ufabc.glyphobe.expressions.ExpressionString;
  import br.edu.ufabc.glyphobe.expressions.IntegerExpression;
  import br.edu.ufabc.glyphobe.expressions.RealExpression;
  import br.edu.ufabc.glyphobe.expressions.BooleanExpression;
  import br.edu.ufabc.glyphobe.expressions.OperatorExpression;
  
  import br.edu.ufabc.glyphobe.exceptions.SemanticError;

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
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

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
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "block", "codeblock", "cmd", "cmdDeclare", "cmdDeclare2", 
			"cmdRead", "cmdWrite", "cmdIf", "cmdAttr", "cmdAttr2", "cmdWhile", "expr", 
			"term", "factor", "boolExpr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog'", "'declare'", "'leia'", "'escreva'", 
			"'se'", "'entao'", "'ou se'", "'senao'", "'enquanto'", null, null, null, 
			null, null, "':='", "'+'", "'-'", "'*'", "'/'", null, null, "','", "'.'", 
			"'('", "')'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "TYPE", 
			"NUMBER", "REAL", "BOOLEAN", "TEXT", "ATTR", "SUM", "SUB", "MUL", "DIV", 
			"RELOP", "ID", "COMMA", "FP", "OP", "CP", "OB", "CB", "BLANK"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	  private List<AbstractCommand> cThread = new ArrayList<AbstractCommand>();
	  private String writeString;
	  private ExpressionString es = new ExpressionString();

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
	      throw new SemanticError("At line " + line + ", identifier [" + idName + "] not declared");
	    }
	  }

	  public void idHaveValue(String idName, int line) {
	    if (st.get(idName).getValue() == null) {
	      throw new SemanticError("At line " + line + ", identifier [" + idName + "] value was used but never assigned");
	    }
	  }

	  public void exprTypeCheck(DataType type, int line) {
	    if (!isExprEvaluating) {
	      isExprEvaluating = true;
	      currentExprType = type;
	    } else {
	      if (type != currentExprType) {
	        throw new SemanticError("At line " + line + ", expression type missmatch. Expression started as " + currentExprType + " but found " + type);
	      }
	    }
	  }

	  public void endExprEval(DataType expectedType, int line) {
	    if (currentExprType != expectedType) {
	      throw new SemanticError("At line " + line + ", expression type should be " + expectedType + " but found " + currentExprType);
	    }
	    isExprEvaluating = false;
	  }

	  public void showCmds() {
	    for (AbstractCommand cmd : program.getCommands()) {
	      System.out.println(cmd.generateCode());
	    }
	  }

	  public void setTargetLanguage(String lang) {
	    program.setLanguage(lang);
	  }

	  public String generateObjectCode() {
	    return program.generateTarget();
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
			      throw new SemanticError("There are identifiers declared but not used starting at line " + declaredOnly.entrySet().iterator().next().getValue().getLine());
			    }

			    program.setCommands(cThread);
			  
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
	}

	public final CodeblockContext codeblock() throws RecognitionException {
		CodeblockContext _localctx = new CodeblockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_codeblock);
		int _la;
		try {
			setState(58);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OB:
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				match(OB);

				    CmdToken cmd = new CmdToken(program.getLanguage(), _input.LT(-1).getText());
				    cThread.add(cmd);
				  
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__9) | (1L << ID) | (1L << FP))) != 0)) {
					{
					{
					setState(49);
					cmd();
					}
					}
					setState(54);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(55);
				match(CB);

				    cmd = new CmdToken(program.getLanguage(), _input.LT(-1).getText());
				    cThread.add(cmd);
				  
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
				setState(57);
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
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_cmd);
		try {
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				cmdDeclare();
				setState(61);
				match(FP);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				cmdRead();
				setState(64);
				match(FP);
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				cmdWrite();
				setState(67);
				match(FP);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(69);
				cmdAttr();
				setState(70);
				match(FP);
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 5);
				{
				setState(72);
				cmdIf();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 6);
				{
				setState(73);
				cmdWhile();
				}
				break;
			case FP:
				enterOuterAlt(_localctx, 7);
				{
				setState(74);
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
	}

	public final CmdDeclareContext cmdDeclare() throws RecognitionException {
		CmdDeclareContext _localctx = new CmdDeclareContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_cmdDeclare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(T__2);
			setState(78);
			match(TYPE);
			setState(79);
			cmdDeclare2();
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(80);
				match(COMMA);
				setState(81);
				cmdDeclare2();
				}
				}
				setState(86);
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
	}

	public final CmdDeclare2Context cmdDeclare2() throws RecognitionException {
		CmdDeclare2Context _localctx = new CmdDeclare2Context(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmdDeclare2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
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
			        throw new SemanticError("At line " + _ctx.getStart().getLine() + ", unexpected Type Declared");
			      }
			    } else {
			      throw new SemanticError("At line " + _ctx.getStart().getLine() + ", identifier " + idName + " already declared");
			    }
			    currentId = st.get(idName);
			  

			    CmdDeclare cmd = new CmdDeclare(program.getLanguage(), currentId);
			    cThread.add(cmd);
			  
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ATTR) {
				{
				setState(90);
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
	}

	public final CmdReadContext cmdRead() throws RecognitionException {
		CmdReadContext _localctx = new CmdReadContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdRead);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(T__3);
			setState(94);
			match(OP);
			setState(95);
			match(ID);

			    idName = _input.LT(-1).getText();
			    isIdDeclared(idName, _input.LT(-1).getLine());
			    idHaveValue(idName, _input.LT(-1).getLine());
			    declaredOnly.remove(idName);
			  
			setState(97);
			match(CP);

			    CmdRead cmd = new CmdRead(program.getLanguage(), st.get(idName));
			    cThread.add(cmd);
			  
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
	}

	public final CmdWriteContext cmdWrite() throws RecognitionException {
		CmdWriteContext _localctx = new CmdWriteContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdWrite);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(T__4);
			setState(101);
			match(OP);
			setState(108);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEXT:
				{
				setState(102);
				match(TEXT);

				    writeString = _input.LT(-1).getText(); 
				  
				}
				break;
			case NUMBER:
			case REAL:
			case BOOLEAN:
			case ID:
			case OP:
				{
				es.resetExpr();
				setState(105);
				expr();

				    endExprEval(currentExprType, _ctx.getStart().getLine());
				    writeString = es.getExpr();
				  
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(110);
			match(CP);

			    CmdWrite cmd = new CmdWrite(program.getLanguage(), writeString);
			    cThread.add(cmd);
			  
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
	}

	public final CmdIfContext cmdIf() throws RecognitionException {
		CmdIfContext _localctx = new CmdIfContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdIf);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(T__5);
			setState(114);
			match(OP);
			es.resetExpr();
			setState(116);
			boolExpr();
			setState(117);
			match(CP);
			setState(118);
			match(T__6);

			    CmdIf cmd = new CmdIf(program.getLanguage(), 1, es.getExpr());
			    cThread.add(cmd);
			  
			setState(120);
			codeblock();
			setState(132);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(121);
					match(T__7);
					setState(122);
					match(OP);
					es.resetExpr();
					setState(124);
					boolExpr();
					setState(125);
					match(CP);
					setState(126);
					match(T__6);

					    cmd = new CmdIf(program.getLanguage(), 2, es.getExpr());
					    cThread.add(cmd);
					  
					setState(128);
					codeblock();
					}
					} 
				}
				setState(134);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(138);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(135);
				match(T__8);

				    cmd = new CmdIf(program.getLanguage(), 3, "");
				    cThread.add(cmd);
				  
				setState(137);
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
	}

	public final CmdAttrContext cmdAttr() throws RecognitionException {
		CmdAttrContext _localctx = new CmdAttrContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdAttr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(ID);

			    idName = _input.LT(-1).getText();
			    isIdDeclared(idName, _input.LT(-1).getLine());
			    currentId = st.get(idName);
			  
			setState(142);
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
	}

	public final CmdAttr2Context cmdAttr2() throws RecognitionException {
		CmdAttr2Context _localctx = new CmdAttr2Context(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmdAttr2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(ATTR);
			es.resetExpr();
			setState(146);
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

			    CmdAttr cmd = new CmdAttr(program.getLanguage(), currentId, es.getExpr());
			    cThread.add(cmd);
			  
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
	}

	public final CmdWhileContext cmdWhile() throws RecognitionException {
		CmdWhileContext _localctx = new CmdWhileContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cmdWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(T__9);
			setState(150);
			match(OP);
			es.resetExpr();
			setState(152);
			boolExpr();
			setState(153);
			match(CP);

			    CmdWhile cmd = new CmdWhile(program.getLanguage(), es.getExpr());
			    cThread.add(cmd);
			  
			setState(155);
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
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expr);
		try {
			setState(168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				term();
				setState(158);
				match(SUM);

				    es.add(new OperatorExpression(program.getLanguage(), _input.LT(-1).getText()));
				  
				setState(160);
				expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(162);
				term();
				setState(163);
				match(SUB);

				    es.add(new OperatorExpression(program.getLanguage(), _input.LT(-1).getText()));
				  
				setState(165);
				expr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(167);
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
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_term);
		try {
			setState(181);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				factor();
				setState(171);
				match(MUL);

				    es.add(new OperatorExpression(program.getLanguage(), _input.LT(-1).getText()));
				  
				setState(173);
				term();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(175);
				factor();
				setState(176);
				match(DIV);
				 
				    es.add(new OperatorExpression(program.getLanguage(), _input.LT(-1).getText()));
				  
				setState(178);
				term();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(180);
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
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_factor);
		try {
			setState(197);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(183);
				match(NUMBER);

				    exprTypeCheck(DataType.INTEGER, _ctx.getStart().getLine());
				    
				    es.add(new IntegerExpression(program.getLanguage(), _input.LT(-1).getText()));
				  
				}
				break;
			case REAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(185);
				match(REAL);

				    exprTypeCheck(DataType.REAL, _ctx.getStart().getLine());
				    
				    es.add(new RealExpression(program.getLanguage(), _input.LT(-1).getText()));
				  
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 3);
				{
				setState(187);
				match(BOOLEAN);

				    exprTypeCheck(DataType.BOOLEAN, _ctx.getStart().getLine());

				    es.add(new BooleanExpression(program.getLanguage(), _input.LT(-1).getText()));
				  
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(189);
				match(ID);

				    idName = _input.LT(-1).getText();
				    isIdDeclared(idName, _input.LT(-1).getLine());
				    idHaveValue(idName, _input.LT(-1).getLine());
				    declaredOnly.remove(idName);
				    exprTypeCheck(st.get(idName).getType(), _ctx.getStart().getLine());

				    es.add(_input.LT(-1).getText());
				  
				}
				break;
			case OP:
				enterOuterAlt(_localctx, 5);
				{
				setState(191);
				match(OP);

				    es.add(_input.LT(-1).getText());
				  
				setState(193);
				expr();
				setState(194);
				match(CP);

				    es.add(_input.LT(-1).getText());
				  
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
		public TerminalNode BOOLEAN() { return getToken(isilangParser.BOOLEAN, 0); }
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
	}

	public final BoolExprContext boolExpr() throws RecognitionException {
		BoolExprContext _localctx = new BoolExprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_boolExpr);
		try {
			setState(209);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(199);
				match(ID);

				    idName = _input.LT(-1).getText();
				    isIdDeclared(idName, _input.LT(-1).getLine());
				    idHaveValue(idName, _input.LT(-1).getLine());
				    if (st.get(idName).getType() != DataType.BOOLEAN) {
				      throw new SemanticError("Identifier should have BOOLEAN type");
				    }
				    declaredOnly.remove(idName);

				    es.add(_input.LT(-1).getText());
				  
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
				match(BOOLEAN);

				    es.add(new BooleanExpression(program.getLanguage(), _input.LT(-1).getText()));
				  
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(203);
				expr();
				setState(204);
				match(RELOP);

				    es.add(new OperatorExpression(program.getLanguage(), _input.LT(-1).getText()));
				  
				setState(206);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\37\u00d6\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\3\7\3*\n\3\f\3\16\3-\13\3\3\3\5\3\60\n\3\3\4\3\4\3"+
		"\4\7\4\65\n\4\f\4\16\48\13\4\3\4\3\4\3\4\5\4=\n\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5N\n\5\3\6\3\6\3\6\3\6\3\6"+
		"\7\6U\n\6\f\6\16\6X\13\6\3\7\3\7\3\7\3\7\5\7^\n\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\to\n\t\3\t\3\t\3\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u0085"+
		"\n\n\f\n\16\n\u0088\13\n\3\n\3\n\3\n\5\n\u008d\n\n\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00ab\n\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00b8\n\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00c8\n\20"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00d4\n\21\3\21"+
		"\2\2\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\2\2\u00de\2\"\3\2\2"+
		"\2\4/\3\2\2\2\6<\3\2\2\2\bM\3\2\2\2\nO\3\2\2\2\fY\3\2\2\2\16_\3\2\2\2"+
		"\20f\3\2\2\2\22s\3\2\2\2\24\u008e\3\2\2\2\26\u0092\3\2\2\2\30\u0097\3"+
		"\2\2\2\32\u00aa\3\2\2\2\34\u00b7\3\2\2\2\36\u00c7\3\2\2\2 \u00d3\3\2\2"+
		"\2\"#\7\3\2\2#$\5\4\3\2$%\7\4\2\2%&\7\32\2\2&\'\b\2\1\2\'\3\3\2\2\2(*"+
		"\5\b\5\2)(\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\60\3\2\2\2-+\3\2\2\2"+
		".\60\5\6\4\2/+\3\2\2\2/.\3\2\2\2\60\5\3\2\2\2\61\62\7\35\2\2\62\66\b\4"+
		"\1\2\63\65\5\b\5\2\64\63\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2"+
		"\2\679\3\2\2\28\66\3\2\2\29:\7\36\2\2:=\b\4\1\2;=\5\b\5\2<\61\3\2\2\2"+
		"<;\3\2\2\2=\7\3\2\2\2>?\5\n\6\2?@\7\32\2\2@N\3\2\2\2AB\5\16\b\2BC\7\32"+
		"\2\2CN\3\2\2\2DE\5\20\t\2EF\7\32\2\2FN\3\2\2\2GH\5\24\13\2HI\7\32\2\2"+
		"IN\3\2\2\2JN\5\22\n\2KN\5\30\r\2LN\7\32\2\2M>\3\2\2\2MA\3\2\2\2MD\3\2"+
		"\2\2MG\3\2\2\2MJ\3\2\2\2MK\3\2\2\2ML\3\2\2\2N\t\3\2\2\2OP\7\5\2\2PQ\7"+
		"\r\2\2QV\5\f\7\2RS\7\31\2\2SU\5\f\7\2TR\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW"+
		"\3\2\2\2W\13\3\2\2\2XV\3\2\2\2YZ\7\30\2\2Z[\b\7\1\2[]\b\7\1\2\\^\5\26"+
		"\f\2]\\\3\2\2\2]^\3\2\2\2^\r\3\2\2\2_`\7\6\2\2`a\7\33\2\2ab\7\30\2\2b"+
		"c\b\b\1\2cd\7\34\2\2de\b\b\1\2e\17\3\2\2\2fg\7\7\2\2gn\7\33\2\2hi\7\21"+
		"\2\2io\b\t\1\2jk\b\t\1\2kl\5\32\16\2lm\b\t\1\2mo\3\2\2\2nh\3\2\2\2nj\3"+
		"\2\2\2op\3\2\2\2pq\7\34\2\2qr\b\t\1\2r\21\3\2\2\2st\7\b\2\2tu\7\33\2\2"+
		"uv\b\n\1\2vw\5 \21\2wx\7\34\2\2xy\7\t\2\2yz\b\n\1\2z\u0086\5\6\4\2{|\7"+
		"\n\2\2|}\7\33\2\2}~\b\n\1\2~\177\5 \21\2\177\u0080\7\34\2\2\u0080\u0081"+
		"\7\t\2\2\u0081\u0082\b\n\1\2\u0082\u0083\5\6\4\2\u0083\u0085\3\2\2\2\u0084"+
		"{\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2"+
		"\u0087\u008c\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008a\7\13\2\2\u008a\u008b"+
		"\b\n\1\2\u008b\u008d\5\6\4\2\u008c\u0089\3\2\2\2\u008c\u008d\3\2\2\2\u008d"+
		"\23\3\2\2\2\u008e\u008f\7\30\2\2\u008f\u0090\b\13\1\2\u0090\u0091\5\26"+
		"\f\2\u0091\25\3\2\2\2\u0092\u0093\7\22\2\2\u0093\u0094\b\f\1\2\u0094\u0095"+
		"\5\32\16\2\u0095\u0096\b\f\1\2\u0096\27\3\2\2\2\u0097\u0098\7\f\2\2\u0098"+
		"\u0099\7\33\2\2\u0099\u009a\b\r\1\2\u009a\u009b\5 \21\2\u009b\u009c\7"+
		"\34\2\2\u009c\u009d\b\r\1\2\u009d\u009e\5\6\4\2\u009e\31\3\2\2\2\u009f"+
		"\u00a0\5\34\17\2\u00a0\u00a1\7\23\2\2\u00a1\u00a2\b\16\1\2\u00a2\u00a3"+
		"\5\32\16\2\u00a3\u00ab\3\2\2\2\u00a4\u00a5\5\34\17\2\u00a5\u00a6\7\24"+
		"\2\2\u00a6\u00a7\b\16\1\2\u00a7\u00a8\5\32\16\2\u00a8\u00ab\3\2\2\2\u00a9"+
		"\u00ab\5\34\17\2\u00aa\u009f\3\2\2\2\u00aa\u00a4\3\2\2\2\u00aa\u00a9\3"+
		"\2\2\2\u00ab\33\3\2\2\2\u00ac\u00ad\5\36\20\2\u00ad\u00ae\7\25\2\2\u00ae"+
		"\u00af\b\17\1\2\u00af\u00b0\5\34\17\2\u00b0\u00b8\3\2\2\2\u00b1\u00b2"+
		"\5\36\20\2\u00b2\u00b3\7\26\2\2\u00b3\u00b4\b\17\1\2\u00b4\u00b5\5\34"+
		"\17\2\u00b5\u00b8\3\2\2\2\u00b6\u00b8\5\36\20\2\u00b7\u00ac\3\2\2\2\u00b7"+
		"\u00b1\3\2\2\2\u00b7\u00b6\3\2\2\2\u00b8\35\3\2\2\2\u00b9\u00ba\7\16\2"+
		"\2\u00ba\u00c8\b\20\1\2\u00bb\u00bc\7\17\2\2\u00bc\u00c8\b\20\1\2\u00bd"+
		"\u00be\7\20\2\2\u00be\u00c8\b\20\1\2\u00bf\u00c0\7\30\2\2\u00c0\u00c8"+
		"\b\20\1\2\u00c1\u00c2\7\33\2\2\u00c2\u00c3\b\20\1\2\u00c3\u00c4\5\32\16"+
		"\2\u00c4\u00c5\7\34\2\2\u00c5\u00c6\b\20\1\2\u00c6\u00c8\3\2\2\2\u00c7"+
		"\u00b9\3\2\2\2\u00c7\u00bb\3\2\2\2\u00c7\u00bd\3\2\2\2\u00c7\u00bf\3\2"+
		"\2\2\u00c7\u00c1\3\2\2\2\u00c8\37\3\2\2\2\u00c9\u00ca\7\30\2\2\u00ca\u00d4"+
		"\b\21\1\2\u00cb\u00cc\7\20\2\2\u00cc\u00d4\b\21\1\2\u00cd\u00ce\5\32\16"+
		"\2\u00ce\u00cf\7\27\2\2\u00cf\u00d0\b\21\1\2\u00d0\u00d1\5\32\16\2\u00d1"+
		"\u00d2\b\21\1\2\u00d2\u00d4\3\2\2\2\u00d3\u00c9\3\2\2\2\u00d3\u00cb\3"+
		"\2\2\2\u00d3\u00cd\3\2\2\2\u00d4!\3\2\2\2\20+/\66<MV]n\u0086\u008c\u00aa"+
		"\u00b7\u00c7\u00d3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}