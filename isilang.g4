grammar isilang;

@header {
  import src.symbols.DataType;
  import src.symbols.Identifier;
  import src.symbols.SymbolTable;
}

@members {
  private SymbolTable st = new SymbolTable();
  private DataType currentType;
  private String idName;
}

program : 'programa' block 'fimprog' FP;

block : (cmd FP)+ | codeblock;

codeblock : OB (cmd FP)+ CB | cmd FP;

cmd : cmdDeclare | cmdRead | cmdWrite | cmdIf | cmdAttr | cmdWhile;

cmdDeclare : 'declare' TYPE cmdDeclare2 (COMMA cmdDeclare2)*;

cmdDeclare2: ID {
    varName = LT(-1).getText();
		varValue = null;
  }
	(cmdAttr2 {})?
;

cmdRead : 'leia' OP ID CP FP;

cmdWrite : 'escreva' OP (TEXT ID) CP FP;

cmdIf : 'se' OP boolExpr CP 'entao' codeblock ('ou se' OP boolExpr CP 'entao' codeblock)? ('senao' codeblock)?;

cmdAttr : ID cmdAttr2;

cmdAttr2 : ATTR expr;

cmdWhile : 'enquanto' OP boolExpr CP codeblock;

boolExpr : ID | expr RELOP expr;

expr : term SUM expr | term SUB expr | term;

term : factor MUL term | factor DIV term | factor;

factor : NUMBER | REAL | ID | OP expr CP;

TYPE : 'INTEIRO' { currentType = DataType.INTEGER; }
  | 'REAL'       { currentType = DataType.REAL;    }
  | 'BOOLEANO'   { currentType = DataType.BOOLEAN; }
;

NUMBER : [0-9]+;

REAL   : [0-9]+'.'[0-9]+'R';

TEXT   : '"' ([a-zA-Z0-9] | ' ' | '\t' | '!' | '-')* '"';

ATTR   : ':=';

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