package src.symbols.identifiers;

import src.symbols.DataType;

public class IntegerId extends AbstractIdentifier {

  private Integer value;
  
  public IntegerId(String name) {
    super(name, DataType.INTEGER);
  }

  public IntegerId(String name, Integer value) {
    super(name, DataType.INTEGER);
    this.value = value;
  }

  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "Identifier [name=" + name + ", type=" + type + ", value=" + value + "]";
  }
}
