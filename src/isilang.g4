grammar isilang;

/**
TODO:
>Análise Semântica:
  >verificar se resultado da expressão é compativel com o tipo do identificador
  >incluir tipo string?
>Geração de Código:
  >A própria geração em si
  >Atribuições realizadas corretamente
  >Operações Aritméticas executadas corretamente
*/

@header {
  import br.edu.ufabc.glyphobe.ast.Program;
  import br.edu.ufabc.glyphobe.ast.AbstractCommand;
  import br.edu.ufabc.glyphobe.ast.CmdRead;
  import br.edu.ufabc.glyphobe.ast.CmdWrite;

  import br.edu.ufabc.glyphobe.symbols.identifiers.AbstractIdentifier;
  import br.edu.ufabc.glyphobe.symbols.identifiers.IntegerId;
  import br.edu.ufabc.glyphobe.symbols.identifiers.RealId;
  import br.edu.ufabc.glyphobe.symbols.identifiers.BooleanId;

  import br.edu.ufabc.glyphobe.symbols.DataType;
  import br.edu.ufabc.glyphobe.symbols.IdTable;
  
  import br.edu.ufabc.glyphobe.exceptions.semanticException;

  import java.util.ArrayList;
  import java.util.List;
  import java.util.HashMap;
}

@members {
  //Geração codigo
  private Program program = new Program();
  private List<AbstractCommand> cThread = new ArrayList<AbstractCommand>();
  private String writeString;

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
}

program : 'programa' block 'fimprog' FP {
    if (declaredOnly.size() > 0) {
      throw new semanticException("There are identifiers declared but not used starting at line " + declaredOnly.entrySet().iterator().next().getValue().getLine());
    }

    program.setCommands(cThread);
  }
;

block : (cmd)* | codeblock;

codeblock : OB (cmd)* CB | cmd;

cmd : cmdDeclare FP | cmdRead FP | cmdWrite FP | cmdAttr FP | cmdIf | cmdWhile | FP;

cmdDeclare : 'declare' TYPE cmdDeclare2 (COMMA cmdDeclare2)*;

cmdDeclare2: ID {
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
  }
	(cmdAttr2)?
;

cmdRead : 'leia' OP ID {
    idName = _input.LT(-1).getText();
    isIdDeclared(idName, _input.LT(-1).getLine());
    idHaveValue(idName, _input.LT(-1).getLine());
    declaredOnly.remove(idName);
  }
  CP
  {
    CmdRead cmd = new CmdRead(st.get(idName));
    cThread.add(cmd);
  }
;

cmdWrite : 'escreva' OP (TEXT {
    writeString = _input.LT(-1).getText().substring(1, _input.LT(-1).getText().length()); //Substring para remover as aspas duplas
  } 
  | expr {
    endExprEval(currentExprType, _ctx.getStart().getLine());
    writeString = _input.LT(-1).getText(); //TODO VALOR PROPRIAMENTE DA EXPR
  }
  ) CP
  {
    CmdWrite cmd = new CmdWrite(writeString);
    cThread.add(cmd);
  }
;

cmdIf : 'se' OP boolExpr CP 'entao' codeblock ('ou se' OP boolExpr CP 'entao' codeblock)? ('senao' codeblock)?
;

cmdAttr : ID {
    idName = _input.LT(-1).getText();
    isIdDeclared(idName, _input.LT(-1).getLine());
    currentId = st.get(idName);
  }
  cmdAttr2
;

cmdAttr2 : ATTR expr {
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
    isIdDeclared(idName, _input.LT(-1).getLine());
    idHaveValue(idName, _input.LT(-1).getLine());
    declaredOnly.remove(idName);
    exprTypeCheck(st.get(idName).getType(), _ctx.getStart().getLine());
  }
  | OP expr CP
;

boolExpr : ID {
    idName = _input.LT(-1).getText();
    isIdDeclared(idName, _input.LT(-1).getLine());
    idHaveValue(idName, _input.LT(-1).getLine());
    if (st.get(idName).getType() != DataType.BOOLEAN) {
      throw new semanticException("Identifier should have BOOLEAN type");
    }
    declaredOnly.remove(idName);
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