package br.edu.ufabc.glyphobe.expressions;

public class BooleanExpression extends AbstractExpression {
  public BooleanExpression(String language, String expr) {
    super(language, expr);
  }

  @Override
  public String eval() {
    return expr.replace("VERDADEIRO", "true").replace("FALSO", "false");
  }
}
