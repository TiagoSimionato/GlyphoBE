package src.symbols;

public class Identifier {
  private DataType type;
  private String   name;
  
  private String  tValue;
  private Boolean bValue;
  private Integer iValue;
  private Double  dValue;

  public String getName() {
    return name;
  }

  public void setText(String name) {
    this.name = name;
  }

  public DataType getType() {
    return type;
  }

  public void setType(DataType type) {
    this.type = type;
  }

  public Identifier(String name, DataType type, String tValue) {
    super();
    this.name = name;
    this.type = type;
    this.tValue = tValue;
  }

  public Identifier(String name, DataType type, Boolean bValue) {
    super();
    this.name = name;
    this.type = type;
    this.bValue = bValue;
  }

  public Identifier(String name, DataType type, Integer iValue) {
    super();
    this.name = name;
    this.type = type;
    this.iValue = iValue;
  }

  public Identifier(String name, DataType type, Double dValue) {
    super();
    this.name = name;
    this.type = type;
    this.dValue = dValue;
  }

  @Override
  public String toString() {
    return "Identifier [name=" + name + ", type=" + type + "]";
  }
}
