grammar isilang;

/**
TODO:
>verificar se resultado da expressão é compativel com o tipo
>ta caindo na regra do numero??????
>geração de codigo
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
}

program : 'programa' block 'fimprog' FP;

block : (cmd)* | codeblock;

codeblock : OB (cmd)* CB | cmd;

cmd : cmdDeclare FP | cmdRead FP | cmdWrite FP | cmdIf | cmdAttr FP | cmdWhile | FP;

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
        throw new semanticException("Unexpected Type Declared");
      }
    } else {
      throw new semanticException("Identifier " + idName + " already declared");
    }
  }
	(cmdAttr2)?
;

cmdRead : 'leia' OP ID {
    isIdDeclared(_input.LT(-1).getText());
  }
  CP
;

cmdWrite : 'escreva' OP (TEXT | ID) CP;

cmdIf : 'se' OP boolExpr CP 'entao' codeblock ('ou se' OP boolExpr CP 'entao' codeblock)? ('senao' codeblock)?;

cmdAttr : ID {
    idName = _input.LT(-1).getText();
    isIdDeclared(idName);
    currentId = st.get(idName);
  }
  cmdAttr2
;

cmdAttr2 : ATTR expr {
    System.out.println("Tipo expr atual: " + currentExprType);
    if (currentExprType != currentId.getType()) {
      throw new semanticException("Expression type does not match Identifier type");
    }
  }
;

cmdWhile : 'enquanto' OP boolExpr CP codeblock;

expr : numberExpr { currentExprType = DataType.INTEGER; System.out.println("Setei tipo expr");}
  | boolExpr      { currentExprType = DataType.BOOLEAN;System.out.println("Setei tipo expr"); }
  | realExpr      { currentExprType = DataType.REAL;System.out.println("Setei tipo expr");    }
;

boolExpr : numberExpr {System.out.println("REGRA DO NUMERO");} RELOP numberExpr
  | realExpr {System.out.println("REGRA DO REAL");} RELOP realExpr
  | boolExpr {System.out.println("REGRA DO BOOLEANO");} RELOP boolExpr
  | ID {
    idName = _input.LT(-1).getText();
    isIdDeclared(idName);
    isIdTypeOk(idName, DataType.BOOLEAN);
  }
;

numberExpr : numberTerm SUM numberExpr | numberTerm SUB numberExpr | numberTerm;

numberTerm : numberFactor MUL numberTerm | numberFactor DIV numberTerm | numberFactor;

numberFactor : NUMBER
  | ID {
    idName = _input.LT(-1).getText();
    if (st.get(idName).getType() != DataType.INTEGER) {
      exitRule();
    }
    isIdDeclared(idName);
    isIdTypeOk(idName, DataType.INTEGER);
  }
  | OP numberExpr CP
;

realExpr : realTerm SUM realExpr | realTerm SUB realExpr | realTerm;

realTerm : realFactor MUL realTerm | realFactor DIV realTerm | realFactor;

realFactor : REAL
  | ID {
    idName = _input.LT(-1).getText();
    isIdDeclared(idName);
    isIdTypeOk(idName, DataType.REAL);
  }
;

TYPE : 'INTEIRO' { isilangParser.currentType = DataType.INTEGER; }
  | 'REAL'       { isilangParser.currentType = DataType.REAL;    }
  | 'BOOLEANO'   { isilangParser.currentType = DataType.BOOLEAN; }
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