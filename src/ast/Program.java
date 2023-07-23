package src.ast;

import java.util.ArrayList;
import java.util.List;

import src.symbols.IdTable;

public class Program {
  private String fileName;
  private List<AbstractCommand> cmds;
  private IdTable it;

  public Program() {
    this.fileName = "output.js";
    this.cmds = new ArrayList<AbstractCommand>();
  }

  public void generateTarget() {

  }

  public List<AbstractCommand> getCommands() {
    return cmds;
  }

  public void setCommands(List<AbstractCommand> cmds) {
    this.cmds = cmds;
  }

  public IdTable getIdTable() {
    return it;
  }

  public void setIdTable(IdTable it) {
    this.it = it;
  }
}
