package br.edu.ufabc.glyphobe.ast;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufabc.glyphobe.symbols.IdTable;

public class Program {
  private String fileName;
  private List<AbstractCommand> cmds;
  private IdTable it;
  private String language;
  private int blockLevel;

  public Program() {
    this.fileName = "output";
    this.cmds = new ArrayList<AbstractCommand>();
    setLanguage("js");
    blockLevel = 0;
  }

  public Program(String fileName) {
    this.fileName = fileName;
    this.cmds = new ArrayList<AbstractCommand>();
    setLanguage("js");
    blockLevel = 0;
  }

  public String generateTarget() {
    StringBuilder strBuilder = new StringBuilder();

    strBuilder.append(generatePreCode());

    cmds.stream().forEach(c -> {
      String blockSpaces = "";
      if (c instanceof CmdToken) {
        if (((CmdToken)c).getToken().contains("{")) blockLevel++;
        else if (((CmdToken)c).getToken().contains("}")) blockLevel--;
      } else {
        blockSpaces = indentBlock();
      }

      strBuilder.append(blockSpaces + c.generateCode());
    });

    strBuilder.append(generatePostCode());

    return strBuilder.toString();
  }

  private String indentBlock() {
    String spaces = "";
    for (int i = 0; i < blockLevel; i++) {
      spaces += "  ";
    }
    return spaces;
  }

  private String generatePreCode() {
    switch(language) {
      case "java":
        blockLevel = 2;
        return "import java.util.Scanner;\n\n"
          + "public class " + fileName + " { \n"
          + "  public static void main(String[] args) {\n"
          + "    Scanner scanner = new Scanner(System.in);\n";
      default:
        return "";
    }
  }

  private String generatePostCode() {
    switch(language) {
      case "java":
        return "    scanner.close();\n"
          + "  }\n}\n";
      default:
        return "";
    }
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

  //Caso seja recebido uma linguagem não suportada, o programa será compilado para JavaScript
  public void setLanguage(String lang) {
    if      (lang.compareTo("java") == 0) this.language = lang;
    else if (lang.compareTo("py") == 0)   this.language = lang;
    else this.language = "js";
  }

  public String getLanguage() {
    return this.language;
  }
}
