// Generated from VSLParser.g by ANTLR 4.7.1

  package TP2;

  import java.util.stream.Collectors;
  import java.util.Arrays;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class VSLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, COMMENT=2, LP=3, RP=4, PLUS=5, VIRGULE=6, SUB=7, MUL=8, DIV=9, IF=10, 
		ELSE=11, FI=12, THEN=13, AFFECT=14, ACCOLADE_OUVERT=15, ACCOLADE_FERME=16, 
		WHILE=17, DO=18, DONE=19, IDENT=20, TEXT=21, INTEGER=22, INT_DECLARATION=23;
	public static final int
		RULE_program = 0, RULE_instruction = 1, RULE_declaration = 2, RULE_expression = 3, 
		RULE_factor = 4, RULE_primary = 5;
	public static final String[] ruleNames = {
		"program", "instruction", "declaration", "expression", "factor", "primary"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'('", "')'", "'+'", "','", "'-'", "'*'", "'/'", "'IF'", 
		"'ELSE'", "'FI'", "'THEN'", "':='", "'{'", "'}'", "'WHILE'", "'DO'", "'DONE'", 
		null, null, null, "'INT'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "COMMENT", "LP", "RP", "PLUS", "VIRGULE", "SUB", "MUL", "DIV", 
		"IF", "ELSE", "FI", "THEN", "AFFECT", "ACCOLADE_OUVERT", "ACCOLADE_FERME", 
		"WHILE", "DO", "DONE", "IDENT", "TEXT", "INTEGER", "INT_DECLARATION"
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
	public String getGrammarFileName() { return "VSLParser.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public VSLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TP2.ASD.Program out;
		public InstructionContext i;
		public TerminalNode EOF() { return getToken(VSLParser.EOF, 0); }
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			ArrayList<TP2.ASD.Instruction> inst= new ArrayList<>();
			setState(18);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << ACCOLADE_OUVERT) | (1L << WHILE) | (1L << IDENT))) != 0)) {
				{
				{
				setState(13);
				((ProgramContext)_localctx).i = instruction();
				inst.add(((ProgramContext)_localctx).i.out);
				}
				}
				setState(20);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(21);
			match(EOF);
			 ((ProgramContext)_localctx).out =  new TP2.ASD.Program(inst);
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

	public static class InstructionContext extends ParserRuleContext {
		public TP2.ASD.Instruction out;
		public DeclarationContext d;
		public InstructionContext i;
		public ExpressionContext cond;
		public InstructionContext i1;
		public Token ident;
		public ExpressionContext e;
		public TerminalNode ACCOLADE_OUVERT() { return getToken(VSLParser.ACCOLADE_OUVERT, 0); }
		public TerminalNode ACCOLADE_FERME() { return getToken(VSLParser.ACCOLADE_FERME, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public TerminalNode IF() { return getToken(VSLParser.IF, 0); }
		public TerminalNode THEN() { return getToken(VSLParser.THEN, 0); }
		public TerminalNode FI() { return getToken(VSLParser.FI, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(VSLParser.ELSE, 0); }
		public TerminalNode WHILE() { return getToken(VSLParser.WHILE, 0); }
		public TerminalNode DO() { return getToken(VSLParser.DO, 0); }
		public TerminalNode DONE() { return getToken(VSLParser.DONE, 0); }
		public TerminalNode AFFECT() { return getToken(VSLParser.AFFECT, 0); }
		public TerminalNode IDENT() { return getToken(VSLParser.IDENT, 0); }
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_instruction);
		int _la;
		try {
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ACCOLADE_OUVERT:
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				match(ACCOLADE_OUVERT);
				ArrayList<TP2.ASD.DeclInstruction> decs = new ArrayList<TP2.ASD.DeclInstruction>();
				ArrayList<TP2.ASD.Instruction> instructions = new ArrayList<TP2.ASD.Instruction>();
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==INT_DECLARATION) {
					{
					{
					setState(27);
					((InstructionContext)_localctx).d = declaration();
					decs=((InstructionContext)_localctx).d.out;
					}
					}
					setState(34);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << ACCOLADE_OUVERT) | (1L << WHILE) | (1L << IDENT))) != 0)) {
					{
					{
					setState(35);
					((InstructionContext)_localctx).i = instruction();
					instructions.add(((InstructionContext)_localctx).i.out);
					}
					}
					setState(42);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				((InstructionContext)_localctx).out = new TP2.ASD.Bloc(decs,instructions);
				setState(44);
				match(ACCOLADE_FERME);
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				match(IF);
				setState(46);
				((InstructionContext)_localctx).cond = expression();
				setState(47);
				match(THEN);
				boolean a = false;
				{
				setState(49);
				((InstructionContext)_localctx).i = instruction();
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(50);
					match(ELSE);
					{
					setState(51);
					((InstructionContext)_localctx).i1 = instruction();
					}
					a=true;
					}
				}

				setState(56);
				match(FI);
				if(a){
				      	    ((InstructionContext)_localctx).out = new TP2.ASD.IF(((InstructionContext)_localctx).cond.out,((InstructionContext)_localctx).i.out,((InstructionContext)_localctx).i1.out);
				      	}else{
				      	((InstructionContext)_localctx).out = new TP2.ASD.IF(((InstructionContext)_localctx).cond.out,((InstructionContext)_localctx).i.out,null);}
				      	
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(59);
				match(WHILE);
				{
				setState(60);
				((InstructionContext)_localctx).cond = expression();
				}
				setState(61);
				match(DO);
				{
				setState(62);
				((InstructionContext)_localctx).i = instruction();
				}
				setState(63);
				match(DONE);
				((InstructionContext)_localctx).out = new TP2.ASD.While(((InstructionContext)_localctx).cond.out,((InstructionContext)_localctx).i.out);
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 4);
				{
				setState(66);
				((InstructionContext)_localctx).ident = match(IDENT);
				setState(67);
				match(AFFECT);
				setState(68);
				((InstructionContext)_localctx).e = expression();
				((InstructionContext)_localctx).out = new TP2.ASD.AffectationInstruction(((InstructionContext)_localctx).ident.getText(),((InstructionContext)_localctx).e.out); 
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

	public static class DeclarationContext extends ParserRuleContext {
		public ArrayList<TP2.ASD.DeclInstruction> out;
		public Token ident;
		public Token ident2;
		public TerminalNode INT_DECLARATION() { return getToken(VSLParser.INT_DECLARATION, 0); }
		public List<TerminalNode> IDENT() { return getTokens(VSLParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(VSLParser.IDENT, i);
		}
		public List<TerminalNode> VIRGULE() { return getTokens(VSLParser.VIRGULE); }
		public TerminalNode VIRGULE(int i) {
			return getToken(VSLParser.VIRGULE, i);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			ArrayList<TP2.ASD.DeclInstruction> decls = new ArrayList<TP2.ASD.DeclInstruction>(); 
			{
			setState(74);
			match(INT_DECLARATION);
			setState(75);
			((DeclarationContext)_localctx).ident = match(IDENT);
			decls.add(new TP2.ASD.IntegerDeclaration(((DeclarationContext)_localctx).ident.getText()));
			}
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULE) {
				{
				{
				setState(78);
				match(VIRGULE);
				setState(79);
				((DeclarationContext)_localctx).ident2 = match(IDENT);
				decls.add(new TP2.ASD.IntegerDeclaration(((DeclarationContext)_localctx).ident2.getText()) );
				}
				}
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			((DeclarationContext)_localctx).out = decls;
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

	public static class ExpressionContext extends ParserRuleContext {
		public TP2.ASD.Expression out;
		public FactorContext l;
		public ExpressionContext r;
		public FactorContext f;
		public TerminalNode PLUS() { return getToken(VSLParser.PLUS, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SUB() { return getToken(VSLParser.SUB, 0); }
		public TerminalNode DIV() { return getToken(VSLParser.DIV, 0); }
		public TerminalNode MUL() { return getToken(VSLParser.MUL, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_expression);
		try {
			setState(111);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				((ExpressionContext)_localctx).l = factor();
				setState(89);
				match(PLUS);
				setState(90);
				((ExpressionContext)_localctx).r = expression();
				 ((ExpressionContext)_localctx).out =  new TP2.ASD.AddExpression(((ExpressionContext)_localctx).l.out, ((ExpressionContext)_localctx).r.out);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				((ExpressionContext)_localctx).l = factor();
				setState(94);
				match(SUB);
				setState(95);
				((ExpressionContext)_localctx).r = expression();
				((ExpressionContext)_localctx).out =  new TP2.ASD.SubExpression(((ExpressionContext)_localctx).l.out,((ExpressionContext)_localctx).r.out);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(98);
				((ExpressionContext)_localctx).l = factor();
				setState(99);
				match(DIV);
				setState(100);
				((ExpressionContext)_localctx).r = expression();
				((ExpressionContext)_localctx).out =  new TP2.ASD.DivExpression(((ExpressionContext)_localctx).l.out,((ExpressionContext)_localctx).r.out);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(103);
				((ExpressionContext)_localctx).l = factor();
				setState(104);
				match(MUL);
				setState(105);
				((ExpressionContext)_localctx).r = expression();
				((ExpressionContext)_localctx).out =  new TP2.ASD.MulExpression (((ExpressionContext)_localctx).l.out,((ExpressionContext)_localctx).r.out);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(108);
				((ExpressionContext)_localctx).f = factor();
				 ((ExpressionContext)_localctx).out =  ((ExpressionContext)_localctx).f.out; 
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
		public TP2.ASD.Expression out;
		public PrimaryContext p;
		public Token id;
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(VSLParser.IDENT, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_factor);
		try {
			setState(118);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				((FactorContext)_localctx).p = primary();
				 ((FactorContext)_localctx).out =  ((FactorContext)_localctx).p.out; 
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				((FactorContext)_localctx).id = match(IDENT);
				((FactorContext)_localctx).out =  new TP2.ASD.VariableExpression(((FactorContext)_localctx).id.getText());
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

	public static class PrimaryContext extends ParserRuleContext {
		public TP2.ASD.Expression out;
		public Token INTEGER;
		public TerminalNode INTEGER() { return getToken(VSLParser.INTEGER, 0); }
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_primary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			((PrimaryContext)_localctx).INTEGER = match(INTEGER);
			 ((PrimaryContext)_localctx).out =  new TP2.ASD.IntegerExpression((((PrimaryContext)_localctx).INTEGER!=null?Integer.valueOf(((PrimaryContext)_localctx).INTEGER.getText()):0)); 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\31~\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\2\7\2\23\n\2\f\2\16\2"+
		"\26\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3!\n\3\f\3\16\3$\13\3\3"+
		"\3\3\3\3\3\7\3)\n\3\f\3\16\3,\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\5\39\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\5\3J\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4T\n\4\f\4\16\4W\13"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5r\n\5\3\6\3\6\3\6\3\6\3\6\5\6y\n\6"+
		"\3\7\3\7\3\7\3\7\2\2\b\2\4\6\b\n\f\2\2\2\u0084\2\16\3\2\2\2\4I\3\2\2\2"+
		"\6K\3\2\2\2\bq\3\2\2\2\nx\3\2\2\2\fz\3\2\2\2\16\24\b\2\1\2\17\20\5\4\3"+
		"\2\20\21\b\2\1\2\21\23\3\2\2\2\22\17\3\2\2\2\23\26\3\2\2\2\24\22\3\2\2"+
		"\2\24\25\3\2\2\2\25\27\3\2\2\2\26\24\3\2\2\2\27\30\7\2\2\3\30\31\b\2\1"+
		"\2\31\3\3\2\2\2\32\33\7\21\2\2\33\34\b\3\1\2\34\"\b\3\1\2\35\36\5\6\4"+
		"\2\36\37\b\3\1\2\37!\3\2\2\2 \35\3\2\2\2!$\3\2\2\2\" \3\2\2\2\"#\3\2\2"+
		"\2#*\3\2\2\2$\"\3\2\2\2%&\5\4\3\2&\'\b\3\1\2\')\3\2\2\2(%\3\2\2\2),\3"+
		"\2\2\2*(\3\2\2\2*+\3\2\2\2+-\3\2\2\2,*\3\2\2\2-.\b\3\1\2.J\7\22\2\2/\60"+
		"\7\f\2\2\60\61\5\b\5\2\61\62\7\17\2\2\62\63\b\3\1\2\638\5\4\3\2\64\65"+
		"\7\r\2\2\65\66\5\4\3\2\66\67\b\3\1\2\679\3\2\2\28\64\3\2\2\289\3\2\2\2"+
		"9:\3\2\2\2:;\7\16\2\2;<\b\3\1\2<J\3\2\2\2=>\7\23\2\2>?\5\b\5\2?@\7\24"+
		"\2\2@A\5\4\3\2AB\7\25\2\2BC\b\3\1\2CJ\3\2\2\2DE\7\26\2\2EF\7\20\2\2FG"+
		"\5\b\5\2GH\b\3\1\2HJ\3\2\2\2I\32\3\2\2\2I/\3\2\2\2I=\3\2\2\2ID\3\2\2\2"+
		"J\5\3\2\2\2KL\b\4\1\2LM\7\31\2\2MN\7\26\2\2NO\b\4\1\2OU\3\2\2\2PQ\7\b"+
		"\2\2QR\7\26\2\2RT\b\4\1\2SP\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2VX\3"+
		"\2\2\2WU\3\2\2\2XY\b\4\1\2Y\7\3\2\2\2Z[\5\n\6\2[\\\7\7\2\2\\]\5\b\5\2"+
		"]^\b\5\1\2^r\3\2\2\2_`\5\n\6\2`a\7\t\2\2ab\5\b\5\2bc\b\5\1\2cr\3\2\2\2"+
		"de\5\n\6\2ef\7\13\2\2fg\5\b\5\2gh\b\5\1\2hr\3\2\2\2ij\5\n\6\2jk\7\n\2"+
		"\2kl\5\b\5\2lm\b\5\1\2mr\3\2\2\2no\5\n\6\2op\b\5\1\2pr\3\2\2\2qZ\3\2\2"+
		"\2q_\3\2\2\2qd\3\2\2\2qi\3\2\2\2qn\3\2\2\2r\t\3\2\2\2st\5\f\7\2tu\b\6"+
		"\1\2uy\3\2\2\2vw\7\26\2\2wy\b\6\1\2xs\3\2\2\2xv\3\2\2\2y\13\3\2\2\2z{"+
		"\7\30\2\2{|\b\7\1\2|\r\3\2\2\2\n\24\"*8IUqx";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}