package br.edu.ufabc.glyphobe.expressions;

public class OperatorExpression extends AbstractExpression{
  public OperatorExpression(String language, String expr) {
    super(language, expr);
  }

  @Override
  public String eval() {
    return " " + expr
    .replace("<>", " != ")
    + " ";
  }
}
