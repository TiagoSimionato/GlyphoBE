// Generated from isilang.g4 by ANTLR 4.7.1
package src.core;
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
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, NUMBER=12, TEXT=13, ATTR=14, SUM=15, SUB=16, MUL=17, 
		DIV=18, RELOP=19, ID=20, COMMA=21, FP=22, OP=23, CP=24, OB=25, CB=26, 
		BLANK=27;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "NUMBER", "TEXT", "ATTR", "SUM", "SUB", "MUL", "DIV", 
		"RELOP", "ID", "COMMA", "FP", "OP", "CP", "OB", "CB", "BLANK"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programa'", "'fimprog'", "'declare'", "'INTEGER'", "'REAL'", "'BOOL'", 
		"'leia'", "'escreva'", "'se'", "'entao'", "'senao'", null, null, "':='", 
		"'+'", "'-'", "'*'", "'/'", null, null, "','", "'.'", "'('", "')'", "'{'", 
		"'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"NUMBER", "TEXT", "ATTR", "SUM", "SUB", "MUL", "DIV", "RELOP", "ID", "COMMA", 
		"FP", "OP", "CP", "OB", "CB", "BLANK"
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\35\u00bb\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\6\r\u0082\n\r\r\r"+
		"\16\r\u0083\3\16\3\16\7\16\u0088\n\16\f\16\16\16\u008b\13\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00a3\n\24\3\25\3\25\7\25\u00a7\n"+
		"\25\f\25\16\25\u00aa\13\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32"+
		"\3\32\3\33\3\33\3\34\3\34\3\34\3\34\2\2\35\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\35\3\2\b\3\2\62;\b\2\13\13\"#//\62;C"+
		"\\c|\4\2>>@@\4\2C\\c|\5\2\62;C\\c|\5\2\13\f\17\17\"\"\2\u00c1\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3"+
		"\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\39\3\2\2\2\5B\3\2\2\2\7"+
		"J\3\2\2\2\tR\3\2\2\2\13Z\3\2\2\2\r_\3\2\2\2\17d\3\2\2\2\21i\3\2\2\2\23"+
		"q\3\2\2\2\25t\3\2\2\2\27z\3\2\2\2\31\u0081\3\2\2\2\33\u0085\3\2\2\2\35"+
		"\u008e\3\2\2\2\37\u0091\3\2\2\2!\u0093\3\2\2\2#\u0095\3\2\2\2%\u0097\3"+
		"\2\2\2\'\u00a2\3\2\2\2)\u00a4\3\2\2\2+\u00ab\3\2\2\2-\u00ad\3\2\2\2/\u00af"+
		"\3\2\2\2\61\u00b1\3\2\2\2\63\u00b3\3\2\2\2\65\u00b5\3\2\2\2\67\u00b7\3"+
		"\2\2\29:\7r\2\2:;\7t\2\2;<\7q\2\2<=\7i\2\2=>\7t\2\2>?\7c\2\2?@\7o\2\2"+
		"@A\7c\2\2A\4\3\2\2\2BC\7h\2\2CD\7k\2\2DE\7o\2\2EF\7r\2\2FG\7t\2\2GH\7"+
		"q\2\2HI\7i\2\2I\6\3\2\2\2JK\7f\2\2KL\7g\2\2LM\7e\2\2MN\7n\2\2NO\7c\2\2"+
		"OP\7t\2\2PQ\7g\2\2Q\b\3\2\2\2RS\7K\2\2ST\7P\2\2TU\7V\2\2UV\7G\2\2VW\7"+
		"I\2\2WX\7G\2\2XY\7T\2\2Y\n\3\2\2\2Z[\7T\2\2[\\\7G\2\2\\]\7C\2\2]^\7N\2"+
		"\2^\f\3\2\2\2_`\7D\2\2`a\7Q\2\2ab\7Q\2\2bc\7N\2\2c\16\3\2\2\2de\7n\2\2"+
		"ef\7g\2\2fg\7k\2\2gh\7c\2\2h\20\3\2\2\2ij\7g\2\2jk\7u\2\2kl\7e\2\2lm\7"+
		"t\2\2mn\7g\2\2no\7x\2\2op\7c\2\2p\22\3\2\2\2qr\7u\2\2rs\7g\2\2s\24\3\2"+
		"\2\2tu\7g\2\2uv\7p\2\2vw\7v\2\2wx\7c\2\2xy\7q\2\2y\26\3\2\2\2z{\7u\2\2"+
		"{|\7g\2\2|}\7p\2\2}~\7c\2\2~\177\7q\2\2\177\30\3\2\2\2\u0080\u0082\t\2"+
		"\2\2\u0081\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0081\3\2\2\2\u0083"+
		"\u0084\3\2\2\2\u0084\32\3\2\2\2\u0085\u0089\7$\2\2\u0086\u0088\t\3\2\2"+
		"\u0087\u0086\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a"+
		"\3\2\2\2\u008a\u008c\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008d\7$\2\2\u008d"+
		"\34\3\2\2\2\u008e\u008f\7<\2\2\u008f\u0090\7?\2\2\u0090\36\3\2\2\2\u0091"+
		"\u0092\7-\2\2\u0092 \3\2\2\2\u0093\u0094\7/\2\2\u0094\"\3\2\2\2\u0095"+
		"\u0096\7,\2\2\u0096$\3\2\2\2\u0097\u0098\7\61\2\2\u0098&\3\2\2\2\u0099"+
		"\u00a3\t\4\2\2\u009a\u009b\7@\2\2\u009b\u00a3\7?\2\2\u009c\u009d\7>\2"+
		"\2\u009d\u00a3\7?\2\2\u009e\u009f\7?\2\2\u009f\u00a3\7?\2\2\u00a0\u00a1"+
		"\7#\2\2\u00a1\u00a3\7?\2\2\u00a2\u0099\3\2\2\2\u00a2\u009a\3\2\2\2\u00a2"+
		"\u009c\3\2\2\2\u00a2\u009e\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3(\3\2\2\2"+
		"\u00a4\u00a8\t\5\2\2\u00a5\u00a7\t\6\2\2\u00a6\u00a5\3\2\2\2\u00a7\u00aa"+
		"\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9*\3\2\2\2\u00aa"+
		"\u00a8\3\2\2\2\u00ab\u00ac\7.\2\2\u00ac,\3\2\2\2\u00ad\u00ae\7\60\2\2"+
		"\u00ae.\3\2\2\2\u00af\u00b0\7*\2\2\u00b0\60\3\2\2\2\u00b1\u00b2\7+\2\2"+
		"\u00b2\62\3\2\2\2\u00b3\u00b4\7}\2\2\u00b4\64\3\2\2\2\u00b5\u00b6\7\177"+
		"\2\2\u00b6\66\3\2\2\2\u00b7\u00b8\t\7\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba"+
		"\b\34\2\2\u00ba8\3\2\2\2\b\2\u0083\u0087\u0089\u00a2\u00a8\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}