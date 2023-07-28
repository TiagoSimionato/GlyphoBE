package br.edu.ufabc.glyphobe.expressions;

public class RealExpression extends AbstractExpression {
  public RealExpression(String language, String expr) {
    super(language, expr);
  }

  @Override
  public String eval() {
    if (language == "java") return expr.replace("R", "F");
    else return expr.replace("R", "");
  }
}
