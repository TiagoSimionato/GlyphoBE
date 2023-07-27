package br.edu.ufabc.glyphobe.symbols.identifiers;

import br.edu.ufabc.glyphobe.symbols.DataType;

public class BooleanId extends AbstractIdentifier{
  private Boolean value = null;
  
  public BooleanId(String name) {
    super(name, DataType.BOOLEAN);
  }

  public BooleanId(String name, Boolean value) {
    super(name, DataType.BOOLEAN);
    this.value = value;
  }

  public Boolean getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = (Boolean) value;
  }

  @Override
  public String toString() {
    return "Identifier [name=" + name + ", type=" + type + ", value=" + value + "]";
  }
}
