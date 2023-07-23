package src.symbols.identifiers;

import src.symbols.DataType;

public class RealId extends AbstractIdentifier {
  private Double value;
  
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

  public void setValue(Double value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "Identifier [name=" + name + ", type=" + type + ", value=" + value + "]";
  }
}
