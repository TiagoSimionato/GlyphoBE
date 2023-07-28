// Generated from d:\ESTUDO\repositorios\GlyphoBE\src\isilang.g4 by ANTLR 4.9.2

  import br.edu.ufabc.glyphobe.ast.Program;
  import br.edu.ufabc.glyphobe.ast.AbstractCommand;
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
  
  import br.edu.ufabc.glyphobe.exceptions.semanticException;

  import java.util.ArrayList;
  import java.util.List;
  import java.util.HashMap;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class isilangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, TYPE=11, NUMBER=12, REAL=13, BOOLEAN=14, TEXT=15, ATTR=16, SUM=17, 
		SUB=18, MUL=19, DIV=20, RELOP=21, ID=22, COMMA=23, FP=24, OP=25, CP=26, 
		OB=27, CB=28, BLANK=29;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "TYPE", "NUMBER", "REAL", "BOOLEAN", "TEXT", "ATTR", "SUM", "SUB", 
			"MUL", "DIV", "RELOP", "ID", "COMMA", "FP", "OP", "CP", "OB", "CB", "BLANK"
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


	public isilangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "isilang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 10:
			TYPE_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void TYPE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 isilangParser.currentType = DataType.INTEGER; 
			break;
		case 1:
			 isilangParser.currentType = DataType.REAL;    
			break;
		case 2:
			 isilangParser.currentType = DataType.BOOLEAN; 
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\37\u00f7\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\5\f\u009b\n\f\3\r\6\r\u009e\n\r\r\r\16\r\u009f\3\16"+
		"\6\16\u00a3\n\16\r\16\16\16\u00a4\3\16\3\16\6\16\u00a9\n\16\r\16\16\16"+
		"\u00aa\5\16\u00ad\n\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00c0\n\17\3\20\3\20\7\20"+
		"\u00c4\n\20\f\20\16\20\u00c7\13\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\5\26\u00df\n\26\3\27\3\27\7\27\u00e3\n\27\f\27\16\27\u00e6\13\27"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36"+
		"\3\36\3\36\2\2\37\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37\3\2\b\3\2\62;\b\2\13\13\"#//\62;C\\c|\4\2>>@@\4\2C\\"+
		"c|\5\2\62;C\\c|\5\2\13\f\17\17\"\"\2\u0103\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\3=\3\2\2\2\5F\3\2\2\2"+
		"\7N\3\2\2\2\tV\3\2\2\2\13[\3\2\2\2\rc\3\2\2\2\17f\3\2\2\2\21l\3\2\2\2"+
		"\23r\3\2\2\2\25x\3\2\2\2\27\u009a\3\2\2\2\31\u009d\3\2\2\2\33\u00a2\3"+
		"\2\2\2\35\u00bf\3\2\2\2\37\u00c1\3\2\2\2!\u00ca\3\2\2\2#\u00cd\3\2\2\2"+
		"%\u00cf\3\2\2\2\'\u00d1\3\2\2\2)\u00d3\3\2\2\2+\u00de\3\2\2\2-\u00e0\3"+
		"\2\2\2/\u00e7\3\2\2\2\61\u00e9\3\2\2\2\63\u00eb\3\2\2\2\65\u00ed\3\2\2"+
		"\2\67\u00ef\3\2\2\29\u00f1\3\2\2\2;\u00f3\3\2\2\2=>\7r\2\2>?\7t\2\2?@"+
		"\7q\2\2@A\7i\2\2AB\7t\2\2BC\7c\2\2CD\7o\2\2DE\7c\2\2E\4\3\2\2\2FG\7h\2"+
		"\2GH\7k\2\2HI\7o\2\2IJ\7r\2\2JK\7t\2\2KL\7q\2\2LM\7i\2\2M\6\3\2\2\2NO"+
		"\7f\2\2OP\7g\2\2PQ\7e\2\2QR\7n\2\2RS\7c\2\2ST\7t\2\2TU\7g\2\2U\b\3\2\2"+
		"\2VW\7n\2\2WX\7g\2\2XY\7k\2\2YZ\7c\2\2Z\n\3\2\2\2[\\\7g\2\2\\]\7u\2\2"+
		"]^\7e\2\2^_\7t\2\2_`\7g\2\2`a\7x\2\2ab\7c\2\2b\f\3\2\2\2cd\7u\2\2de\7"+
		"g\2\2e\16\3\2\2\2fg\7g\2\2gh\7p\2\2hi\7v\2\2ij\7c\2\2jk\7q\2\2k\20\3\2"+
		"\2\2lm\7q\2\2mn\7w\2\2no\7\"\2\2op\7u\2\2pq\7g\2\2q\22\3\2\2\2rs\7u\2"+
		"\2st\7g\2\2tu\7p\2\2uv\7c\2\2vw\7q\2\2w\24\3\2\2\2xy\7g\2\2yz\7p\2\2z"+
		"{\7s\2\2{|\7w\2\2|}\7c\2\2}~\7p\2\2~\177\7v\2\2\177\u0080\7q\2\2\u0080"+
		"\26\3\2\2\2\u0081\u0082\7K\2\2\u0082\u0083\7P\2\2\u0083\u0084\7V\2\2\u0084"+
		"\u0085\7G\2\2\u0085\u0086\7K\2\2\u0086\u0087\7T\2\2\u0087\u0088\7Q\2\2"+
		"\u0088\u0089\3\2\2\2\u0089\u009b\b\f\2\2\u008a\u008b\7T\2\2\u008b\u008c"+
		"\7G\2\2\u008c\u008d\7C\2\2\u008d\u008e\7N\2\2\u008e\u008f\3\2\2\2\u008f"+
		"\u009b\b\f\3\2\u0090\u0091\7D\2\2\u0091\u0092\7Q\2\2\u0092\u0093\7Q\2"+
		"\2\u0093\u0094\7N\2\2\u0094\u0095\7G\2\2\u0095\u0096\7C\2\2\u0096\u0097"+
		"\7P\2\2\u0097\u0098\7Q\2\2\u0098\u0099\3\2\2\2\u0099\u009b\b\f\4\2\u009a"+
		"\u0081\3\2\2\2\u009a\u008a\3\2\2\2\u009a\u0090\3\2\2\2\u009b\30\3\2\2"+
		"\2\u009c\u009e\t\2\2\2\u009d\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u009d"+
		"\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\32\3\2\2\2\u00a1\u00a3\t\2\2\2\u00a2"+
		"\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2"+
		"\2\2\u00a5\u00ac\3\2\2\2\u00a6\u00a8\7\60\2\2\u00a7\u00a9\t\2\2\2\u00a8"+
		"\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2"+
		"\2\2\u00ab\u00ad\3\2\2\2\u00ac\u00a6\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad"+
		"\u00ae\3\2\2\2\u00ae\u00af\7T\2\2\u00af\34\3\2\2\2\u00b0\u00b1\7X\2\2"+
		"\u00b1\u00b2\7G\2\2\u00b2\u00b3\7T\2\2\u00b3\u00b4\7F\2\2\u00b4\u00b5"+
		"\7C\2\2\u00b5\u00b6\7F\2\2\u00b6\u00b7\7G\2\2\u00b7\u00b8\7K\2\2\u00b8"+
		"\u00b9\7T\2\2\u00b9\u00c0\7Q\2\2\u00ba\u00bb\7H\2\2\u00bb\u00bc\7C\2\2"+
		"\u00bc\u00bd\7N\2\2\u00bd\u00be\7U\2\2\u00be\u00c0\7Q\2\2\u00bf\u00b0"+
		"\3\2\2\2\u00bf\u00ba\3\2\2\2\u00c0\36\3\2\2\2\u00c1\u00c5\7$\2\2\u00c2"+
		"\u00c4\t\3\2\2\u00c3\u00c2\3\2\2\2\u00c4\u00c7\3\2\2\2\u00c5\u00c3\3\2"+
		"\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c8\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8"+
		"\u00c9\7$\2\2\u00c9 \3\2\2\2\u00ca\u00cb\7<\2\2\u00cb\u00cc\7?\2\2\u00cc"+
		"\"\3\2\2\2\u00cd\u00ce\7-\2\2\u00ce$\3\2\2\2\u00cf\u00d0\7/\2\2\u00d0"+
		"&\3\2\2\2\u00d1\u00d2\7,\2\2\u00d2(\3\2\2\2\u00d3\u00d4\7\61\2\2\u00d4"+
		"*\3\2\2\2\u00d5\u00df\t\4\2\2\u00d6\u00d7\7@\2\2\u00d7\u00df\7?\2\2\u00d8"+
		"\u00d9\7>\2\2\u00d9\u00df\7?\2\2\u00da\u00db\7?\2\2\u00db\u00df\7?\2\2"+
		"\u00dc\u00dd\7>\2\2\u00dd\u00df\7@\2\2\u00de\u00d5\3\2\2\2\u00de\u00d6"+
		"\3\2\2\2\u00de\u00d8\3\2\2\2\u00de\u00da\3\2\2\2\u00de\u00dc\3\2\2\2\u00df"+
		",\3\2\2\2\u00e0\u00e4\t\5\2\2\u00e1\u00e3\t\6\2\2\u00e2\u00e1\3\2\2\2"+
		"\u00e3\u00e6\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5.\3"+
		"\2\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00e8\7.\2\2\u00e8\60\3\2\2\2\u00e9\u00ea"+
		"\7\60\2\2\u00ea\62\3\2\2\2\u00eb\u00ec\7*\2\2\u00ec\64\3\2\2\2\u00ed\u00ee"+
		"\7+\2\2\u00ee\66\3\2\2\2\u00ef\u00f0\7}\2\2\u00f08\3\2\2\2\u00f1\u00f2"+
		"\7\177\2\2\u00f2:\3\2\2\2\u00f3\u00f4\t\7\2\2\u00f4\u00f5\3\2\2\2\u00f5"+
		"\u00f6\b\36\5\2\u00f6<\3\2\2\2\r\2\u009a\u009f\u00a4\u00aa\u00ac\u00bf"+
		"\u00c3\u00c5\u00de\u00e4\6\3\f\2\3\f\3\3\f\4\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}