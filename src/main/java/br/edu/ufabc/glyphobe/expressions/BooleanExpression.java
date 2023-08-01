package br.edu.ufabc.glyphobe.expressions;

public class BooleanExpression extends AbstractExpression {
  public BooleanExpression(String language, String expr) {
    super(language, expr);
  }

  @Override
  public String eval() {
    switch(language) {
      case "py":
        return expr.replace("VERDADEIRO", "True").replace("FALSO", "False");
      default: /*js, java */
        return expr.replace("VERDADEIRO", "true").replace("FALSO", "false");
    }
  }
}
