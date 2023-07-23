grammar isilang;

/**
TODO:
>Análise Semântica:
  >verificar se resultado da expressão é compativel com o tipo
  >incluir tipo string
  >Verificar se a variável foi declarada e não foi usada
  >Verificar se uma variável está sendo usada sem ter valor inicial
>Geração de Código:
  >A própria geração em si
  >Atribuições realizadas corretamente
  >Operações Aritméticas executadas corretamente
*/

@header {
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
}

@members {
  private Program program = new Program();
  private List<AbstractCommand> mainThread = new ArrayList<AbstractCommand>();
  private IdTable st = new IdTable();
  public static DataType currentType;
  public static DataType currentExprType;
  private AbstractIdentifier currentId;
  private String idName;
  private boolean isExprEvaluating = false;

  public void isIdDeclared(String idName) {
    if (!st.exists(idName)) {
      throw new semanticException("Identifier " + idName + " not declared");
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
}

program : 'programa' block 'fimprog' FP;

block : (cmd)* | codeblock;

codeblock : OB (cmd)* CB | cmd;

cmd : cmdDeclare FP | cmdRead FP | cmdWrite FP | cmdAttr FP | cmdIf | cmdWhile | FP;

cmdDeclare : 'declare' TYPE cmdDeclare2 (COMMA cmdDeclare2)*;

cmdDeclare2: ID {
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
        throw new semanticException("At line " + _ctx.getStart().getLine() + ", unexpected Type Declared");
      }
    } else {
      throw new semanticException("At line " + _ctx.getStart().getLine() + ", identifier " + idName + " already declared");
    }
  }
	(cmdAttr2)?
;

cmdRead : 'leia' OP ID {
    isIdDeclared(_input.LT(-1).getText());
  }
  CP
;

cmdWrite : 'escreva' OP (TEXT | expr {}
  ) CP
;

cmdIf : 'se' OP boolExpr CP 'entao' codeblock ('ou se' OP boolExpr CP 'entao' codeblock)? ('senao' codeblock)?
;

cmdAttr : ID {
    idName = _input.LT(-1).getText();
    isIdDeclared(idName);
    currentId = st.get(idName);
  }
  cmdAttr2
;

cmdAttr2 : ATTR expr {
    endExprEval(currentId.getType(), _ctx.getStart().getLine());
  }
;

cmdWhile : 'enquanto' OP boolExpr CP codeblock
;

expr : term SUM expr | term SUB expr | term;

term : factor MUL term | factor DIV term | factor;

factor : NUMBER {
    exprTypeCheck(DataType.INTEGER, _ctx.getStart().getLine());
  }
  | REAL {
    exprTypeCheck(DataType.REAL, _ctx.getStart().getLine());
  }
  | BOOLEAN {
    exprTypeCheck(DataType.BOOLEAN, _ctx.getStart().getLine());
  }
  | ID {
    idName = _input.LT(-1).getText();
    isIdDeclared(idName);
    exprTypeCheck(st.get(idName).getType(), _ctx.getStart().getLine());
  }
  | OP expr CP
;

boolExpr : ID {
    idName = _input.LT(-1).getText();
    isIdDeclared(idName);
    if (st.get(idName).getType() != DataType.BOOLEAN) {
      throw new semanticException("Identifier should have BOOLEAN type");
    }
  }
  | expr RELOP expr {
    endExprEval(currentExprType, _ctx.getStart().getLine());
  }
;

TYPE : 'INTEIRO' { isilangParser.currentType = DataType.INTEGER; }
  | 'REAL'       { isilangParser.currentType = DataType.REAL;    }
  | 'BOOLEANO'   { isilangParser.currentType = DataType.BOOLEAN; }
;

NUMBER : [0-9]+;

REAL   : [0-9]+ ('.'[0-9]+)? 'R';

BOOLEAN : 'VERDADEIRO' | 'FALSO';

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