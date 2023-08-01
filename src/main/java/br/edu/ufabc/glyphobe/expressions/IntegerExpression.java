package br.edu.ufabc.glyphobe.expressions;

public class IntegerExpression extends AbstractExpression {
  public IntegerExpression(String language, String expr) {
    super(language, expr);
  }

  @Override
  public String eval() {
    return expr; /*js, java, py */
  }
}
