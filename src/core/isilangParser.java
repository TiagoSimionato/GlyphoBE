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
		T__9=10, TYPE=11, NUMBER=12, REAL=13, TEXT=14, ATTR=15, SUM=16, SUB=17, 
		MUL=18, DIV=19, RELOP=20, ID=21, COMMA=22, FP=23, OP=24, CP=25, OB=26, 
		CB=27, BLANK=28;
	public static final int
		RULE_program = 0, RULE_block = 1, RULE_codeblock = 2, RULE_cmd = 3, RULE_cmdDeclare = 4, 
		RULE_cmdDeclare2 = 5, RULE_cmdRead = 6, RULE_cmdWrite = 7, RULE_cmdIf = 8, 
		RULE_cmdAttr = 9, RULE_cmdAttr2 = 10, RULE_cmdWhile = 11, RULE_expr = 12, 
		RULE_boolExpr = 13, RULE_numberExpr = 14, RULE_numberTerm = 15, RULE_numberFactor = 16, 
		RULE_realExpr = 17, RULE_realTerm = 18, RULE_realFactor = 19;
	public static final String[] ruleNames = {
		"program", "block", "codeblock", "cmd", "cmdDeclare", "cmdDeclare2", "cmdRead", 
		"cmdWrite", "cmdIf", "cmdAttr", "cmdAttr2", "cmdWhile", "expr", "boolExpr", 
		"numberExpr", "numberTerm", "numberFactor", "realExpr", "realTerm", "realFactor"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programa'", "'fimprog'", "'declare'", "'leia'", "'escreva'", "'se'", 
		"'entao'", "'ou se'", "'senao'", "'enquanto'", null, null, null, null, 
		"':='", "'+'", "'-'", "'*'", "'/'", null, null, "','", "'.'", "'('", "')'", 
		"'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "TYPE", 
		"NUMBER", "REAL", "TEXT", "ATTR", "SUM", "SUB", "MUL", "DIV", "RELOP", 
		"ID", "COMMA", "FP", "OP", "CP", "OB", "CB", "BLANK"
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


	  private Program program = new Program();
	  private List<AbstractCommand> mainThread = new ArrayList<AbstractCommand>();
	  private IdTable st = new IdTable();
	  public static DataType currentType;
	  public static DataType currentExprType;
	  private AbstractIdentifier currentId;
	  private String idName;

	  public void isIdDeclared(String idName) {
	    if (!st.exists(idName)) {
	      throw new semanticException("Identifier " + idName + " not declared");
	    }
	  }

	  public void isIdTypeOk(String idName, DataType type) {
	    System.out.println(st.get(idName).getType());
	    System.out.println(type);
	    if (st.get(idName).getType() != type) {
	      throw new semanticException("Identifier used in the wrong type of expression");
	    }
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
			setState(40);
			match(T__0);
			setState(41);
			block();
			setState(42);
			match(T__1);
			setState(43);
			match(FP);
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
			setState(52);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__9) | (1L << ID) | (1L << FP))) != 0)) {
					{
					{
					setState(45);
					cmd();
					}
					}
					setState(50);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
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
			setState(63);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OB:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				match(OB);
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__9) | (1L << ID) | (1L << FP))) != 0)) {
					{
					{
					setState(55);
					cmd();
					}
					}
					setState(60);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(61);
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
				setState(62);
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
		public CmdIfContext cmdIf() {
			return getRuleContext(CmdIfContext.class,0);
		}
		public CmdAttrContext cmdAttr() {
			return getRuleContext(CmdAttrContext.class,0);
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
			setState(80);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				cmdDeclare();
				setState(66);
				match(FP);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				cmdRead();
				setState(69);
				match(FP);
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(71);
				cmdWrite();
				setState(72);
				match(FP);
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 4);
				{
				setState(74);
				cmdIf();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(75);
				cmdAttr();
				setState(76);
				match(FP);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 6);
				{
				setState(78);
				cmdWhile();
				}
				break;
			case FP:
				enterOuterAlt(_localctx, 7);
				{
				setState(79);
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
			setState(82);
			match(T__2);
			setState(83);
			match(TYPE);
			setState(84);
			cmdDeclare2();
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(85);
				match(COMMA);
				setState(86);
				cmdDeclare2();
				}
				}
				setState(91);
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
			setState(92);
			match(ID);

			    idName = _input.LT(-1).getText();
			    if (!st.exists(idName)) {
			      if (currentType == DataType.INTEGER) {
			        st.add(idName, new IntegerId(idName));
			      }
			      else if (currentType == DataType.BOOLEAN) {
			        st.add(idName, new BooleanId(idName));
			      }
			      else if (currentType == DataType.REAL) {
			        st.add(idName, new RealId(idName));
			      }
			      else {
			        throw new semanticException("Unexpected Type Declared");
			      }
			    } else {
			      throw new semanticException("Identifier " + idName + " already declared");
			    }
			  
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ATTR) {
				{
				setState(94);
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
			setState(97);
			match(T__3);
			setState(98);
			match(OP);
			setState(99);
			match(ID);

			    isIdDeclared(_input.LT(-1).getText());
			  
			setState(101);
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
		public TerminalNode ID() { return getToken(isilangParser.ID, 0); }
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(T__4);
			setState(104);
			match(OP);
			setState(105);
			_la = _input.LA(1);
			if ( !(_la==TEXT || _la==ID) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(106);
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
			setState(108);
			match(T__5);
			setState(109);
			match(OP);
			setState(110);
			boolExpr(0);
			setState(111);
			match(CP);
			setState(112);
			match(T__6);
			setState(113);
			codeblock();
			setState(121);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(114);
				match(T__7);
				setState(115);
				match(OP);
				setState(116);
				boolExpr(0);
				setState(117);
				match(CP);
				setState(118);
				match(T__6);
				setState(119);
				codeblock();
				}
				break;
			}
			setState(125);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(123);
				match(T__8);
				setState(124);
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
			setState(127);
			match(ID);

			    idName = _input.LT(-1).getText();
			    isIdDeclared(idName);
			    currentId = st.get(idName);
			  
			setState(129);
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
			setState(131);
			match(ATTR);
			setState(132);
			expr();

			    System.out.println("Tipo expr atual: " + currentExprType);
			    if (currentExprType != currentId.getType()) {
			      throw new semanticException("Expression type does not match Identifier type");
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
			setState(135);
			match(T__9);
			setState(136);
			match(OP);
			setState(137);
			boolExpr(0);
			setState(138);
			match(CP);
			setState(139);
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
		public NumberExprContext numberExpr() {
			return getRuleContext(NumberExprContext.class,0);
		}
		public BoolExprContext boolExpr() {
			return getRuleContext(BoolExprContext.class,0);
		}
		public RealExprContext realExpr() {
			return getRuleContext(RealExprContext.class,0);
		}
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
			setState(150);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(141);
				numberExpr();
				 currentExprType = DataType.INTEGER; System.out.println("Setei tipo expr");
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				boolExpr(0);
				 currentExprType = DataType.BOOLEAN;System.out.println("Setei tipo expr"); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(147);
				realExpr();
				 currentExprType = DataType.REAL;System.out.println("Setei tipo expr");    
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

	public static class BoolExprContext extends ParserRuleContext {
		public List<NumberExprContext> numberExpr() {
			return getRuleContexts(NumberExprContext.class);
		}
		public NumberExprContext numberExpr(int i) {
			return getRuleContext(NumberExprContext.class,i);
		}
		public TerminalNode RELOP() { return getToken(isilangParser.RELOP, 0); }
		public List<RealExprContext> realExpr() {
			return getRuleContexts(RealExprContext.class);
		}
		public RealExprContext realExpr(int i) {
			return getRuleContext(RealExprContext.class,i);
		}
		public TerminalNode ID() { return getToken(isilangParser.ID, 0); }
		public List<BoolExprContext> boolExpr() {
			return getRuleContexts(BoolExprContext.class);
		}
		public BoolExprContext boolExpr(int i) {
			return getRuleContext(BoolExprContext.class,i);
		}
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
		return boolExpr(0);
	}

	private BoolExprContext boolExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BoolExprContext _localctx = new BoolExprContext(_ctx, _parentState);
		BoolExprContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_boolExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(153);
				numberExpr();
				System.out.println("REGRA DO NUMERO");
				setState(155);
				match(RELOP);
				setState(156);
				numberExpr();
				}
				break;
			case 2:
				{
				setState(158);
				realExpr();
				System.out.println("REGRA DO NUMERO");
				setState(160);
				match(RELOP);
				setState(161);
				realExpr();
				}
				break;
			case 3:
				{
				setState(163);
				match(ID);

				    idName = _input.LT(-1).getText();
				    isIdDeclared(idName);
				    isIdTypeOk(idName, DataType.BOOLEAN);
				  
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(173);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BoolExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_boolExpr);
					setState(167);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					System.out.println("REGRA DO NUMERO");
					setState(169);
					match(RELOP);
					setState(170);
					boolExpr(3);
					}
					} 
				}
				setState(175);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class NumberExprContext extends ParserRuleContext {
		public NumberTermContext numberTerm() {
			return getRuleContext(NumberTermContext.class,0);
		}
		public TerminalNode SUM() { return getToken(isilangParser.SUM, 0); }
		public NumberExprContext numberExpr() {
			return getRuleContext(NumberExprContext.class,0);
		}
		public TerminalNode SUB() { return getToken(isilangParser.SUB, 0); }
		public NumberExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).enterNumberExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).exitNumberExpr(this);
		}
	}

	public final NumberExprContext numberExpr() throws RecognitionException {
		NumberExprContext _localctx = new NumberExprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_numberExpr);
		try {
			setState(185);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				numberTerm();
				setState(177);
				match(SUM);
				setState(178);
				numberExpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(180);
				numberTerm();
				setState(181);
				match(SUB);
				setState(182);
				numberExpr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(184);
				numberTerm();
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

	public static class NumberTermContext extends ParserRuleContext {
		public NumberFactorContext numberFactor() {
			return getRuleContext(NumberFactorContext.class,0);
		}
		public TerminalNode MUL() { return getToken(isilangParser.MUL, 0); }
		public NumberTermContext numberTerm() {
			return getRuleContext(NumberTermContext.class,0);
		}
		public TerminalNode DIV() { return getToken(isilangParser.DIV, 0); }
		public NumberTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).enterNumberTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).exitNumberTerm(this);
		}
	}

	public final NumberTermContext numberTerm() throws RecognitionException {
		NumberTermContext _localctx = new NumberTermContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_numberTerm);
		try {
			setState(196);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				numberFactor();
				setState(188);
				match(MUL);
				setState(189);
				numberTerm();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(191);
				numberFactor();
				setState(192);
				match(DIV);
				setState(193);
				numberTerm();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(195);
				numberFactor();
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

	public static class NumberFactorContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(isilangParser.NUMBER, 0); }
		public TerminalNode ID() { return getToken(isilangParser.ID, 0); }
		public TerminalNode OP() { return getToken(isilangParser.OP, 0); }
		public NumberExprContext numberExpr() {
			return getRuleContext(NumberExprContext.class,0);
		}
		public TerminalNode CP() { return getToken(isilangParser.CP, 0); }
		public NumberFactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberFactor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).enterNumberFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).exitNumberFactor(this);
		}
	}

	public final NumberFactorContext numberFactor() throws RecognitionException {
		NumberFactorContext _localctx = new NumberFactorContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_numberFactor);
		try {
			setState(205);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				match(NUMBER);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(199);
				match(ID);

				    idName = _input.LT(-1).getText();
				    if (st.get(idName).getType() != DataType.INTEGER) {
				      exitRule();
				    }
				    isIdDeclared(idName);
				    isIdTypeOk(idName, DataType.INTEGER);
				  
				}
				break;
			case OP:
				enterOuterAlt(_localctx, 3);
				{
				setState(201);
				match(OP);
				setState(202);
				numberExpr();
				setState(203);
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

	public static class RealExprContext extends ParserRuleContext {
		public RealTermContext realTerm() {
			return getRuleContext(RealTermContext.class,0);
		}
		public TerminalNode SUM() { return getToken(isilangParser.SUM, 0); }
		public RealExprContext realExpr() {
			return getRuleContext(RealExprContext.class,0);
		}
		public TerminalNode SUB() { return getToken(isilangParser.SUB, 0); }
		public RealExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_realExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).enterRealExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).exitRealExpr(this);
		}
	}

	public final RealExprContext realExpr() throws RecognitionException {
		RealExprContext _localctx = new RealExprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_realExpr);
		try {
			setState(216);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(207);
				realTerm();
				setState(208);
				match(SUM);
				setState(209);
				realExpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(211);
				realTerm();
				setState(212);
				match(SUB);
				setState(213);
				realExpr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(215);
				realTerm();
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

	public static class RealTermContext extends ParserRuleContext {
		public RealFactorContext realFactor() {
			return getRuleContext(RealFactorContext.class,0);
		}
		public TerminalNode MUL() { return getToken(isilangParser.MUL, 0); }
		public RealTermContext realTerm() {
			return getRuleContext(RealTermContext.class,0);
		}
		public TerminalNode DIV() { return getToken(isilangParser.DIV, 0); }
		public RealTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_realTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).enterRealTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).exitRealTerm(this);
		}
	}

	public final RealTermContext realTerm() throws RecognitionException {
		RealTermContext _localctx = new RealTermContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_realTerm);
		try {
			setState(227);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(218);
				realFactor();
				setState(219);
				match(MUL);
				setState(220);
				realTerm();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(222);
				realFactor();
				setState(223);
				match(DIV);
				setState(224);
				realTerm();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(226);
				realFactor();
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

	public static class RealFactorContext extends ParserRuleContext {
		public TerminalNode REAL() { return getToken(isilangParser.REAL, 0); }
		public TerminalNode ID() { return getToken(isilangParser.ID, 0); }
		public RealFactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_realFactor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).enterRealFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof isilangListener ) ((isilangListener)listener).exitRealFactor(this);
		}
	}

	public final RealFactorContext realFactor() throws RecognitionException {
		RealFactorContext _localctx = new RealFactorContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_realFactor);
		try {
			setState(232);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case REAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(229);
				match(REAL);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(230);
				match(ID);

				    idName = _input.LT(-1).getText();
				    isIdDeclared(idName);
				    isIdTypeOk(idName, DataType.REAL);
				  
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 13:
			return boolExpr_sempred((BoolExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean boolExpr_sempred(BoolExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\36\u00ed\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\3\2\3\3\7\3\61\n\3\f\3"+
		"\16\3\64\13\3\3\3\5\3\67\n\3\3\4\3\4\7\4;\n\4\f\4\16\4>\13\4\3\4\3\4\5"+
		"\4B\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5"+
		"\5S\n\5\3\6\3\6\3\6\3\6\3\6\7\6Z\n\6\f\6\16\6]\13\6\3\7\3\7\3\7\5\7b\n"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n|\n\n\3\n\3\n\5\n\u0080\n\n\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\5\16\u0099\n\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00a8\n\17\3\17\3\17\3\17\3\17"+
		"\7\17\u00ae\n\17\f\17\16\17\u00b1\13\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\5\20\u00bc\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\5\21\u00c7\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00d0\n"+
		"\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00db\n\23\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00e6\n\24\3\25\3\25\3\25"+
		"\5\25\u00eb\n\25\3\25\2\3\34\26\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(\2\3\4\2\20\20\27\27\2\u00f6\2*\3\2\2\2\4\66\3\2\2\2\6A\3\2\2\2"+
		"\bR\3\2\2\2\nT\3\2\2\2\f^\3\2\2\2\16c\3\2\2\2\20i\3\2\2\2\22n\3\2\2\2"+
		"\24\u0081\3\2\2\2\26\u0085\3\2\2\2\30\u0089\3\2\2\2\32\u0098\3\2\2\2\34"+
		"\u00a7\3\2\2\2\36\u00bb\3\2\2\2 \u00c6\3\2\2\2\"\u00cf\3\2\2\2$\u00da"+
		"\3\2\2\2&\u00e5\3\2\2\2(\u00ea\3\2\2\2*+\7\3\2\2+,\5\4\3\2,-\7\4\2\2-"+
		".\7\31\2\2.\3\3\2\2\2/\61\5\b\5\2\60/\3\2\2\2\61\64\3\2\2\2\62\60\3\2"+
		"\2\2\62\63\3\2\2\2\63\67\3\2\2\2\64\62\3\2\2\2\65\67\5\6\4\2\66\62\3\2"+
		"\2\2\66\65\3\2\2\2\67\5\3\2\2\28<\7\34\2\29;\5\b\5\2:9\3\2\2\2;>\3\2\2"+
		"\2<:\3\2\2\2<=\3\2\2\2=?\3\2\2\2><\3\2\2\2?B\7\35\2\2@B\5\b\5\2A8\3\2"+
		"\2\2A@\3\2\2\2B\7\3\2\2\2CD\5\n\6\2DE\7\31\2\2ES\3\2\2\2FG\5\16\b\2GH"+
		"\7\31\2\2HS\3\2\2\2IJ\5\20\t\2JK\7\31\2\2KS\3\2\2\2LS\5\22\n\2MN\5\24"+
		"\13\2NO\7\31\2\2OS\3\2\2\2PS\5\30\r\2QS\7\31\2\2RC\3\2\2\2RF\3\2\2\2R"+
		"I\3\2\2\2RL\3\2\2\2RM\3\2\2\2RP\3\2\2\2RQ\3\2\2\2S\t\3\2\2\2TU\7\5\2\2"+
		"UV\7\r\2\2V[\5\f\7\2WX\7\30\2\2XZ\5\f\7\2YW\3\2\2\2Z]\3\2\2\2[Y\3\2\2"+
		"\2[\\\3\2\2\2\\\13\3\2\2\2][\3\2\2\2^_\7\27\2\2_a\b\7\1\2`b\5\26\f\2a"+
		"`\3\2\2\2ab\3\2\2\2b\r\3\2\2\2cd\7\6\2\2de\7\32\2\2ef\7\27\2\2fg\b\b\1"+
		"\2gh\7\33\2\2h\17\3\2\2\2ij\7\7\2\2jk\7\32\2\2kl\t\2\2\2lm\7\33\2\2m\21"+
		"\3\2\2\2no\7\b\2\2op\7\32\2\2pq\5\34\17\2qr\7\33\2\2rs\7\t\2\2s{\5\6\4"+
		"\2tu\7\n\2\2uv\7\32\2\2vw\5\34\17\2wx\7\33\2\2xy\7\t\2\2yz\5\6\4\2z|\3"+
		"\2\2\2{t\3\2\2\2{|\3\2\2\2|\177\3\2\2\2}~\7\13\2\2~\u0080\5\6\4\2\177"+
		"}\3\2\2\2\177\u0080\3\2\2\2\u0080\23\3\2\2\2\u0081\u0082\7\27\2\2\u0082"+
		"\u0083\b\13\1\2\u0083\u0084\5\26\f\2\u0084\25\3\2\2\2\u0085\u0086\7\21"+
		"\2\2\u0086\u0087\5\32\16\2\u0087\u0088\b\f\1\2\u0088\27\3\2\2\2\u0089"+
		"\u008a\7\f\2\2\u008a\u008b\7\32\2\2\u008b\u008c\5\34\17\2\u008c\u008d"+
		"\7\33\2\2\u008d\u008e\5\6\4\2\u008e\31\3\2\2\2\u008f\u0090\5\36\20\2\u0090"+
		"\u0091\b\16\1\2\u0091\u0099\3\2\2\2\u0092\u0093\5\34\17\2\u0093\u0094"+
		"\b\16\1\2\u0094\u0099\3\2\2\2\u0095\u0096\5$\23\2\u0096\u0097\b\16\1\2"+
		"\u0097\u0099\3\2\2\2\u0098\u008f\3\2\2\2\u0098\u0092\3\2\2\2\u0098\u0095"+
		"\3\2\2\2\u0099\33\3\2\2\2\u009a\u009b\b\17\1\2\u009b\u009c\5\36\20\2\u009c"+
		"\u009d\b\17\1\2\u009d\u009e\7\26\2\2\u009e\u009f\5\36\20\2\u009f\u00a8"+
		"\3\2\2\2\u00a0\u00a1\5$\23\2\u00a1\u00a2\b\17\1\2\u00a2\u00a3\7\26\2\2"+
		"\u00a3\u00a4\5$\23\2\u00a4\u00a8\3\2\2\2\u00a5\u00a6\7\27\2\2\u00a6\u00a8"+
		"\b\17\1\2\u00a7\u009a\3\2\2\2\u00a7\u00a0\3\2\2\2\u00a7\u00a5\3\2\2\2"+
		"\u00a8\u00af\3\2\2\2\u00a9\u00aa\f\4\2\2\u00aa\u00ab\b\17\1\2\u00ab\u00ac"+
		"\7\26\2\2\u00ac\u00ae\5\34\17\5\u00ad\u00a9\3\2\2\2\u00ae\u00b1\3\2\2"+
		"\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\35\3\2\2\2\u00b1\u00af"+
		"\3\2\2\2\u00b2\u00b3\5 \21\2\u00b3\u00b4\7\22\2\2\u00b4\u00b5\5\36\20"+
		"\2\u00b5\u00bc\3\2\2\2\u00b6\u00b7\5 \21\2\u00b7\u00b8\7\23\2\2\u00b8"+
		"\u00b9\5\36\20\2\u00b9\u00bc\3\2\2\2\u00ba\u00bc\5 \21\2\u00bb\u00b2\3"+
		"\2\2\2\u00bb\u00b6\3\2\2\2\u00bb\u00ba\3\2\2\2\u00bc\37\3\2\2\2\u00bd"+
		"\u00be\5\"\22\2\u00be\u00bf\7\24\2\2\u00bf\u00c0\5 \21\2\u00c0\u00c7\3"+
		"\2\2\2\u00c1\u00c2\5\"\22\2\u00c2\u00c3\7\25\2\2\u00c3\u00c4\5 \21\2\u00c4"+
		"\u00c7\3\2\2\2\u00c5\u00c7\5\"\22\2\u00c6\u00bd\3\2\2\2\u00c6\u00c1\3"+
		"\2\2\2\u00c6\u00c5\3\2\2\2\u00c7!\3\2\2\2\u00c8\u00d0\7\16\2\2\u00c9\u00ca"+
		"\7\27\2\2\u00ca\u00d0\b\22\1\2\u00cb\u00cc\7\32\2\2\u00cc\u00cd\5\36\20"+
		"\2\u00cd\u00ce\7\33\2\2\u00ce\u00d0\3\2\2\2\u00cf\u00c8\3\2\2\2\u00cf"+
		"\u00c9\3\2\2\2\u00cf\u00cb\3\2\2\2\u00d0#\3\2\2\2\u00d1\u00d2\5&\24\2"+
		"\u00d2\u00d3\7\22\2\2\u00d3\u00d4\5$\23\2\u00d4\u00db\3\2\2\2\u00d5\u00d6"+
		"\5&\24\2\u00d6\u00d7\7\23\2\2\u00d7\u00d8\5$\23\2\u00d8\u00db\3\2\2\2"+
		"\u00d9\u00db\5&\24\2\u00da\u00d1\3\2\2\2\u00da\u00d5\3\2\2\2\u00da\u00d9"+
		"\3\2\2\2\u00db%\3\2\2\2\u00dc\u00dd\5(\25\2\u00dd\u00de\7\24\2\2\u00de"+
		"\u00df\5&\24\2\u00df\u00e6\3\2\2\2\u00e0\u00e1\5(\25\2\u00e1\u00e2\7\25"+
		"\2\2\u00e2\u00e3\5&\24\2\u00e3\u00e6\3\2\2\2\u00e4\u00e6\5(\25\2\u00e5"+
		"\u00dc\3\2\2\2\u00e5\u00e0\3\2\2\2\u00e5\u00e4\3\2\2\2\u00e6\'\3\2\2\2"+
		"\u00e7\u00eb\7\17\2\2\u00e8\u00e9\7\27\2\2\u00e9\u00eb\b\25\1\2\u00ea"+
		"\u00e7\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb)\3\2\2\2\24\62\66<AR[a{\177\u0098"+
		"\u00a7\u00af\u00bb\u00c6\u00cf\u00da\u00e5\u00ea";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}