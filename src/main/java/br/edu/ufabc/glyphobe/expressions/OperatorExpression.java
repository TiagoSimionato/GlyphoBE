package br.edu.ufabc.glyphobe.expressions;

public class OperatorExpression extends AbstractExpression{
  public OperatorExpression(String language, String expr) {
    super(language, expr);
  }

  @Override
  public String eval() {
    expr = expr.replace("<>", "!=");
    if (language == "js") {
      expr = expr.replace("==", "===")
      .replace("!=", "!==");
    }
    return " " + expr + " ";
  }
}
