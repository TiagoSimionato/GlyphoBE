grammar isilang-wcode;

@header {
	import java.util.ArrayList;
	import java.util.List;
	import symbols.DataType;
	import java.util.Stack;
	import symbols.Identifier;
	import symbols.SymbolTable;
	import expressions.*;
	import ast.*;
}

@members{
	private SymbolTable symbolTable = new SymbolTable();
	private DataType currentType;
	private AbstractExpression expression;
	private char operator;
	private DataType leftDT;
	private DataType rightDT;
	private String   idAtribuido;
	private String   text;
	private Program  program = new Program();
	private Stack<List<AbstractCommand>> stack = new Stack<List<AbstractCommand>>();
	
	public void init(){
		program.setSymbolTable(symbolTable);
		stack.push(new ArrayList<AbstractCommand>());
	}
		
	public void exibirID(){
		symbolTable.getSymbols().values().stream().forEach((id)->System.out.println(id));
	}
	
	public void generateObjectCode(){
		program.generateTarget();
	}
	
	public void runInterpreter(){
		program.run();
	}
}
program : 'programa' declare block 'fimprog' FP
  {
    program.setComandos(stack.pop());
  };

declare : 'declare' ID (COMMA ID)* FP;

block : (cmd FP )+ | OB (cmd FP )+ CB;

type : 'INTEGER' { currentType = DataType.INTEGER; } | 'REAL' { currentType = DataType.REAL; } | 'BOOL' { currentType = DataType.BOOLEAN; };

lista_var : ID { symbolTable.add(_input.LT(-1).getText(), new Identifier(_input.LT(-1).getText(), currentType)); } 
           (COMMA
           	ID { symbolTable.add(_input.LT(-1).getText(), new Identifier(_input.LT(-1).getText(), currentType)); }
           )*;

cmd : cmdAttr | cmdRead | cmdWrite | cmdIf;

cmdRead : 'leia' OP ID {
    Identifier id = symbolTable.get(_input.LT(-1).getText());
    if (id == null) {
      throw new RuntimeException("Undeclared Variable");
    }
    CmdRead _read = new CmdRead(id);
    stack.peek().add(_read);
  }
  CP FP;

cmdWrite : 'escreva' OP (
    TEXT {
      CmdWrite _write = new CmdWrite(_input.LT(-1).getText());
      stack.peek().add(_write);
    }
    ID {
      Identifier id = symbolTable.get(_input.LT(-1).getText());
      if (id == null) {
        throw new RuntimeException("Undeclared Variable");	         		
      }
      CmdWrite _write = new CmdWrite(id);
      stack.peek().add(_write);
    }
  )
  CP FP;

cmdIf : 'se' {
    stack.push(new ArrayList<AbstractCommand>());
    BinaryExpression _relExpr = new BinaryExpression();				
    CmdIf _cmdIf = new CmdIf();
  }
  OP
	expr {
    _relExpr.setLeftSide(expression);
  }
  RELOP {
    _relExpr.setOperator(_input.LT(-1).getText().charAt(0));
  } 
  expr {
    _relExpr.setRightSide(expression);
    _cmdIf.setExpr(_relExpr);
  }
  FP
	'entao'
	block {
    _cmdIf.setListaTrue(stack.pop());
  }
  (
    'senao' {
      stack.push(new ArrayList<AbstractCommand>());
    }
    block
  )?;

cmdAttr : ID {
		idAtribuido = _input.LT(-1).getText();
		if (!symbolTable.exists(_input.LT(-1).getText())){
			throw new RuntimeException("Semantic ERROR - Undeclared Identifier");
		}
		leftDT = symbolTable.get(_input.LT(-1).getText()).getType();
		rightDT = null;
	}
	ATTR expr FP {
		// logica para atribuir o valor da expressao no identificador
		Identifier id = symbolTable.get(idAtribuido);
		id.setValue(expression.eval());
		symbolTable.add(idAtribuido, id);

		//System.out.println("EVAL ("+expression+") = "+expression.eval());
			
		CmdAttrib _attr = new CmdAttrib(id, expression);
		stack.peek().add(_attr);
		expression = null;					
	};

expr : term SUM expr | term SUB expr | term;

term : factor {
    expression = new NumberExpression(Integer.parseInt(_input.LT(-1).getText()));
  }
	(MUL | DIV) term | factor;

factor : NUMBER | ID | OP expr CP;

NUMBER : [0-9]+;

TEXT   : '"' ([a-zA-Z0-9] | ' ' | '\t' | '!' | '-')* '"';

ATTR	 : ':=';

SUM    : '+';

SUB    : '-';

MUL    : '*';

DIV    : '/';

RELOP  : '<' | '>' | '>=' | '<=' | '==' | '!=';

ID     : [a-zA-Z] ([a-zA-Z0-9])*;

COMMA  : ',';

FP     : '.';

OP     : '(';

CP     : ')';

OB     : '{';

CB     : '}';

BLANK  : (' '| '\t' | '\n' | '\r') -> skip;