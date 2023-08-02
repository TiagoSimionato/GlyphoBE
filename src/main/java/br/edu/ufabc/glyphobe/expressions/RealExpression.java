package br.edu.ufabc.glyphobe.expressions;

public class RealExpression extends AbstractExpression {
  public RealExpression(String language, String expr) {
    super(language, expr);
  }

  @Override
  public String eval() {
    switch(language) {
      case "java":
        return expr.replace("R", "f");
      default: /*js, py*/
        return expr.replace("R", "");
    }
  }
}
