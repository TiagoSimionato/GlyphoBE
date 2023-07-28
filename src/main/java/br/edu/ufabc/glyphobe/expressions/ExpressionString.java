package br.edu.ufabc.glyphobe.expressions;

public class ExpressionString {
  private String expr;

  public ExpressionString() {
    this.expr = "";
  }

  public String getExpr() {
    return expr;
  }

  public void resetExpr() {
    expr = "";
  }

  public void add(String literal) {
    expr += literal;
  }

  public void add(IntegerExpression ie) {
    expr += ie.eval();
  }

  public void add(RealExpression re) {
    expr += re.eval();
  }

  public void add(BooleanExpression be) {
    expr += be.eval();
  }

  public void add(OperatorExpression oe) {
    expr += oe.eval();
  }
}
