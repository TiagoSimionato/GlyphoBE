package br.edu.ufabc.glyphobe.symbols.identifiers;

import br.edu.ufabc.glyphobe.symbols.DataType;

public abstract class AbstractIdentifier {
  protected DataType type;
  protected String   name;

  public AbstractIdentifier(String name, DataType type) {
    super();
    this.name = name;
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public DataType getType() {
    return type;
  }

  public abstract Object getValue();

  public abstract void setValue(Object v);
}
