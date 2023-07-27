package br.edu.ufabc.glyphobe.expressions;

public class IntegerExpression extends AbstractExpression {

  private int value;

  public IntegerExpression(int value) {
    super();
    this.value = value;
  }

  public IntegerExpression() {
    super();
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  @Override
  public int eval() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }
}
