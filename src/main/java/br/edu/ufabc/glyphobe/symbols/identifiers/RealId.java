package br.edu.ufabc.glyphobe.symbols.identifiers;

import br.edu.ufabc.glyphobe.symbols.DataType;

public class RealId extends AbstractIdentifier {
  private Double value = null;
  
  public RealId(String name) {
    super(name, DataType.REAL);
  }

  public RealId(String name, Double value) {
    super(name, DataType.REAL);
    this.value = value;
  }

  public Double getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = (Double) value;
  }

  @Override
  public String toString() {
    return "Identifier [name=" + name + ", type=" + type + ", value=" + value + "]";
  }
}
