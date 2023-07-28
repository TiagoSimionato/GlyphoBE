package br.edu.ufabc.glyphobe.expressions;

public abstract class AbstractExpression {
  protected String expr;
  protected String language;

  public AbstractExpression(String language, String expr) {
    this.language = language;
    this.expr = expr;
  }

  public abstract String eval();

  public String getExpr() {
    return expr;
  }

  public void setExpr(String expr) {
    this.expr = expr;
  }
}
